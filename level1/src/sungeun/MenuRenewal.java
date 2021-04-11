package sungeun;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class MenuRenewal {
	class Solution {
	    public String[] solution(String[] orders, int[] course) {
	        String[] answer = {};
	        
	        int cl; // Course Length
	        String ol; // Order list
	        Set<Character> set = new HashSet<Character>();
	        Map<String, Integer> strMap = new HashMap<String, Integer>();
	        
	        for(int i = 0; i < course.length; i++){
	            ol = "";
	            cl = course[i];
	            
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
	            System.out.println(ol);
	            
	            for(int x = 1,b = 1, f = cl-b; x < ol.length()-b; x++,b++,f=cl-b){
	                System.out.println("f = "+f);
	                System.out.println("b = "+b);
	                for(int y = x+1; y < ol.length(); y++){
	                    
	                }
	            }
	            
	            
	            
	        }
	        
	        
	        return answer;
	    }
	}
}
