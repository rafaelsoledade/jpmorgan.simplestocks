package main.java.com.jpmorgan.simplestocks.model;

import java.util.Date;

import main.java.com.jpmorgan.simplestocks.enums.TradeIndicator;

/**
 * Object that represents a stock trade operation.
 * 
 * @author rafaelmatos
 * 
 */
public class StockTrade {

    private Date	   timeStamp;
    private int	    quantity;
    private TradeIndicator tradeIndicator; // Buy or Sell
    private double     tradePrice;

    /* Class constructor */
    public StockTrade() {
	timeStamp = new Date();
	quantity = 0;
	tradePrice = 0.0;
    }

    /* Getters and setters */

    public Date getTimeStamp() {
	return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
	this.timeStamp = timeStamp;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public TradeIndicator getTradeIndicator() {
	return tradeIndicator;
    }

    public void setTradeIndicator(TradeIndicator tradeIndicator) {
	this.tradeIndicator = tradeIndicator;
    }

    public double getTradePrice() {
	return tradePrice;
    }

    public void setTradePrice(double tradePrice) {
	this.tradePrice = tradePrice;
    }

    @Override
    public String toString() {
	return "Time Stamp: " + timeStamp.toString() + "; Quantity: " + quantity + "; Operation: "
		+ tradeIndicator.getIndicator() + "; Price: " + tradePrice;
    }
}
