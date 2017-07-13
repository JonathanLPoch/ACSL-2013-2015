//Jonathan Poch FPHS
import java.util.Scanner;
import java.util.Arrays;
/*
3, 12, 17, 22, 3, 4, 14, 10
3, 12, 17, 22, 3, 9, 10, 15
3, 12, 17, 22, 3, 25, 9, 5
3, 12, 17, 22, 3, 5, 15, 20
3, 12, 17, 22, 3, 3, 18, 19
3, 12, 17, 22, 3, 4, 14, 10
3, 12, 17, 22, 3, 9, 10, 15
3, 12, 17, 22, 3, 25, 9, 5
3, 12, 17, 22, 3, 5, 15, 20
5, 12, 17, 22, 15, 14, 5, 1, 2, 3, 4, 26
*/
public class Fanorona
{
    public static void main(String[] args)
    {
        int[] shiftVal = new int[] {-5,-4,1,6,5,4,-2,-6};
        int[] forward    = new int[] {-10,-8,2,12,10,8,-2,-12};
        int[] backwards       = new int[] {5,4,-1,-6,-5,-4,1,6};
        String out = "";
        int wNum = 0, bNum =0, combo = 0, firstBlack=0, comboPath =0;
        boolean moveMade = false;
        boolean[][] forwardPossible;
        boolean[][] backwardPossible;
        char[] board = new char[50];
        Scanner x = new Scanner(System.in);
        forwardPossible = new boolean [][]
        {
            {false,false,false,false,false,false,
                 false,false,false,false,false,
                 true,true,true,true,true,
                 true,true,true,true,true,
                 true,true,true,true,true},
                {false,false,false,false,false,false,
                       false,false,false,false,false,
                       false,false,true,false,false,
                       false,true,false,false,false,
                       true,false,false,false,false},
                {false,true,true,true,false,false,
                       true,true,true,false,false,
                       true,true,true,false,false,
                       true,true,true,false,false,
                       true,true,true,false,false},
                {false,true,false,false,false,false,
                       false,true,false,false,false,
                       false,false,true,false,false,
                       false,false,false,false,false,
                       false,false,false,false,false},
                {false,true,true,true,true,true,
                       true,true,true,true,true,
                       true,true,true,true,true,
                       false,false,false,false,false,
                       false,false,false,false,false},
                {false,false,false,false,false,true,
                       false,false,false,true,false,
                       false,false,true,false,false,
                       false,false,false,false,false,
                       false,false,false,false,false},
                {false,false,false,true,true,true,
                       false,false,true,true,true,
                       false,false,true,true,true,
                       false,false,true,true,true,
                       false,false,true,true,true},
                {false,false,false,false,false,false,
                       false,false,false,false,false,
                       false,false,true,false,false,
                       false,false,false,true,false,
                       false,false,false,false,true}
            };
            backwardPossible = new boolean [][]
            {
                {false,false,false,false,false,false,
                       true,true,true,true,true,
                       true,true,true,true,true,
                       true,true,true,true,true,
                       false,false,false,false,false},
                {false,false,false,false,false,false,
                       false,false,false,true,false,
                       false,false,true,false,false,
                       false,true,false,false,false,
                       false,false,false,false,false},
                {false,false,true,true,true,false,
                       false,true,true,true,false,
                       false,true,true,true,false,
                       false,true,true,true,false,
                       false,true,true,true,true},
                {false,false,false,false,false,false,
                       false,true,false,false,false,
                       false,false,true,false,false,
                       false,false,false,true,false,
                       false,false,false,false,false},
                {false,false,false,false,false,false,
                       true,true,true,true,true,
                       true,true,true,true,true,
                       true,true,true,true,true,
                       false,false,false,false,false},
                {false,false,false,false,false,false,
                       false,false,false,true,false,
                       false,false,true,false,false,
                       false,true,false,false,false,
                       false,false,false,false,false},
                {false,false,true,true,true,false,
                       false,true,true,true,false,
                       false,true,true,true,false,
                       false,true,true,true,false,
                       false,true,true,true,false},
                 {false,false,false,false,false,false,
                       false,true,false,false,false,
                       false,false,true,false,false,
                       false,false,false,true,false,
                       false,false,false,false,false}
            };
                    System.out.print("\nEnter values \n");

        for(int a=0;a<5;a++)
        {
            Arrays.fill(board, 'E');
            combo = 0;
            moveMade = false;
            firstBlack = 0;
            String[] newString = x.nextLine().split(",");
            String in = "";
            for(String s:newString)
            {
                in+=s;
            }
            Scanner sc = new Scanner(in);
            wNum = sc.nextInt();
            int[] whitePieces = new int[wNum];
            for(int b=0;b<wNum;b++)
            {
                whitePieces[b] = sc.nextInt();
                board[whitePieces[b]] = 'W';
            }

            bNum = sc.nextInt();
            for(int b=0;b<bNum;b++)
                board[sc.nextInt()] = 'B';

            for(int currentWhite=0;currentWhite<wNum;currentWhite++)
            {
                if(moveMade)
                    break;
                else
                {
                    for(int moveDirection=0;moveDirection<8;moveDirection++)
                    {
                        if(!moveMade && forwardPossible[moveDirection][whitePieces[currentWhite]] && board[whitePieces[currentWhite]+shiftVal[moveDirection]] == 'E' && board[whitePieces[currentWhite]+forward[moveDirection]] == 'B')
                        {
                            firstBlack = whitePieces[currentWhite]+forward[moveDirection];
                            moveMade = true;
                            comboPath = moveDirection;
                        }
                        if(!moveMade && backwardPossible[moveDirection][whitePieces[currentWhite]] && board[whitePieces[currentWhite]+shiftVal[moveDirection]] == 'E' && board[whitePieces[currentWhite]+backwards[moveDirection]] == 'B')
                        {
                            firstBlack = whitePieces[currentWhite]+backwards[moveDirection];
                            moveMade = true;
                            comboPath = moveDirection>3?moveDirection-4:moveDirection+4;
                        }
                        if(moveMade)
                        {
                            combo = 0;
                            out+="\n";
                            while((forwardPossible[comboPath][firstBlack-shiftVal[comboPath]+shiftVal[comboPath]*combo]||backwardPossible[comboPath][firstBlack-shiftVal[comboPath]+shiftVal[comboPath]*combo]) && board[firstBlack+shiftVal[comboPath]*combo] == 'B')
                            {
                                out+= firstBlack+shiftVal[comboPath]*combo + " ";
                                //System.out.print(firstBlack+shiftVal[comboPath]*combo + " ");
                                combo+=1;
                            }
                            out+="\n";
                            break;
                        }
                    }
                }
            }
            if(!moveMade)
                out+="NONE";
            out+=("\n");

        }
        System.out.print(out);
    }
}