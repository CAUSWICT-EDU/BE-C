package baseball;

public  class Game {

    //public ErrorMessege error = new ErrorMessege();
    public GameService Service = new GameService();
    public Computer Computer = new Computer();
    public Player Player = new Player();

    public static int MAX_ROUND = 9; // 최대 라운드
    public static int NUMS_SIZE = 3; // 숫자야구 수 갯수
    public  int gameRound = 1; // 게임 라운드
    void start() {
        setup(); // 게임셋업
        //System.out.println(Computer.nums);
       while ( gameRound < MAX_ROUND) {
           startRound(); // 라운드 시작
           gameRound++; // 라운드 횟수 추가
       }
       GameEnd();
    }

    void setup() {
        this.explainGameRule(); // 게임룰 알려주는 설명 출력
        Computer.creatRandomNums(); // 컴퓨터가 NUM_SIZE 자리수의 난수 생성
    }

    void explainGameRule() {
        System.out.println("------------숫자야구------------");
        System.out.println("컴퓨터가 생성한 숫자를 추리하세요.");
        //System.out.println("명령어 도움은 /help를 입력하세요");
        System.out.println("------------------------------");

    }

    void startRound() {
        Player.getUserInput(); // 플레이어에게 3자리 수 입력받기
        Service.compareNums(Computer.nums, Player.nums); // 컴퓨터와 플레이어 숫자 비교하기
        Service.printRoundResult(); // 비교한 결과 출력하기
    }

    void printGameResult() {
        System.out.println(gameRound+"번 만에 맞췄습니다.");
    }

    void GameEnd() {
        System.out.println("게임을 종료합니다.");
        System.exit(0);
    }
}
