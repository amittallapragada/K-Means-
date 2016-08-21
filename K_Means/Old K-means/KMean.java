import java.util.*;
import java.lang.*;


public class KMean{
	private int l;
	private ArrayList<Double> x = new ArrayList<Double>();
	private ArrayList<Double> y = new ArrayList<Double>();
	
	
	
	
	public KMean(double[] xIn, double[] yIn){
		l = xIn.length;
		
		

		for(int tit=0; tit<xIn.length; tit++)
		{
			x.add(xIn[tit]);
			y.add(yIn[tit]);
		}
		
		
	}
	public int create_Centroids()
	{
		Random tit = new Random();
		int num_Of_Centroids = tit.nextInt(l) +1 ;
		return num_Of_Centroids;
	}
	
	public ArrayList<Double> getX()
			{
		return x;
		
			}
	public ArrayList<Double> getY()
	{
return y;

	}
	
	
}
