import java.util.ArrayList;

public class MergeSort {

	public static ArrayList<Integer> mergesrt(ArrayList<Integer> A)
	{
		int n = A.size();
		if(n<2)
			return A;
		int mid = n/2;
		ArrayList<Integer> L = new ArrayList<Integer>(mid);
		ArrayList<Integer> R = new ArrayList<Integer>(n-mid);
		for(int i = 0; i<mid;i++)
			L.add(i, A.get(i));
		for(int i=0;i<n-mid;i++)
			R.add(i,A.get(mid+i));
		
		L = mergesrt(L);
		R = mergesrt(R);
		A = merge(L, R, A);		
		
		return A;
	}
	private static ArrayList<Integer> merge(ArrayList<Integer> L,ArrayList<Integer> R, ArrayList<Integer> A)
	{
		
		int n1= L.size();
		int n2= R.size();
		int i=0,j=0,k=0;
		while(i<n1&&j<n2)
		{
			if ((Integer)L.get(i)<=(Integer)R.get(j))
			{
				A.set(k,L.get(i));
				i++;
			}
			else
			{
				A.set(k,R.get(j));
				j++;
			}
			k++;
		}
		while(i<n1)
		{
			A.set(k,L.get(i));
			i++;
			k++;
		}
		while(j<n2)
		{
			A.set(k,R.get(j));
			j++;
			k++;
		}
		return A;
	}
}
