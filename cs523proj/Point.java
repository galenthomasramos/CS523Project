package com.cs523proj;

public class Point {
	   public Point(float x, float y) {
	      // .. set x and Y coord
	   }

	   // Getters and Setters
	   public float getX() {
	      return x;
	   }

	  public float getY() {
	      return y;
	  }

	  public String toPrint() {
	      return "[" + x + "," + y + "]";
	  }
	  // Your other Pofloat methods...


	  private float x = 0;
	  private float y = 0;
	}