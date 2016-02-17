package vhmeirelles.gwtGeocluster.model;

public class SimpleCluster extends Coordinate {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6475582201803074975L;
	
	private int quantity;
	private BoundingBox Bbox;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BoundingBox getBbox() {
		return Bbox;
	}
	public void setBbox(BoundingBox bbox) {
		Bbox = bbox;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Bbox == null) ? 0 : Bbox.hashCode());
		result = prime * result + quantity;
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
		SimpleCluster other = (SimpleCluster) obj;
		if (Bbox == null) {
			if (other.Bbox != null)
				return false;
		} else if (!Bbox.equals(other.Bbox))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SimpleCluster [quantity=" + quantity + ", Bbox=" + Bbox + "]";
	}
	
	
	

}
