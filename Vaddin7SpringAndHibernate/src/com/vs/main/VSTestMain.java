package com.vs.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.vs.dao.VSMenuDAO;

public class VSTestMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springContext.xml");
		HibernateTemplate hibernateTemplate = (HibernateTemplate) applicationContext.getBean("hibernateTemplate");
		List<VSMenuDAO> vsMenuDAOs = hibernateTemplate.loadAll(VSMenuDAO.class);
		System.out.println(vsMenuDAOs.size()+"--DB");
	}
}
