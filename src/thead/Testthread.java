package thead;

public class Testthread {
	static String[] strarr = new String[10]; // strarr[10] = "10";
	public static void main(String[] args) {
		Testthread testthread  = new Testthread();
		testthread.dosomr();
		for(int i = 0 ; i < strarr.length; i++){
			Thread th = new Thread(new Runables(testthread,strarr[i]));
			th.start();
		}
		
	}
	public void dosomr(){
		for(int i=0;i<10;i++){
			strarr[i] = i+"1";
		}
	}
	
	public void  test(String i){
//		for (int i = 0; i < 10; i++) {
//			try {
//				Thread.currentThread().sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
			System.out.println(Thread.currentThread().getName()+"&&&&" + i  );
//		}
	}
}
