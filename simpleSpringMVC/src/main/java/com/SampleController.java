package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@RequestMapping(value="welcome",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		SampleTestPojo pojo =  new SampleTestPojo();
		pojo.setFilename("file");
		model.addAttribute("fileContent", pojo);
		return "sam";
	}

	@RequestMapping(value = "/reportTemplate", method = RequestMethod.GET)
	@ResponseBody
	public byte[] downloadReporstTemplateConstent()
			throws IOException {

		File file = new File("C:/Users/Rocky/Pictures/1mickey_mouse_6.jpg");
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

		File file = new File("C:/Users/Rocky/Pictures/20121011213635!Mickey_Mouse_Clubhouse_-_Mickey_-_Playhouse_Disney_Canada.png");
		FileInputStream fileInputStream = new FileInputStream(file);
		long l = file.length();
		byte[] b = new byte[(int)l];
		fileInputStream.read(b);		
		return Base64.encodeBase64(b);
	}

}