package by.gsu.isheremetov.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {
	private String[] items;

	public Menu(String[] menuItems) {
		items = menuItems;
	}

	public void print() {
		int i = 1;
		for (String item : items) {
			System.out.println(i + ". " + item);
			i++;
		}
	}

	public int getChoise() throws Exception {
		int choise = -1;
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		String input = bufferedReader.readLine();
		try {
			choise = Integer.parseInt(input);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return choise;
	}
}
