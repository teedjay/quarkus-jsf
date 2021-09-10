package com.teedjay;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Named
@ViewScoped
public class ScopedBeanForView {

    private String msg = "The View Scoped Bean was created @ " + LocalDateTime.now().toString();
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
