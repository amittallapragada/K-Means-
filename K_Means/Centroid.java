import java.util.*;

public class Centroid extends Point {
	
	ArrayList<Point> closestPoints = new ArrayList<Point>();
	
	public Centroid()
	{
		super();
	}
	
	public Centroid(double x, double y)
	{
		super(x,y);
	}
	
	public void setPoint(Point p)
	{
		setX(p.getX());
		setY(p.getY());
	}
	
	public double calcDist(Point p1, Point p2)
	{
		double distance = Math.abs(Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2) +  Math.pow(p1.getY()-p2.getY(),2)));
		return distance;
	}
	/*
	 * Generates a list of points that are closest to a given centroid
	 */
	public ArrayList<Point> pointListGenerator(ArrayList<Centroid> centroids, ArrayList<Point> points)
	{
		ArrayList<Point> cent2point = new ArrayList<Point>();
		for(int x =0; x<centroids.size(); x++)
		{
			for(Point point:points)
			{
				if(calcDist(this,point)<calcDist(centroids.get(x),point))
				{
					cent2point.add(point);
				}
			}		
		}
//		System.out.println("Points in centroid");
//		for(int y=0; y<cent2point.size(); y++)
//		{
//			System.out.println("CENT: "  + cent2point.get(y).getX() + "," + cent2point.get(y).getY() );
//		}
		return cent2point;
	}
	
	
}
