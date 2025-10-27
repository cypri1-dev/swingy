package com.swingy.model;

public class Coordinates {
	private int x;
	private int y;
	private int prevX;
	private int prevY;

	Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
		this.prevX = x;
		this.prevY = y;
	}

	public void setStart(int size) {
		this.x = size / 2;
		this.y = size / 2;
		this.prevX = this.x;
		this.prevY = this.y;
	}

	public void setX(int x) {this.x += x;}
	public void setY(int y) {this.y += y;}
	public void setPrevX(int x) {this.prevX = x;}
	public void setPrevY(int y) {this.prevY = y;}
	public int getX() {return this.x;}
	public int getPrevX() {return this.prevX;}
	public int getY() {return this.y;}
	public int getPrevY() {return this.prevY;}
	public void setXBack(int x) {this.x = x;}
	public void setYBack(int y) {this.y = y;}
}