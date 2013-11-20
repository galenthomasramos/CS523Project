package com.cs523proj;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Ant {
	PApplet parent;
	Circle circle;
	int color;
	boolean colonyDuty;
	Circle colonyDutyLocation;

	public Ant(PApplet _parent, PVector _position, int _radius, int _color) {
		parent = _parent;
		circle = new Circle (position.x, position.y, radius)
		color = _color;
	}

	public void render() {
		parent.fill(color);
		parent.ellipse(circle.point.getX(),circle.point.getY(), 2*c.radius, 2*c.radius);
	}

	public void setOnRole() {
		colonyDuty = false;
		colonyDutyLocation = null;
	}

	public void setColonyDuty(PVector p, float radius) {
		colonyDutyLocation = new Circle (p.x, p.y, radius);
		colonyDuty = true;
	}

	public boolean colonyDutyFulFilled() {
		if (colonyDutyLocation == null)
			return false;
		
		return isColliding(colonyDutyLocation);
	}

	public boolean isColliding(Circle c)
	{
		float circleDistanceX = abs(circle.point.getX() - c.point.getX());
		float circleDistanceY = abs(circle.point.getY() - c.point.getY());
	 
		float distance = parent.pow(circleDistanceX, 2) +
							 parent.pow(circleDistanceY, 2);
	 
		return (distance <= parent.pow(circle.radius+c.radius, 2));
	}

}
