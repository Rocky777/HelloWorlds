package com.vs.service;

import java.io.Serializable;
import java.util.Set;

import com.vs.dao.VSProductAttributeDAO;


public class VsSubmenuCatogarization implements Serializable{

	int id;
	
	String vsSubmenuCatogary;
	Set<VSProductAttribute> vsProductAttributes;
	
	public Set<VSProductAttribute> getVsProductAttributes() {
		return vsProductAttributes;
	}

	public void setVsProductAttributes(Set<VSProductAttribute> vsProductAttributes) {
		this.vsProductAttributes = vsProductAttributes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVsSubmenuCatogary() {
		return vsSubmenuCatogary;
	}

	public void setVsSubmenuCatogary(String vsSubmenuCatogary) {
		this.vsSubmenuCatogary = vsSubmenuCatogary;
	}
	

}
