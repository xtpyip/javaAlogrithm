package src.class01;

import java.util.Stack;

public class AllTimesMinToMax {
    // 暴力遍历 O(n^3)
    public static int max1(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int min = Integer.MAX_VALUE;
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    min = Math.min(min,arr[k]);
                }
                max = Math.max(max,min*sum);
            }
        }
        return max;
    }
    public static int max2(int[] arr){
        int size = arr.length;
        int[] sums = new int[size];
        sums[0] = arr[0];
        for (int i = 1; i < size; i++) {
            sums[i] = sums[i-1]+arr[i];
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                int j = stack.pop();
                max = Math.max(max,(stack.isEmpty() ? sums[i-1] : (sums[i - 1] - sums[stack.peek()])) * arr[j]);
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            int j = stack.pop();
            max = Math.max(max,(stack.isEmpty() ? sums[size-1] : (sums[size - 1] - sums[stack.peek()])) * arr[j]);
        }
        return max;
    }

    public static int[] generateRandomArray() {
        int[] arr = new int[(int) (Math.random() * 20) + 10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTimes = 2000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray();
            if (max1(arr) != max2(arr)) {
                System.out.println("FUCK!");
                break;
            }
        }
        System.out.println("test finish");
    }
}
