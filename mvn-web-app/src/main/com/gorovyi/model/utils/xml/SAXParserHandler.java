package model.utils.xml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@Component
public class SAXParserHandler extends DefaultHandler {
	private ArrayList<String> tagNames;
	
	public SAXParserHandler(){
		
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(uri + " , localName = " + localName + ", qName = " + qName + ", number of attr = "  + attributes.getLength());
        super.startElement(uri, localName, qName, attributes);

    }
	
	public ArrayList<String> getTagNames() {
		return tagNames;
	}
	

}
