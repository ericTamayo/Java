class Count implements Runnable{
	
	Thread myThread;
	
	Count(){
		myThread = new Thread(this,"My runnable thread");
		System.out.println("My thread created." + myThread);
		myThread.start();
	}
	
	public void run(){
		try{
			for(int i = 0; i<10; i++){
				System.out.println("Printing the Count: " + i);
				Thread.sleep(1000); //Suspends thread activity 
			}
		}
	

		catch(InterruptedException e){
		System.out.println("My thread interrupted.");
		}

		System.out.println("My thread is over");
	}

}

class multiThreadCount{
	public static void main(String args[]){
		Count count = new Count();
		try{
			while(count.myThread.isAlive()){//loop while thread is active
				System.out.println("Main thread will be alive till the child thread is live.");
				Thread.sleep(1500);
			} 

		}

		catch(InterruptedException e){
			System.out.println("Main thread Interrupetd.");
		}

		System.out.println("Main thread run over.");
	}
}