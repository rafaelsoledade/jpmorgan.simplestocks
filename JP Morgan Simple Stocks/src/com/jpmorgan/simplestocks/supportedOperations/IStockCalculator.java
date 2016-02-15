package com.jpmorgan.simplestocks.supportedOperations;

import java.util.List;

import com.jpmorgan.simplestocks.enums.TradeIndicator;
import com.jpmorgan.simplestocks.model.Stock;
import com.jpmorgan.simplestocks.model.StockTrade;

/**
 * Interface for the stock calculator. These are considered to be the base operations for all stocks.
 * 
 */
public interface IStockCalculator<T extends Stock> {

    /**
     * Exercise a. i.
     * 
     * @param stock
     *            the stock being evaluated
     * @param marketPrice
     *            the established market price
     */
    public double calculateDividendYield(T stock, double marketPrice);

    /**
     * Exercise a. ii.
     * 
     * @param stock
     *            the stock being evaluated
     * @param marketPrice
     *            the established market price
     */
    public double calculatePeRatio(T stock, double marketPrice);

    /**
     * Exercise a. iii.
     * 
     * @param stock
     *            the stock being transacted
     * @param nShares
     *            number of shares traded
     * @param tradeIndicator
     *            indication if it's a sell or buy trade
     *            
     * return the trade object
     */
    public StockTrade recordTrade(T stock, int nShares, TradeIndicator tradeIndicator);

    /**
     * Exercise a. iv.
     * 
     * @param gbceStock
     * @param timeSpanInMinutes
     *            calculate trades for the past <timeSpanInMinutes> minutes
     */
    public double calculateVolumeWeightedStockPrice(T stock, int timeSpanInMinutes);

    /**
     * Exercise b.
     * 
     * @param allStocks 
     * 		The list of all available stocks
     * @return GBCE Price share index
     */
    public double calculateGBCEAllShareIndex(List<T> allStocks);
}
