package main.java.com.jpmorgan.simplestocks.enums;

/**
 * 
 * Constants for the stock symbol, as java enum
 * 
 * @author rafaelmatos
 * 
 */
public enum StockType {

    /* GBCE Stock Types */
    COMMON("Common"), PREFERRED("Preferred");

    private final String type;

    /**
     * @param text
     */
    private StockType(final String type) {
	this.type = type;
    }

    public String getType() {
	return type;
    }
    
    @Override
    public String toString() {
        return type;
    }
}
