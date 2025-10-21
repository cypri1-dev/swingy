package com.swingy.view;

import static com.swingy.utils.Constants.*;

public class DisplayController {

	private static DisplayController instance;

	private DisplayController() {}

	public void sleepTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static DisplayController getInstance() {
		if (instance == null) {
			instance = new DisplayController();
		}
		return instance;
	}

	public void printSlow(String asciiArt) {
	for (String line : asciiArt.split("\n")) {
		System.out.println(line);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			}
		}
	}

	public void clearTerminal() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	

}
