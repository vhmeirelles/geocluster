package wiiglo.geocluster;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String args[] )
    {
        //System.out.println( "Hello World!" );
    	GeoCluster geoCluster = new GeoCluster();
    	BoundingBox bd = new BoundingBox();
    	
    	bd.setBounds(-22.902118, -43.222080, -22.900240,43.224419);
    	
    	
    	geoCluster.getItemCoordinates(bd, 10, true);
    }
}
