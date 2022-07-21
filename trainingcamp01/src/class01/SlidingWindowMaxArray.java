package src.class01;
import java.util.LinkedList;


/*
题目：
    假设一个固定大小的W的窗口，依次划过arr,假设每一次滑出状况的最大值
    例如：
        arr=[4,3,5,4,3,3,6,7] W=3
    返回：
        [5,5,5,4,6,7]
 */
public class SlidingWindowMaxArray {

    public static  int[] getMax(int[] arr ,int W){
        // 判断arr的大小与W
        if(arr == null || arr.length < W || W < 1 ){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - W + 1];
        int index = 0;
        for(int r = 0;r<arr.length;r++){
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[r]){
                qmax.pollLast();
            }
            qmax.addLast(r);
            if(qmax.peekFirst() == r - W){
                qmax.pollFirst();
            }
            if(r>=W-1){
                res[index++]=arr[qmax.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int[] res = getMax(arr,2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+' ');
        }
    }



}
