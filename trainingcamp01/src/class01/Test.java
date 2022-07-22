package src.class01;

public class Test {
    public static int way1(int x,int y,int k){
        return f(x,y,k);
    }

    public static int f(int x,int y,int k){
        if(k==0){
            return x==0 && y==0 ? 1 : 0;
        }
        if(x<0 || x >9 || y<0 || y>8){
            return 0;
        }
        // 有步数要走，x,y也是棋盘上的位置
        return f(x+2,y-1,k-1)
                +f(x+2,y+1,k-1)
                +f(x+1,y+2,k-1)
                +f(x-1,y+2,k-1)
                +f(x-2,y+1,k-1)
                +f(x-2,y-1,k-1)
                +f(x-1,y-2,k-1)
                +f(x+1,y-2,k-1);

    }

    public static int way2(int x,int y,int k){
        int[][][] dp = new int[10][9][k+1];
        dp[0][0][0] = 1;
        for (int level = 1; level <= k; level++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    dp[i][j][level] = getValue(dp,i + 1,j - 2,level-1)+
                            getValue(dp,i + 2,j - 1,level-1)+
                            getValue(dp,i + 2,j + 1,level-1)+
                            getValue(dp,i + 1,j + 2,level-1)+
                            getValue(dp,i - 1,j + 2,level-1)+
                            getValue(dp,i - 2,j + 1,level-1)+
                            getValue(dp,i - 2,j - 1,level-1)+
                            getValue(dp,i - 1,j - 2,level-1);

                }
            }
        }
        return dp[x][y][k];
    }
    public static int getValue(int[][][] dp,int i,int j,int level){
        if(i < 0 || i > 9 || j < 0 || j > 8){
            return 0;
        }
        return dp[i][j][level];

    }


    public static void main(String[] args) {
        int x=6,y=8,k=10;
        System.out.println(way1(x,y,k));
        System.out.println(way2(x,y,k));
    }

}
