package com.kh.example.inherit1;

public class RectangleController {
	private Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int area = width * height;
		return r.toString() + " / " + area;
//		return x +", "+ y +", "+ height +", "+ width +" / " + area;
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int perimeter = 2 * (width + height);
		return r.toString() + " / " + perimeter;
//		return x +", "+ y +", "+ height +", "+ width +" / " + perimeter;
	}
}
