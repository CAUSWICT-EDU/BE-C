import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;
public class Number {
    static int digit=3; //배열의 자릿수
    int[] number_array=new int[digit]; //배열

    //컴퓨터 배열 만들기
    public int[] makeComputerNumber(){
        Random random=new Random();
        number_array[0]=random.nextInt(9)+1;

        for(int i=1; i<digit;){
            //난수 생성 후 겹치는지 확인
            int number=random.nextInt(9)+1;
            boolean state=true;
            for(int j=0; j<i;j++){
                if(number_array[j]==number){
                    state=false;
                }
            }
            //state==true면 겹치는 수가 없다는 뜻! 컴퓨터 배열에 저장
            if(state==true){
                number_array[i]=number;
                i++;
            }

            //겹치면 false, 다시 난수 생성
            else{
                continue;
            }

        }
        return number_array;
    }

    //사용자에게 입력받은 정수로 배열 만들기
    public  int[] makeUserNumber(){
        Scanner scanner=new Scanner(System.in);
        for(int i=0; i<digit;){
            //1~9까지의 정수입력받고 배열에 저장
            System.out.print("정수(1~9)를 입력하세요: ");
            int userInput=scanner.nextInt();
            if(1<=userInput&&userInput<=9)
            {
                number_array[i]=userInput;
                i++;
            }

            //1~9까지의 정수입력이 아닐시 다시 입력받음
            else{
                continue;
            }

        }
        return number_array;
    }


}
