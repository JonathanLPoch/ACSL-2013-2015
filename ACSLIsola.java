/*
 * Jonathan Poch
 * ACSL Contest #3
 */
import java.util.Scanner;
import java.util.ArrayList;
public class ACSLIsola 
{
	public static Tile[][] board = new Tile[7][7];
	public static void setUp()
	{
		int x = 6;
		int y = 1;
		for(int r = 0; r<7; r++)
		{
			for(int c = 0; c<7; c++)
			{
				board[r][c]=new Tile(x*7+y+"");
				//board[r][c].setName(x*7+y+"");
				y++;
			}
			y=1;
			x--;
		}
	}
	public static Tile eliminate(String s)
	{
		String[] str = s.split(", ");
		String mod = "";
		Tile t = new Tile(str[1]);
		int refX=0;
		int refY=0;
		for(int k = 0; k<str.length-1; k++)
		{
			
				 refX = 6-(Integer.parseInt(str[k])/7);
				 if(Integer.parseInt(str[k])%7==0)
				 {
					 refX++;
				 }
				 for(int x = 0; x<7; x++)
				 {
					 if(board[refX][x].getName().equals(str[k]))
					 {
						 refY =x;
					 }
				 }
				 if(k!=1)
				 {
					 board[refX][refY].setName("x");
				 }
				 if(k==1)
				 {
					 
					 mod = board[refX][refY].getName();
					 board[refX][refY].setName("*"+mod+"*");
					 t.setX(refX);
					 t.setY(refY);
				 }
		}
		return t;
	}
	public static int north(Tile t)
	{
		int x = 0;
		int posX = t.getX();
		int posY = t.getY();
		while (true)
		{
			posX--;
			if(posX <0 || posY <0 || posX >6 || posY >6 || board[posX][posY].getName().equals("x"))
			{
				break;
			}
			x++;
		}
		return x;
	}
	public static int northEast(Tile t)
	{
		int x = 0;
		int posX = t.getX();
		int posY = t.getY();
		while (true)
		{
			posX--;
			posY++;
			if(posX <0 || posY <0 || posX >6 || posY >6 || board[posX][posY].getName().equals("x"))
			{
				break;
			}
			x++;
		}
		return x;
	}
	public static int east(Tile t)
	{
		int x = 0;
		int posX = t.getX();
		int posY = t.getY();
		while (true)
		{
			posY++;
			if(posX <0 || posY <0 || posX >6 || posY >6 || board[posX][posY].getName().equals("x"))
			{
				break;
			}
			x++;
		}
		return x;
	}
	public static int southEast(Tile t)
	{
		int x = 0;
		int posX = t.getX();
		int posY = t.getY();
		while (true)
		{
			posX++;
			posY++;
			if(posX <0 || posY <0 || posX >6 || posY >6 || board[posX][posY].getName().equals("x"))
			{
				break;
			}
			x++;
		}
		return x;
	}
	public static int south(Tile t)
	{
		int x = 0;
		int posX = t.getX();
		int posY = t.getY();
		while (true)
		{
			posX++;
			if(posX <0 || posY <0 || posX >6 || posY >6 || board[posX][posY].getName().equals("x"))
			{
				break;
			}
			x++;
		}
		return x;
	}
	public static int southWest(Tile t)
	{
		int x = 0;
		int posX = t.getX();
		int posY = t.getY();
		while (true)
		{
			posX++;
			posY--;
			if(posX <0 || posY <0 || posX >6 || posY >6 || board[posX][posY].getName().equals("x"))
			{
				break;
			}
			x++;
		}
		return x;
	}
	public static int west(Tile t)
	{
		int x = 0;
		int posX = t.getX();
		int posY = t.getY();
		while (true)
		{
			posY--;
			if(posX <0 || posY <0 || posX >6 || posY >6 || board[posX][posY].getName().equals("x"))
			{
				break;
			}
			x++;
		}
		return x;
	}
	public static int northWest(Tile t)
	{
		int x = 0;
		int posX = t.getX();
		int posY = t.getY();
		while (true)
		{
			posX--;
			posY--;
			if(posX <0 || posY <0 || posX >6 || posY >6 || board[posX][posY].getName().equals("x"))
			{
				break;
			}
			x++;
		}
		return x;
	}
	public static String findPath(Tile marker)
	{
		String out = "";
		int[] path = new int[8];
		int max = 0;
		int index = 0;
		path[0] = ACSLIsola.north(marker);
		path[1] = ACSLIsola.northEast(marker);
		path[2] = ACSLIsola.east(marker);
		path[3] = ACSLIsola.southEast(marker);
		path[4] = ACSLIsola.south(marker);
		path[5] = ACSLIsola.southWest(marker);
		path[6] = ACSLIsola.west(marker);
		path[7] = ACSLIsola.northWest(marker);
		max = path[0];
		for(int k=0;k<6;k++)
		{
			if(path[k]<path[k+1])
			{
				max = path[k+1];
				index = k+1;
			}
			//System.out.print(path[k]+" ");
		}
		//System.out.println();
		switch(index)
		{
			case(0):
			{
				for(int x=1;x<=max;x++)
				{
					out+=board[marker.getX()-x][marker.getY()].getName()+", ";
				}
				break;
			}
			case(1):
			{
				for(int x=1;x<=max;x++)
				{
					out+=board[marker.getX()-x][marker.getY()+x].getName()+", ";
				}
				break;
			}
			case(2):
			{
				for(int x=1;x<=max;x++)
				{
					out+=board[marker.getX()][marker.getY()+x].getName()+", ";
				}
				break;
			}
			case(3):
			{
				for(int x=1;x<=max;x++)
				{
					out+=board[marker.getX()+x][marker.getY()+x].getName()+", ";
				}
				break;
			}
			case(4):
			{
				for(int x=1;x<=max;x++)
				{
					out+=board[marker.getX()+x][marker.getY()].getName()+", ";
				}
				break;
			}
			case(5):
			{
				for(int x=1;x<=max;x++)
				{
					out+=board[marker.getX()+x][marker.getY()-x].getName()+", ";
				}
				break;
			}
			case(6):
			{
				for(int x=1;x<=max;x++)
				{
					out+=board[marker.getX()][marker.getY()-x].getName()+", ";
				}
				break;
			}
			case(7):
			{
				for(int x=1;x<=max;x++)
				{
					out+=board[marker.getX()-x][marker.getY()-x].getName()+", ";
				}
				break;
			}
		}
		if(out.equals(""))
		{
			return "NONE";
		}
		return out.substring(0,out.length()-2);
		
	}
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		String s3 = sc.nextLine();
		String s4 = sc.nextLine();
		String s5 = sc.nextLine();
		
		ACSLIsola.setUp();
		Tile marker1 = ACSLIsola.eliminate(s1);
		System.out.println(ACSLIsola.findPath(marker1));
		ACSLIsola.setUp();
		Tile marker2 = ACSLIsola.eliminate(s2);
		System.out.println(ACSLIsola.findPath(marker2));
		ACSLIsola.setUp();
		Tile marker3 = ACSLIsola.eliminate(s3);
		System.out.println(ACSLIsola.findPath(marker3));
		ACSLIsola.setUp();
		Tile marker4 = ACSLIsola.eliminate(s4);
		System.out.println(ACSLIsola.findPath(marker4));
		ACSLIsola.setUp();
		Tile marker5 = ACSLIsola.eliminate(s5);
		System.out.println(ACSLIsola.findPath(marker5));
		
		/*for(int r = 0; r<7; r++)
		{
			for(int c = 0; c<7; c++)
			{
				System.out.print(board[r][c].getName()+"  ");
			}
			System.out.println();
		}*/

		
	}
}
/*
40, 42, 10, 49, 0
33, 32, 39, 25, 20, 24, 0
22, 29, 32, 43, 5, 0
44, 32, 39, 33, 25, 24, 31, 0
25, 26, 33, 27, 19, 32, 34, 18, 20, 0

31, 25, 32, 49, 27, 19, 24, 17, 18, 0
31, 25, 32, 41, 28, 19, 24, 18, 17, 0
31, 25, 32, 33, 26, 19, 18, 17, 0
31, 25, 32, 33, 24, 19, 18, 17, 0
31, 25, 32, 24, 26, 19, 18, 17, 0
44, 43, 36, 37, 0
2, 1, 8, 9, 0
6, 7, 14, 13, 0
48, 49, 41, 42, 0
*/