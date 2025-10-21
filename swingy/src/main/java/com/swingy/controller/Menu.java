package com.swingy.controller;

import static com.swingy.utils.Constants.ARCHER_CLASS;
import static com.swingy.utils.Constants.ASSASSIN_CLASS;
import static com.swingy.utils.Constants.HERO_TYPE;
import static com.swingy.utils.Constants.MAGE_CLASS;
import static com.swingy.utils.Constants.PALADIN_CLASS;
import static com.swingy.utils.Constants.WARRIOR_CLASS;

import java.util.Scanner;
import java.util.Set;

import com.swingy.model.Characters;
import com.swingy.model.CharactersFactory;
import com.swingy.view.DisplayController;

public class Menu {

	private Game ref;

	Menu(Game game) {
		this.ref = game;
	}

	public void launchGame() {
		DisplayController.getInstance().printHeader();
		DisplayController.getInstance().displayMainMenu();
	}

	public void createHero() {
		Scanner scanner = new Scanner(System.in);
		Set<String> validClasses = Set.of(WARRIOR_CLASS, MAGE_CLASS, ARCHER_CLASS, PALADIN_CLASS, ASSASSIN_CLASS);

		System.out.println("Enter name of the new hero: ");
		String inputName = scanner.nextLine();
		String inputClass = "";
		do {
			System.out.println("Enter a class between: warrior - mage - archer - paladin - assassin");
			inputClass = scanner.nextLine().trim().toLowerCase();

		} while (!validClasses.contains(inputClass));
		ref.getListAvaible().add(CharactersFactory.getInstance().newCharacters(HERO_TYPE, inputName, inputClass));
		scanner.close();
	}

	static private void removeHero() {}

	static private void loadHero() {}
}