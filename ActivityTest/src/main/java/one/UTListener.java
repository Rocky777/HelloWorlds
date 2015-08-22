package one;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class UTListener implements TaskListener{

	private static final long serialVersionUID = 1L;

	public void notify(DelegateTask arg0) {
		System.out.println("UT Called");
		
	}

}
