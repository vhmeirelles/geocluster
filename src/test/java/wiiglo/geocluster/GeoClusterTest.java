package wiiglo.geocluster;

import junit.framework.TestCase;

public class GeoClusterTest extends TestCase {

	private int distance;
	private int zoomLevel;
	
	protected void setUp() throws Exception {
		super.setUp();
		distance = 100;
		zoomLevel = 4;
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		distance = 0;
		zoomLevel = 0;
	}

	public void testCluster() {
		fail("Not yet implemented");
	}

	public void testGetBoundsZoomLevel() {
		fail("Not yet implemented");
	}

	public void testHaversineDistance() {
		fail("Not yet implemented");
	}

}
