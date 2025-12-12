package com.swingy.controller;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import static com.swingy.utils.Constants.*;

import java.awt.event.ItemEvent;

import java.util.List;
import java.util.Map;

public class GuiInventoryController {

	public static void inventoryManager(Map<JCheckBox, Artefact> checkBoxToArtefact, JCheckBox checkBox, Map<String, List<JCheckBox>> checkBoxesByType, Characters hero, ItemEvent e) {
		Artefact artefact = checkBoxToArtefact.get(checkBox);
		if (artefact == null) {
			System.err.println("Erreur : Artefact introuvable pour cette checkbox !");
			return;
		}

		if (e.getStateChange() == ItemEvent.SELECTED) {
			hero.equipArtefact(artefact);
			artefact.setIsEquipped(true);

			String type = artefact.getType();
			List<JCheckBox> sameTypeCheckBoxes = checkBoxesByType.get(type);

			for (JCheckBox cb : sameTypeCheckBoxes) {
				if (cb != checkBox && cb.isSelected()) {
					cb.setSelected(false);
					Artefact otherItem = checkBoxToArtefact.get(cb);
					if (otherItem != null)
						otherItem.setIsEquipped(false);
				}
			}
		} else if (e.getStateChange() == ItemEvent.DESELECTED) {
			hero.unequipArtefact(artefact);
			artefact.setIsEquipped(false);
		}
	}

	public static void checkPotion(Game rpg, JPanel baseInventory) {
		Artefact potion = null;

		for (Artefact items : rpg.getMainHero().getArtefacts()) {
			if (items.getType().equals(CONSOMMABLE_TYPE)) {
				rpg.healHero(items.getBonus());
				potion = items;
			}
		}
		if (potion != null)
			rpg.getMainHero().removeArtefact(potion);
	}
}