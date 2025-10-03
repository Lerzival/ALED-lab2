package es.upm.aled.lab2.kinematics;

import java.util.*;

// 
public class Segment {

	private double length;
	private double angle;
	private List<Segment> children =new ArrayList<Segment>();
	
	public Segment(double length, double angle) { 
		
		this.length=length;
		this.angle=angle;
		
	}

	public double getLength() {
		return length;
	}

	public double getAngle() {		
		return angle;
	}

	public List<Segment> getChildren() {
		return children;
	}
	
	public void setAngle(double angle) {
		this.angle=angle;
	}
	
	public void addChild(Segment child) {
		
		if(!children.contains(child)) {
		children.add(child);
		}
	}
	
}