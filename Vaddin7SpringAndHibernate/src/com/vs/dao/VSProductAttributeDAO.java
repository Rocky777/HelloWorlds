package com.vs.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VsProductAttributes")
public class VSProductAttributeDAO {

	@Id
	@GeneratedValue
	int id;
	
	String attributeName;
	
	@Column(length=3000,name="AttributeValuesJSON")
	String attriubuteValues;

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

	public String getAttriubuteValues() {
		return attriubuteValues;
	}

	public void setAttriubuteValues(String attriubuteValues) {
		this.attriubuteValues = attriubuteValues;
	}
}
