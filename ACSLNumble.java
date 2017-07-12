//Jonathan Poch 4/6/14 Pd 3
import java.util.*;
public class Numble
{
    public static int[] order(int[]x)
    {
        int[] a = x;
        Arrays.sort(a);
        return a;
    }
    public static ArrayList<Integer>solve(int[] x, int n)
    {
        int count = n;
        int i = 0;
        ArrayList<Integer> copy = new ArrayList<Integer>();
        ArrayList<Integer> copyR = new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int k=x.length-1;k>-1;k--)
        {
            copy.add(x[k]);
        }
       /* for(Integer c:copy)
        {
            System.out.print(c);
        }
        System.out.println();*/
        for(Integer a:copy)
        {
            copyR.add(a%5);
        }
        /*for(Integer c:copyR)
        {
            System.out.print(c);
        }
        System.out.println();*/
        //System.out.println(copyR.indexOf(5-copyR.get(0)));
        while(count>0)
        {
            /*System.out.println("Answer: ");
                for(Integer c:ans)
                {
                    System.out.print(c);
                }
                System.out.println();
            System.out.println("Copy: ");
                for(Integer c:copy)
                {
                    System.out.print(c);
                }
                System.out.println();
                System.out.println("CopyR: ");
                for(Integer c:copyR)
                {
                    System.out.print(c);
                }
                System.out.println();
                System.out.println(count);
                System.out.println();
                System.out.println(count>=2 && copyR.indexOf(5-copyR.get(0))>-1);*/
                if(count == 2 && copy.get(0)%5==0 && copy.get(1)%5==0)
                {
                    ans.add(copy.get(0));
                    ans.add(copy.get(1));
                }
                else if(count==2&&copy.get(0)%5==0)
                {
                    copy.remove(0);
                    copyR.remove(0);
                }
                if(count>=2 && copyR.indexOf(5-copyR.get(0))>-1)
                {
                    for(int ab = 0;ab<copy.size();ab++)
                    {
                        if(copy.get(ab)%5!=0)
                        {
                            ans.add(copy.get(0));
                            break;
                        }
                    }
                //ans.add(copy.get(0));
                ans.add(copy.get(copyR.indexOf(5-copyR.get(0))));
                /*System.out.println("Answer: ");
                for(Integer c:ans)
                {
                    System.out.print(c);
                }
                System.out.println();*/
                i = copy.indexOf(ans.get(ans.size()-1));
                //System.out.println(i);
                copy.remove(ans.get(ans.size()-1));
                copy.remove(0);
                copyR.remove(i);
                copyR.remove(0);
                count-=2;
                /*System.out.println("Copy: ");
                for(Integer c:copy)
                {
                    System.out.print(c);
                }
                System.out.println();
                System.out.println("CopyR: ");
                for(Integer c:copyR)
                {
                    System.out.print(c);
                }
                System.out.println();*/
            }
            else if(copyR.get(0)==0)
            {
                ans.add(copy.get(0));
                copyR.remove(0);
                copy.remove(0);
                count--;
                /*for(Integer c:copy)
                {
                    System.out.print(c);
                }
                System.out.println();
                for(Integer c:copyR)
                {
                    System.out.print(c);
                }
                System.out.println();*/
            }
            else if(count==1)
            {
                ans.add(copy.get(copyR.indexOf(0)));
                count--;
            }
        }
        return ans;
    }
    public void process(int[] x, int[] y, int num)
    {
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = s.substring(0,s.indexOf(", "));
        String s2 = s.substring(s.indexOf(", ")+2);
        //System.out.println(s2);
        int []x =new int[7];
        int []y =new int[7];
        for(int k=0;k<7;k++)
        {
            x[k] = Integer.valueOf(""+s1.charAt(k));
            y[k] = Integer.valueOf(""+s2.charAt(k));
        }
        //int[] x = {6,8,7,4,5,1,4};
        String output = "";
        for(int count = 0;count<5;count++)
        {
        String s3 = sc.nextLine();
        String[]s4 = s3.split(", ");
        int num1 = Integer.valueOf(s4[0]);
        int num2 = Integer.valueOf(s4[1]);
        int num3 = Integer.valueOf(s4[2]);
        int[] a = order(x);
        int[] b = order(y);
        ArrayList<Integer> c = solve(a,num1);
        ArrayList<Integer> d = solve(b,num2);
        Collections.sort(c);
        ArrayList<Integer> outX = new ArrayList<Integer>();
        ArrayList<Integer> outY = new ArrayList<Integer>();
        for(int i= c.size()-1;i>-1;i--)
        {
            outX.add(c.get(i));
        }
        System.out.println();
         Collections.sort(d);
        for(int i= d.size()-1;i>-1;i--)
        {
            outY.add(d.get(i));
        }
        String[][] out = new String [7][7];
        int startX = outY.indexOf(num3);
        int startY = outX.indexOf(num3);
        for(int row=0;row<7;row++)
        {
            for(int col=0;col<7;col++)
            {
                    out[row][col] = " ";
            }
        }
        
        for(int k=0;k<outX.size();k++)
        {
            out[startX][k]=""+outX.get(k);
        }
        for(int k=0;k<outY.size();k++)
        {
            out[k][startY]=""+outY.get(k);
        }
        for(int row=0;row<7;row++)
        {
            for(int col=0;col<7;col++)
            {
                    output+=(out[row][col]+" ");
            }
            output+=("\n\n");
        }
        System.out.println();
    }
        System.out.print(output);
    }
}
/*
9768014, 6874514
7, 7, 7
6, 5, 6
5, 6, 6
4, 5, 8
6, 6, 4
*/