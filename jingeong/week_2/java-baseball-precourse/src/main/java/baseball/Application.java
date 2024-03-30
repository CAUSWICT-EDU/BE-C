package baseball;

    public class Application {
        public static void main(String[] args) {
            //TODO: 숫자 야구 게임 구현
            try {
                Game.getInstance();

            } catch (ExceptionInInitializerError e) {
                throw new IllegalArgumentException();

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

