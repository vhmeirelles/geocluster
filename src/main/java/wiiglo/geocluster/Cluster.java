package wiiglo.geocluster;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Cluster extends Coordinate{

	private Set<Coordinate> coords = new HashSet<Coordinate>();

	public int getQuantity() {
		return coords.size();
	}

	public BoundingBox getBbox() {
		if (coords.isEmpty())
			return null;
		double minx = coords.iterator().next().getX();
		double miny = coords.iterator().next().getY();
		double maxx = coords.iterator().next().getX();
		double maxy = coords.iterator().next().getY();
		for (Coordinate coord : coords) {
			minx = Math.min(minx, coord.getX());
			miny = Math.min(miny, coord.getY());
			maxx = Math.max(maxx, coord.getX());
			maxy = Math.max(maxy, coord.getY());
		}
		BoundingBox bounds = new BoundingBox();
		bounds.setBounds(minx, miny, maxx, maxy);
		return bounds;
	}

	public void add(Coordinate coord) {
		coords.add(coord);
		BoundingBox bounds = getBbox();
		setX(bounds.getMinX() + ((bounds.getMaxX() - bounds.getMinX()) / 2));
		setY(bounds.getMinY() + ((bounds.getMaxY() - bounds.getMinY()) / 2));
	}

	public void addAll(Collection<? extends Coordinate> c) {
		coords.addAll(c);
		BoundingBox bounds = getBbox();
		setX(bounds.getMinX() + ((bounds.getMaxX() - bounds.getMinX()) / 2));
		setY(bounds.getMinY() + ((bounds.getMaxY() - bounds.getMinY()) / 2));
	}

	public void remove(Coordinate coord) {
		coords.remove(coord);
		BoundingBox bounds = getBbox();
		setX(bounds.getMinX() + ((bounds.getMaxX() - bounds.getMinX()) / 2));
		setY(bounds.getMinY() + ((bounds.getMaxY() - bounds.getMinY()) / 2));
	}

	public Set<Coordinate> getCoords() {
		return coords;
	}
	
	public boolean contains(Coordinate coord){
		BoundingBox bounds = getBbox();
		if (coord.getX() < bounds.getMinX()){
			return false;
		}
		if (coord.getX() > bounds.getMaxX()){
			return false;
		}
		if (coord.getY() < bounds.getMinY()){
			return false;
		}
		if (coord.getY() > bounds.getMaxY()){
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((coords == null) ? 0 : coords.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cluster other = (Cluster) obj;
		if (coords == null) {
			if (other.coords != null)
				return false;
		} else if (!coords.equals(other.coords))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cluster [coords=" + coords.toString() + "]";
	}
	
}
