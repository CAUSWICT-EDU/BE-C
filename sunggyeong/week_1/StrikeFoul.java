public class StrikeFoul{
    //strike와 foul 개수
    int strike;
    int foul;

    //배열의 자릿수
    int digit=Number.digit;
    
    //strike 개수 계산
    public int calculateStrike(int[] number_array1, int[] number_array2){
        strike=0;
        for(int i=0;i<digit;i++){
            if(number_array1[i]==number_array2[i]){
                strike++;
            }
            else{
                continue;
            }
        }

        return strike;
    }

    //foul 개수 계산
    public int calculateFoul(int[] number_array1, int[] number_array2){
        foul=0;
        for(int i=0;i<digit;i++){
            for(int j=0; j<digit; j++){
                if(number_array1[i]==number_array2[j]){
                    if(i!=j) {
                        foul++;
                    }
                }
            }
        }

        return foul;
    }
}
