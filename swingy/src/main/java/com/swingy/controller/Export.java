package com.swingy.controller;

import static com.swingy.utils.Constants.RED_BOLD;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.List;

import com.swingy.model.Characters;
import com.swingy.model.Artefact;
import com.swingy.view.DisplayController;

public class Export {

	public static void exportData(List<Characters> avaibleHeros) {
		
		if (avaibleHeros.isEmpty()) {
			DisplayController.getInstance().printNormal("No characters created yet!");
			return;
		}
		else {
			PrintWriter out;
			try {
				// file to export
				File file = new File("save.txt");
				out = new PrintWriter(file);

				for (Characters c : avaibleHeros) {
					// Characters data
					out.println(c.getName());
					out.println(c.getCharacterClass());
					out.println(c.getLevel());
					out.println(c.getXp());
					out.println(c.getAttack());
					out.println(c.getDefense());
					out.println(c.getHitPoint());
					out.println(c.getMaxHitPoint());

					out.println("*** BAG ***");
					
					// Bag
					if (!c.getArtefacts().isEmpty()) {
						for (Artefact item : c.getArtefacts()) {
							out.println(item.getName());
							out.println(item.getIsEquipped());
							out.println(item.getBonus());
							out.println(item.getRarity());
							out.println(item.getType());
							out.println("----------");
						}
					}

					out.println("*** KNOWLEDGE ***");
					// Knwolegde
					if (!c.getKnowledge().getMap().isEmpty()) {
						out.println(c.getKnowledge().getMap());
					}
					out.println("**********");
				}
				out.close();
				file.setWritable(false);
				file.setReadable(true);


			} catch(FileNotFoundException e) {
				DisplayController.getInstance().printNormal(RED_BOLD + "Error: an error occurred while exporting save.txt file...");
				e.getStackTrace();
			}
		}
	}
}