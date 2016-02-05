package vhmeirelles.gwtGeoclusterTest;

import junit.framework.TestSuite;

public class GeoClusterTest {

	public static TestSuite suite() {
		TestSuite suite = new TestSuite(GeoClusterTest.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(GeoClusterTest1.class);
		suite.addTestSuite(GeoClusterTest2.class);
		suite.addTestSuite(GeoClusterTest3.class);
		suite.addTestSuite(GeoClusterTest4.class);
		suite.addTestSuite(GeoClusterTest5.class);
		suite.addTestSuite(GeoClusterTest6.class);
		suite.addTestSuite(GeoClusterTest7.class);
		suite.addTestSuite(GeoClusterTest8.class);
		//$JUnit-END$
		return suite;
	}

}
