//package wiiglo.geocluster;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Hello world!
// *
// */
//public class Main 
//{
//    public static void main( String[] args )
//    {
//        //System.out.println( "Hello World!" );
//    	GeoCluster geoCluster = new GeoCluster();
//    	BoundingBox bd = new BoundingBox();
//    	Coordinate coo = new Coordinate();
//
//    	Cluster cluster = new Cluster();
//
//    	
//    	coo.setX(-22.902118);
//    	coo.setY(-43.222080);
//    	item.setX(-22.900240);
//    	item.setY(43.224419);
//    	bd.setBounds(-22.902118, -43.222080, -22.900240,43.224419);
//    	
//    	Set<Coordinate> setCoor = new HashSet<Coordinate>();
//    	setCoor.add(coo);
//    	setCoor.add(item);
//    	
//    	cluster.add(coo);
//    	cluster.add(item);
//    	
//    	for (Coordinate a : setCoor){
//    		System.out.println("AAA"+a.toWKT());
//    	}
//    	
//    	System.out.println(geoCluster.getItemCoordinates(bd, 5, false));  	
//    	System.out.println(bd.toString());
//    	System.out.println(coo.toString());
//    	System.out.println(item.toString());
//    	System.out.println(cluster.getBbox());
//    	System.out.println(geoCluster.getItemCoordinates(cluster.getBbox(),5, true));
//    	
//    }
//}
//
