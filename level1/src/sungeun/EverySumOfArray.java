package sungeun;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class EverySumOfArray {
    public int[] solution(int[] numbers) {
        int[] answer;
        Arrays.sort(numbers);
        
        Set<Integer> set = new HashSet();
        
        for(int x = 0; x < numbers.length-1; x++){
            for(int y = x+1; y < numbers.length; y++){
                set.add(numbers[x] + numbers[y]);
            }
        }
        
        answer = new int[set.size()];
        int idx = 0;
        for(int i : set){
            answer[idx] = i;
            idx++;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}