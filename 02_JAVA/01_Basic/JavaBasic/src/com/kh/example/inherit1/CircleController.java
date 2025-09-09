package com.kh.example.inherit1;

public class CircleController{
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		double area = Math.PI * radius * radius;
		return c.toString() + " / " + area;
//		return x +", "+ y +", "+ radius +" / " + area;
	}
	
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		double circum = Math.PI * radius * 2;
		return c.toString() + " / " + circum;
//		return x +", "+ y +", "+ radius +" / "+ circum;
	}
}
