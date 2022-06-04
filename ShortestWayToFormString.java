import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Time Complexity : O(nlogm); where m and n are lengths of source and target strings.
//Space Complexity : O(m)
public class ShortestWayToFormString { 	
	/**Approach: HashMap + Binary Search**/
	public int shortestWay(String source, String target) {        
        //Prepare map to store all indices of source chars.
        Map<Character, List<Integer>> map= new HashMap<>();
        for(int i=0; i<source.length(); i++){
            char c= source.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }
        
        //Scan target and count how many times source can be used.
        int count=1;        
        int i=0; //target index
        int j=0; //source index
        while(i < target.length()){
            char c= target.charAt(i); 
            //If target char is not in source char map
            if(!map.containsKey(c)) return -1;     
            
            //Else, find the next position of target char in source string
            List<Integer> list = map.get(c);
            int k= Collections.binarySearch(list, j);
            //If element not found, Collections.binarySearch returns -ve index i.e. -k-1 position. 
            if(k < 0)  {
                k = -k-1;
            }
            //if index is beyond the source indices, means source string exhausted.
            if(k == list.size()){
                j = 0; //reset to start of source
                count++;
            }else{
                j = list.get(k);
                i++;
                j++;
            }
        }
        return count;
    }
    
	// Driver code to test above
	public static void main (String[] args) {	
		ShortestWayToFormString ob  = new ShortestWayToFormString();	
		String source = "abc";//"xyz";
		String target = "acdbc";//"xzyxz";
		System.out.println("Min number of times subsequences of source can be used to form target: "+ ob.shortestWay(source,target));         
	}
}
