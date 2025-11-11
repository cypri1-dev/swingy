package com.swingy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import static com.swingy.utils.Constants.*;
import com.swingy.controller.Game;
import com.swingy.controller.Import;
import com.swingy.view.DisplayController;
import com.swingy.view.ExempleBoxLayout;
import com.swingy.view.JPanelWithBackground;

public class App {
	public static void main(String[] args) {
		if (args.length != 1) {
			DisplayController.getInstance().printNormal("Please specify the mode: console - gui");
			return;
		}

		switch (args[0]) {
			case CONSOLE:
				Game rpg = new Game();
				boolean loadingSave = Import.fileChecker();
				if (loadingSave)
					Import.fileParser(rpg);
				while (true) {
					rpg.getMenu().launchGame();
				}

			case GUI:
				DisplayController.getInstance().printNormal("GUI coming soon...");
				// JFrame window = new ExempleBoxLayout();

				JFrame f = new JFrame();
				try {
					f.getContentPane().add(new JPanelWithBackground("parchment.jpeg"));
				} catch (IOException e) {
					e.printStackTrace();
				}

				f.setSize(673, 930);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				break;

			default:
				DisplayController.getInstance().printNormal("Please specify the mode: console - gui");
				break;
		}
	}
}
