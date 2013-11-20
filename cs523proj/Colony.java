package com.cs523proj;

import processing.core.PApplet;
import processing.core.PVector;

public class Colony {

	PApplet parent;
	Circle circle;
	int color;

	public Colony(PApplet _parent, PVector _position, int _radius, int _color) {
		parent = _parent;
		circle = new Circle (position.x, position.y, radius);
		color = _color;
	}

	public void render() {
		parent.fill(color);
		parent.ellipse(circle.point.getX(),circle.point.getY(), 2*c.radius, 2*c.radius);
	}

	boolean isColliding(Circle c)
	{
		float circleDistanceX = abs(circle.point.getX() - c.point.getX());
		float circleDistanceY = abs(circle.point.getY() - c.point.getY());
	 
		float distance = parent.pow(circleDistanceX, 2) +
							 parent.pow(circleDistanceY, 2);
	 
		return (distance <= parent.pow(circle.radius+c.radius, 2));
	}
}
