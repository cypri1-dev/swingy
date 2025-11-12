package com.swingy.view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ExempleBoxLayout extends JFrame {

	private JTabbedPane tabbedPane;

	@Override
	protected void frameInit() {
		super.frameInit();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Exemple composants");
		tabbedPane = new JTabbedPane();
		this.add(tabbedPane);

		addComponent("Label",
					new JLabel(UIManager.getIcon("FileView.computerIcon")),
					new JLabel("Libellé avec du texte"));

		addComponent("Text field", new JTextField("champ de texte"));
		addComponent("Text area", new JTextArea("zone de texte"));
		addComponent("Combo box", new JComboBox<>(new String[] {"Bleu", "Rouge", "Vert"}));
		addComponent("Check box", new JCheckBox("une boîte à cocher"));
		addComponent("Spinner", new JSpinner());
		addComponent("Editor", new JEditorPane("text/html", "<p>Un éditeur de texte <strong>riche</strong></p>"));

		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(60);
		addComponent("Progress bar", progressBar);

		addComponent("Button", new JButton("Un bouton"));
	}

	private void addComponent(String titre, JComponent... components) {
		JPanel panel = new JPanel();
		for (JComponent component : components) {
		panel.add(component);
		}
		tabbedPane.add(titre, panel);
	}
}
