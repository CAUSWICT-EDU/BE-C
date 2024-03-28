package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
    User user = new User();
    Game game = new Game();

    @Test
    void rightInput() {
        List<Integer> arr;
        arr = game.changeStringToInteger(user.enterUserInput());
        assertThat(arr).containsAnyElementsOf(Arrays.asList(1,2,3,4,5,6,7,8,9));
        System.out.println(game.changeStringToInteger(user.enterUserInput()));

        // 원래 테스트 코드는 콘솔 입력이 안되나..? main에선 되는데 왜 안되는지 모르겠다.
    }
}
