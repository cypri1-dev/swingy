package com.swingy.controller;

import com.swingy.controller.GameMovement;
import com.swingy.model.Characters;
import com.swingy.model.Maps;
import com.swingy.view.GuiGamePage;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.Map;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;

public class GuiInputController {

    private GameMovement movement;
    private Characters hero;
    private Maps map;
    private Menu menu;
    private JPanel grid;
    private Game rpg;
    private Map<String, ImageIcon> listToken;
    
    private boolean levelFinished = false;  // Flag pour bloquer les actions après fin de niveau

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
            if (levelFinished) return;
            if (!canMove(hero.getCoordinates().getX() - 1, hero.getCoordinates().getY()))
                return;
            movement.moveWest(hero, map, menu);
            update(panel);
        });

        bind(panel, "DOWN", () -> {
            if (levelFinished) return;
            if (!canMove(hero.getCoordinates().getX() + 1, hero.getCoordinates().getY()))
                return;
            movement.moveEast(hero, map, menu);
            update(panel);
        });

        bind(panel, "LEFT", () -> {
            if (levelFinished) return;
            if (!canMove(hero.getCoordinates().getX(), hero.getCoordinates().getY() - 1))
                return;
            movement.moveNorth(hero, map, menu);
            update(panel);
        });

        bind(panel, "RIGHT", () -> {
            if (levelFinished) return;
            if (!canMove(hero.getCoordinates().getX(), hero.getCoordinates().getY() + 1))
                return;
            movement.moveSouth(hero, map, menu);
            update(panel);
        });
    }

    private boolean canMove(int x, int y) {
        int size = map.getSize();
        return !(x < 0 || y < 0 || x >= size || y >= size);
    }

    private void update(JComponent panel) {
        if (map.getLevelCompleted()) {
            if (!levelFinished) { // S'assure que ça s'exécute qu'une seule fois
                System.out.println("[GG]: LvL completed!");
                panel.remove(grid);

                JLabel endLabel = new JLabel("<html><div align='center'>"
                        + "Congratulation !<br/>"
                        + "Level Completed!"
                        + "</div></html>");

                endLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 65));
                JPanel wrapperEndLabel = wrapperLabelGenerator(endLabel, 60, 0, 0, 0, true);
                panel.add(wrapperEndLabel);

                panel.revalidate();
                panel.repaint();

                levelFinished = true; // Bloque les mouvements futurs
            }
            return;
        }
        GuiGamePage.updateMap(rpg, listToken, grid);
    }

    private static JPanel wrapperLabelGenerator(JLabel elem, int top, int left, int bottom, int right, boolean setSize) {
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapper.setOpaque(false);
        wrapper.add(elem);

        wrapper.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 0),
                BorderFactory.createEmptyBorder(top, left, bottom, right)
        ));

        // 🔥 FIX IMPORTANT : empêche le wrapper de prendre toute la hauteur !
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
