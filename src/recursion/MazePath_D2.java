package recursion;
import java.util.Scanner;
//Take as input N. N is the number of rows and columns on a square board. 
//Our player starts in top-left corner of the board and must reach bottom-right corner.
//In one move the player can move 1 step horizontally (right) or 1 step vertically (down) or 1 step diagonally (south-east). 
//But the diagonal step is allowed only when the player is currently on one of the diagonals (there are two diagonals)

public class MazePath_D2 {

	public static void main(String args[]) {
	    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int totalPaths = mazePath(n);
        System.out.println("Total Paths: " + totalPaths);
        sc.close();
        
    }

    public static int mazePath(int n)
	{
		return mazePath(1, 1, n, "");
	}
	
	public static int mazePath(int cr, int cc, int n, String osf)
	{
		if(cr == n && cc == n)
		{
			System.out.println(osf);
			return 1;
		}
		
		if(cr > n || cc > n)
			return 0;
		
		int count = 0;
		count += mazePath(cr+1, cc, n, osf + "V");
		count += mazePath(cr, cc+1, n, osf + "H");
		//1 == 1 -> on first diagonal
		//1 + 4 == 4 + 1 -> on second diagonal
		//2 + 3 == 4 + 1 -> on second diagonal 
		if(cc == cr || cr + cc == n+1)
            count += mazePath(cr+1, cc+1, n, osf + "D");
		
        return count;
	}
}
