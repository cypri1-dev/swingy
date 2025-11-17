package com.swingy.view.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;

public class FadingToken extends JLabel {
	private float alpha = 0f;

	public FadingToken(ImageIcon token) {
		super(token);
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