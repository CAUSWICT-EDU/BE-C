import java.util.Scanner;
import java.util.Random;

public class baseball {

    static int[] Uanswer = new int[3];
    static int[] Ranswer = new int[3];

    public static boolean samedata (int[] array, int number, int indexN) { // 중복 숫자 검사

       // int index = indexN;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number && i!= indexN) {
                return true;
            }
        }
        return false;
    }
    public void real_answer(){ //랜덤으로 수 세 개 지정하기 >> 컴퓨터가 만든 진짜 정답
        Random random = new Random();
        for(int i = 0; i<3; i++) {
            Ranswer[i] = random.nextInt(9) + 1;
            if  (samedata(Ranswer, Ranswer[i], i)) { // 컴퓨터 입력 중복 방지
                i = i - 2;
            }
        }
    }
    public void user_answer() {  //사용자가 수 세 개 입력하기

        Scanner scanner = new Scanner(System.in);
        System.out.println("한 자리 수 정수를 세 개 입력하세요 (중복 금지)");

        for (int i = 0; i < 3; i++) {
            Uanswer[i] = scanner.nextInt();
            if (Uanswer[i] > 9 || Uanswer[i] == 0) { // 사용자가 범위가 아닌 수를 자리를 입력했을 때
                System.out.println("범위에 맞지 않은 입력입니다. 다시 입력해주세요");
                i--;
            }
            else if (samedata(Uanswer, Uanswer[i],i)){ // 사용자 입력 중복 검사
                System.out.println("중복된 입력입니다. 다시 입력해주세요");
                i--;
            }
        }

        System.out.printf("입력한 정수는 "); //사용자가 입력받은 수 확인하기 (생략 가능)
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d", Uanswer[i]);
        }
        System.out.println("입니다.");
    }

     public static void main(String[] args) {

        baseball game = new baseball();
        game.real_answer();
        int gamecount = 1;

         // 게임 시작
         while(true){

            // 초기화
             int strikecount = 0;
             int ballcount = 0;

            //사용자의 게임 시작
             game.user_answer();

             //strike, ball 개수 검사
             for(int i = 0; i<3; i++){
                 if (Uanswer[i] == Ranswer[i]){
                     strikecount ++; }
                 else{
                     for(int j = 0; j<3; j++) {
                         if (i != j && Uanswer[j] == Ranswer[i]){
                             ballcount++;} }

             }}

             // 게임 결과
             System.out.printf("[%d]회차 %d스트라이크 %d볼\n",gamecount, strikecount, ballcount);

             if(strikecount==3){
                 System.out.println("게임 성공");

                 System.out.printf("정답은 ");
                 for (int i = 0; i < 3; i++) {
                     System.out.printf("%d", Ranswer[i]);
                 }
                 System.out.println("입니다.");
                 break;}

             else if (gamecount>=9) {
                 System.out.println("게임 실패");

                 System.out.printf("정답은 ");
                 for (int i = 0; i < 3; i++) {
                     System.out.printf("%d", Ranswer[i]);
                 }
                 System.out.println("입니다.");

                 break;}

             //재시작
             gamecount ++;
             for (int i = 0; i < Uanswer.length; i++) { //사용자 배열 초기화
                 Uanswer[i] = 0;
             }

         }
    }
}