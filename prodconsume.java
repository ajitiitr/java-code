import java.util.ArrayList;

class prod implements Runnable
{
	ArrayList<Integer> prodt;
	public prod()
	{
		prodt = new ArrayList<>();				
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this)
		{
			System.out.println("Production strated");
			for(int i=0;i<10;i++)
				{prodt.add(i);
				System.out.println("Production strated for "+i);}
				
			try{
				Thread.sleep(1000);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("Production Over");
			this.notify();
		}
		}
	}

class cons extends Thread{
	prod p;
	public cons(prod o)
	{
		p = (prod) o;
	}
	
	public void run()
	{
		
		
		synchronized(this.p)
		{
			System.out.println("consumer is waiting to consume");
			try {
				this.p.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int s = p.prodt.size();
		for(int i=0;i<s;i++)
		{
			System.out.println("consumint "+i+" by thread" +Thread.currentThread().getName());
		}
	}
}





public class prodconsume {	
	
	

	public static void main(String[] args) throws InterruptedException {
		prod p = new prod();
		cons c = new cons(p);
		
		Thread pt = new Thread(p, "Producer");
		Thread ct= new Thread(c, "consumer");
				
		ct.start();
		Thread.sleep(100);
		pt.start();
		

	}

}
