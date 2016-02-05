package vhmeirelles.gwtGeocluster.model;

import java.io.Serializable;

/**
 * 
 * Classe que representa um Retângulo envolvente.
 * 
 */
public class BoundingBox implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2208968198563860476L;

	private double minX;
	private double minY;
	private double maxX;
	private double maxY;

	/**
	 * @param minx
	 *            {@link #getMinX()}
	 * @param miny
	 *            {@link #getMinY()}
	 * @param maxx
	 *            {@link #getMaxX()}
	 * @param maxy
	 *            {@link #getMaxY()}
	 */

	public void setBounds(double minx, double miny, double maxx, double maxy) {
		this.minX = minx;
		this.minY = miny;
		this.maxX = maxx;
		this.maxY = maxy;
	}

	/**
	 * @return Valor m�nimo no eixo x.
	 */
	public double getMinX() {
		return minX;
	}

	/**
	 * @return Valor m�nimo no eixo y.
	 */
	public double getMinY() {
		return minY;
	}

	/**
	 * @return Valor m�ximo no eixo x.
	 */
	public double getMaxX() {
		return maxX;
	}

	/**
	 * @return Valor m�ximo no eixo y.
	 */
	public double getMaxY() {
		return maxY;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(minX);
		result = PRIME * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(maxX);
		result = PRIME * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(maxY);
		result = PRIME * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(minY);
		result = PRIME * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final BoundingBox other = (BoundingBox) obj;
		if (this.minX != other.minX)
			return false;

		if (this.maxX != other.maxX)
			return false;

		if (this.minY != other.minY)
			return false;

		if (this.maxY != other.maxY)
			return false;

		return true;
	}

	public boolean equals(Object obj, double delta) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final BoundingBox other = (BoundingBox) obj;
		if (Double.compare(this.minX, other.minX) != 0) {
			if ((Math.abs(this.minX - other.minX) > delta)) {
				return false;
			}
		}
		if (Double.compare(this.maxX, other.maxX) != 0) {
			if ((Math.abs(this.maxX - other.maxX) > delta)) {
				return false;
			}
		}
		if (Double.compare(this.minY, other.minY) != 0) {
			if ((Math.abs(this.minY - other.minY) > delta)) {
				return false;
			}
		}
		if (Double.compare(this.maxY, other.maxY) != 0) {
			if ((Math.abs(this.maxY - other.maxY) > delta)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		return "BoundingBox [minX=" + minX + ", minY=" + minY + ", maxX=" + maxX + ", maxY=" + maxY + "]";
	}

	/**
	 * @return Representação WKT do BoundingBox
	 */
	public String toWKT() {
		String wkt = "POLYGON((<xmin> <ymin>,<xmin> <ymax>,<xmax> <ymax>,<xmax> <ymin>,<xmin> <ymin>))";
		wkt = wkt.replaceAll("<xmin>", String.valueOf(minX));
		wkt = wkt.replaceAll("<xmax>", String.valueOf(maxX));
		wkt = wkt.replaceAll("<ymin>", String.valueOf(minY));
		wkt = wkt.replaceAll("<ymax>", String.valueOf(maxY));
		return wkt;
	}

	public boolean contains(Coordinate coord) {
		if (this.minX < coord.getX() && this.minY < coord.getY() && this.maxX > coord.getX()
				&& this.maxY > coord.getY())
			return true;
		return false;
	}

	public boolean contains(BoundingBox other) {
		Coordinate min = new Coordinate();
		min.setX(other.minX);
		min.setY(other.minY);
		Coordinate max = new Coordinate();
		max.setX(other.maxX);
		max.setY(other.maxY);
		if (contains(min) && contains(max))
			return true;
		return false;
	}

	public boolean intersect(BoundingBox other) {
		Coordinate c00 = new Coordinate();
		c00.setX(other.minX);
		c00.setY(other.minY);
		if (contains(c00))
			return true;
		Coordinate c01 = new Coordinate();
		c01.setX(other.maxX);
		c01.setY(other.minY);
		if (contains(c01))
			return true;
		Coordinate c10 = new Coordinate();
		c10.setX(other.minX);
		c10.setY(other.maxY);
		if (contains(c00))
			return true;
		Coordinate c11 = new Coordinate();
		c11.setX(other.maxX);
		c11.setY(other.maxY);
		if (contains(c01))
			return true;
		return false;
	}

}
