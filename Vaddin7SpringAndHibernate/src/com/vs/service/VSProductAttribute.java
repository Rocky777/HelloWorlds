package com.vs.service;

import java.io.Serializable;
import java.util.Set;

public class VSProductAttribute implements Comparable<VSProductAttribute>,Serializable{

	int id;
	
	String attributeName;
	
	Set<String> attriubuteValues;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public Set<String> getAttriubuteValues() {
		return attriubuteValues;
	}

	public void setAttriubuteValues(Set<String> attriubuteValues) {
		this.attriubuteValues = attriubuteValues;
	}

	@Override
	public int compareTo(VSProductAttribute vsProductAttribute) {
		int attributeId = ((VSProductAttribute) vsProductAttribute).getId(); 
		//ascending order
		return this.id - attributeId;
	}


	
	
}
