package com.teedjay;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Named
@RequestScoped
public class ScopedBeanForRequest {

    private String msg = "The Request Scoped Bean was created @ " + LocalDateTime.now().toString();
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
