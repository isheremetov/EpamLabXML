package by.gsu.isheremetov.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import by.gsu.isheremetov.models.Weapon;

public class StAXController {
	private Weapon weapon;
	private String chars;

	public void parse(File file) throws IOException, XMLStreamException {
		FileInputStream in = new FileInputStream(file);
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventReader = factory.createXMLEventReader(in);
		while (eventReader.hasNext()) {
			XMLEvent xmlEvent = eventReader.nextEvent();
			switch (xmlEvent.getEventType()) {
			case XMLStreamConstants.START_DOCUMENT:
				init();
				break;
			case XMLStreamConstants.START_ELEMENT:
				processStartElement(xmlEvent.asStartElement());
				break;
			case XMLStreamConstants.CHARACTERS:
				processCharacters(xmlEvent.asCharacters());
				break;
			case XMLStreamConstants.END_ELEMENT:
				processEndElement(xmlEvent.asEndElement());
				break;
			case XMLStreamConstants.END_DOCUMENT:
				cleanup();
				break;
			}
		}
	}

	private void init() {
		weapon = new Weapon();
		Collection.clear();
	}

	private void processStartElement(StartElement element) {
		if (element.getName().equals(new QName("handle"))) {
			if (element.getAttributeByName(new QName("kind")) != null) {
				weapon.setHandleKind(element.getAttributeByName(
						new QName("kind")).getValue());
			}
			weapon.setHandleMaterial(element.getAttributeByName(
					new QName("material")).getValue());
		}
	}

	private void processEndElement(EndElement element) {
		if (element.getName().equals(new QName("weapon"))) {
			Collection.add(weapon);
			weapon = new Weapon();
		}
		if (element.getName().equals(new QName("type"))) {
			weapon.setType(chars);
		}
		if (element.getName().equals(new QName("handy"))) {
			weapon.setHandy(chars);
		}
		if (element.getName().equals(new QName("origin"))) {
			weapon.setOrigin(chars);
		}
		if (element.getName().equals(new QName("width"))) {
			weapon.setWidth(Integer.parseInt(chars));
		}
		if (element.getName().equals(new QName("height"))) {
			weapon.setHeight(Integer.parseInt(chars));
		}
		if (element.getName().equals(new QName("material"))) {
			weapon.setMaterial(chars);
		}
		if (element.getName().equals(new QName("krovostok"))) {
			weapon.setKrovostok(Boolean.parseBoolean(chars));
		}
		if (element.getName().equals(new QName("value"))) {
			weapon.setValue(Boolean.parseBoolean(chars));
		}
	}

	private void processCharacters(Characters characters) {
		chars = characters.getData();
	}

	private void cleanup() {
		chars = null;
		weapon = null;
	}
}
