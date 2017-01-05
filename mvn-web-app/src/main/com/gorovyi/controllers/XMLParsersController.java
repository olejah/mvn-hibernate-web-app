package controllers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import model.utils.xml.SAXParserHandler;

@Controller
public class XMLParsersController {
	private File file;
	private static GenericXmlApplicationContext context = new GenericXmlApplicationContext();
	
	@RequestMapping(value="/xmlparsers", method = RequestMethod.GET)
	public ModelAndView getXmlPage() {
		ModelAndView modelView = new ModelAndView("xmlparsers");
		return modelView;
	}
	
	@RequestMapping(value="/xmlparsers", method = RequestMethod.POST)
	public ModelAndView uploadFile(@RequestParam("file") MultipartFile xmlFile) throws IllegalStateException, IOException {
		ModelAndView modelView = new ModelAndView("xmlparsers");
		boolean isFileUploaded = false;
		String errorMessage = "";
		
		if (xmlFile != null && (xmlFile.getSize() == 0 || !xmlFile.getContentType().split("/")[1].equals("xml") )) {
			errorMessage = "Please Choose a valid not empty xml file";
		} else if(isFileUploaded) {
			return modelView;
		} else {
			file = new File(xmlFile.getOriginalFilename());
			xmlFile.transferTo(file);
			isFileUploaded = true;
		}
		
		
		modelView.addObject("errorMessage", errorMessage);
		modelView.addObject("isFileUploaded", isFileUploaded);
		
		return modelView;
	}
	
	@RequestMapping(value="/parse-with-sax")
	public ModelAndView parseWithSax() {
		SAXParserHandler saxParserHandler = (SAXParserHandler) context.getBean("saxParserHandler");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(file, saxParserHandler);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("xmlparsers/saxparser");
	}
	
	@RequestMapping(value="/parse-with-dom")
	public ModelAndView parseWithDom() {
		System.out.println("parseWithDom");
		return new ModelAndView("xmlparsers/domparser");
	}
	
	static {
		System.out.println("preparing context...");
		context.load("app-context.xml");
		context.refresh();
	}
}
