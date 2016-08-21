
public class KM_Driver {
public static void main(String[] ass){
	double[] x = {1,2,3,4,5};
	double[] y = {2,3,4,5,6};
	KMean tit = new KMean(x,y);
	int numCent = tit.create_Centroids();
	System.out.println(numCent);
	
	
	
	
	
	
}
}
