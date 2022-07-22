package src.class02;

/**
 *  n = 1 时   1
 *  n = 2 时   10 11
 *  n = 3 时   100 101 110 111
 *  n = 4 时   1000 1001 1010 1100 1110 1101 1011 1111
 */
public class ZeroLeftOneStringNumber {
    public static int getNum1(int n){
        if(n<1){
            return 0;
        }

        return process(1,n);
    }
    public static int process(int i,int n){
        if (i == n-1){
            return 2;
        }
        if (i==n){
            return 1;
        }
        return process(i+1,n)+process(i+2,n);
    }

    public static void main(String[] args) {
        for (int i = 0; i != 20; i++) {
            System.out.println(getNum1(i));
            System.out.println("===================");
        }

    }

}
