import java.util.HashMap;
import java.util.Map;

//Time Complexity : O(n); where n is length of dominoes array.
//Space Complexity : O(1)
public class MinDominoRotationsForEqualRow { 
	/**Approach2: Greedy**/
	public int minDominoRotations(int[] tops, int[] bottoms) {
		//Check first element of which of the array works. If none works, means not possible to have all same.
        int target = check(tops, bottoms, tops[0]);
        if(target != -1) return target;
        return check(tops, bottoms, bottoms[0]);
    }
    private int check(int[] a, int[] b, int target){ 
        int aRot=0; int bRot=0;
        for(int i=0; i<a.length; i++){
            if(target != a[i] && target != b[i]) return -1;
            if(target != a[i]) aRot++;
            if(target != b[i]) bRot++;
        }
        return Math.min(aRot, bRot);
    }
    
	// Driver code to test above
	public static void main (String[] args) {	
		MinDominoRotationsForEqualRow ob  = new MinDominoRotationsForEqualRow();			
		int[] tops = {2,1,2,4,2,2};
		int[] bottoms = {5,2,6,2,3,2};
		System.out.println("Min rotations to have all the values in tops/bottoms as same: "+ob.minDominoRotations(tops, bottoms));
	}
}
