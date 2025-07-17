package com.pack1;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener
{
	@Override
    public void requestInitialized(ServletRequestEvent sre)
    {
    	System.out.println("Request object initialized");
    }
	@Override
    public void requestDestroyed(ServletRequestEvent sre)
    {
		System.out.println("Request object destroyed");
    }
	@Override
    public void attributeAdded(ServletRequestAttributeEvent srae)
    {
		System.out.println("Attribute added to servlet request");
		System.out.println("===>"+srae.getName());
    }
	@Override
    public void attributeRemoved(ServletRequestAttributeEvent srae)
    {
		System.out.println("Attribute removed from servlet request");
    }
}
