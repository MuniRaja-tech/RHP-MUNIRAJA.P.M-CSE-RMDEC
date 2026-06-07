import java.util.*;

public class MaximumRowValue
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] grid = new int[r][c];

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[r][c];

        // Base case
        for(int j = 0; j < c; j++)
        {
            dp[0][j] = grid[0][j];
        }

        for(int i = 1; i < r; i++)
        {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int maxCol = -1;

            // Find largest and second largest in previous DP row
            for(int j = 0; j < c; j++)
            {
                if(dp[i - 1][j] > max1)
                {
                    max2 = max1;
                    max1 = dp[i - 1][j];
                    maxCol = j;
                }
                else if(dp[i - 1][j] > max2)
                {
                    max2 = dp[i - 1][j];
                }
            }

            // Compute current row
            for(int j = 0; j < c; j++)
            {
                if(j == maxCol)
                {
                    dp[i][j] = grid[i][j] + max2;
                }
                else
                {
                    dp[i][j] = grid[i][j] + max1;
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int j = 0; j < c; j++)
        {
            answer = Math.max(answer, dp[r - 1][j]);
        }

        System.out.println("Maximum value: " + answer);
        sc.close();
    }
}