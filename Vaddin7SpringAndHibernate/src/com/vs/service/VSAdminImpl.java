package com.vs.service;

import java.io.Serializable;
import java.util.Set;
import com.vs.dao.VSAdminDAOService;
import com.vs.util.VSAdminUtils;

public class VSAdminImpl implements VSAdminService,Serializable {
	VSAdminDAOService vsAdminDAOService;

	public void setVsAdminDAOService(VSAdminDAOService vsAdminDAOService) {
		this.vsAdminDAOService = vsAdminDAOService;
	}

	@Override
	public boolean saveMainMenuItems(Set<VSMenu> vsMenus) {
		boolean status = vsAdminDAOService.saveMainMenuItems(VSAdminUtils.convertVSMenuToVSMenuDAO(vsMenus));
		return status;
	}

	@Override
	public boolean saveSubMenuItems(Set<VSSubmenu> submenus, Integer vsMenuId) {
		boolean status = vsAdminDAOService.saveSubMenuItems(VSAdminUtils.convertVSSubmenuToVSMenuDAO(submenus),vsMenuId);
		return status;
	}

	@Override
	public boolean saveSubmenuCatogarizations(
			Set<VsSubmenuCatogarization> vsSubmenuCatogarizations,
			Integer vsSubMenuId) {
		boolean status = vsAdminDAOService.saveSubmenuCatogarizations(VSAdminUtils.convertVsSubmenuCatogarizationToVSSubmenuCatogarizationDAO(vsSubmenuCatogarizations),vsSubMenuId);
		return status;
	}

	@Override
	public Set<VSMenu> getAllMainMenuItems() {
		return VSAdminUtils.convertVSMenuDAOToVSMenu(vsAdminDAOService.getAllMainMenuItems());
	}

	@Override
	public Set<VSSubmenu> getAllSubMenuItems() {
		return VSAdminUtils.convertVSSubmenuDAOToVSSubmenu(vsAdminDAOService.getAllSubMenuItems());
	}

	@Override
	public Set<VsSubmenuCatogarization> getAllSubmenuCatogarizations() {
		return VSAdminUtils.convertVsSubmenuCatogarizationDAOToVSSubmenuCatogarization(vsAdminDAOService.getAllSubmenuCatogarizations());
	}

	@Override
	public Boolean saveAttribute(VSProductAttribute vsProductAttribute) {
		return vsAdminDAOService.saveAttribute(VSAdminUtils.convertVSProductAttributeToVSProductAttributeDAO(vsProductAttribute));
	}

	@Override
	public Set<VSProductAttribute> getAllAttributes() {
		// TODO Auto-generated method stub
		return VSAdminUtils.convertVSProductAttributeDAOToVSProductAttribute(vsAdminDAOService.getAllAttributes());
	}

	@Override
	public boolean updateSubmenuCatogarization(
			VsSubmenuCatogarization vsSubmenuCatogarization) {
		boolean status = vsAdminDAOService.updateSubmenuCatogarization(VSAdminUtils.convertVsSubmenuCatogarizationToVSSubmenuCatogarizationDAO(vsSubmenuCatogarization));
		return status;
	}
}
