package com.swingy.controller;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import static com.swingy.utils.Constants.*;

import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.Component;

import java.util.List;
import java.util.Map;

public class GuiInventoryController {

	public static String buildFormattedStats(Game rpg) {

		return String.format(
			"<html><div style='font-family: Ancient Modern Tales; font-size: 17px; color: #444444;'>" +
			"<i>Attack</i>: <span style='color: #008000;'>%d</span> &nbsp;&nbsp; " +
			"<i>Defense</i>: <span style='color: #008000;'>%d</span> &nbsp;&nbsp; " +
			"<i>Hit Points</i>: <span style='color: #FF0000;'>%d/%d</span>" +
			"</div></html>",
			rpg.getMainHero().getAttack(),
			rpg.getMainHero().getDefense(),
			rpg.getMainHero().getHitPoint(),
			rpg.getMainHero().getMaxHitPoint()
		);
	}

	public static String buildFormattedItem(Artefact items) {
		String name  = items.getName() + " ";
		Color color;

		switch (items.getRarity()) {
			case COMMON: color = Color.BLACK; break;
			case RARE: color = Color.BLUE; break;
			case EPIC: color = new Color(128, 0, 128); break;
			case LEGENDARY: color = new Color(255, 215, 0); break;
			default: color = Color.WHITE;
		}

		String bonus = "+" + items.getBonus();
		switch (items.getType()) {
			case HELM_TYPE: bonus += " HP"; break;
			case WEAPON_TYPE: bonus += " ATT"; break;
			case ARMOR_TYPE: bonus += " DEF"; break;
			case CONSOMMABLE_TYPE: bonus += " HP"; break;
		}

		String hexColor = String.format("#%02x%02x%02x",
			color.getRed(), color.getGreen(), color.getBlue());

		return "<html><span style='color:" + hexColor + "'>" + name + bonus + "</span></html>";
	}

	public static void inventoryManager(
		JCheckBox checkBox,
		Map<String, List<JCheckBox>> checkBoxesByType,
		Characters hero,
		ItemEvent e
	) {
		Artefact artefact = (Artefact) checkBox.getClientProperty("artefact");
		if (artefact == null)
			return;

		if (e.getStateChange() == ItemEvent.SELECTED) {
			hero.equipArtefact(artefact);
			artefact.setIsEquipped(true);

			List<JCheckBox> sameType = checkBoxesByType.get(artefact.getType());
			for (JCheckBox cb : sameType) {
				if (cb != checkBox && cb.isSelected()) {
					cb.setSelected(false);
					Artefact other = (Artefact) cb.getClientProperty("artefact");
					if (other != null)
						other.setIsEquipped(false);
				}
			}
		}
		else {
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
				break;
			}
		}
		if (potion != null)
			rpg.getMainHero().removeArtefact(potion);
	}

	/******************************** DELETE ITEM ********************************/

	public static void deleteSelectedItem(
		JPanel baseInventory,
		Characters hero,
		Game rpg
	) {
		JCheckBox selected = null;

		for (Component comp : baseInventory.getComponents()) {
			if (comp instanceof JPanel panel) {
				for (Component c : panel.getComponents()) {
					if (c instanceof JCheckBox cb && cb.isSelected()) {
						selected = cb;
						break;
					}
				}
			}
			if (selected != null)
				break;
		}

		if (selected == null) {
			JOptionPane.showMessageDialog(null,
				"Aucun objet sélectionné.",
				"Erreur",
				JOptionPane.ERROR_MESSAGE);
			return;
		}

		Artefact artefact = (Artefact) selected.getClientProperty("artefact");
		if (artefact == null)
			return;

		int confirm = JOptionPane.showConfirmDialog(
			null,
			"Voulez-vous vraiment supprimer " + artefact.getName() + " ?",
			"Confirmation",
			JOptionPane.YES_NO_OPTION
		);

		if (confirm != JOptionPane.YES_OPTION)
			return;

		if (artefact.getIsEquipped()) {
			hero.unequipArtefact(artefact);
			artefact.setIsEquipped(false);
		}

		hero.removeArtefact(artefact);
	}
}
