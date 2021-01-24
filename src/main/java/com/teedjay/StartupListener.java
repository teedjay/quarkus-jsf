package com.teedjay;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // https://primefaces.github.io/primefaces/8_0/#/gettingstarted/configuration
        sce.getServletContext().setInitParameter("primefaces.THEME", "arya");
    }

}

