package by.gsu.isheremetov.views;

import java.io.File;

import by.gsu.isheremetov.controllers.Collection;
import by.gsu.isheremetov.controllers.DOMController;
import by.gsu.isheremetov.controllers.Menu;
import by.gsu.isheremetov.controllers.SAXController;
import by.gsu.isheremetov.controllers.StAXController;
import by.gsu.isheremetov.models.Weapon;

public class MainMenu {

	private final static File file = new File("xml/knife.xml");

	public MainMenu() {
		Menu mainMenu = new Menu(new String[] { "SAX", "DOM", "StAX",
				"Вывести коллекцию", "Выход" });
		boolean notExit = true;
		while (notExit) {
			mainMenu.print();
			try {
				switch (mainMenu.getChoise()) {
				case 1: {
					SAXController sax = new SAXController();
					sax.parse(file);
					System.out.println("SAX отработал.");
					break;
				}
				case 2: {
					DOMController dom = new DOMController();
					dom.parse(file);
					System.out.println("DOM отработал.");
					break;
				}
				case 3: {
					StAXController stax = new StAXController();
					stax.parse(file);
					System.out.println("StAX отработал.");
					break;
				}
				case 4: {
					for (Weapon weapon : Collection.getArrayList()) {
						System.out.println(weapon);
						System.out.println();
					}
					break;
				}
				case 5: {
					notExit = false;
					break;
				}
				default: {
					System.out.println("Не верный выбор.");
					break;
				}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
