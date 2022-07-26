package src.chapter1_stackandqueue;

import java.util.LinkedList;

public class Problem_07_SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr,int W){
        if (arr == null || W <= 0 || arr.length < W){
            return null;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[arr.length-W+1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while(!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]){
                qMax.pollLast();
            }
            qMax.addLast(i);
            if (qMax.peekFirst() == i - W){
                qMax.pollFirst();
            }
            if(i >= W -1){
                res[index++] = arr[qMax.peekFirst()];
            }
        }
        return res;


    }

    //for test
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
     int[] arr = {4,3,5,4,3,3,6,7};
     int w = 3;
     printArray(arr);
     int[] res = getMaxWindow(arr,w);
     printArray(res);
    }
}
