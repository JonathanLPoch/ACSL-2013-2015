import java.util.Scanner;


public class ACSLBinary 
{
	public static String[] convertArray(String[] s)
	{
		int [] bin = new int[s.length];
		String [] out = new String[s.length];
		for(int k=0;k<s.length;k++)
		{
			bin[k]=Integer.parseInt(s[k]);
			if(bin[k] == 0)
			{
				out[k] = "0000";
			}
			if(bin[k] == 1)
			{
				out[k] = "0001";
				//out[k] += Integer.toBinaryString(bin[k]);
			}
			if(bin[k] <= 3 && bin[k] > 1)
			{
				out[k]="00";
				out[k] += Integer.toBinaryString(bin[k]);
			}
			if(bin[k] <= 7 && bin[k] > 3)
			{
				out[k]="0";
				out[k] += Integer.toBinaryString(bin[k]);
			}
			if(bin[k]>7)
			{
				out[k] = Integer.toBinaryString(bin[k]);
			}
		}
		return out;
	}
	public static String compareArrays(String[] s)
	{
		String out = "";
		for(int j=0;j<4;j++)
		{
			if(s.length == 4)
			{
				if(s[0].charAt(j)=='1' && s[1].charAt(j)=='1' && s[2].charAt(j)=='1' && s[3].charAt(j)=='1')
				{
					out+="1";
				}
				if(s[0].charAt(j)=='0' && s[1].charAt(j)=='0' && s[2].charAt(j)=='0' && s[3].charAt(j)=='0')
				{
					out+="0";
				}
				if(!(s[0].charAt(j)=='0' && s[1].charAt(j)=='0' && s[2].charAt(j)=='0' && s[3].charAt(j)=='0')&&!(s[0].charAt(j)=='1' && s[1].charAt(j)=='1' && s[2].charAt(j)=='1' && s[3].charAt(j)=='1'))
				{
					out+="x";
				}
			}
			if(s.length == 2)
			{
				if(s[0].charAt(j)=='1' && s[1].charAt(j)=='1')
				{
					out+="1";
				}
				if(s[0].charAt(j)=='0' && s[1].charAt(j)=='0')
				{
					out+="0";
				}
				if(!(s[0].charAt(j)=='0' && s[1].charAt(j)=='0')&&!(s[0].charAt(j)=='1' && s[1].charAt(j)=='1' ))
				{
					out+="x";
				}
			}		
		}
		return out;
	}
	public static String getOutput(String s)
	{
		if(s.indexOf("1")==-1)
		{
			return "NONE";
		}
		String out = "";
		for(int k=0;k<4;k++)
		{
			if(s.charAt(k)=='x')
			{
				out+="";
			}
			if(s.charAt(k)=='1')
			{
				out+=((char)(65+k));
			}
			if(s.charAt(k)=='0')
			{
				out+=Character.toLowerCase(((char)(65+k)));
			}
		}
		return s + ", " + out;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String out = "";
		for(int k=0; k<5; k++)
		{
			out+=ACSLBinary.getOutput(ACSLBinary.compareArrays(ACSLBinary.convertArray(sc.nextLine().split(", "))))+"\n";
		}
		System.out.println(out);
		/*
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		String s3 = sc.nextLine();
		String s4 = sc.nextLine();
		String s5 = sc.nextLine();
		String [] x1 = s1.split(", ");
		String [] x2 = s2.split(", ");
		String [] x3 = s3.split(", ");
		String [] x4 = s4.split(", ");
		String [] x5 = s5.split(", ");
		String[] a = ACSLBinary.convertArray(x1);
		String[] b = ACSLBinary.convertArray(x2);
		String[] c = ACSLBinary.convertArray(x3);
		String[] d = ACSLBinary.convertArray(x4);
		String[] e = ACSLBinary.convertArray(x5);
*/
		/*
		for(int k=0;k<s.length;k++)
		{
			System.out.println(s[k]);
		}
		*/
		/*
		String out1 = ACSLBinary.compareArrays(a);
		String out2 = ACSLBinary.compareArrays(b);
		String out3 = ACSLBinary.compareArrays(c);
		String out4 = ACSLBinary.compareArrays(d);
		String out5 = ACSLBinary.compareArrays(e);
		System.out.println(ACSLBinary.getOutput(out1));
		System.out.println(ACSLBinary.getOutput(out2));
		System.out.println(ACSLBinary.getOutput(out3));
		System.out.println(ACSLBinary.getOutput(out4));
		System.out.println(ACSLBinary.getOutput(out5));
		*/
	}
}
/*
4, 8, 9, 10, 11, 12, 14, 15, -1
4, 12
9, 11
8, 9, 10, 11
8, 10, 12, 14
10, 11, 14, 15
*/