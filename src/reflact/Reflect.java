package reflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Reflect {
    public static <T> T initByDefaultConst()throws Throwable{  
        ClassLoader loader = Thread.currentThread().getContextClassLoader();  
        Class cls = loader.loadClass("reflact.Car");  
        Constructor cons = cls.getDeclaredConstructor((Class[])null);  
        
        Map<String, Object> map = new HashMap<String, Object>();
         
        Object car = cons.newInstance(); 
        map.put(cls.getName(), car);
          
          
        Field[] fil = cls.getDeclaredFields();
        for(int i = 0; i < fil.length ; i ++){
        	System.out.println(fil[i]);
        }
        Field c = cls.getDeclaredField("a");  
        c.setAccessible(true);  
        c.set(car, 888);  
        Method setBrand = cls.getMethod("setBrant",String.class);  
        setBrand.invoke(car, "aaaaa");  
        Method setColor = cls.getMethod("setColor",String.class);  
        setColor.invoke(car, "red");  
        Method setMaxSpeed = cls.getMethod("setMaxSpeed",int.class);  
        setMaxSpeed.invoke(car, 11);  
          
        return (T) car;  
    }  
    public static void main(String[] args) throws Throwable{  
    	Car car = initByDefaultConst();  
    	car.print();  
        System.out.println(car.toString());  
    }  
}
