package by.gsu.isheremetov.controllers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import by.gsu.isheremetov.models.Weapon;

public class DOMController {

	public void parse(File xmlFile) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			document.getDocumentElement().normalize();
			NodeList nodeList = document
					.getElementsByTagName(document.getDocumentElement()
							.getChildNodes().item(1).getNodeName());
			Collection.clear();
			for (int tmp = 0; tmp < nodeList.getLength(); tmp++) {
				Node node = nodeList.item(tmp);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					Weapon weapon = new Weapon();
					weapon.setType(element.getElementsByTagName("type").item(0)
							.getChildNodes().item(0).getNodeValue());
					weapon.setHandy(element.getElementsByTagName("handy")
							.item(0).getChildNodes().item(0).getNodeValue());
					weapon.setOrigin(element.getElementsByTagName("origin")
							.item(0).getChildNodes().item(0).getNodeValue());
					weapon.setWidth(Integer.parseInt(element
							.getElementsByTagName("width").item(0)
							.getChildNodes().item(0).getNodeValue()));
					weapon.setHeight(Integer.parseInt(element
							.getElementsByTagName("height").item(0)
							.getChildNodes().item(0).getNodeValue()));
					weapon.setMaterial(element.getElementsByTagName("material")
							.item(0).getChildNodes().item(0).getNodeValue());
					if (element.getElementsByTagName("handle").item(0)
							.getAttributes().getLength() == 2) {
						weapon.setHandleKind(element
								.getElementsByTagName("handle").item(0)
								.getAttributes().item(0).getNodeValue());
						weapon.setHandleMaterial(element
								.getElementsByTagName("handle").item(0)
								.getAttributes().item(1).getNodeValue());
					} else {
						weapon.setHandleMaterial(element
								.getElementsByTagName("handle").item(0)
								.getAttributes().item(0).getNodeValue());
					}
					weapon.setKrovostok(Boolean.parseBoolean(element
							.getElementsByTagName("krovostok").item(0)
							.getChildNodes().item(0).getNodeValue()));
					weapon.setValue(Boolean.parseBoolean(element
							.getElementsByTagName("value").item(0)
							.getChildNodes().item(0).getNodeValue()));
					Collection.add(weapon);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

}
