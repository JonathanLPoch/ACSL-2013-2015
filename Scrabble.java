/* Jonathan Poch
 * 12/7/13
 *FPHS
 *ACSL Intermediate Contest #1
 */
 /*J, A, V, A
27, H
37, H
35, H
7, H
17, H*/
 import java.util.*;
 public class Scrabble
 {
    int A=1,E=1;
    int D=2,R=2;
    int B=3,M=3;
    int V=4,Y=4;
    int J=8,X=8;
    private Map<String,Integer> vals = new TreeMap<String,Integer>();
    private Tile[][]board;
    public Scrabble()
    {
        vals.put("A",1);
        vals.put("E",1);
        vals.put("D",2);
        vals.put("R",2);
        vals.put("B",3);
        vals.put("M",3);
        vals.put("V",4);
        vals.put("Y",4);
        vals.put("J",8);
        vals.put("X",8);
        board = new Tile[4][10];
    }
    public void fillBoard()
    {
        for(int r=0;r<board.length;r++)
        {
            for(int c=0;c<board[r].length;c++)
            {
                board[r][c] = new Tile(r*10+(c+1));
                if(board[r][c].getNum()%3==0)
                {
                    board[r][c].setMult(1);
                    if((board[r][c].getNum()/3)%2==1)//if it is divisble by 3 with an odd factor
                    {
                        board[r][c].setMult(2);
                    }
                }
                else{} if((board[r][c].getNum()%5==0 && board[r][c].getMult()!=2))//if divisible by 5 and not a mult of 3
                {
                    board[r][c].setMult(3);
                }
                else{} if((board[r][c].getNum()%7==0 && board[r][c].getMult()==0))//if divisible by 7 and not assigned yet
                {
                    board[r][c].setMult(2);
                }
                else{} if((board[r][c].getNum()%8==0 && board[r][c].getMult()!=2))//if divisible by 8 and not assigned yet
                {
                    board[r][c].setMult(3);
                }
                else{} if(board[r][c].getMult()==0)
                {
                    board[r][c].setMult(1);
                }
                //System.out.print(board[r][c].getMult() + " ");
            }
            //System.out.println();
        }
    }
    public int getPoints(int pos,String dir,String[] w)
    {
        int rowInit=0;
        int colInit=0;
        int total=0;
        for(int r=0;r<board.length;r++)
        {
            for(int c=0;c<board[0].length;c++)
            {
                if(board[r][c].getNum()==pos)
                {
                     rowInit=r;
                     colInit=c;
                }
            }
        }
        if(dir.equalsIgnoreCase("V"))
        {
            for(int k=0;k<w.length;k++)//for each letter
            {
                if(rowInit<board.length&&colInit<board[0].length&&rowInit>=0&&colInit>=0)//for keeping in bounds
                {
                    total+=board[rowInit+k][colInit].getMult()*vals.get(w[k]);
                }
            }
        }
        if(dir.equalsIgnoreCase("H"))
        {
            for(int k=0;k<w.length;k++)//for each letter
            {
                if(rowInit<board.length&&colInit<board[0].length&&rowInit>=0&&colInit>=0)//for keeping in bounds
                {
                    total+=board[rowInit][colInit+k].getMult()*vals.get(w[k]);
                }
            }
        }
        return total;
    }
    public static void main(String[] args)
    {
        Scrabble s = new Scrabble();
        s.fillBoard();
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        String pos1 = scan.nextLine();
        String pos2 = scan.nextLine();
        String pos3 = scan.nextLine();
        String pos4 = scan.nextLine();
        String pos5 = scan.nextLine();
        String[]str = word.split(", ");
        String[]p1 = pos1.split(",");
        String[]p2 = pos2.split(",");
        String[]p3 = pos3.split(",");
        String[]p4 = pos4.split(",");
        String[]p5 = pos5.split(",");
        System.out.println(s.getPoints(Integer.parseInt(p1[0]),p1[1].trim(),str));
        System.out.println(s.getPoints(Integer.parseInt(p2[0]),p2[1].trim(),str));
        System.out.println(s.getPoints(Integer.parseInt(p3[0]),p3[1].trim(),str));
        System.out.println(s.getPoints(Integer.parseInt(p4[0]),p4[1].trim(),str));
        System.out.println(s.getPoints(Integer.parseInt(p5[0]),p5[1].trim(),str));
        /*for(String letter:str)
        {
        System.out.print(letter);
        }*/

    }
 }