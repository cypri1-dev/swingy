package com.swingy.view;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GuiGamePage {

	public static JPanel createGamePage() {

		// Main panel to return
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);  // Make the main panel transparent
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

		// Hold the tabs
		JTabbedPane tabPanel = new JTabbedPane();
		tabPanel.setOpaque(false);  // Make the JTabbedPane itself transparent
		tabPanel.setBackground(new Color(0, 0, 0, 0));  // Transparent background for the JTabbedPane

		// Custom UI for JTabbedPane to override tab background rendering
		tabPanel.setUI(new BasicTabbedPaneUI() {
			@Override
			protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
				g.setColor(new Color(0, 0, 0, 0)); // Transparent background for tabs
				g.fillRect(x, y, w, h);  // Fill the tab with transparent color
			}

			// Override paintContentBorder to avoid any border rendering
			@Override
			protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
				// No border around the content
			}
		});

		// Tab1 (Map)
		JPanel map = new JPanel();
		map.setOpaque(false);  // Make the map panel transparent
		map.setBackground(new Color(0, 0, 0, 0));  // Set transparent background for the map panel
		JLabel mapLabel = new JLabel("Map");
		mapLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 45));
		mapLabel.setOpaque(false);  // Transparent background for label
		map.add(mapLabel);

		// Tab2 (Inventory)
		JPanel inventory = new JPanel();
		inventory.setOpaque(false);  // Make the inventory panel transparent
		inventory.setBackground(new Color(0, 0, 0, 0)); // Set transparent background for the inventory panel
		JLabel inventoryLabel = new JLabel("Inventory");
		inventoryLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 45));
		inventoryLabel.setOpaque(false); // Transparent background for label
		inventory.add(inventoryLabel);

		// Adding the tabs
		JLabel mapTabLabel = new JLabel("Map");
		mapTabLabel.setFont(new Font("Ancient Modern Tales", Font.PLAIN, 20));

		JLabel inventoryTabLabel = new JLabel("Inventory");
		inventoryTabLabel.setFont(new Font("Ancient Modern Tales", Font.PLAIN, 20));

		tabPanel.addTab("Map", map);
		tabPanel.setTabComponentAt(0, mapTabLabel);
		tabPanel.addTab("Inventory", inventory);
		tabPanel.setTabComponentAt(1, inventoryTabLabel);

		// Adding tabPanel to main panel
		panel.add(tabPanel, BorderLayout.CENTER);

		return panel;
	}
}




