package src.class01;

import java.util.LinkedList;

/*
给定一个整形数组arr，和一个整数num，
某个arr中的子数组sub，如果想达标，必须满足：
    sub中的最大值-sub中的最小值<=num
    返回中达标子数组的数量
 */
public class AllLessNumSubArray {
    // 1 暴力遍历 O(n^3)
    // 2 大范围内达标=》小范围内一定达标
//       小范围内不达标=》大范围内一定不达标
    public static int getNum(int[] arr,int num){
        if (arr == null || arr.length == 0)
            return 0;
        LinkedList<Integer> qMin = new LinkedList<>();
        LinkedList<Integer> qMax = new LinkedList<>();
        int L=0,R=0,res=0;
        while(L < arr.length){

            while(R <arr.length){
                while(!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[R]){
                    qMin.pollLast();
                }
                qMin.addLast(R);
                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]){
                    qMax.pollLast();
                }
                qMax.addLast(R);

                if(arr[qMax.getFirst()] - arr[qMin.getFirst()]>num){
                    break;
                }
                R++;
            }
            res += R-L;
            if(qMin.peekFirst() == L){
                qMin.pollFirst();
            }
            if(qMax.peekFirst() == L){
                qMax.pollFirst();
            }
            L++;

        }

        return res;
    }

    // for test
    public static int[] getRandomArray(int len) {
        if (len < 0) {
            return null;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = getRandomArray(30);
        int num = 5;
        printArray(arr);
        System.out.println(getNum(arr, num));

    }
}
