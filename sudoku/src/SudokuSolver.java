
public class SudokuSolver
{
    public static void main(String args[])
    {
        int arr[][] ={  {0,0,0,2,6,0,7,0,1},
                        {6,8,0,0,7,0,0,9,0},
                        {1,9,0,0,0,4,5,0,0},
                        {8,2,0,1,0,0,0,4,0},
                        {0,0,4,6,0,2,9,0,0},
                        {0,5,0,0,0,3,0,2,8},
                        {0,0,9,3,0,0,0,7,4},
                        {0,4,0,0,5,0,0,3,6},
                        {7,0,3,0,1,8,0,0,0}
                    };
        int maxRow = arr.length;
        int maxCol = arr[0].length;
        solveSudoku(arr,0,0,maxRow,maxCol);
    }

    private static boolean solveSudoku(int[][] arr, int row, int col, int maxRow, int maxCol)
    {
        if(row >= maxRow)
        {
            printArray(arr,maxRow,maxCol);
            return true;
        }
        int value=0;
        if(arr[row][col] != 0)
        {
            solveSudoku(arr, row + ((col + 1) / maxCol), (col + 1) % maxCol, maxRow, maxCol);
        }
        else
        {
            for (value = 1; value <= maxRow; value++) {
                if (arr[row][col] == 0 && checkIfSatisfy(arr, row, col, value)) {
                    arr[row][col] = value;
                    if (!solveSudoku(arr, row + ((col + 1) / maxCol), (col + 1) % maxCol, maxRow, maxCol)) {
                        arr[row][col] = 0;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkIfSatisfy(int[][] arr, int row, int col, int value)
    {
        for(int i=0;i<9;i++)
        {
            if(arr[row][i] == value)
            {
                return false;
            }
            if(arr[i][col] == value)
            {
                return false;
            }
        }

        int lowLimitRow = (row/3)*3;
        int lowLimitCol = (col/3)*3;

        int highLimitRow = lowLimitRow+3;
        int highLimitCol = lowLimitCol+3;

        for(;lowLimitRow<highLimitRow;lowLimitRow++)
        {
            for(int j=lowLimitCol;j<highLimitCol;j++)
            {
                if(arr[lowLimitRow][j] == value)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printArray(int [][]arr,int maxRow,int maxCol)
    {
        for(int i=0;i<maxRow;i++)
        {
            for(int j=0;j<maxCol;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
