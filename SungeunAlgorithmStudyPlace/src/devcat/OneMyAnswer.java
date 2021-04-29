package devcat;

public class OneMyAnswer {
	class Solution {
	    public int[] solution(int[] lottos, int[] win_nums) {
	        int[] answer = new int[2];
	        int wins = 0;
	        int unknown = 0;
	        
	        for(int i = 0; i < lottos.length; i++){
	            if(lottos[i] == 0){
	                unknown++;
	                continue;
	            }
	            for(int num : win_nums){
	                if(lottos[i] == num){
	                    wins++;
	                    break;
	                }
	            }
	        }
	        if(wins < 1) wins = 1;
	        answer[0] = 7 - (wins+unknown);//최고 등수
	        answer[1] = 7 - wins;//최저 등수
	        if(answer[0] == 0) answer[0] = 1;
	        return answer;
	    }
	}
}
