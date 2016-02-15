package main.java.com.jpmorgan.simplestocks.enums;

/**
 * 
 * Constants for the trade indicator, as java enum
 * 
 * @author rafaelmatos
 * 
 */
public enum TradeIndicator {

    BUY("Buy"), SELL("Sell");

    private final String indicator;

    /**
     * @param text
     */
    private TradeIndicator(final String indicator) {
	this.indicator = indicator;
    }

    public String getIndicator() {
	return indicator;
    }
    
    @Override
    public String toString() {
        return indicator;
    }
}
