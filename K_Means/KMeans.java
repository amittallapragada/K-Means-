import java.util.ArrayList;
import java.util.HashMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
public class KMeans {
	private ArrayList<Point> points;
	private ArrayList<Centroid> centroids;

	public KMeans(ArrayList<Point> points, ArrayList<Centroid> centroids) {
		this.points = points;
		this.centroids = centroids;
	}
	/*
	 * generates a hashmap with key centroid and value its closest points.
	 */
	private HashMap<Centroid,ArrayList<Point>> assignPoints() {
		HashMap<Centroid, ArrayList<Point>> centroidToPoints = new HashMap<Centroid, ArrayList<Point>>();

		// fill in the keys.
		for (Centroid centroid: centroids){
			centroidToPoints.put(centroid, centroid.pointListGenerator(centroids,points));
		}

		return centroidToPoints;
	}
	
	/*
	 * checks if 2 hashmaps are equal and returns true
	 */
	private boolean compareTo(HashMap map1, HashMap map2) {
		if (map1.size() != map2.size()) {
			return false;
		}

		for (Centroid centroid : centroids) {
			ArrayList<Point> list1 = (ArrayList<Point>) map1.get(centroid);
			ArrayList<Point> list2 = (ArrayList<Point>) map2.get(centroid);

			if (compareTo(list1, list2) == false) {
				return false;
			}
		}

		return true;
	}

	private boolean compareTo(ArrayList<Point> list1, ArrayList<Point> list2) {
		if (list1.size() != list2.size()) {
			return false;
		}

		for (Point point : list1) {
			if (!list2.contains(point)) {
				return false;
			}
		}

		return true;
	}


	/*
	 * generates new position of centroid and updates the centroid value
	 */
	private void modifyCentroids(HashMap<Centroid, ArrayList<Point>> centroidToPoints) {

		for (Centroid centroid : centroids) 
		{
			ArrayList<Point> pointvals = (ArrayList<Point>) centroidToPoints.get(centroid);
			double sumX = 0;
			double sumY = 0;
			for (Point point: pointvals)
			{
				sumX = sumX + point.getX();
				sumY = sumY + point.getY();
			}
			double avgX = sumX/pointvals.size();
			double avgY = sumY/pointvals.size();
			
			centroid.setX(avgX);
			centroid.setY(avgY);
			
			System.out.println(centroid.getX() + "," + centroid.getY());

		}		

	}

	public void run() {
		HashMap<Centroid, ArrayList<Point>> prevState = new HashMap<Centroid, ArrayList<Point>>();
		HashMap<Centroid, ArrayList<Point>> currState = assignPoints();
		int count = 0;
		while (compareTo(currState, prevState) == false) {
			prevState = currState;
			modifyCentroids(currState);
			currState = assignPoints();
			System.out.println("Its lit.");
			count = count +1;
			plot();
		}
		System.out.println("total iterations: " + count);

	}
	public void plot()
	{
        XYSeries p = new XYSeries("points");
        XYSeries c = new XYSeries("centroids");
		XYSeriesCollection dataset = new XYSeriesCollection();

		for(Point point: points)
		{
			p.add(point.getX(), point.getY());
		}
		
		for(Centroid cent: centroids)
		{
			c.add(cent.getX(), cent.getY());
		}

        dataset.addSeries(p);
        dataset.addSeries(c);	        
		JFreeChart chart = ChartFactory.createScatterPlot("K-Means", "X-Axis", "Y-Axis", dataset);
		ChartFrame frame = new ChartFrame("K-Means", chart);
		frame.setVisible(true);
		frame.setSize(450,350);
	}
	
	

	public static void main(String[] args) {
		ArrayList<Point> points = new ArrayList<Point>();
		ArrayList<Centroid> centroids = new ArrayList<Centroid>();

		points.add(new Point(1, 5));
		points.add(new Point(2, 2));
		points.add(new Point(3, 4));
		points.add(new Point(3, 3));
		points.add(new Point(4, 1));
		points.add(new Point(5, 3));
				centroids.add(new Centroid(2,1));
		centroids.add(new Centroid(4, 3));

		KMeans kmeans = new KMeans(points, centroids);
		kmeans.plot();
		kmeans.run();
	}
}
