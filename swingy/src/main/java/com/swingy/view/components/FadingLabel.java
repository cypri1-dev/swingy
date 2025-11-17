package com.swingy.view.components;

import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;


public class FadingLabel extends JLabel {
	private float alpha = 0f; // transparence initiale

	public FadingLabel(String text) {
		super(text);
		setOpaque(false);
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
		repaint();
	}

	public float getAlpha() {
		return alpha;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		super.paintComponent(g2d);
		g2d.dispose();
	}
}