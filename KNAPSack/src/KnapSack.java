public class KnapSack
{
    public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }

    private static int knapSack(int w, int[] wArray, int[] valArray, int totalItem)
    {
        int k[][] =new int[totalItem+1][w+1];

        for(int i=0;i<=totalItem;i++)
        {
            boolean flag = true;
            for(int j=0;j<=w;j++)
            {
                if(i==0 || j==0)
                {
                    k[i][j] =0;
                }
                else if(wArray[i-1]<=j)
                {
                    k[i][j] = Math.max(valArray[i-1]+k[i-1][j-wArray[i-1]],k[i-1][j]);
                }
                else {
                    k[i][j] = k[i-1][j];
                }
            }
        }
        findVal(k,totalItem,w,valArray,wArray);
        return k[totalItem][w];
    }

    private static void findVal(int[][] k, int totalItem, int w, int[] valArray,int[] wArray)
    {
        int selectedVal = k[totalItem][w];
        int i = totalItem,j=w;
        while(i!=0 && j!=0)
        {
            if(selectedVal == k[i-1][j])
            {
                i--;
            }
            else
            {
                System.out.println(valArray[i-1]);
                j-=wArray[i-1];
                i--;
                selectedVal = k[i][j];
            }
        }
    }
}
