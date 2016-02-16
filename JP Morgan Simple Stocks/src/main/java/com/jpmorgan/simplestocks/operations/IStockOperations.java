package main.java.com.jpmorgan.simplestocks.operations;

import java.util.List;

import main.java.com.jpmorgan.simplestocks.enums.TradeIndicator;
import main.java.com.jpmorgan.simplestocks.model.Stock;
import main.java.com.jpmorgan.simplestocks.model.StockTrade;

/**
 * Interface for the stock calculator. These are considered to be the base
 * operations for all stocks.
 * 
 */
public interface IStockOperations<T extends Stock> {

    /**
     * Exercise a. i.
     * 
     * @param stock
     *            the stock being evaluated
     * @param marketPrice
     *            the established market price
     * 
     * @return the stock dividend yield
     */
    public double calculateDividendYield(T stock, double marketPrice);

    /**
     * Exercise a. ii.
     * 
     * @param stock
     *            the stock being evaluated
     * @param marketPrice
     *            the established market price
     * 
     * @return the stock Price/Earnings ratio
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
     * @param tradePrice
     *            the trade price
     * 
     * @return a stock trade record object
     */
    public StockTrade recordTrade(T stock, int nShares, TradeIndicator tradeIndicator, double tradePrice);

    /**
     * Exercise a. iv.
     * 
     * @param gbceStock
     * @param timeSpanInMinutes
     *            calculate trades for the past n minutes
     * 
     * @return the stocks volume weighted stock price
     */
    public double calculateVolumeWeightedStockPrice(T stock, int timeSpanInMinutes);

    /**
     * Exercise b.
     * 
     * @param allStocks
     *            The list of all available stocks
     * @return GBCE Price share index
     */
    public double calculateGBCEAllShareIndex(List<T> allStocks);
}
