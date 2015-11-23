class multiThreadBasic implements Runnable{
	public void run(){
		System.out.println("My thread is in the running state.");
	}

	public static void main(String args[]){
			multiThreadBasic obj = new multiThreadBasic();

			Thread tobj = new Thread(obj);
			tobj.start();
	}
}