import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] com_nums = new Random().ints(1, 10).distinct().limit(3).toArray();

        for(int i = 0; i < 9; ++i){
            int strike = 0;
            int ball = 0;
            int[] user_nums = {0, 0, 0};
            int error_code = 0;

            System.out.printf("[%d회차 숫자야구]\n", i + 1);
            System.out.print("1부터 9까지의 숫자를 입력하세요 : ");

            for (int j = 0; j < 3; ++j){
                int user_num;
                try{
                    user_num = scan.nextInt();
                    if ( user_num < 1 || user_num > 9){ // 숫자가 범위를 벗어난 경우
                        error_code = 2;
                        break;
                    }
                    else if (Arrays.stream(user_nums).anyMatch(num -> num == user_num)){ // 숫자가 중복될 경우
                        error_code = 3;
                        break;
                    }
                    else if (user_num == com_nums[j]) // 컴퓨터의 같은 자리에 같은 수가 있는 경우
                        ++strike;
                    else if(Arrays.stream(com_nums).anyMatch(num -> num == user_num)) // 컴퓨터의 수에 있는 경우
                        ++ball;

                    user_nums[j] = user_num;
                } catch (Exception e){ // 숫자 외의 입력이 들어왔을 경우
                    error_code = 1;
                    scan.nextLine(); // 버퍼 삭제
                    break;
                }
            }

            if (error_code > 0){ // 에러 코드에 따른 텍스트 출력
                if (error_code == 1)
                    System.out.println("잘못된 입력입니다.\n");
                else if (error_code == 2)
                    System.out.println("범위 밖의 숫자입니다.\n");
                else if(error_code == 3)
                    System.out.println("중복된 숫자입니다.\n");

                --i;
                continue;
            }


            System.out.printf("[결과]스트라이크 : %d, 볼 : %d\n\n", strike, ball);

            if(strike == 3){
                System.out.print("***** 승리했습니다. *****");
                return;
            }
        }
        System.out.print("***** 컴퓨터가 승리했습니다. *****");
    }
}