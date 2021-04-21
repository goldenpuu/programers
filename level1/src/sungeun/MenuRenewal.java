package sungeun;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class MenuRenewal {
	class Solution {
	    public String[] solution(String[] orders, int[] course) {
	        String[] answer ={};
	        List<String> answerList = new ArrayList<String>();
	        
	        int cl; // Course Length
	        String ol; // Order list
	        Set<Character> set = new HashSet<Character>();
	        Map<String, Integer> strMap = new HashMap<String, Integer>();
	        
	        for(int i = 0; i < course.length; i++){
	            ol = "";
	            cl = course[i];
	            set.clear();
	            strMap.clear();
	            
	            // add unique Characters to set 
	            for(String str: orders){
	                for(int n = 0; n < str.length(); n++){
	                    set.add(str.charAt(n));
	                }
	            }
	            
	            // make Order List
	            Iterator<Character> it = set.iterator();
	            while(it.hasNext()){
	                ol += it.next();
	            }
	            // System.out.println(ol);
	            
	            int b_idx,b_len,r_idx,r_len=1;
	            String str = "";
	            int front_box_size = 1, after_box_size;
	            int max_num = 0;
	            
	            while(front_box_size < cl){
	                after_box_size = cl-front_box_size;
	                for(String cor_ord : orders){
	                    for(b_idx=0, b_len=front_box_size; (b_idx+b_len+r_len) <= cor_ord.length(); b_idx++){
	                        for(r_idx=(b_len==1) ? b_idx+b_len : b_idx+b_len+1, r_len=after_box_size; (r_idx+r_len) <= cor_ord.length(); r_idx++){
	                            for(int j = 0; j<b_len; j++){
	                                str += Character.toString(cor_ord.charAt(j+b_idx));
	                            }
	                            for(int j = 0; j<r_len; j++){
	                                str += Character.toString(cor_ord.charAt(j+r_idx));
	                            }
	                            char[] asd = str.toCharArray();
	                            Arrays.sort(asd);
	                            str = new String(asd);
	                            
	                            if(strMap.containsKey(str)){
	                                strMap.put(str,strMap.get(str)+1);
	                            }else{
	                                strMap.put(str,0);
	                            }
	                            str="";
	                        }
	                    }
	                }
	                front_box_size++;
	            }
	            // System.out.println(strMap.toString());
	            for(int num : strMap.values()){
	                if(num > max_num){
	                    max_num = num;
	                }
	            }
	            if(max_num > 0){
	                for(Map.Entry<String, Integer> entry : strMap.entrySet()){
	                    if(entry.getValue() == max_num){
	                        answerList.add(entry.getKey());
	                    }
	                }
	            }
	        }
	        answer = new String[answerList.size()];
	        int i = 0;
	        for(String s : answerList){
	            answer[i] = s;
	            i++;
	        }
	        
	        Arrays.sort(answer);
	        return answer;
	    }
}
