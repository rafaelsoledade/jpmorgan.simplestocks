package main.java.com.jpmorgan.simplestocks.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.jpmorgan.simplestocks.enums.StockSymbol;
import main.java.com.jpmorgan.simplestocks.model.GBCEStock;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class responsible for generating test data from a json array
 * 
 * @author rafaelmatos
 * 
 */
public class GBCEStockSampleDataGenerator {

    /**
     * This method will generate a HashMap with all the test data, as follows:
     * key - the stock symbol value - the GBCE stock
     * 
     * @param gbceStock
     *            the current stock being evaluated
     * @return the hashmap that contains all the sample data used for testing
     * 
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     * @throws ParseException
     */
    public static HashMap<StockSymbol, GBCEStock> generateSampleDataMap() throws JsonParseException, JsonMappingException, IOException, ParseException {

	return sampleDataMap(jsonArrayToList());
    }

    /**
     * Auxiliary method responsible for generating a HashMap given a stocks list
     * 
     * @param sampleDataList
     * @return the hashmap representation of the sample data list
     */
    private static HashMap<StockSymbol, GBCEStock> sampleDataMap(List<GBCEStock> sampleDataList) {

	HashMap<StockSymbol, GBCEStock> sampleDataMap = new HashMap<StockSymbol, GBCEStock>();
	GBCEStock sampleStockData = null;

	/*
	 * Putting all sample data into a hashmap with the purpose of
	 * simplifying the stock search process
	 */
	for (GBCEStock currStock : sampleDataList) {
	    sampleStockData = new GBCEStock(currStock.getStockSymbol(), currStock.getStockType(), currStock.getLastDividend(), currStock.getFixedDividend(), currStock.getParValue());
	    sampleDataMap.put(currStock.getStockSymbol(), sampleStockData);
	}
	return sampleDataMap;
    }

    /**
     * Auxiliary method responsible for reading sample data from an JSON array
     * to a java list
     * 
     * @return list with all the sample data
     * @throws IOException
     * @throws ParseException
     */
    private static List<GBCEStock> jsonArrayToList() throws IOException, ParseException {
	/* Get file from resources folder */
	JSONParser parser = new JSONParser();
	FileReader fileReader = null;
	fileReader = new FileReader("src/main/resources/sampleData.json");
	JSONArray jsonString;
	jsonString = (JSONArray) parser.parse(fileReader);

	/* Reading from JSON array to java list using Jackson library */
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);

	return objectMapper.readValue(jsonString.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, GBCEStock.class));
    }

    public static List<GBCEStock> allGBCEStocksList(HashMap<StockSymbol, GBCEStock> sampleData) {

	List<GBCEStock> allStocks = new ArrayList<GBCEStock>();

	for (Map.Entry<StockSymbol, GBCEStock> entry : sampleData.entrySet()) {
	    allStocks.add(entry.getValue());
	}
	return allStocks;
    }
    
}
