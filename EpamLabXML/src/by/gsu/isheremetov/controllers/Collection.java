package by.gsu.isheremetov.controllers;

import java.util.ArrayList;

import by.gsu.isheremetov.models.Weapon;

public class Collection {
	private static Collection instance;
	private static ArrayList<Weapon> arrayList;

	private Collection() {
		arrayList = new ArrayList<Weapon>();
	}

	public static synchronized Collection getInstance() {
		if (instance == null) {
			instance = new Collection();
		}
		return instance;
	}

	public static synchronized void clear() {
		arrayList.clear();
	}

	public static synchronized void add(Weapon weapon) {
		arrayList.add(weapon);
	}

	public static synchronized ArrayList<Weapon> getArrayList() {
		return arrayList;
	}

}
