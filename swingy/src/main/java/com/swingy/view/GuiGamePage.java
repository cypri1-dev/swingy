package com.swingy.view;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.swingy.controller.Game;
import com.swingy.controller.GuiInputController;
import com.swingy.controller.GuiInventoryController;
import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.view.components.RoundedImageButton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.awt.image.BufferedImage;

public class GuiGamePage extends GuiCustomPage {

	/************************************************************************ METHOD USE POTION ************************************************************************/

	private static void usePotion(Game rpg, JPanel baseInventory, Icon icon) {
		GuiInventoryController.checkPotion(rpg, baseInventory);
		refreshInventory(rpg, baseInventory, icon);
		if (GuiCustomPage.getShowingPageFight())
			GuiFightPage.refreshHeroHP(rpg.getMainHero());
	}

	/************************************************************************ METHOD REFRESH CHECKBOXES ************************************************************************/

	public static void refreshInventory(Game rpg, JPanel baseInventory, Icon icon) {
		baseInventory.removeAll();

		JLabel titleInventory = new JLabel("Inventory");
		setCustomFont(titleInventory, Font.BOLD, 45);
		JPanel wrapperTitleInventory =
			wrapperLabelGeneratorInventory(titleInventory, 0, 0, 40, 0, true);
		baseInventory.add(wrapperTitleInventory);

		JLabel statsLabel =
			new JLabel(GuiInventoryController.buildFormattedStats(rpg));
		JPanel wrapperStats =
			wrapperLabelGeneratorInventory(statsLabel, 0, 0, 20, 0, true);
		baseInventory.add(wrapperStats);

		createCheckBoxes(rpg, baseInventory, icon);

		RoundedImageButton deleteButton =
			new RoundedImageButton("Supprimer", icon);
		configButtons(deleteButton);
		deleteButton.addActionListener(e -> {
			GuiInventoryController.deleteSelectedItem(
				baseInventory, rpg.getMainHero(), rpg
			);
			refreshInventory(rpg, baseInventory, icon);
		});

		JPanel deleteWrapper = new JPanel();
		deleteWrapper.setOpaque(false);
		deleteWrapper.add(deleteButton);
		baseInventory.add(deleteWrapper);

		baseInventory.revalidate();
		baseInventory.repaint();
	}

	/************************************************************************ METHOD TO SET CHECKBOXES ************************************************************************/

	private static void createCheckBoxes(Game rpg, JPanel baseInventory, Icon icon) {
		Characters hero = rpg.getMainHero();
		Map<String, List<JCheckBox>> checkBoxesByType = new HashMap<>();

		for (Artefact items : hero.getArtefacts()) {
			String checkboxText =
				GuiInventoryController.buildFormattedItem(items);

			JCheckBox checkBox = new JCheckBox(checkboxText);
			checkBox.setOpaque(false);
			checkBox.setSelected(items.getIsEquipped());
			setCustomFont(checkBox, Font.PLAIN, 25);

			checkBoxesByType
				.computeIfAbsent(items.getType(), k -> new ArrayList<>())
				.add(checkBox);

			checkBox.putClientProperty("artefact", items);

			checkBox.addItemListener(e -> {
				GuiInventoryController.inventoryManager(checkBox, checkBoxesByType, hero, e);
				refreshInventory(rpg, baseInventory, icon);
			});

			JPanel wrapperCheckBox =
				wrapperCheckboxGenerator(checkBox, 0, 0, 0, 0);
			baseInventory.add(wrapperCheckBox);
		}
	}

	/************************************************************************ RESET PAGE METHOD ************************************************************************/

	public static void resetPage(
		JPanel baseMap,
		Game rpg,
		Map<String, ImageIcon> listToken,
		JPanel grid,
		JPanel baseInventory,
		Icon icon
	) {
		baseMap.removeAll();
		baseMap.setLayout(new BoxLayout(baseMap, BoxLayout.Y_AXIS));

		JLabel titleMap = new JLabel("Map");
		setCustomFont(titleMap, Font.BOLD, 45);
		JPanel wrapperTitleMap =
			wrapperLabelGeneratorInventory(titleMap, 0, 0, 20, 0, true);
		baseMap.add(wrapperTitleMap);

		BufferedImage newBg = selectRandomBackground();
		grid.putClientProperty("background", newBg);

		grid.removeAll();
		GuiMapTab.updateMap(rpg, listToken, grid);
		baseMap.add(grid);

		if (baseInventory != null)
			refreshInventory(rpg, baseInventory, icon);

		baseMap.revalidate();
		baseMap.repaint();
		grid.repaint();
	}

	/************************************************************************ GAME PAGE BUILDER ************************************************************************/

	public static JPanel createGamePage(
		Game rpg,
		CardLayout cardLayout,
		JPanel cardPanel,
		Map<String, ImageIcon> listToken,
		ImageIcon icon
	) {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);

		JTabbedPane tabPanel = new JTabbedPane();
		configureTabPanel(tabPanel);

		/************************ TAB — INVENTORY ************************/

		JPanel baseInventory = createBaseStructure();

		JLabel titleInventory = new JLabel("Inventory");
		setCustomFont(titleInventory, Font.BOLD, 45);
		JPanel wrapperTitleInventory =
			wrapperLabelGeneratorInventory(titleInventory, 0, 0, 40, 0, true);
		baseInventory.add(wrapperTitleInventory);

		JLabel statsLabel =
			new JLabel(GuiInventoryController.buildFormattedStats(rpg));
		JPanel wrapperStats =
			wrapperLabelGeneratorInventory(statsLabel, 0, 0, 20, 0, true);
		baseInventory.add(wrapperStats);

		createCheckBoxes(rpg, baseInventory, icon);

		JScrollPane inventoryScroll = new JScrollPane(baseInventory);
		inventoryScroll.setBorder(null);
		inventoryScroll.setOpaque(false);
		inventoryScroll.getViewport().setOpaque(false);
		inventoryScroll.setHorizontalScrollBarPolicy(
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
		);
		inventoryScroll.getVerticalScrollBar().setUnitIncrement(18);

		/************************ TAB — MAP ************************/

		JPanel baseMap = createBaseStructure();

		JLabel titleMap = new JLabel("Map");
		setCustomFont(titleMap, Font.BOLD, 45);
		JPanel wrapperTitleMap =
			wrapperLabelGeneratorInventory(titleMap, 0, 0, 20, 0, true);
		baseMap.add(wrapperTitleMap);

		int viewportSize = 9;
		BufferedImage initialBg = selectRandomBackground();

		JPanel grid = new JPanel(new GridLayout(viewportSize, viewportSize)) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				BufferedImage bg =
					(BufferedImage) getClientProperty("background");
				if (bg != null)
					g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
			}
		};

		grid.putClientProperty("background", initialBg);
		grid.setOpaque(false);
		baseMap.add(grid);

		rpg.placeHero(rpg.getMainHero());
		GuiMapTab.drawMap(rpg, listToken, grid);

		/************************ ADD TABS ************************/

		JLabel mapTabLabel = new JLabel("Map");
		setCustomFont(mapTabLabel, Font.PLAIN, 20);

		JLabel inventoryTabLabel = new JLabel("Inventory");
		setCustomFont(inventoryTabLabel, Font.PLAIN, 20);

		tabPanel.addTab("Map", baseMap);
		tabPanel.setTabComponentAt(0, mapTabLabel);

		tabPanel.addTab("Inventory", inventoryScroll);
		tabPanel.setTabComponentAt(1, inventoryTabLabel);

		panel.add(tabPanel, BorderLayout.CENTER);

		/************************ BOTTOM ************************/

		RoundedImageButton btnPotion =
			new RoundedImageButton("Use Potion", icon);
		configButtons(btnPotion);
		btnPotion.addActionListener(
			e -> usePotion(rpg, baseInventory, icon)
		);

		RoundedImageButton btn =
			new RoundedImageButton("Menu", icon);
		configButtons(btn);
		btn.addActionListener(
			e -> cardLayout.show(cardPanel, "main_menu")
		);

		JPanel bottom = new JPanel();
		bottom.add(btn);
		configureBottomPanel(bottom, btnPotion);
		panel.add(bottom, BorderLayout.SOUTH);

		new GuiInputController(btn, baseMap, rpg.getMainHero().getMovement(), rpg.getMainHero(), rpg.getMap(), rpg.getMenu(), grid, rpg, listToken, icon, baseInventory, bottom);
		return panel;
	}
}

