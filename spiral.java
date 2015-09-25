import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class spiral {

	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 int LR = 0;
		 int LC = 0 ;
		 int UR = a.size()-1;
		 int UC = a.get(0).size()-1;
		 
		 
		 while (LR < UR && LC < UC)
		 {
			 for(int i = LC ; i <= UC; i++)
				 result.add((a.get(LR).get(i)));
			 LR++;
			 
			 for(int i = LR ; i <= UR; i++)
				 result.add(a.get(i).get(UC));
			 UC--;
			 
			 for(int i = UC ; i >= LC; i--)
				 result.add(a.get(UR).get(i));
			 UR--;
			 
			 for(int i = UR ; i >= LR; i--)
				 result.add(a.get(i).get(LC));
			 LC++;
		 }		 
		
		 return result;
	}
	public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < A.size(); i++) {
			ret.add(A.get(i + B));
		}
		return ret;
	}
	
	public int maxSubArray(final List<Integer> a) {
	     
	    int maxsum= a.get(0);
	    int cursum = a.get(0);
	    for(int i =1;i<a.size();i++)
	    {
	    	cursum = Math.max(a.get(i), cursum+a.get(i));
	    	maxsum = Math.max(maxsum, cursum);
	    }    
	    
	    return maxsum;
	    
	    
	    
	}
	 
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		int n = a.size();
		int index =-1;
		for(int i=n-1;i>=0;i--)
		{
			if(a.get(i)!=9)
			{
				a.set(i, a.get(i)+1);
				break;
			}
			else
			{
				a.set(i, 0);
				index=-1;
			}
		}
		if(index == 0)
		{
			a.add(0);
			a.set(0, 1);
		}
		else
		for(int i=0;i<n;)
		{
			if(a.get(i)!=0)
				break;
			else
			{
				a.remove(i);
				i=0;
			}
		}		
		return a;
	}
	 
	 
	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		
		Collections.sort(arrive);
		Collections.sort(depart);
		int ar=0,de=0,sat=0,nos=0;
		while(ar<arrive.size()&&de<depart.size())
		{
			if(arrive.get(ar)<depart.get(de))
			{
				ar++;
				nos++;
				sat=Math.max(sat, nos);
			}
			else
			{
				de++;
				nos--;
			}
		}
		
		return sat<=K?true:false;
    }
	
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
		Collections.sort(a);
		
		for(int i=0;i<a.size()-2;i+=2)
		{
			int tmp = a.get(i);
			a.set(i, a.get(i+1));
			a.set(i+1, tmp);
		}
		
		return a;
	}
	
	
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
}
