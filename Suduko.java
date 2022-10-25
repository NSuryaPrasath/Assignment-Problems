package newclass;

public class Suduko 
{
	public static void main(String args[]) 
	{
		int[][] table = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
		solve(table);
		for (int i = 0; i < 9; i++) 
		{
			for (int j = 0; j < 9; j++) 
			{
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean solve(int[][] table) 
	{
		int n = 9,row = -1,col = -1;
		boolean filled = true;
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				if (table[i][j] == 0) 
				{
					row = i;
					col = j;
					filled = false;
					break;
				}
			}
			if (!filled) break;
		}
		if (filled)
			return true;
		for (int number = 1; number <= 9; number++) 
		{
			if (isCheck(table, row, col, number)) 
			{
				table[row][col] = (number + 0);
				if (solve(table)) 
				{
					return true;
				} 
				else 
				{
					table[row][col] = 0;
				}
			}
		}
		return false;
	}
	private static boolean isCheck(int[][] table, int row, int col, int num) 
	{
		for (int i = 0; i < table.length; i++) 
		{
			if (num == (table[row][i] - 0)) 
			{
				return false;
			}
		}
		for (int i = 0; i < table.length; i++) 
		{
			if (num == (table[i][col] - 0)) 
			{
				return false;
			}
		}
		int sqrt = (int) Math.sqrt(table.length);
		int rowStart = row - row % sqrt;
		int colStart = col - col % sqrt;
		for (int i = rowStart; i < rowStart + sqrt; i++) 
		{
			for (int j = colStart; j < colStart + sqrt; j++) 
			{
				if (num == (table[i][j] - 0))
					return false;
			}
		}
		return true;
	}
}