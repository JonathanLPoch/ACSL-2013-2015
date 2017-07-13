/*Jonathan Poch
 *2/9/14
 *ACSL Contest #2
 */
import java.util.*;
import java.text.*;
public class PrintFormatter
{
    public String process1(String s, String val)//value is right justified
    {
        String out = "";
        int x = s.length();
        for(int k=0;k<s.length()-val.length();k++)
        {
            out += "*";
        }
        out+=val;
        return out;
    }
    public String process2(String s, String val)//right justified with commas
    {
        String out = "";
        String str = "";
        String ands = s.substring(0,s.indexOf(",")) + (s.substring(s.indexOf(",")+1,s.length()));
        if(val.length()>9)
        {
            for(int k=0;k<val.length();k++)
            {
                if(k==val.length()-9)
                {
                    str = NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(val.substring(0,k)))+ "," + NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(val.substring(k))); 
                }
            }
        }
        else
        {
        str = NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(val));
        }
        for(int k=0;k<ands.length()-val.length();k++)
        {
            out += "*";
        }
        out +=str;
        return out;
    }
    public String process34(String s, String val)//decimals
    {
        String intHalf = val.substring(0,val.indexOf("."));//length of the value]
        int intSize = s.substring(0,s.indexOf(".")).length();//length of the &'s
        String p1 = "";
        for(int k = 0;k<intSize;k++)
        {
            p1+="&";
        }
        String decHalf = val.substring(val.indexOf(".")+1);//numbers
        String decHalf2 = s.substring(s.indexOf(".")+1);//&'s

        String out = process1(p1,intHalf);
        int round = 0;
        int num = 0;
        int check = 0;
        if(decHalf2.length()-decHalf.length()<0)//process4, rounding
        {
            round = decHalf2.length();//takes the number of decimal places
            num = Integer.parseInt(decHalf.substring(0,round));
            check = Integer.parseInt(decHalf.charAt(round)+"");
            if(check>=5)
            {
                num++;
            }
            out+="." + num;
        }
        else
            {
                out += "." + decHalf ;
                for(int k=0;k<decHalf2.length()-decHalf.length();k++)
                {
                    out += "0";
                }
            }
        return out;
    }
    public String process5(String s, String val)//rounding
    {
        String newS = s.substring(0,s.indexOf("$")) + s.substring(s.indexOf("$")+1);
        String newOut = "";
        String help = "";
 
        if(newS.indexOf(".")==-1)
        {
            System.out.println(newS + "\n" + val);
            help = process1("&" + newS,val);

            return help.substring(0,help.lastIndexOf("*")) + "$" + help.substring(help.lastIndexOf("*")+1);
        }
        else
        {            
            help =  process34("&" + newS,val);   
            return help.substring(0,help.lastIndexOf("*")) + "$" + help.substring(help.lastIndexOf("*")+1);
        }
    }
    public String findMethod(String s, String val)
    {
        
        if(s.indexOf("$")>=0)
        {
            return process5(s,val);
        }
        if(s.indexOf(",")>=0)
        {
            return process2(s,val);
        }
        if(s.indexOf(".")>=0)
        {
            return process34(s,val);
        }
        return process1(s,val);
    }
    public static void main(String[] args)
    {
        PrintFormatter p = new PrintFormatter();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter inputs: ");
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        String s3 = s.nextLine();
        String s4 = s.nextLine();
        String s5 = s.nextLine();
        System.out.println("\n" + p.findMethod(s1.substring(0,s1.indexOf(", ")),s1.substring(s1.indexOf(", ")+2)));
        System.out.println(p.findMethod(s2.substring(0,s2.indexOf(", ")),s2.substring(s2.indexOf(", ")+2)));
        System.out.println(p.findMethod(s3.substring(0,s3.indexOf(", ")),s3.substring(s3.indexOf(", ")+2)));
        System.out.println(p.findMethod(s4.substring(0,s4.indexOf(", ")),s4.substring(s4.indexOf(", ")+2)));
        System.out.println(p.findMethod(s5.substring(0,s5.indexOf(", ")),s5.substring(s5.indexOf(", ")+2)));
/*
&&&&&&, 456
&&&&&&,&, 1000000
$&&&&.&&, 123.38
&&&.&&&, 23.49
&&&.&&&, 23.4999
&&&&&&, 46
&&&&&&&&&&&,&, 8761876547
$&&&&.&&, 4.38
&&&.&&&, 23.49
&&&.&&&, 23.4994999
*/
        /*System.out.println(p.findMethod("&,&&&&&","12345"));
        System.out.println(p.findMethod("&&&.&&&&","12.34"));
        System.out.println(p.findMethod("&&.&&","12.345"));
        System.out.println(p.findMethod("$&&&.&&","123.45"));*/

    }
}