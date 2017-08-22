package thead;

public class Runables implements Runnable {
	Testthread Testthread = new Testthread();
	String i = null;
	public Runables(Testthread testthread,String i){
		this.Testthread = testthread;
		this.i = i;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		i = i+"00000000000";
		System.out.println(Thread.currentThread().getName()+"&&&&" + i);
		Testthread.test(i);
	}

}
