package com.vs.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class VSAdminDAOServiceImpl implements VSAdminDAOService,Serializable{

	HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean saveMainMenuItems(Set<VSMenuDAO> vsMenuDAOs) {
		boolean status = true;
		try{
			hibernateTemplate.saveOrUpdateAll(vsMenuDAOs);
		}catch(DataAccessException dataAccessException){
			status = false;
			dataAccessException.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean saveSubMenuItems(Set<VSSubmenuDAO> vsSubmenuDAOs,
			Integer vsMenuId) {
		boolean status = true;
		try{
			VSMenuDAO vsMenuDAO = hibernateTemplate.get(VSMenuDAO.class, vsMenuId);
			vsMenuDAO.setVsSubmenus(vsSubmenuDAOs);
			hibernateTemplate.saveOrUpdateAll(vsSubmenuDAOs);
			hibernateTemplate.update(vsMenuDAO);
		}catch(DataAccessException dataAccessException){
			status = false;
			dataAccessException.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean saveSubmenuCatogarizations(
			Set<VsSubmenuCatogarizationDAO> vsSubmenuCatogarizationDAOs,
			Integer vsSubMenuId) {
		boolean status = true;
		try{
			VSSubmenuDAO vsSubmenuDAO = hibernateTemplate.get(VSSubmenuDAO.class, vsSubMenuId);
			vsSubmenuDAO.setVsSubmenuCatogarizations(vsSubmenuCatogarizationDAOs);
			hibernateTemplate.saveOrUpdateAll(vsSubmenuCatogarizationDAOs);
			hibernateTemplate.update(vsSubmenuDAO);
		}catch(DataAccessException dataAccessException){
			status = false;
			dataAccessException.printStackTrace();
		}
		return status;
	}

	@Override
	public Set<VSMenuDAO> getAllMainMenuItems() {
		Collection<VSMenuDAO> collection = hibernateTemplate.loadAll(VSMenuDAO.class);
		System.out.println(collection.size()+"------------------");
		Set<VSMenuDAO> vsMenuDAOs = new LinkedHashSet<VSMenuDAO>();
		vsMenuDAOs.addAll(collection);
		return vsMenuDAOs;
	}

	@Override
	public Set<VSSubmenuDAO> getAllSubMenuItems() {
		
		Collection<VSSubmenuDAO> collection = hibernateTemplate.loadAll(VSSubmenuDAO.class);
		Set<VSSubmenuDAO> vsSubmenuDAOs = new LinkedHashSet<VSSubmenuDAO>();
		vsSubmenuDAOs.addAll(collection);
		return vsSubmenuDAOs;
	}

	@Override
	public Set<VsSubmenuCatogarizationDAO> getAllSubmenuCatogarizations() {
		Collection<VsSubmenuCatogarizationDAO> collection = hibernateTemplate.loadAll(VsSubmenuCatogarizationDAO.class);
		Set<VsSubmenuCatogarizationDAO> vsSubmenuCatogarizationDAOs = new LinkedHashSet<VsSubmenuCatogarizationDAO>();
		vsSubmenuCatogarizationDAOs.addAll(collection);
		return vsSubmenuCatogarizationDAOs;
	}

	@Override
	public Boolean saveAttribute(
			VSProductAttributeDAO vsProductAttributeDAO) {
		boolean status =true;
		try{
			hibernateTemplate.save(vsProductAttributeDAO);
		}catch(DataAccessException dataAccessException){
			status = false;
			dataAccessException.printStackTrace();
		}
		return status;
	}

	@Override
	public Set<VSProductAttributeDAO> getAllAttributes() {
		Collection<VSProductAttributeDAO> collection = hibernateTemplate.loadAll(VSProductAttributeDAO.class);
		Set<VSProductAttributeDAO> vsProductAttributeDAOs = new LinkedHashSet<VSProductAttributeDAO>();
		vsProductAttributeDAOs.addAll(collection);
		return vsProductAttributeDAOs;
	}

	@Override
	public boolean updateSubmenuCatogarization(
			VsSubmenuCatogarizationDAO vsSubmenuCatogarizationDAO) {
		boolean status =true;
		try{
			System.out.println(vsSubmenuCatogarizationDAO.getVsProductAttributeDAOs().size()+"-DAO Layer Attri Size");
			hibernateTemplate.update(vsSubmenuCatogarizationDAO);
		}catch(DataAccessException dataAccessException){
			status = false;
			dataAccessException.printStackTrace();
		}
		return status;
	}
}
