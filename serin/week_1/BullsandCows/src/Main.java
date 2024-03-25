import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random ramdom = new Random();
        int game=1,Strike,Ball,Out=0;
        int Win=1,Lose=0;
        int Result=Lose; //기본 Result 값을 Lose로 정하여 9회가 모두 끝나버리면 패배할 수 있게 하였습니다.
        int error;
        int[] Answer = new int[3];
        int[] guess = new int[3];
        for (int i=0;i<3;i++){
            Answer[i] = ramdom.nextInt(9);
            for (int j=0;j<i;j++){
                if (Answer[i]==Answer[j]) i--; //정답 숫자 세개 중 중복된 수가 나올 경우를 제외하기
            }
        }
        Scanner scan = new Scanner(System.in);
        while(game<=9){
            Strike = 0;
            Ball=0;
            System.out.print("예상 숫자 세 개를 입력하세요 : ");
            for (int i=0;i<3;i++){ //예상 숫자를 세개 입력 받는다
                error = 0;
                try {
                    guess[i] = scan.nextInt(); /*try 블록에는 예외가 발생할 수 있는 코드가 있어야 한다고 해서 입력받는 부분을 입력하였습니다.
                    '예외가 발생할 수 있는 부분' == '입력을 받을 때 0~9사이가 아닌 다른 값이 들어오는 경우'이기 때문입니다.*/
                    if (guess[i]<0 || guess[i]>9) error=1; // 0에서 9 사이의 정수가 아니면 에러값이 1이 되도록 하였습니다.
                }catch (Exception e)
                {
                    error=1; //이외에도 다른 예외들이 발생할 경우 에러값 1이 되도록 하였습니다.
                }
                if (error == 1) { //에러값이 1일 경우 다시 입력을 받을 수 있도록 하였습니다.
                    System.out.println("입력 오류 ! 0~9사이 숫자 세 개를 다시 입력해주세요.\n");
                    i--;
                    continue;
                }
                for (int j=0;j<3;j++){ //예상숫자 하나와 정답숫자 세 개를 돌아가며 비교한다
                    if (guess[i]==Answer[j]){
                        if(i==j) Strike++;
                        else Ball++;
                    }
                }
            }
            if (Strike ==0 && Ball ==0){ //스트라이크와 볼 모두 없다면 아웃 처리
                Out++;
                System.out.printf("%d OUT\n",Out);
            }
            else if (Strike==3) { //스트라이크 세 개면 result 변수에 win을 대입
                System.out.printf("%d B %d S\n",Ball,Strike);
                Result=Win;
                break;
            }
            else {
                System.out.printf("%d B %d S\n",Ball,Strike);
            }
            if (Out==3) {
                break;
            }
            game++;
        }
        if (Result==Win) System.out.println("게임에 승리하였습니다.");
        else System.out.printf("게임에 패배하였습니다.정답은 %d %d %d입니다",Answer[0],Answer[1],Answer[2]);

    }
}