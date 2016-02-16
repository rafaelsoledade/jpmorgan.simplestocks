package test.java.com.jpmorgan.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import main.java.com.jpmorgan.simplestocks.enums.StockSymbol;
import main.java.com.jpmorgan.simplestocks.enums.TradeIndicator;
import main.java.com.jpmorgan.simplestocks.model.GBCEStock;
import main.java.com.jpmorgan.simplestocks.supportedOperations.impl.GBCEStockOperations;
import main.java.com.jpmorgan.simplestocks.utils.DateHelper;
import main.java.com.jpmorgan.simplestocks.utils.GBCEStockSampleDataGenerator;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class SimpleStocksUnitaryTests {

    @Test
    public void testDividendYield() throws JsonParseException, JsonMappingException, IOException, ParseException {
	HashMap<StockSymbol, GBCEStock> testEntries = GBCEStockSampleDataGenerator.generateSampleDataMap();
	GBCEStockOperations stockCalculator = new GBCEStockOperations();
	
	GBCEStock stock = testEntries.get(StockSymbol.ALE);
	double dividendYield = stockCalculator.calculateDividendYield(stock, 25.0);
	assertEquals(0.92, dividendYield);
    }
    
    @Test
    public void testPERatio() throws JsonParseException, JsonMappingException, IOException, ParseException {
	HashMap<StockSymbol, GBCEStock> testEntries = GBCEStockSampleDataGenerator.generateSampleDataMap();
	GBCEStockOperations stockCalculator = new GBCEStockOperations();
	
	GBCEStock stock = testEntries.get(StockSymbol.POP);
	double peRatio = stockCalculator.calculatePeRatio(stock, 1.35);
	assertEquals(0.169, peRatio);
    }
    
    @Test
    public void testVolumeWeightedStockPrice() throws JsonParseException, JsonMappingException, IOException, ParseException {

	HashMap<StockSymbol, GBCEStock> testEntries = GBCEStockSampleDataGenerator.generateSampleDataMap();
	GBCEStockOperations stockCalculator = new GBCEStockOperations();
	
	GBCEStock stock = testEntries.get(StockSymbol.ALE);
	stockCalculator.recordTrade(stock, 50, TradeIndicator.SELL, 15.0);
	
	double volumeWeightedStockPrice = stockCalculator.calculateVolumeWeightedStockPrice(stock, 15);
	assertEquals(15.0, volumeWeightedStockPrice);
	
	stockCalculator.recordTrade(stock, 10, TradeIndicator.BUY, 10.5);
	volumeWeightedStockPrice = stockCalculator.calculateVolumeWeightedStockPrice(stock, 5);
	assertEquals(14.25, volumeWeightedStockPrice);
    }    
    
    @Test
    public void testGBCEAllShareIndex() throws JsonParseException, JsonMappingException, IOException, ParseException {

	HashMap<StockSymbol, GBCEStock> testEntries = GBCEStockSampleDataGenerator.generateSampleDataMap();
	List<GBCEStock> testEntriesList = GBCEStockSampleDataGenerator.allGBCEStocksList(testEntries);

	GBCEStockOperations stockCalculator = new GBCEStockOperations();
	double gbceAllShareIndex = stockCalculator.calculateGBCEAllShareIndex(testEntriesList);

	assertEquals(0.0, gbceAllShareIndex);
	
	for(GBCEStock currStock : testEntriesList) {
	    currStock.setMarketPrice(15.35);
	}
	gbceAllShareIndex = stockCalculator.calculateGBCEAllShareIndex(testEntriesList);
	assertEquals(15.35, gbceAllShareIndex);
    }

    @Test
    public void testDateIsWithinSpan() {
	
	int timeSpan = 15; // in minutes
	
	Calendar currentDate = Calendar.getInstance();

	Calendar targetDate = Calendar.getInstance();
	targetDate.setTimeInMillis(currentDate.getTimeInMillis());
	targetDate.add(Calendar.MINUTE, timeSpan);
	
	assertEquals(DateHelper.isTradeProcessedWithinTimeSpan(targetDate.getTime(), 10), true);
	
    }

    @Test
    public void testDateIsNotWithinSpan() {
	
	int timeSpan = 15; // in minutes
	
	Calendar currentDate = Calendar.getInstance();

	Calendar targetDate = Calendar.getInstance();
	targetDate.setTimeInMillis(currentDate.getTimeInMillis());
	targetDate.add(Calendar.MINUTE, -timeSpan); // n minutes into the future 
	
	assertEquals(DateHelper.isTradeProcessedWithinTimeSpan(targetDate.getTime(), 10), false);
	
    }
}
