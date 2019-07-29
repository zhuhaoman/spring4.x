package com.zhuhaoman.aop;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SimpleThreadLocal
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/7/29 13:57
 **/
public class SimpleThreadLocal {
    private Map valueMap = Collections.synchronizedMap(new HashMap<>());

    public void set(Object newValue) {
        valueMap.put(Thread.currentThread(),newValue);
    }

    public Object get() {
        Thread currentThread = Thread.currentThread();
        Object o = valueMap.get(currentThread);
        if (o == null && !valueMap.containsKey(currentThread)) {
            o = initialValue();
            valueMap.put(currentThread,o);
        }
        return o;
    }

    protected Object initialValue() {
        return null;
    }

    public void remove() {
        valueMap.remove(Thread.currentThread());
    }
}
