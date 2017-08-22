package thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thead extends Thread {

	 String[] strarr = new String[1000000]; // strarr[10] = "10";
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Thead thead = new Thead();
		thead.dosomething();
		System.out.println("main   end");
	}

	/**
	 * 
	 */
	public void dosomething() {

		for(int i=0;i<10;i++){
			strarr[i] = i+"1";
		}
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();  
		cachedThreadPool.execute(new Runnable2(strarr));
		for(int i=0;i<10;i++){
			strarr[i] = i+"00000";
		}
		for(int i=0;i<3;i++){
//			strarr[i] = i+"0";
			synchronized (Runnable2.class) {
				cachedThreadPool.execute(new Runnable2(strarr));
			}
		}
		cachedThreadPool.shutdown();
		if(cachedThreadPool.isShutdown()){
			System.out.println("end");
		}
		while(true){
			if(cachedThreadPool.isTerminated()){
				System.out.println(Thread.currentThread().getName()+"¹Ø±Õ");
				break;
			}
		}
		
		
//		
//		Thread th = new Thread(new Runnable2());
//		th.setName("BBBBBBBBBB");
//		th.start();
//		Thread th2 = new Thread(new Runnable2());
//		th2.setName("AAA");
//		th2.start();
//		if(th2.isAlive()){
//			try {
//				th.join(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

	// @Override
	public static class Runnable2 implements Runnable {
		    static String[] strarr = new String[1000000]; 
			public Runnable2(String[] arr){
//				strarr = new String[1000000];
				this.strarr = arr;
			}
			@Override
			public synchronized void run() {
				doanything(this.strarr);
			}
	}
	public synchronized static void doanything(String[] strarr){
		for (int i = 0; i < 10; i++) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"&&&&" + strarr[i]);
		}
	}
}
