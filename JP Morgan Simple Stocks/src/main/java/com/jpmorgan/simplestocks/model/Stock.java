package main.java.com.jpmorgan.simplestocks.model;

import java.util.ArrayList;
import java.util.List;

import main.java.com.jpmorgan.simplestocks.enums.StockSymbol;
import main.java.com.jpmorgan.simplestocks.enums.StockType;

/**
 * Abstract class that represents any stock with these base attributes
 * 
 * @author rafaelmatos
 *
 */
public abstract class Stock {

	private StockSymbol stockSymbol;
	private StockType stockType;
	private int lastDividend;
	private double fixedDividend;
	private int parValue;
	
	private double marketPrice;
	private List<StockTrade> tradeRecords;
	
	public Stock() {
	    lastDividend = 0;
	    fixedDividend = 0.0;
	    tradeRecords = new ArrayList<StockTrade>();
	    marketPrice = 0.0;
	}
	
	public Stock(StockSymbol stockSymbol, StockType stockType, int lastDividend,
		double fixedDividend, int parValue) {
		
		this.stockSymbol = stockSymbol;
		this.stockType = stockType;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
		marketPrice = 0.0;
		tradeRecords = new ArrayList<StockTrade>();
	}

	public StockSymbol getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(StockSymbol stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public StockType getStockType() {
		return stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public int getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(int lastDividend) {
		this.lastDividend = lastDividend;
	}

	public double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public int getParValue() {
		return parValue;
	}

	public void setParValue(int parValue) {
		this.parValue = parValue;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public List<StockTrade> getTradeRecords() {
	    return tradeRecords;
	}

	public void setTradeRecords(List<StockTrade> tradeRecords) {
	    this.tradeRecords = tradeRecords;
	}

	@Override
	public String toString() {
	    return "Stock Symbol: '" + this.getStockSymbol() 
		    + "', Stock Type: '" + this.getStockType() 
		    + "', Last Dividend: '" + this.getLastDividend() 
		    + " , Fixed Dividend: '" + this.getFixedDividend()
		    + " , Par Value: '" + this.getParValue()
	    	    + " , Market Price: '" + this.getMarketPrice();
	}
	
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == this) { 
		return true; 
	    } 
	    if (obj == null || obj.getClass() != this.getClass()) { 
		return false; 
	    }
	    
	    Stock stockParam = (Stock) obj;
	    
	    return (this.getStockSymbol().equals(stockParam.getStockSymbol()));
	}
}
