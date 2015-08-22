package com;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ServiceTaskListener implements JavaDelegate{

	public void execute(DelegateExecution arg0) throws Exception {
		
		System.out.println("In service task..........."+arg0.getEventName()+"-----"+arg0.getCurrentActivityId()+"--------"+arg0.getId());
	}

}
