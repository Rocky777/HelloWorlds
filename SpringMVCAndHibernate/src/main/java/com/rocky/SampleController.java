package com.rocky;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rocky.domain.User;

@Controller
public class SampleController {

	@Autowired
	HibernateTemplate hibernateTemplate;

	

	@RequestMapping(value="demo",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		System.out.println(hibernateTemplate+"-----------------");
		User user = new User();
		user.setName("hi");
		hibernateTemplate.save(user);
		return "HelloWorld";
	}

	@RequestMapping(value = "/reportTemplate", method = RequestMethod.GET)
	@ResponseBody
	public byte[] downloadReporstTemplateConstent()
			throws IOException {

		File file = new File("C:/Users/Rocky/Pictures/tigers/images.jpg");
		FileInputStream fileInputStream = new FileInputStream(file);
		long l = file.length();
		byte[] b = new byte[(int)l];
		fileInputStream.read(b);		
		return Base64.encodeBase64(b);
	}

	@RequestMapping(value = "/reportTemplaten", method = RequestMethod.GET)
	@ResponseBody
	public byte[] downloadReportTemplateConstent()
			throws IOException {

		File file = new File("C:/Users/Rocky/Pictures/tigers/images (2).jpg");
		FileInputStream fileInputStream = new FileInputStream(file);
		long l = file.length();
		byte[] b = new byte[(int)l];
		fileInputStream.read(b);		
		return Base64.encodeBase64(b);
	}

}