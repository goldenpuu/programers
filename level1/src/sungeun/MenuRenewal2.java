package sungeun;

//다른사람 풀이를 봄

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Arrays;

class MenuRenewal2 {
 static HashMap<String, Integer> map; // 재귀함수에서 찾은 값을 넣어주기 위해 static선언
 static int m; // 마찬가지로 static int
 
 public String[] solution(String[] orders, int[] course) {
     PriorityQueue<String> pq = new PriorityQueue<>(); //answer를 알파벳 순으로 반환받기위한 pq
     for(int i = 0; i < course.length; i++){ // 코스 배열의 수 만큼 반복
         map = new HashMap<>();
         m = 0;
         for(int j = 0; j < orders.length; j++){
             find(0, "", course[i], 0, orders[j]);
         }
         for(String s : map.keySet()){
             if(map.get(s)==m && m > 1){
                 pq.offer(s);
             }
         }
     }
     String answer[] = new String[pq.size()];
     int k = 0;
     while(!pq.isEmpty()){
         answer[k++] = pq.poll();
     }
     return answer;
 }
 
 static void find(int cnt, String str, int targetNum, int idx, String word){ // 재귀함수(1str의 갯수, 2현재str, 3현재 course의 길이, 4인덱스, 5현재 order)
     if(cnt == targetNum){
         char[] c = str.toCharArray();
         Arrays.sort(c);
         String temps="";
         for(int i=0; i<c.length; i++){
             temps += c[i];
         }
         map.put(temps, map.getOrDefault(temps, 0)+1); // map.getOrDefault의 인자는 (Key, defValue)로key 값이 있으면 매칭되는 밸류를 반환, 없다면 defValue를 반환하는 메서드이다.
         m = Math.max(m, map.get(temps));
         return;
     }
     for(int i=idx; i<word.length(); i++){
         char now = word.charAt(i);
         find(cnt+1, str+now, targetNum, i+1, word);
     }
 }
}