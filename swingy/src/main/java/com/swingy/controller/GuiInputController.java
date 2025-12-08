package com.swingy.controller;

import com.swingy.controller.GameMovement;
import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.model.Maps;
import com.swingy.view.GuiGamePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;

public class GuiInputController {

    private GameMovement movement;
    private Characters hero;
    private Maps map;
    private Menu menu;
    private static JPanel grid;
    private Game rpg;
    private static Map<String, ImageIcon> listToken;

    private boolean levelFinished = false;  // bloque actions après fin niveau
    private static boolean showingPotionPage = false; // bloque update normal pendant potion

    public GuiInputController(
            JComponent panel,
            GameMovement movement,
            Characters hero,
            Maps map,
            Menu menu,
            JPanel grid,
            Game rpg,
            Map<String, ImageIcon> listToken
    ) {
        this.movement = movement;
        this.hero = hero;
        this.map = map;
        this.menu = menu;
        this.grid = grid;
        this.rpg = rpg;
        this.listToken = listToken;

        bind(panel, "UP", () -> {
            if (levelFinished || showingPotionPage) return;
            if (!canMove(hero.getCoordinates().getX() - 1, hero.getCoordinates().getY()))
                return;
            movement.moveWest(hero, map, menu, true);
            update(panel);
        });

        bind(panel, "DOWN", () -> {
            if (levelFinished || showingPotionPage) return;
            if (!canMove(hero.getCoordinates().getX() + 1, hero.getCoordinates().getY()))
                return;
            movement.moveEast(hero, map, menu, true);
            update(panel);
        });

        bind(panel, "LEFT", () -> {
            if (levelFinished || showingPotionPage) return;
            if (!canMove(hero.getCoordinates().getX(), hero.getCoordinates().getY() - 1))
                return;
            movement.moveNorth(hero, map, menu, true);
            update(panel);
        });

        bind(panel, "RIGHT", () -> {
            if (levelFinished || showingPotionPage) return;
            if (!canMove(hero.getCoordinates().getX(), hero.getCoordinates().getY() + 1))
                return;
            movement.moveSouth(hero, map, menu, true);
            update(panel);
        });
    }

    private boolean canMove(int x, int y) {
        int size = map.getSize();
        return !(x < 0 || y < 0 || x >= size || y >= size);
    }

    private void update(JComponent panel) {

        // Potion détectée ?
		System.out.println("Hero coords: (" + hero.getCoordinates().getX() + ", " + hero.getCoordinates().getY() + ")");
		for (Artefact healingPotion : map.getListConsommable()) {
			System.out.println("Potion coords: (" + healingPotion.getCoordinates().getX() + ", " + healingPotion.getCoordinates().getY() + ")");
			if (hero.getCoordinates().getX() == healingPotion.getCoordinates().getX() && hero.getCoordinates().getY() == healingPotion.getCoordinates().getY()) {
				System.out.println("Potion trouvée !");
				map.getListConsommable().remove(healingPotion);
				showPotionPage(panel, healingPotion);
				return;
			}
		}

        // Game Over
        if (hero.getHitPoint() <= 0) {
            Icon deadIcon = listToken.get("Cranefeu");

            if (!levelFinished) {
                panel.removeAll();
                panel.setLayout(new BorderLayout());

                JLabel deadLabel = new JLabel("<html><div align='center'>"
                        + "<span style='color: #FF0000;'>Game Over !</span><br/>"
                        + "Your journey ends here… for now."
                        + "</div></html>");

                deadLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 45));
                deadLabel.setIcon(deadIcon);
                deadLabel.setHorizontalTextPosition(JLabel.CENTER);
                deadLabel.setVerticalTextPosition(JLabel.BOTTOM);

                JPanel wrapperEndLabel = wrapperLabelGenerator(deadLabel, 30, 0, 30, 0, true);
                panel.add(wrapperEndLabel, BorderLayout.CENTER);

                panel.revalidate();
                panel.repaint();
                levelFinished = true;
            }
            return;
        }

        // Level Completed
        if (map.getLevelCompleted()) {
            if (!levelFinished) {
                panel.removeAll();
                panel.setLayout(new BorderLayout());

                JLabel endLabel = new JLabel("<html><div align='center'>"
                        + "Congratulation !<br/>"
                        + "Level Completed!"
                        + "</div></html>");

                endLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 65));
                JPanel wrapperEndLabel = wrapperLabelGenerator(endLabel, 60, 0, 30, 0, true);
                panel.add(wrapperEndLabel, BorderLayout.NORTH);

                String inlineStats = String.format(
                        "<html><div style='font-family: Ancient Modern Tales; font-size: 18px; color: #444444; text-align: center;'>"
                                + "%s<br/>"
                                + "<b>Level</b>: %d<br/>"
                                + "<b>XP</b>: %d<br/><br/>"
                                + "<i>Attack</i>: <span style='color: #008000;'>%d</span><br/>"
                                + "<i>Defense</i>: <span style='color: #008000;'>%d</span><br/>"
                                + "<i>Hit Points</i>: <span style='color: #FF0000;'>%d/%d</span>"
                                + "</div></html>",
                        hero.getName(),
                        hero.getLevel(),
                        hero.getXp(),
                        rpg.getMainHero().getAttack(),
                        rpg.getMainHero().getDefense(),
                        rpg.getMainHero().getHitPoint(),
                        rpg.getMainHero().getMaxHitPoint()
                );

                JLabel statsLabel = new JLabel(inlineStats);
                statsLabel.setIcon(hero.getToken());
                statsLabel.setHorizontalTextPosition(JLabel.CENTER);
                statsLabel.setVerticalTextPosition(JLabel.BOTTOM);
                statsLabel.setIconTextGap(15);
                statsLabel.setHorizontalAlignment(JLabel.CENTER);

                JPanel wrapperStats = wrapperLabelGenerator(statsLabel, 0, 0, 20, 0, true);
                panel.add(wrapperStats, BorderLayout.CENTER);

                panel.revalidate();
                panel.repaint();

                levelFinished = true;
            }
            return;
        }

        // Update normal
        GuiGamePage.updateMap(rpg, listToken, grid);
    }

    public static void showPotionPage(JComponent panel, Artefact potion) {
        showingPotionPage = true;

        panel.removeAll();
        panel.setLayout(new BorderLayout());

        Icon potionIcon = listToken.get(potion.getName());
        if (potionIcon == null) {
            System.err.println("Warning: potion icon not found for " + potion.getName());
            potionIcon = new ImageIcon();  // icône vide pour éviter erreur
        }

        JLabel potionLabel = new JLabel("<html><div align='center'>"
                + "You found a Healing Potion !<br/>"
                + "</div></html>");
        potionLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 40));
        potionLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel iconLabel = new JLabel(potionIcon);
        iconLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton backButton = new JButton("Back to Map");
        backButton.setFont(new Font("Ancient Modern Tales", Font.BOLD, 30));
        backButton.addActionListener(e -> {
            showingPotionPage = false;
            panel.removeAll();
            panel.setLayout(new BorderLayout());
            panel.add(grid, BorderLayout.CENTER);
            panel.revalidate();
            panel.repaint();
        });

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setOpaque(false);
        container.add(potionLabel);
        container.add(iconLabel);
        container.add(Box.createRigidArea(new Dimension(0, 20)));
        container.add(backButton);

        panel.add(container, BorderLayout.CENTER);

        panel.revalidate();
        panel.repaint();
    }

    private static JPanel wrapperLabelGenerator(JLabel elem, int top, int left, int bottom, int right, boolean setSize) {
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapper.setOpaque(false);
        wrapper.add(elem);

        wrapper.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 0),
                BorderFactory.createEmptyBorder(top, left, bottom, right)
        ));

        if (setSize) {
            Dimension pref = wrapper.getPreferredSize();
            wrapper.setMaximumSize(new Dimension(pref.width, pref.height));
        }

        wrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
        return wrapper;
    }

    private void bind(JComponent comp, String key, Runnable action) {
        comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(key), key);

        comp.getActionMap().put(key, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.run();
            }
        });
    }
}
