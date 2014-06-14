package com.vs.vsadmin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("vsadmin")
public class VsadminUI extends UI {
	MainGUI mainGUI;
	

	public void setMainGUI(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
	}


	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		layout.addComponent(mainGUI);
		
//		layout.addComponent(new Sim());
	}

}