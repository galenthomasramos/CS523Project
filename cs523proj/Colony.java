package com.cs523proj;

import processing.core.PApplet;
import processing.core.PVector;

public class Colony {

	PApplet parent;
	PVector position;
	int diameter;
	int color;

	public Colony(PApplet _parent, PVector _position, int _diameter, int _color) {
		parent = _parent;
		position = _position;
		diameter = _diameter;
		color = _color;
	}

	public void render() {
		parent.fill(color);
		parent.ellipse(position.x, position.y, diameter, diameter);
	}
}
