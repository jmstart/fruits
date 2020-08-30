package com.jiaming.povos;

import java.math.BigDecimal;

public class PricePovo {

	private BigDecimal min;
	private BigDecimal max;
	public BigDecimal getMin() {
		return min;
	}
	public void setMin(BigDecimal min) {
		this.min = min;
	}
	public BigDecimal getMax() {
		return max;
	}
	public void setMax(BigDecimal max) {
		this.max = max;
	}
	@Override
	public String toString() {
		return "PricePovo [min=" + min + ", max=" + max + "]";
	}
	public PricePovo(BigDecimal min, BigDecimal max) {
		super();
		this.min = min;
		this.max = max;
	}
	public PricePovo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
