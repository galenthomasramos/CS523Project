package com.cs523proj;

import java.util.ArrayList;
import java.util.List;

import processing.core.*;

public class Trail {
	PApplet parentApplet;
	ArrayList<Circle> circleList;
	static float circleRadius;
	
	public Trail(PApplet _parent, float circleRadius){
		circleRadius = circleRadius;
		parentApplet = _parent;
		circleList = new ArrayList<Circle>();
	}
	
	public Trail(PApplet _parent, List<PVector> passedList, float _circleRadius){
		parentApplet = _parent;
		circleRadius = _circleRadius;
		for(PVector pvec: passedList){
			circleList.add(new Circle(pvec.x, pvec.y, circleRadius));
		}
	}
	
	//Add circles in regions of absent circles of trail
	public void interpolateTrail(){
		int i = 1;
		int noToAdd;
		float angleBetween;
		float interpolateDistance;
		
		float tempDist;
		
		float trailDivisor = 0.5f;
		
		PVector tempVec1;
		PVector tempVec2;
		
		PVector interpolateVec;
		
		Circle tempCircle;
		
		for (i = i; i < circleList.size(); i++){
			tempDist = PApplet.dist(circleList.get(i).point.getX(),circleList.get(i).point.getY(), circleList.get(i-1).point.getX(), circleList.get(i-1).point.getY());
			
			if(tempDist > trailDivisor * circleRadius){
				noToAdd = (int)(tempDist / (trailDivisor * circleRadius));
				
				interpolateDistance = tempDist / noToAdd;
				
				tempVec1 = new PVector(circleList.get(i-1).point.getX(), circleList.get(i-1).point.getY());
				tempVec2 = new PVector(circleList.get(i).point.getX(), circleList.get(i).point.getY());
				
				angleBetween = PVector.angleBetween(tempVec1, tempVec2);
						
				for(int j = 1; j < noToAdd; j++){
					interpolateVec = PVector.lerp(tempVec1, tempVec2, j / noToAdd);
					tempCircle = new Circle(interpolateVec.x, interpolateVec.y, circleRadius);
					
					circleList.add(i, tempCircle);
				}
			}
		}
	}
	
	public void render(){
		
		if(circleList.size() > 0){
			for(Circle circ: circleList){
				parentApplet.fill(255);
				parentApplet.stroke(0);
				parentApplet.strokeWeight(5);
				parentApplet.ellipse(circ.point.getX(), circ.point.getY(), circ.getRadius(), circleRadius);
			}
		}
		
	}
	
	public void randomPopulate(){
		
		float divX = 5;
		float divY = 10;
		
		int countX;
		int countY;
		
		float mappedX;
		float mappedY;
		
		int randInt;
		int randDir;
		
		ArrayList<PVector> pvecs= new ArrayList<PVector>();
		
		circleList = new ArrayList<Circle>();
		
		for(int i = 0; i < divY; i++){
				
			mappedY = parentApplet.map(i, 0, divY, 0, parentApplet.height);
			
			//randInt = (int) (Math.random() * 2);
			
			randDir = (int) (Math.random() * parentApplet.width);
			
			mappedX = parentApplet.map(i, 0, divY, 0, parentApplet.width);
			
			circleList.add(new Circle(mappedX, mappedY, circleRadius));
			
		}
		
	}
	
}
