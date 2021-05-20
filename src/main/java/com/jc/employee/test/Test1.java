package com.jc.employee.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * @author LX
 * @date 2021/4/7
 */
public class Test1 {
    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());

        int[] array = IntStream.generate(() -> random.nextInt(1000)).limit(10).toArray();
        System.out.println(Arrays.toString(array));
//        bubbleSort(array);
//        selectSort(array);
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i;
            while (index > 0 && arr[index - 1] > temp) {
                arr[index] = arr[index - 1];
                index--;
            }
            if (arr[i] != temp){
                arr[index] = temp;
            }
        }
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i + 1;
            int minIndex = i;
            while (index < arr.length) {
                if (arr[index] < min) {
                    min = arr[index];
                    minIndex = index;
                }
                index++;
            }
            if (minIndex != min) {
                change(arr, i, minIndex);
            }
        }
    }

    private static void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    change(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    private static void change(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
