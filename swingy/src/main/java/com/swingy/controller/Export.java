package com.swingy.controller;

import static com.swingy.utils.Constants.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.List;

import com.swingy.model.Characters;
import com.swingy.model.Artefact;
import com.swingy.view.DisplayController;

public class Export {

	public static void exportData(List<Characters> avaibleHeros) {

		File file = new File("save.txt");

		if (avaibleHeros.isEmpty()) {

			if (file.exists())
				file.setWritable(true);
			try (PrintWriter pw = new PrintWriter(file)) {}
			catch (FileNotFoundException e) {
				DisplayController.getInstance().printNormal(RED_BOLD + "Error: impossible de tronquer save.txt" + RESET);
				e.printStackTrace();
			}

			if (file.exists()) {
				file.setWritable(false);
				file.setReadable(true);
			}

			DisplayController.getInstance().printNormal("No characters created yet! Save cleared.");
			return;
		}
		else {
			if (file.exists())
				file.setWritable(true);
			try (PrintWriter out = new PrintWriter(file)) {
				for (Characters c : avaibleHeros) {
					out.print(c.getName());
					out.print(",");
					out.print(c.getCharacterClass());
					out.print(",");
					out.print(c.getLevel());
					out.print(",");
					out.print(c.getXp());
					out.print(",");
					out.print(c.getAttack());
					out.print(",");
					out.print(c.getDefense());
					out.print(",");
					out.print(c.getHitPoint());
					out.print(",");
					out.print(c.getMaxHitPoint());

					out.print("|");
					if (!c.getArtefacts().isEmpty()) {
						for (Artefact item : c.getArtefacts()) {
							out.print(item.getName());
							out.print(",");
							out.print(item.getIsEquipped());
							out.print(",");
							out.print(item.getBonus());
							out.print(",");
							out.print(item.getRarity());
							out.print(",");
							out.print(item.getType());
							out.print("%");
						}
					}

					out.print("|");
					if (!c.getKnowledge().getMap().isEmpty()) {
						out.print(c.getKnowledge().getMap());
					}
					out.print("*");
				}
			}
			catch (FileNotFoundException e) {
				DisplayController.getInstance().printNormal(
					RED_BOLD + "Error: an error occurred while exporting save.txt file...");
			}
			
			if (file.exists()) {
				file.setWritable(false);
				file.setReadable(true);
			}
		}
	}
}
