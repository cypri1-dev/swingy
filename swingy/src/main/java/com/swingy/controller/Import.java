package com.swingy.controller;

import static com.swingy.utils.Constants.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.swingy.view.DisplayController;

public class Import {

	public static void fileChecker() {
		
		File file = new File("save.txt");
		DisplayController display = DisplayController.getInstance();

		if (!file.exists()) {
			display.printNormal(ORANGE_BOLD + "No save detected! Press ENTER to continue..." + RESET);
			display.getUserInput();
			return;
		}

		if (file.canWrite() || file.canExecute() || !file.canRead()) {
			display.printNormal(RED_BOLD + "Modification detected or corrupted data!"  + RESET + " The " + ITALIC + "save.txt" + RESET + " file will not be loaded! Press ENTER to continue...");
			display.getUserInput();
			return;
		}
		else {
			display.printNormal ( BOLD + BLUE + "Loading " + ITALIC + "save.txt" + RESET + BLUE + BOLD + " file... Press ENTER to continue..." + RESET);
			display.getUserInput();
			return;
		}

		// try (Scanner myReader = new Scanner(myObj)) {
		// 	while (myReader.hasNextLine()) {
		// 		String data = myReader.nextLine();
		// 		System.out.println(data);
		// 	}
		// } catch (FileNotFoundException e) {
		// 	System.out.println("An error occured.");
		// 	e.printStackTrace();
		// }
	}
}