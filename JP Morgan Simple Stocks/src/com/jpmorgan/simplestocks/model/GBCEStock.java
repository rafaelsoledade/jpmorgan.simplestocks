package com.jpmorgan.simplestocks.model;

import com.jpmorgan.simplestocks.enums.StockSymbol;
import com.jpmorgan.simplestocks.enums.StockType;


/**
 * An object that represents a Global Beverage Corporation Exchange stock.
 * 
 * @author rafaelmatos
 * 
 */
public class GBCEStock extends Stock{

	public GBCEStock(){
	    super();
	}
    
    public GBCEStock(StockSymbol stockSymbol, StockType stockType, int lastDividend, double fixedDividend, int parValue) {
	super(stockSymbol, stockType, lastDividend, fixedDividend, parValue);
    }
}