package com.teedjay;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Named
@SessionScoped
public class ScopedBeanForSession {

    private String msg = "The Session Scoped Bean was created @ " + LocalDateTime.now().toString();
    private AtomicInteger clicks = new AtomicInteger();

    public String getMsg() {
        return msg;
    }

    public int getClickCount() {
        return clicks.get();
    }

    public void onClick() {
        int number = clicks.incrementAndGet();
    }

}
