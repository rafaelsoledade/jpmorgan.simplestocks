package main.java.com.jpmorgan.simplestocks.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.jpmorgan.simplestocks.enums.StockSymbol;
import main.java.com.jpmorgan.simplestocks.enums.TradeIndicator;
import main.java.com.jpmorgan.simplestocks.model.GBCEStock;
import main.java.com.jpmorgan.simplestocks.model.StockTrade;
import main.java.com.jpmorgan.simplestocks.supportedOperations.impl.GBCEStockCalculator;
import main.java.com.jpmorgan.simplestocks.utils.GBCEStockSampleDataGenerator;

import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * 
 * Main class for testing purposes
 * 
 * @author rafaelmatos
 *
 */
public class SimpleStocksMain {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, ParseException {

	HashMap<StockSymbol, GBCEStock> sampleData = GBCEStockSampleDataGenerator.generateSampleDataMap();
	GBCEStockCalculator stockOperations = new GBCEStockCalculator();

	/* Simulated input */
	String inputStock = "ale";
	double marketPrice = 15.35;
	GBCEStock stock = sampleData.get(StockSymbol.valueOf(inputStock.toUpperCase()));

	System.out.println("\n==== EXERCISE a. i. Dividend Yield =====");
	System.out.println(stockOperations.calculateDividendYield(stock, marketPrice));
	System.out.println("");

	System.out.println("==== EXERCISE a. ii. P/E Ratio =====");
	System.out.println(stockOperations.calculatePeRatio(stock, marketPrice));
	System.out.println("");

	System.out.println("==== EXERCISE a. iii. Record a trade =====");
	int nShares = 50;
	String tradeIndicator = "sell";

	StockTrade trade = stockOperations.recordTrade(stock, nShares, TradeIndicator.valueOf(tradeIndicator.toUpperCase()));

	if (trade != null) {
	    System.out.println("Recorded trade for stock " + stock.getStockSymbol() + ":\n" + trade.toString());
	} else {
	    System.out.println("No stocks were traded.");
	}
	System.out.println("");

	System.out.println("==== EXERCISE a. iv. Volume Weighted Stock Price for the past 15 minutes =====");
	int timeSpanInMinutes = 15;
	System.out.println(stockOperations.calculateVolumeWeightedStockPrice(stock, timeSpanInMinutes));
	System.out.println("");

	System.out.println("==== EXERCISE b. GBCE All Share Index =====");
	System.out.println(stockOperations.calculateGBCEAllShareIndex(allGBCEStocks(sampleData)));
	System.out.println("");
    }

    private static List<GBCEStock> allGBCEStocks(HashMap<StockSymbol, GBCEStock> sampleData) {

	List<GBCEStock> allStocks = new ArrayList<GBCEStock>();

	for (Map.Entry<StockSymbol, GBCEStock> entry : sampleData.entrySet()) {
	    allStocks.add(entry.getValue());
	}
	return allStocks;
    }
}