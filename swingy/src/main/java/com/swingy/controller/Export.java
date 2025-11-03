package com.swingy.controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
				out = new PrintWriter("save.txt");

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
					if (!c.getKnowledge().getInstance().getMap().isEmpty()) {
						out.println(c.getKnowledge().getInstance().getMap());
					}
					out.println("**********");
				}
				out.close();

			} catch(FileNotFoundException e) {
				;
			}
		}
	}
}