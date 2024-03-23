import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] com_nums = new Random().ints(1, 10).distinct().limit(3).toArray();

        for(int i = 0; i < 9; ++i){
            int strike = 0;
            int ball = 0;

            System.out.printf("[%d회차 숫자야구]\n", i + 1);
            System.out.print("1부터 9까지의 숫자를 입력하세요 : ");

            for (int j = 0; j < 3; ++j){
                int user_num = scan.nextInt();
                if (user_num == com_nums[j])
                    ++strike;
                else if(Arrays.stream(com_nums).anyMatch(num -> num == user_num))
                    ++ball;
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