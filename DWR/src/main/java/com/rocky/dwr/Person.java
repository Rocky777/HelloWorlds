package com.rocky.dwr;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

public class Person implements Serializable{

	private String name;
	public Integer getAge(Integer age) {
		System.out.println("okkkkkkk"+age);
		
		return age;
	}
	public void setAge(Integer age) {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
    public void sendStocks() throws InterruptedException {
        WebContext wctx = WebContextFactory.get();
        String currentPage = wctx.getCurrentPage();

        Collection sessions = wctx.getScriptSessionsByPage(currentPage);
        Util utilAll = new Util(sessions);
  
        for (int i = 0; i < 10; i++) {
        	System.out.println("It's working"); 
            Thread.sleep(1000);
            utilAll.setValue("elementID", new Date().toString());
        }

    }
}
