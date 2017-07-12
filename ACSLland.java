/*
 * Jonathan Poch
 * 12/8/14
 * ACSL Intermidiate Division Contest #1
 *
A,C,M,H,3.79
E,F,C,S,3.69
B,E,F,M,3.59
F,G,V,H,3.89
A,G,C,I,3.63
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class ACSLland 
{
	//Keeps track of distances
	static int[] dist = new int[]{450,140,120,320,250,80};	
	//processes each line
	public static String process(String str)
	{
		String out = "";
		int start = 0;
		int end = 0;
		int total = 0;
		double price = 0;
		float time = 0;
		String [] s = str.split(",");
		//chooses starting point
		switch(s[0])
		{
		case("A"):
		{start = 0; break;}
		case("B"):
		{start = 1; break;}
		case("C"):
		{start = 2; break;}
		case("D"):
		{start = 3; break;}
		case("E"):
		{start = 4; break;}
		case("F"):
		{start = 5; break;}
		}
		//chooses ending point
		switch(s[1])
		{
		case("B"):
		{end = 0; break;}
		case("C"):
		{end = 1; break;}
		case("D"):
		{end = 2; break;}
		case("E"):
		{end = 3; break;}
		case("F"):
		{end = 4; break;}
		case("G"):
		{end = 5; break;}
		}
		//adds up all intermediate paths
		for(int k = start; k<=end; k++)
		{
			total+=dist[k];
		}
		//calculates total price
		switch(s[2])
		{
		case("C"):
		{price = Double.parseDouble(s[4])*total/28;break;}
		case("M"):
		{price = Double.parseDouble(s[4])*total/25;break;}
		case("F"):
		{price = Double.parseDouble(s[4])*total/22;break;}
		case("V"):
		{price = Double.parseDouble(s[4])*total/20;break;}
		}
		DecimalFormat d = new DecimalFormat("$###.##");
		//calculates time
		switch(s[3])
		{
		case("I"):
		{time=65; break; }
		case("H"):
		{time=60; break; }
		case("M"):
		{time=55; break; }
		case("S"):
		{time=45; break; }
		}
		int hour = (int)(total/time);
		int min = Math.round(60*(total/time-hour));
		String h = "";
		if(hour<10)
		{h = "0"+hour;
		}
		else
		{ h = ""+hour;}
		//concats everything 
		out+=""+total+","+h+":"+min+","+d.format(price);
		return out;
	}
	public static void main(String[]args)
	{
		Scanner s = new Scanner(System.in);
		String st1 = "";
		String st2 = "";
		String st3 = "";
		String st4 = "";
		String st5 = "";
		st1 = s.nextLine();
		st2 = s.nextLine();
		st3 = s.nextLine();
		st4 = s.nextLine();
		st5 = s.nextLine();
		System.out.println(ACSLland.process(st1));
		System.out.println(ACSLland.process(st2));
		System.out.println(ACSLland.process(st3));
		System.out.println(ACSLland.process(st4));
		System.out.println(ACSLland.process(st5));
		//System.out.println(st1 + "\n" + st1 + "\n" + st1 + "\n" + st1 + "\n" + st1);
		
	}
}
