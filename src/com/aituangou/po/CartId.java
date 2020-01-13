package com.aituangou.po;


public class CartId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Buyer buyer;
	private Goods goods;


	public CartId() {}

	public CartId(Buyer buyer, Goods goods) {
		this.buyer = buyer;
		this.goods = goods;
	}


	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CartId))
			return false;
		CartId castOther = (CartId) other;

		return ((this.getBuyer() == castOther.getBuyer()) || (this.getBuyer() != null && castOther.getBuyer() != null
				&& this.getBuyer().equals(castOther.getBuyer())))
				&& ((this.getGoods() == castOther.getGoods()) || (this.getGoods() != null
						&& castOther.getGoods() != null && this.getGoods().equals(castOther.getGoods())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBuyer() == null ? 0 : this.getBuyer().hashCode());
		result = 37 * result + (getGoods() == null ? 0 : this.getGoods().hashCode());
		return result;
	}

}