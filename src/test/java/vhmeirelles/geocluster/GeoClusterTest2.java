package vhmeirelles.geocluster;

import java.util.*;

import junit.framework.TestCase;
/*@author: Eric Ferreira
 * Test to cluster generate.
 * @return Clusters
 * @see Numbers of Clusters genereted
 * @param Coordinates, zoom level and distance of area. 
*/
public class GeoClusterTest2 extends TestCase {

	private int distance;
	private int zoomLevel;
	private Coordinate coo1 = new Coordinate();
	private Coordinate coo2 = new Coordinate();
	private Coordinate coo3 = new Coordinate();
	private Coordinate coo4 = new Coordinate();
	private Coordinate coo5 = new Coordinate();
	private Coordinate coo6 = new Coordinate();
	private Coordinate coo7 = new Coordinate();
	private Coordinate coo8 = new Coordinate();
	private Coordinate coo9 = new Coordinate();
	private Coordinate coo10 = new Coordinate();
	private Set<Coordinate> setCoor = new HashSet<Coordinate>();
	
	protected void setUp() throws Exception {
		super.setUp();
		distance = 100;
		zoomLevel = 8;
		
		//RJ
		coo1.setX(-22.902146);
		coo1.setY(-43.222123);
		
		coo2.setX(-22.951528);
		coo2.setY(-43.184752);
		
		coo3.setX(-22.956017);
		coo3.setY(-43.604587);
		
		//SP
		coo4.setX(-23.452058);
		coo4.setY(-46.541755);
		
		coo5.setX(-23.805724);
		coo5.setY(-45.403447);
		
		//MS
		coo6.setX(-20.433163);
		coo6.setY(-54.655055);
		
		coo7.setX(-19.010370);
		coo7.setY(-57.604503);
		
		//MT
		coo8.setX(-9.173753);
		coo8.setY(-60.640114);
		
		//AM
		coo9.setX(-6.967134);
		coo9.setY(-63.939732);
		
		//RO
		coo10.setX(-10.798076);
		coo10.setY(-65.031514);
		
		setCoor.add(coo1);
		setCoor.add(coo2);
		setCoor.add(coo3);
		setCoor.add(coo4);
		setCoor.add(coo5);
		setCoor.add(coo6);
		setCoor.add(coo7);
		setCoor.add(coo8);
		setCoor.add(coo9);
		setCoor.add(coo10);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		distance = 0;
		zoomLevel = 0;
		coo1 = null;
		coo2 = null;
		coo3 = null;
		coo4 = null;
		coo5 = null;
		coo6 = null;
		coo7 = null;
		coo8 = null;
		coo9 = null;
		coo10 = null;
		setCoor = null;
	}

	public void testCluster() {
		GeoCluster geocluster = new GeoCluster();
		Set<Coordinate> a = geocluster.cluster(setCoor, distance, zoomLevel);
		int i = 0;
		for(Coordinate b : a){
			System.out.println(b);
			i++;
		}
		
		//Quantidade de clusters com o zoomLevel 8 e distância 100
		int valorEsperado = 9;
		assertEquals(valorEsperado, i);
		
		//fail("Not yet implemented");
	}

	public void testGetBoundsZoomLevel() {
		//fail("Not yet implemented");
	}

	public void testHaversineDistance() {
		//fail("Not yet implemented");
	}

}
