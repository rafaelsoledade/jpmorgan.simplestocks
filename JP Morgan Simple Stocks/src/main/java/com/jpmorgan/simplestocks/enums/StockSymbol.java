package main.java.com.jpmorgan.simplestocks.enums;


/**
 * 
 * Constants for the stock symbol, as java enum
 * 
 * @author rafaelmatos
 *
 */
public enum StockSymbol {

    /* GBCE Stock Symbols */
    TEA("TEA"), POP("POP"), ALE("ALE"), GIN("GIN"), JOE("JOE");
    
    private final String symbol;

    StockSymbol(final String symbol) {
        this.symbol = symbol;
    }
    
    public String getSymbol() {
	return symbol;
    }
    
    @Override
    public String toString() {
        return symbol;
    }
}
