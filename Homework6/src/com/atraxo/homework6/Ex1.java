package com.atraxo.homework6;

import java.util.ArrayList;
import java.util.Collection;
//[ZP] - 10
public class Ex1 {
	static Sink<Object> s;
    static Collection<String> cs;
	
	public static void main(String[] args) {
	
		s = new Sink<Object>() {

			@Override
			public void flush(Object t) {
				System.out.println(t);
			}
		};
		
		cs = new ArrayList<>();
		cs.add("a");
		cs.add("b");
		cs.add("c");
		
	    String str = writeAll(cs, s);
	    System.out.println(str);
	}
	
	public static <T> T writeAll(Collection<T> cs, Sink<Object> s){ 
        T last = null;
        for (T t : cs) { 
            last = t;
            s.flush(last);
        }
        return last;
    }  
}

interface Sink<T> { 
    void flush(T t); 
}
