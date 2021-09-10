package com.teedjay;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Named
@SessionScoped
public class ScopedBeanForSession implements Serializable {

    private String msg = "The Session Scoped Bean was created @ " + LocalDateTime.now().toString();
    private AtomicInteger clicks = new AtomicInteger();

    public String getMsg() {
        return msg;
    }

    public int getClickCount() {
        return clicks.get();
    }

    public void onClick() {
        clicks.incrementAndGet();
    }

}
