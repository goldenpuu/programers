package yw;

public class RecommendationID {

}
class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        // 1단계
        
        answer = answer.replaceAll("[^a-z|0-9|_|.|-]", "");
        // 2단계
        
        answer = answer.replaceAll("\\.{2,}", ".");
        // 3단계
        
        answer = answer.replaceAll("^\\.", "");
        answer = answer.replaceAll("\\.$", "");
        // 4단계
        
        // 5단계
        if(answer.length() ==0){
            answer += "a";
        }
        if(answer.length() >15){
            answer = answer.substring(0,15);
            answer = answer.replaceAll("\\.$", "");
        }
        while(answer.length()<3){
            answer += Character.toString(answer.charAt(answer.length()-1));
        } // while
        

        
        System.out.println(answer);
        
        return answer;
    }
}