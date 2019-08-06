package com.zwq.demo.sort;

import java.util.Arrays;

/*
 * @description:
 * @author: zwq
 * @date: 2019/6/24 21:04
 */
public class MyQuickSort {

    public static void quickSort(int[] arr, int low, int high) {

        if (low > high) {
            return;
        }

        int i = low, j = high, temp = arr[low];


        System.out.println(Arrays.toString(arr));

        while (i < j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }

            while (i < j && arr[i] <= temp) {
                i++;
            }

            if (i < j) {
                int x = arr[i];
                int y = arr[j];
                arr[i] = y;
                arr[j] = x;
            }
        }

        arr[low] = arr[j];
        arr[j] = temp;

        System.out.println(Arrays.toString(arr));

        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);

    }


    public static void main(String[] args) throws InterruptedException {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        //int[] arr = {3, 1, 2, 5 , 4};
        long start = System.currentTimeMillis();
        //quickSort(arr, 0, arr.length - 1);
        Arrays.sort(arr);
        //Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println(start);
        System.out.println(end);
        System.out.println(end-start);
    }
}
