import java.util.*;
import java.lang.*;
public class Point {
	private double x, y;

	public Point() {x = 0; y = 0;};

public Point(double xIn, double yIn) {x = xIn; y = yIn;};
public double distance(Point p) 
{
	double thisDick = Math.abs(Math.sqrt(Math.pow((p.x-x),2) + Math.pow((p.y-y),2)));
	return thisDick;
}
public Point createCentroid(KMean k){
	Point p;
	Random randVar = new Random();
	ArrayList<Double> xArr = new ArrayList<Double>();
	ArrayList<Double> yArr = new ArrayList<Double>();
	xArr = k.getX();
	yArr = k.getY();
	double xMin = xArr.get(0);
	double xMax = xArr.get(xArr.size()-1);
	double yMin = yArr.get(0);
	double yMax = yArr.get(yArr.size()-1);
	
	double xRand = xMin + (xMax - xMin) * randVar.nextDouble();
	double yRand = yMin + (yMax - yMin) * randVar.nextDouble();
	
	p = new Point(xRand,yRand);
	
	
	return p;
}
;



}



