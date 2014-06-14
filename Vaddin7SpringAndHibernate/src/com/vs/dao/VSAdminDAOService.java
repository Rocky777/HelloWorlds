package com.vs.dao;

import java.util.Set;

public interface VSAdminDAOService {
	
	
boolean saveMainMenuItems(Set<VSMenuDAO> vsMenuDAOs);
	
	boolean saveSubMenuItems(Set<VSSubmenuDAO> vsSubmenuDAOs,Integer vsMenuId);
	
	boolean saveSubmenuCatogarizations(Set<VsSubmenuCatogarizationDAO> vsSubmenuCatogarizationDAOs,Integer vsSubMenuId);
	
	Set<VSMenuDAO> getAllMainMenuItems();
	
	Set<VSSubmenuDAO> getAllSubMenuItems();
	
	Set<VsSubmenuCatogarizationDAO> getAllSubmenuCatogarizations();

	Boolean saveAttribute(
			VSProductAttributeDAO convertVSProductAttributeToVSProductAttributeDAO);

	Set<VSProductAttributeDAO> getAllAttributes();

	boolean updateSubmenuCatogarization(
			VsSubmenuCatogarizationDAO vsSubmenuCatogarizationDAO);

}
