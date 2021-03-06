package vhmeirelles.gwtGeocluster.model;

import java.util.HashSet;
import java.util.Set;
/*
 * @author victor
 * Create clusters
 */
import java.util.logging.Logger;

public class GeoCluster {

	private static final long OFFSET = 268435456;
	private static final double RADIUS = 85445659.4471; /* $offset / pi() */
	//private Logger logger = Logger.getLogger(this.getClass().getName());

	private long lonToX(double lon) {
		return Math.round(OFFSET + RADIUS * lon * Math.PI / 180);
	}

	private long latToY(double lat) {
		return Math.round(OFFSET
				- RADIUS * Math.log((1 + Math.sin(lat * Math.PI / 180)) / (1 - Math.sin(lat * Math.PI / 180))) / 2);
	}

	private int pixelDistance(double lat1, double lon1, double lat2, double lon2, int zoom) {
		long x1 = lonToX(lon1);
		long y1 = latToY(lat1);
		long x2 = lonToX(lon2);
		long y2 = latToY(lat2);

		int sqrt = (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		return sqrt >> (21 - zoom);
	}

	public Set<Coordinate> cluster(Set<Coordinate> coords, int distance, int zoom) {
		Set<Coordinate> elements = new HashSet<Coordinate>();
		Set<Coordinate> removeList = new HashSet<Coordinate>();

		/* Loop until all markers have been compared. */
		for (Coordinate coord : coords) {
			if (removeList.contains(coord)) {
				continue;
			}

			Cluster cluster = new Cluster();
			cluster.add(coord);
			/* Compare against all markers which are left. */
			for (Coordinate target : coords) {
				if (target.equals(coord)) {
					continue;
				}

				int pixels = pixelDistance(coord.getY(), coord.getX(), target.getY(), target.getX(), zoom);
				/* If two markers are closer than given distance remove */
				/* target marker from array and add it to cluster. */

				if (distance > pixels) {
					cluster.add(target);
					removeList.add(target);

				}

			}

			/* If a marker has been added to cluster, add also the one */
			/* we were comparing to and remove the original from array. */
			if (cluster.getQuantity() > 1) {
				
				// elements.add(cluster);

				SimpleCluster sc = cluster.toSimpleCluster();
				elements.add(sc);

			} else {
				elements.add(coord);
			}
		}
		return elements;
	}

	public int getBoundsZoomLevel(BoundingBox bbox, int width, int height) {
		int worldHeight = 256;
		int worldWidth = 256;

		double lngDiff = bbox.getMaxX() - bbox.getMinX();
		if (lngDiff < 0) {
			lngDiff += 360;
		}
		double latDiff = bbox.getMaxY() - bbox.getMinY();
		if (latDiff < 0) {
			latDiff += 360;
		}

		int latZoom = (int) Math.round(Math.log(height * 360 / latDiff / worldHeight) / Math.log(2));
		;
		int lngZoom = (int) Math.round(Math.log(width * 360 / lngDiff / worldWidth) / Math.log(2));

		int zoomLevel = Math.min(latZoom, lngZoom);

		return zoomLevel;
	}

	public double haversineDistance(double lat1, double lon1, double lat2, double lon2) {
		double latd = Math.toRadians(lat2 - lat1);
		double lond = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latd / 2) * Math.sin(latd / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lond / 2) * Math.sin(lond / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return 6371.0 * c;
	}

}
