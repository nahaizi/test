package thead;

import java.util.ArrayList;
import java.util.List;

public class LargDataWithRunnable  {
	 public static void main(String[] args) {  
	        final ShareData shareData = new ShareData();  
	        new Thread(new Runnable() {  
	            @Override  
	            public void run() {  
	                while (true) {  
	                    shareData.decrease();  
	                }  
	            }  
	        }).start();  
	        new Thread(new Runnable() {  
	            @Override  
	            public void run() {  
	                while (true) {  
	                    shareData.increment();  
	                }  
	  
	            }  
	        }).start();  
	    }  
	  
	    static class ShareData {  
	        int count = 100;  
	  
	        public synchronized void decrease() {  
	            count--;  
	            System.out.println(Thread.currentThread().getName() + "this count: " + count);  
	        }  
	  
	        public synchronized void increment() {  
	            count++;  
	            System.out.println(Thread.currentThread().getName() + "this count: " + count);  
	        }  
	    }  
}
