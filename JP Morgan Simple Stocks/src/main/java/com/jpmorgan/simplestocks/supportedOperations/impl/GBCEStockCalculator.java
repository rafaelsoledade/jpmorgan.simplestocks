package main.java.com.jpmorgan.simplestocks.supportedOperations.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import main.java.com.jpmorgan.simplestocks.enums.StockType;
import main.java.com.jpmorgan.simplestocks.enums.TradeIndicator;
import main.java.com.jpmorgan.simplestocks.model.GBCEStock;
import main.java.com.jpmorgan.simplestocks.model.StockTrade;
import main.java.com.jpmorgan.simplestocks.supportedOperations.IStockCalculator;
import main.java.com.jpmorgan.simplestocks.utils.DateHelper;

/**
 * Class responsible for doing all required GBCE stock calculation operations
 * 
 * @author rafaelmatos
 * 
 *         Logger
 * 
 *         JUNIT com testes de unidade: sanity checks, inserir dados de teste
 *         errados (stock diferente), etc
 * 
 */
public class GBCEStockCalculator implements IStockCalculator<GBCEStock> {

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

	if (stock.getLastDividend() > 0) {
	    stock.setMarketPrice(marketPrice);
	    return new BigDecimal((marketPrice / stock.getLastDividend())).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	return defaultReturnValue;
    }

    public StockTrade recordTrade(GBCEStock stock, int nShares, TradeIndicator tradeIndicator) {

	StockTrade stockTrade = new StockTrade();

	if (nShares > 0) {

	    stockTrade.setQuantity(nShares);
	    stockTrade.setTimeStamp(new Date());
	    stockTrade.setTradeIndicator(tradeIndicator);

	    double tradePrice = new BigDecimal(nShares * stock.getMarketPrice()).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();

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

	double stockPriceSum = 0.0;

	if (allStocks.size() > 0) {
	    for (GBCEStock currStock : allStocks) {
		stockPriceSum += currStock.getMarketPrice();
	    }
	    return new BigDecimal(Math.pow(stockPriceSum, 1.0 / allStocks.size())).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	return stockPriceSum;
    }
}
