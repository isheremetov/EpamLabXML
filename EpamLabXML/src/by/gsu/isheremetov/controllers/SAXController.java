package by.gsu.isheremetov.controllers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import by.gsu.isheremetov.models.Weapon;

public class SAXController {

	class SAXPars extends DefaultHandler {

		private Weapon weapon;
		private String thisElement;

		public Weapon getResult() {
			return weapon;
		}

		@Override
		public void startDocument() throws SAXException {
			weapon = new Weapon();
		}

		@Override
		public void startElement(String namespaceURI, String localName,
				String qName, Attributes atts) throws SAXException {
			if (qName.equals("handle")) {
				if (atts.getLength() == 2) {
					weapon.setHandleKind(atts.getValue(0));
					weapon.setHandleMaterial(atts.getValue(1));
				} else {
					weapon.setHandleMaterial(atts.getValue(0));
				}
			}
			thisElement = qName;
		}

		@Override
		public void endElement(String namespaceURI, String localName,
				String qName) throws SAXException {
			if (qName.equals("weapon")) {
				Collection.add(weapon);
				weapon = new Weapon();
			}
			thisElement = "";
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			if (thisElement.equals("type")) {
				weapon.setType(new String(ch, start, length));
			}
			if (thisElement.equals("handy")) {
				weapon.setHandy(new String(ch, start, length));
			}
			if (thisElement.equals("origin")) {
				weapon.setOrigin(new String(ch, start, length));
			}
			if (thisElement.equals("width")) {
				weapon.setWidth(new Integer(new String(ch, start, length)));
			}
			if (thisElement.equals("height")) {
				weapon.setHeight(new Integer(new String(ch, start, length)));
			}
			if (thisElement.equals("material")) {
				weapon.setMaterial(new String(ch, start, length));
			}
			if (thisElement.equals("krovostok")) {
				weapon.setKrovostok(new Boolean(new String(ch, start, length)));
			}
			if (thisElement.equals("value")) {
				weapon.setValue(new Boolean(new String(ch, start, length)));
			}
		}

		@Override
		public void endDocument() {

		}
	}

	public void parse(File file) throws SAXException, IOException,
			ParserConfigurationException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		SAXParser parser = factory.newSAXParser();
		SAXPars saxp = new SAXPars();
		parser.parse(file, saxp);
	}
}
