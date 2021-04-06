package level1;

import java.util.HashSet;
import java.util.Set;

class SetToArray {
	public static void main(String args[]) {
		
	}
    public int[] solution(int[] numbers) {
        int[] answer;
        Set<Integer> numset = new HashSet<>();
        int num = 0;
        
        for(int i : numbers){
            for(int j : numbers){
            	System.out.println(i+j);
                numset.add(i+j);
            }
        }
        
        answer = new int[numset.size()];
        numset.toArray();
        
        return answer;
    }
}