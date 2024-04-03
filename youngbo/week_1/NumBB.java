import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumBB {
    public static void main(String args[]){

        //Setting Phase
        Random rd = new Random();
        rd.setSeed(System.currentTimeMillis());

        Scanner sc = new Scanner(System.in);

        int[] Answer = new int[3];
        Answer[0] = rd.nextInt(9)+1;   //1 ~ 9
        while(Answer[0] == Answer[1] || Answer[1] == Answer[2] || Answer[2] == Answer[0])
        {
            Answer[1] = rd.nextInt(9)+1;
            Answer[2] = rd.nextInt(9)+1;
        }

        int[] Player = new int[3];

        int Strike = 0;
        int Ball = 0;

        int ResultTrigger = 0;

        int CorrectInput = 1;
        //Main Phase
        for(int Turn = 1; Turn<=9; Turn++, Strike = 0, Ball = 0)
        {
            System.out.printf("[%d회차 숫자야구]\n", Turn);
            System.out.print("1부터 9까지의 숫자를 입력하세요 : ");
            for(int i = 0; i < 3; i++, CorrectInput =1)
            {
                //Input Phase
                try
                {
                    Player[i] = sc.nextInt();
                    if(Player[i] > 9 || Player[i] < 1)
                        CorrectInput = 0;
                }
                catch(InputMismatchException e)
                {
                    CorrectInput = 0;
                }

                if(CorrectInput == 0)
                {
                    System.out.println("[ERROR]1~9의 숫자를 입력해주세요.");
                    sc.nextLine();
                    i--;
                    continue;
                }

                //Count Phase
                for(int j = 0; j < 3; j++)
                {
                    if(Player[i] == Answer[j])
                    {
                        if(i==j)
                            Strike++;
                        else
                            Ball++;
                    }
                }
            }

            //Result Phase
            if(Strike == 3)
            {
                ResultTrigger = 1;
                break;
            }
            else if(Strike + Ball > 0)
            {
                System.out.printf("[결과] 스트라이크 : %d, 볼 : %d\n\n", Strike, Ball);
            }
            else
            {
                System.out.print("[결과] 아웃\n\n");
            }
        }
        //End Phase
        switch (ResultTrigger)
        {
            case 0: //Lose
                System.out.printf("패배했습니다. 답 : %d %d %d", Answer[0], Answer[1], Answer[2]);
                break;
            case 1: //Win
                System.out.printf("승리했습니다.");
                break;
        }

    }
}