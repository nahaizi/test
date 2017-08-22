package test;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.Test;

import dto.Lidtdto;

public class TestJdk8 {

	public static void main(String[] args) {
//		TestJdk8 testjdk8 = new TestJdk8();
		URL[] urls = new URL[1];
//		urls[0] = "E:\\workspace\\test\\src";	
//		ClassLoader runtimeClassLoader = new URLClassLoader(urls);  
		try {
			Class<?> classdef = Class.forName("test.TestJdk8");
			Object object = classdef.newInstance();
			System.out.println(classdef.getName());
//			TestJdk8 testjdk8 = (TestJdk8)   
//					runtimeClassLoader.loadClass("test.TestJdk8").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		ParallelStreams ParallelStreams = ;
		
		List<Lidtdto> values = null;
        new ParallelStreams(values);
        
	}

	public static class ParallelStreams {

		int max = 1000_000;

		public ParallelStreams(List values) {
			// 创建一个包含唯一元素的大容器：
			values = new ArrayList<Lidtdto>();
			for (int i = max; i > 0; i--) {
				UUID uuid = UUID.randomUUID();
				Lidtdto dto = new Lidtdto();
			    dto.setId(uuid.getLeastSignificantBits());
			    dto.setDate(new Date());
			    dto.setRn(uuid.toString());
				values.add(dto);
			}
			sequentialSort(values);
			parallelSort(values);
		}
		// 测试排序这些元素需要多长时间。

		// Sequential Sort, 采用顺序流进行排序
		@Test
		public void sequentialSort(List values) {
			long t0 = System.nanoTime();

//			Collections.sort((values o1, values o2) -> o1.getDate().compareTo(o2.getDate()));		
			long count = values.stream().sorted(new Comparator<Lidtdto>() {
				@Override
				public int compare(Lidtdto o1, Lidtdto o2) {
					// TODO Auto-generated method stub
					long i = o1.getId();
					long k = o2.getId();
					
//					return i-k>0?1:0;
					return o1.getDate().compareTo(o2.getDate());
				}
			}).count();
			System.err.println("count = " + count);

			long t1 = System.nanoTime();

			long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
			System.out.println(String.format("sequential sort took: %d ms", millis));
			// sequential sort took: 1932 ms

		}

		// parallel Sort, 采用并行流进行排序
		@Test
		public void parallelSort(List values) {
			long t0 = System.nanoTime();
//			Comparators cs = ;
			long count = values.parallelStream().sorted(new Comparator<Lidtdto>() {
				@Override
				public int compare(Lidtdto o1, Lidtdto o2) {
					// TODO Auto-generated method stub
					long i = o1.getId();
					long k = o2.getId();
//					return i-k>0?1:0;
					return o1.getDate().compareTo(o2.getDate());
				}
			}).count();
			System.err.println("count = " + count);

			long t1 = System.nanoTime();

			long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
			System.out.println(String.format("parallel sort took: %d ms", millis));
			// parallel sort took: 1373 ms 并行排序所花费的时间大约是顺序排序的一半。
		}
	}
}
