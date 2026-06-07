import java.util.*;

public class MaximunColumnValue
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

        // Initialize first column
        for(int i = 0; i < r; i++)
        {
            dp[i][0] = grid[i][0];
        }

        // Process column by column
        for(int j = 1; j < c; j++)
        {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int maxRow = -1;

            // Find largest and second largest in previous column
            for(int i = 0; i < r; i++)
            {
                if(dp[i][j - 1] > max1)
                {
                    max2 = max1;
                    max1 = dp[i][j - 1];
                    maxRow = i;
                }
                else if(dp[i][j - 1] > max2)
                {
                    max2 = dp[i][j - 1];
                }
            }

            // Fill current column
            for(int i = 0; i < r; i++)
            {
                if(i == maxRow)
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

        for(int i = 0; i < r; i++)
        {
            answer = Math.max(answer, dp[i][c - 1]);
        }

        System.out.println("Maximum value: " + answer);
        sc.close();
    }
}