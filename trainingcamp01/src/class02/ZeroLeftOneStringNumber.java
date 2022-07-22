package src.class02;

/**
 *  n = 1 时   1
 *  n = 2 时   10 11
 *  n = 3 时   100 101 110 111
 *  n = 4 时   1000 1001 1010 1100 1110 1101 1011 1111
 */
public class ZeroLeftOneStringNumber {
    public static int getNum(int n){
        if(n<1){
            return 0;
        }
        if(n == 1 || n == 2){
            return n;
        }


        return getNum(n-1);
    }


}
