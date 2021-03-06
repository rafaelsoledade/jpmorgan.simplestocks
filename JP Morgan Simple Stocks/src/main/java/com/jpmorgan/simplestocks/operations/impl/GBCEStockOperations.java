package main.java.com.jpmorgan.simplestocks.operations.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import main.java.com.jpmorgan.simplestocks.enums.StockType;
import main.java.com.jpmorgan.simplestocks.enums.TradeIndicator;
import main.java.com.jpmorgan.simplestocks.model.GBCEStock;
import main.java.com.jpmorgan.simplestocks.model.StockTrade;
import main.java.com.jpmorgan.simplestocks.operations.IStockOperations;
import main.java.com.jpmorgan.simplestocks.utils.DateHelper;

/**
 * Class responsible for doing all required GBCE stock calculation operations
 * 
 * @author rafaelmatos
 * 
 */
public class GBCEStockOperations implements IStockOperations<GBCEStock> {

    private static final double defaultReturnValue = 0.0;

    public double calculateDividendYield(GBCEStock stock, double marketPrice) {

	stock.setMarketPrice(marketPrice);

	if (marketPrice > 0) {
	    if (StockType.COMMON.equals(stock.getStockType())) {
		return new BigDecimal((stock.getLastDividend() / marketPrice)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	    }

	    if (StockType.PREFERRED.equals(stock.getStockType())) {
		return new BigDecimal(((stock.getFixedDividend() * stock.getParValue()) / marketPrice)).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	    }
	}

	return defaultReturnValue;
    }

    public double calculatePeRatio(GBCEStock stock, double marketPrice) {

	stock.setMarketPrice(marketPrice);

	if (stock.getLastDividend() > 0) {
	    return new BigDecimal((marketPrice / stock.getLastDividend())).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	return defaultReturnValue;
    }

    public StockTrade recordTrade(GBCEStock stock, int nShares, TradeIndicator tradeIndicator, double tradePrice) {

	StockTrade stockTrade = new StockTrade();

	if (nShares * tradePrice > 0) {

	    stockTrade.setQuantity(nShares);
	    stockTrade.setTimeStamp(new Date());
	    stockTrade.setTradeIndicator(tradeIndicator);

	    tradePrice = new BigDecimal(tradePrice).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();

	    stockTrade.setTradePrice(tradePrice);

	    stock.getTradeRecords().add(stockTrade);
	}
	return stockTrade;
    }

    public double calculateVolumeWeightedStockPrice(GBCEStock gbceStock,
	    int timeSpanInMinutes) {

	double divisor = 0.0;
	double divider = 0.0;

	for (StockTrade currentTrade : gbceStock.getTradeRecords()) {

	    if (DateHelper.isTradeProcessedWithinTimeSpan(currentTrade.getTimeStamp(), timeSpanInMinutes)) {
		divisor += currentTrade.getQuantity();
		divider += currentTrade.getTradePrice() * currentTrade.getQuantity();
	    }
	}
	if (divisor > 0) {
	    return new BigDecimal(divider / divisor).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	return defaultReturnValue;
    }

    public double calculateGBCEAllShareIndex(List<GBCEStock> allStocks) {

	double stockPriceMultiplied = 1.0;

	if (allStocks.size() > 0) {
	    for (GBCEStock currStock : allStocks) {
		if (currStock.getMarketPrice() > 0) {
		    stockPriceMultiplied *= currStock.getMarketPrice();
		}
	    }
	    return new BigDecimal(Math.pow(stockPriceMultiplied, 1.0 / allStocks.size())).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	return defaultReturnValue;
    }
}
