package com.bjsxt.dp.observer.original;

class Child implements Runnable  {

	private boolean wakenUp = false;
	
	void wakeUp(){
		wakenUp =true;
	}
	
	public boolean isWakenUp()
	{
		return wakenUp;
	}
	
	public void setWakenUp(boolean wakenUp)
	{
		this.wakenUp=wakenUp;
	}
	
	@Override
	public void run() {
		try
		{
			Thread.sleep(5000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		this.wakeUp();
	}

}

class Dad implements Runnable
{
	Child c;

	public Dad(Child c)
	{
		this.c=c;
	}
	
	@Override
	public void run() {
		while(!c.isWakenUp())
		{
			try
			{
				Thread.sleep(1000);
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		feed(c);
	}
	
	private void feed(Child c)
	{
		System.out.println("feed child");
	}
	
}

public class Test{
	public static void main(String[] args)
	{
		Child d = new Child();
		new Thread(d).start();
		new Thread(new Dad(d)).start();
	}
}
