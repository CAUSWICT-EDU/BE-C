package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Player {
    ArrayList<Integer> nums;

    public void inputNums(int size){
        System.out.print("숫자를 입력해 주세요 : ");
        String input = input();
        checkException(input, size);
        nums = convertStringToNums(input);
    }

    public String input(){
        return Console.readLine();
    }

    public ArrayList<Integer> getNums() {
        return nums;
    }

    private void checkException(String input, int size){
        System.out.println(size);
        String regex = "\\d(?:\\s\\d{1}){" + (size - 1) + "}";

        if (!input.matches(regex))
            throw new IllegalArgumentException("Invalid argument: " + input);
    }

    private ArrayList<Integer> convertStringToNums(String input){
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
