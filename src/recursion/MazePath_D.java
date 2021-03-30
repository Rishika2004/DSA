package recursion;

import java.util.Scanner;

//Take as input N1 and N2, the number of rows and columns on a rectangular board. 
//Our player starts in top-left corner of the board and must reach bottom-right corner.
//In one move the player can move 1 step horizontally (right) or 1 step vertically (down) or 1 step diagonally (south-east).

//Sample Input
//2
//3

//Sample Output
//VHH
//HVH
//HHV
//HD
//DH
//Total Paths: 5

public class MazePath_D {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int totalPaths = mazePath(r, c);
		System.out.println("Total Paths: " + totalPaths);
		sc.close();
	}
	
	public static int mazePath(int r, int c)
	{
		return mazePath(1, 1, r, c, "");
	}
	
	//cr -> current row, cc -> current column
	//er -> ending row, ec -> ending column
	private static int mazePath(int cr, int cc, int er, int ec, String osf)
	{
		if(cr == er && cc == ec)
		{
			System.out.println(osf);
			return 1;
		}
		
		if(cr > er || cc > ec)
			return 0;
		
		int count = 0;
		count += mazePath(cr+1, cc, er, ec, osf + 'V');
		count += mazePath(cr, cc+1, er, ec, osf + 'H');
		count += mazePath(cr+1, cc+1, er, ec, osf + 'D');
	
		return count;
	}
}
