package com.company;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        Main m=new Main();

        System.out.println("\n Task 11:");
        Scanner scanner1 = new Scanner(System.in);
        int n=scanner1.nextInt();
        System.out.println(m.ex11(n));

        System.out.println("\n Task 19:");
        Scanner scanner2 = new Scanner(System.in);
        String str=scanner2.next();
        System.out.println(m.ex19(str));

        System.out.println("\n Task 5:");
        int[] arrForDelete = new int[8];
        for (int i = 0; i < arrForDelete.length; i++) {
            arrForDelete[i] = (int) (0 + Math.random() * 10);
            System.out.print(arrForDelete[i] + " ");
        }
        arrForDelete = m.ex5(arrForDelete);

        System.out.println("\n Task 14:");
        System.out.println(m.ex14("AaBbCcDd"));
        System.out.println(m.ex14("ABcd"));

        System.out.println("\n Task 18:");
        System.out.println(m.ex18("abc","aabbcc"));
    }

    public int ex11(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public String ex19(String str) {
        String reversedString = new StringBuffer(str).reverse().toString();
        return reversedString;
    }

    public static int[] ex5(int[] arr)
    {
        System.out.print("\n Enter number to delete: ");
        Scanner delete = new Scanner(System.in);
        int numberDelete= delete.nextInt();
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(numberDelete==arr[i])
            {
                count++;
            }
        }
        if(count==0)
        {
            return arr;
        }
        else
        {
            int[] tarr=new int[arr.length-count];
            for(int i=0,j=0;i< arr.length;i++)
            {
                if(arr[i]!=numberDelete) {
                    tarr[j] = arr[i];
                    j++;
                }
            }
            System.out.println(" Array after delete!");
            for(int i=0;i<tarr.length;i++)
            {
                System.out.print(tarr[i]+" ");
            }
            return tarr;
        }
    }

 String ex14(String str) {
        String result ="";
        int tmp;
        int tmpLength;
        int size = str.length();
        String tmpString;
        for (int i = 2; i <= size; i++) {
            tmpString = str.substring(0, i);
            tmpLength = tmpString.length();
            tmp = upperCaseLettersCount(tmpString);
            if(tmp == tmpLength - tmp && tmpLength > result.length())
                result = tmpString;
        }
        return result;
    }
    int upperCaseLettersCount(String str) {
        int result = 0;
        int size = str.length();
        for(int i =0; i < size ; i++)
        {
            if(Character.isUpperCase(str.charAt(i))) {
                result++;
            }
        }
        return result;
    }

    public int ex18(String str1, String str2) {
        String tmp2=str2;
        int numOfReplacing;
        int result = 0;
        int length = tmp2.length();
        while(true){
            numOfReplacing = str1.length();
            for(int i = 0,i2 = 0;i2 < length;)
            {
                if(str1.charAt(i) == tmp2.charAt(i2))
                {
                    tmp2 = tmp2.substring(0,i2) + tmp2.substring(i2+1);
                    --length;
                    i2 = 0;
                    if(--numOfReplacing == 0) break;
                    ++i;
                    continue;
                }
                ++i2;
            }
            if(numOfReplacing != 0) break;
            ++result;
        }
        return result;
    }

}
