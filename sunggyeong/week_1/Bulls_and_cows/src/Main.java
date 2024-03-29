
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //컴퓨터와 사용자의 배열 생성
        Number computer=new Number();
        Number user=new Number();

        int[] computer_array=computer.makeComputerNumber();

        for(int i=0; i<9;i++){
            int[] user_array=user.makeUserNumber();
            //strike와 foul계산
            StrikeFoul strike=new StrikeFoul();
            StrikeFoul foul=new StrikeFoul();

            int strikeResult=strike.calculateStrike(computer_array,user_array);
            int foulResult=foul.calculateFoul(computer_array,user_array);

            //strike가 3개면 사용자 승리
            if(strikeResult==3){
                System.out.println("You win!");
                break;
            }

            //마지막 회차까지 못 맞출 경우 사용자 패배
            if(i==8){
                System.out.println("You lose!");
            }

            //아니면 strike와 foul 개수 출력
            else{
                System.out.println("strike:"+strikeResult+" foul:"+foulResult);
                System.out.println("남은 기회:"+(8-i));
            }

        }

    }















}