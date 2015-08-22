package com;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		ProcessEngine processEngine = applicationContext.getBean(ProcessEngine.class);
//		RepositoryService repositoryService = processEngine.getRepositoryService();
//		repositoryService.createDeployment()
//		.addClasspathResource("1.bpmn20.xml")
//		.deploy();
//		RuntimeService runtimeService = processEngine.getRuntimeService();
//		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
//		System.out.println(processInstance.getProcessInstanceId());
//		HistoryService historyService = processEngine.getHistoryService();
		List<Task> tasks = processEngine.getTaskService().createTaskQuery().list();
		for(Task task : tasks){
			System.out.println(task.getId()+"----------");
			processEngine.getTaskService().complete(task.getId());
		}
	}
}
