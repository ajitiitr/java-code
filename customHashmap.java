
public class customHashmap {
	
	private int SIZE = 4;
	private Enter[] table;
	
	public customHashmap()
	 {
		 table = new Enter[SIZE];
	 }
		 
	class Enter{
		Object key;
		Object value;
		Enter next;
		public Enter(Object key,Object Value,Enter next)
		{
			super();
			this.key= key;
			this.value= Value;
			this.next=next;
			
			
		}
		
	
	 public void put(Object key,Object value)
	 {
		 if(key==null)
			 return;
		 int hash = hash(key);
		 Enter newE = new Enter(key,value,null);
		 if(table[hash]==null)
		 {
			 table[hash]=newE;
			 return;
		 }
		 else
		 {
			 Enter cur = table[hash];
			 Enter pre = null;
			 while(cur  !=null)
			 {
				 if(cur.key.equals(newE.key))
				 {
					 if(pre==null)
					 {
						 newE.next=cur.next;
						 return;
					 }
					 else
					 {
						 newE.next=cur.next;
						 pre.next=newE;
						 return;
					 }
				 }
				 pre = cur;
				 cur=cur.next;
			 }
			 
			 pre.next=newE;
		 }
	 } 
	 
	 public Object get(Object k)
	 {
		 int hash = hash(k);
		 if(table[hash]==null)
			 return null;
		 else
		 {
			 Enter cu = table[hash];
			 while(cu!=null)
			 {
				 if(cu.key.equals(k))
					 return cu.value;
				 cu = cu.next;
			 }
			 return null;
		 }
		 
		 
	 }
	 
	 public int hash(Object key)
	 {
		 return Math.abs(key.hashCode()%SIZE);
	 }
	 
 }
}
