package com.swingy.view;

import java.util.Scanner;

public class DisplayController {

	private static DisplayController instance;
	private final Scanner scanner = new Scanner(System.in);

	private DisplayController() {}

	public static DisplayController getInstance() {
		if (instance == null) {
			instance = new DisplayController();
		}
		return instance;
	}

	private void printSlow(String asciiArt) {
	for (String line : asciiArt.split("\n")) {
		System.out.println(line);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			}
		}
	}

	private void clearTerminal() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void printHeader() {
		String header = """

			██████╗ ███████╗████████╗██████╗  ██████╗     ██████╗ ██████╗  ██████╗ 
			██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██╔═══██╗    ██╔══██╗██╔══██╗██╔════╝ 
			██████╔╝█████╗     ██║   ██████╔╝██║   ██║    ██████╔╝██████╔╝██║  ███╗
			██╔══██╗██╔══╝     ██║   ██╔══██╗██║   ██║    ██╔══██╗██╔═══╝ ██║   ██║
			██║  ██║███████╗   ██║   ██║  ██║╚██████╔╝    ██║  ██║██║     ╚██████╔╝
			╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝     ╚═╝  ╚═╝╚═╝      ╚═════╝ 
																				
																				
		""";
		printSlow(header);
		try {
			Thread.sleep(80);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		clearTerminal();

	}

	public void displayMainMenu() {
		String menu = """

			███╗   ███╗ █████╗ ██╗███╗   ██╗    ███╗   ███╗███████╗███╗   ██╗██╗   ██╗
			████╗ ████║██╔══██╗██║████╗  ██║    ████╗ ████║██╔════╝████╗  ██║██║   ██║
			██╔████╔██║███████║██║██╔██╗ ██║    ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║
			██║╚██╔╝██║██╔══██║██║██║╚██╗██║    ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║
			██║ ╚═╝ ██║██║  ██║██║██║ ╚████║    ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝
			╚═╝     ╚═╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝    ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝ 
																					
																					
			  ░▀█░░░░░░░█▀▀░█▀▄░█▀▀░█▀█░▀█▀░█▀▀░░░█▀█░█▀▀░█░█░░░█░█░█▀▀░█▀▄░█▀█
			  ░░█░░░░░░░█░░░█▀▄░█▀▀░█▀█░░█░░█▀▀░░░█░█░█▀▀░█▄█░░░█▀█░█▀▀░█▀▄░█░█
			  ░▀▀▀░▀░░░░▀▀▀░▀░▀░▀▀▀░▀░▀░░▀░░▀▀▀░░░▀░▀░▀▀▀░▀░▀░░░▀░▀░▀▀▀░▀░▀░▀▀▀

			  ░▀▀▄░░░░░░█▀▀░█▀█░▀█▀░█▀▀░█▀▄░░░▀█▀░█░█░█▀▀░░░█▀█░█▀▄░█▀▀░█▀█░█▀█
			  ░▄▀░░░░░░░█▀▀░█░█░░█░░█▀▀░█▀▄░░░░█░░█▀█░█▀▀░░░█▀█░█▀▄░█▀▀░█░█░█▀█
			  ░▀▀▀░▀░░░░▀▀▀░▀░▀░░▀░░▀▀▀░▀░▀░░░░▀░░▀░▀░▀▀▀░░░▀░▀░▀░▀░▀▀▀░▀░▀░▀░▀
				
			  ░▀▀█░░░░░░█▀▄░█▀▀░█▀▀░▀█▀░░░▄▀░░█▀▀░█░█░▀█▀░▀█▀░░░█▀▀░█▀█░█▄█░█▀▀░▀▄░
			  ░░▀▄░░░░░░█▀▄░█▀▀░▀▀█░░█░░░░█░░░█▀▀░▄▀▄░░█░░░█░░░░█░█░█▀█░█░█░█▀▀░░█░
			  ░▀▀░░▀░░░░▀░▀░▀▀▀░▀▀▀░░▀░░░░░▀░░▀▀▀░▀░▀░▀▀▀░░▀░░░░▀▀▀░▀░▀░▀░▀░▀▀▀░▀░░
																								
																					
		""";

		try {
			Thread.sleep(80);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		printSlow(menu);

		// Scanner scanner = new Scanner(System.in);
		String choice = "";

		do {
			System.out.println("\n\n" + """
				░█▀▀░█▀▀░█░░░█▀▀░█▀▀░▀█▀░░░█▀█░█▀█░░░█▀█░█▀█░▀█▀░▀█▀░█▀█░█▀█░░░░
				░▀▀█░█▀▀░█░░░█▀▀░█░░░░█░░░░█▀█░█░█░░░█░█░█▀▀░░█░░░█░░█░█░█░█░░▀░
				░▀▀▀░▀▀▀░▀▀▀░▀▀▀░▀▀▀░░▀░░░░▀░▀░▀░▀░░░▀▀▀░▀░░░░▀░░▀▀▀░▀▀▀░▀░▀░░▀░
										""");
			choice = scanner.nextLine();
		} while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));
		
		if (choice.equals("3")) {
			clearTerminal();
			String out = "\n\n" + """
				░█▀▀░█░█░▀█▀░▀█▀░▀█▀░█▀█░█▀▀░░░█▀▀░█▀█░█▄█░█▀▀░░░░░░░░░░░░█▀▀░█▀█░█▀█░█▀▄░█▀▄░█░█░█▀▀░░░█▀█░█▀▄░█░█░█▀▀░█▀█░▀█▀░█░█░█▀▄░█▀▀░█▀▄░█
				░█▀▀░▄▀▄░░█░░░█░░░█░░█░█░█░█░░░█░█░█▀█░█░█░█▀▀░░░░░░░░░░░░█░█░█░█░█░█░█░█░█▀▄░░█░░█▀▀░░░█▀█░█░█░▀▄▀░█▀▀░█░█░░█░░█░█░█▀▄░█▀▀░█▀▄░▀
				░▀▀▀░▀░▀░▀▀▀░░▀░░▀▀▀░▀░▀░▀▀▀░░░▀▀▀░▀░▀░▀░▀░▀▀▀░▀░░▀░░▀░░░░▀▀▀░▀▀▀░▀▀▀░▀▀░░▀▀░░░▀░░▀▀▀░░░▀░▀░▀▀░░░▀░░▀▀▀░▀░▀░░▀░░▀▀▀░▀░▀░▀▀▀░▀░▀░▀
					""";
			printSlow(out);
			scanner.close();
			System.exit(0);
		}
		clearTerminal();
	}
}