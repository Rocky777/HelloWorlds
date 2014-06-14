package com.vs.service;

import java.util.Set;

public interface VSAdminService{

	boolean saveMainMenuItems(Set<VSMenu> vsMenus);
	
	boolean saveSubMenuItems(Set<VSSubmenu> submenus,Integer vsMenuId);
	
	boolean saveSubmenuCatogarizations(Set<VsSubmenuCatogarization> vsSubmenuCatogarizations,Integer vsSubMenuId);
	
	Set<VSMenu> getAllMainMenuItems();
	
	Set<VSSubmenu> getAllSubMenuItems();
	
	Set<VsSubmenuCatogarization> getAllSubmenuCatogarizations();

	Boolean saveAttribute(VSProductAttribute vsProductAttribute);

	Set<VSProductAttribute> getAllAttributes();

	boolean updateSubmenuCatogarization(
			VsSubmenuCatogarization vsSubmenuCatogarization);
}
