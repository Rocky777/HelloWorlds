package com.vs.util;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vs.dao.VSMenuDAO;
import com.vs.dao.VSProductAttributeDAO;
import com.vs.dao.VSSubmenuDAO;
import com.vs.dao.VsSubmenuCatogarizationDAO;
import com.vs.service.VSMenu;
import com.vs.service.VSProductAttribute;
import com.vs.service.VSSubmenu;
import com.vs.service.VsSubmenuCatogarization;

public class VSAdminUtils {

	public static VSMenuDAO convertVSMenuToVSMenuDAO(VSMenu vsMenu ){
		VSMenuDAO vsMenuDAO = new VSMenuDAO();
		vsMenuDAO.setId(vsMenu.getId());
		vsMenuDAO.setMainMenu(vsMenu.getMainMenu());
		Set<VSSubmenu> vsSubmenus = vsMenu.getVsSubmenus();
		if(vsSubmenus!=null){
			vsMenuDAO.setVsSubmenus(convertVSSubmenuToVSMenuDAO(vsSubmenus));
		}
		return vsMenuDAO;
	}

	public static VSSubmenuDAO convertVSSubmenuToVSSubmenuDAO(VSSubmenu vsSubmenu ){
		VSSubmenuDAO vsSubmenuDAO = new VSSubmenuDAO();
		vsSubmenuDAO.setId(vsSubmenu.getId());
		vsSubmenuDAO.setSubMenu(vsSubmenu.getSubMenu());
		Set<VsSubmenuCatogarization> vsSubmenus = vsSubmenu.getVsSubmenuCatogarizations();
		if(vsSubmenus!=null){
			vsSubmenuDAO.setVsSubmenuCatogarizations(convertVsSubmenuCatogarizationToVSSubmenuCatogarizationDAO(vsSubmenus));
		}
		return vsSubmenuDAO;
	}

	public static VsSubmenuCatogarizationDAO convertVsSubmenuCatogarizationToVSSubmenuCatogarizationDAO(VsSubmenuCatogarization vsSubmenuCatogarization ){
		VsSubmenuCatogarizationDAO vsSubmenuCatogarizationDAO = new VsSubmenuCatogarizationDAO();
		vsSubmenuCatogarizationDAO.setId(vsSubmenuCatogarization.getId());
		vsSubmenuCatogarizationDAO.setVsSubmenuCatogary(vsSubmenuCatogarization.getVsSubmenuCatogary());
		vsSubmenuCatogarizationDAO.setVsProductAttributeDAOs(convertVSProductAttributeToVSProductAttributeDAO(vsSubmenuCatogarization.getVsProductAttributes()));
		return vsSubmenuCatogarizationDAO;
	}


	public static Set<VSSubmenuDAO> convertVSSubmenuToVSMenuDAO(Set<VSSubmenu> vsSubmenus ){

		Set<VSSubmenuDAO> vsSubmenuDAOs = new HashSet<VSSubmenuDAO>();
		for(VSSubmenu vsSubmenu : vsSubmenus){
			VSSubmenuDAO vsSubmenuDAO = convertVSSubmenuToVSSubmenuDAO(vsSubmenu);
			vsSubmenuDAOs.add(vsSubmenuDAO);
		}
		return vsSubmenuDAOs;

	}

	public static Set<VsSubmenuCatogarizationDAO> convertVsSubmenuCatogarizationToVSSubmenuCatogarizationDAO(Set<VsSubmenuCatogarization> vsSubmenuCatogarizations ){
		Set<VsSubmenuCatogarizationDAO> vsSubmenuCatogarizationDAOs = new HashSet<VsSubmenuCatogarizationDAO>();
		for(VsSubmenuCatogarization vsSubmenuCatogarization : vsSubmenuCatogarizations){
			VsSubmenuCatogarizationDAO vsSubmenuCatogarizationDAO = convertVsSubmenuCatogarizationToVSSubmenuCatogarizationDAO(vsSubmenuCatogarization);
			vsSubmenuCatogarizationDAOs.add(vsSubmenuCatogarizationDAO);
		}
		return vsSubmenuCatogarizationDAOs;
	}

	public static Set<VSMenuDAO> convertVSMenuToVSMenuDAO(Set<VSMenu> vsMenus ){
		Set<VSMenuDAO> vsMenuDAOs = new HashSet<VSMenuDAO>();
		for(VSMenu vsMenu : vsMenus){
			vsMenuDAOs.add(convertVSMenuToVSMenuDAO(vsMenu));
		}
		return vsMenuDAOs;
	}

	//	*****************************************


	public static VSMenu convertVSMenuDAOToVSMenu(VSMenuDAO vsMenuDAO ){
		VSMenu vsMenu = new VSMenu();
		vsMenu.setId(vsMenuDAO.getId());
		vsMenu.setMainMenu(vsMenuDAO.getMainMenu());
		Set<VSSubmenu> vsSubmenus = new HashSet<VSSubmenu>();
		Set<VSSubmenuDAO> vsSubmenuDAOs = vsMenuDAO.getVsSubmenus();
		if(vsSubmenuDAOs!=null){
			for(VSSubmenuDAO vsSubmenuDAO : vsSubmenuDAOs){
				VSSubmenu vsSubmenu = convertVSSubmenuDAOToVSSubmenu(vsSubmenuDAO);
				vsSubmenus.add(vsSubmenu);
			}
			vsMenu.setVsSubmenus(vsSubmenus);
		}
		return vsMenu;
	}

	public static VSSubmenu convertVSSubmenuDAOToVSSubmenu(VSSubmenuDAO vsSubmenuDAO ){
		VSSubmenu vsSubmenu = new VSSubmenu();
		vsSubmenu.setId(vsSubmenuDAO.getId());
		vsSubmenu.setSubMenu(vsSubmenuDAO.getSubMenu());
		Set<VsSubmenuCatogarization> vsSubmenuCatogarizations = new HashSet<VsSubmenuCatogarization>();
		Set<VsSubmenuCatogarizationDAO> vsSubmenuCatogarizationDAOs = vsSubmenuDAO.getVsSubmenuCatogarizations();
		for(VsSubmenuCatogarizationDAO vsSubmenuCatogarizationDAO : vsSubmenuCatogarizationDAOs){
			VsSubmenuCatogarization vsSubmenuCatogarization = convertVsSubmenuCatogarizationDAOToVSSubmenuCatogarization(vsSubmenuCatogarizationDAO);
			vsSubmenuCatogarizations.add(vsSubmenuCatogarization);
		}
		vsSubmenu.setVsSubmenuCatogarizations(vsSubmenuCatogarizations);
		return vsSubmenu;
	}

	public static VsSubmenuCatogarization convertVsSubmenuCatogarizationDAOToVSSubmenuCatogarization(VsSubmenuCatogarizationDAO vsSubmenuCatogarizationDAO ){
		VsSubmenuCatogarization vsSubmenuCatogarization = new VsSubmenuCatogarization();
		vsSubmenuCatogarization.setId(vsSubmenuCatogarizationDAO.getId());
		vsSubmenuCatogarization.setVsSubmenuCatogary(vsSubmenuCatogarizationDAO.getVsSubmenuCatogary());
		vsSubmenuCatogarization.setVsProductAttributes(convertVSProductAttributeDAOToVSProductAttribute(vsSubmenuCatogarizationDAO.getVsProductAttributeDAOs()));
		return vsSubmenuCatogarization;
	}

	public static Set<VSMenu> convertVSMenuDAOToVSMenu(Set<VSMenuDAO> vsMenuDAOs ){
		Set<VSMenu> vsMenus = new HashSet<VSMenu>();
		if(vsMenuDAOs!=null){
			for(VSMenuDAO vsMenuDAO : vsMenuDAOs){
				vsMenus.add(convertVSMenuDAOToVSMenu(vsMenuDAO));
			}
		}
		return vsMenus;
	}

	public static Set<VSSubmenu> convertVSSubmenuDAOToVSSubmenu(Set<VSSubmenuDAO> vsSubmenuDAOs ){
		Set<VSSubmenu> vsSubmenus = new HashSet<VSSubmenu>();
		if(vsSubmenuDAOs!=null){
			for(VSSubmenuDAO vsSubmenuDAO : vsSubmenuDAOs){
				vsSubmenus.add(convertVSSubmenuDAOToVSSubmenu(vsSubmenuDAO));
			}
		}
		return vsSubmenus;
	}

	public static Set<VsSubmenuCatogarization> convertVsSubmenuCatogarizationDAOToVSSubmenuCatogarization(Set<VsSubmenuCatogarizationDAO> vsSubmenuCatogarizationDAOs ){
		Set<VsSubmenuCatogarization> vsSubmenuCatogarizations = new HashSet<VsSubmenuCatogarization>();
		if(vsSubmenuCatogarizationDAOs!=null){
			for(VsSubmenuCatogarizationDAO vsSubmenuCatogarizationDAO : vsSubmenuCatogarizationDAOs){
				vsSubmenuCatogarizations.add(convertVsSubmenuCatogarizationDAOToVSSubmenuCatogarization(vsSubmenuCatogarizationDAO));
			}
		}
		return vsSubmenuCatogarizations;
	}
	
	
	
	/*********************************************************************************/
	
	
	public static VSProductAttributeDAO convertVSProductAttributeToVSProductAttributeDAO(VSProductAttribute vsProductAttribute){
		
		VSProductAttributeDAO productAttributeDAO = new VSProductAttributeDAO();
		productAttributeDAO.setAttributeName(vsProductAttribute.getAttributeName());
		String attributeValues = new Gson().toJson(vsProductAttribute.getAttriubuteValues());
		productAttributeDAO.setAttriubuteValues(attributeValues);
		productAttributeDAO.setId(vsProductAttribute.getId());
		return productAttributeDAO;
	}
	
	public static Set<VSProductAttributeDAO> convertVSProductAttributeToVSProductAttributeDAO(Set<VSProductAttribute> vsProductAttributes){
		Set<VSProductAttributeDAO> vsProductAttributeDAOs = new HashSet<VSProductAttributeDAO>();
		if(vsProductAttributes!=null){
			
			for(VSProductAttribute vsProductAttribute : vsProductAttributes ){
				VSProductAttributeDAO productAttributeDAO = new VSProductAttributeDAO();
				productAttributeDAO.setAttributeName(vsProductAttribute.getAttributeName());
				String attributeValues = new Gson().toJson(vsProductAttribute.getAttriubuteValues());
				productAttributeDAO.setAttriubuteValues(attributeValues);
				productAttributeDAO.setId(vsProductAttribute.getId());
				vsProductAttributeDAOs.add(productAttributeDAO);
			}
		}
		return vsProductAttributeDAOs;
	}
	
	
	
	public static VSProductAttribute convertVSProductAttributeDAOToVSProductAttribute(VSProductAttributeDAO vsProductAttributeDAO){
		
		VSProductAttribute vsProductAttribute = new VSProductAttribute();
		vsProductAttribute.setAttributeName(vsProductAttributeDAO.getAttributeName());
		Set<String> attributeValues = new Gson().fromJson(vsProductAttributeDAO.getAttriubuteValues(), new TypeToken<Set<String>>(){}.getType());
		vsProductAttribute.setAttriubuteValues(attributeValues);
		vsProductAttribute.setId(vsProductAttributeDAO.getId());
		return vsProductAttribute;
	}
	
	
	public static Set<VSProductAttribute> convertVSProductAttributeDAOToVSProductAttribute(Set<VSProductAttributeDAO> vsProductAttributeDAOs){
		
		Set<VSProductAttribute> vsProductAttributes = new HashSet<VSProductAttribute>();
		for(VSProductAttributeDAO vsProductAttributeDAO : vsProductAttributeDAOs){
			vsProductAttributes.add(convertVSProductAttributeDAOToVSProductAttribute(vsProductAttributeDAO));
		}
		return vsProductAttributes;
	}
}
