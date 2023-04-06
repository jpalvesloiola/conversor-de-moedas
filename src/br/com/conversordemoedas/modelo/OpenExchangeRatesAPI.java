package br.com.conversordemoedas.modelo;

/*
 * To use the Open Exchange Rates API in your Java program, you will need to send an HTTP request to the API endpoint and parse the response to get the exchange rate data. Here is an example of how you can do this using the java.net package:
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenExchangeRatesAPI {
	String targetCurrency;
	
	public OpenExchangeRatesAPI(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	
	public String getRate() {
		try {
			// Set the API endpoint and parameters
			String endpoint = "https://openexchangerates.org/api/latest.json";
			String appId = "95f050d224e646fc8d431d199bb37d65";
			String baseCurrency = "USD";

			// Create the URL
			URL url = new URL(endpoint + "?app_id=" + appId + "&base=" + baseCurrency + "&symbols=" + targetCurrency);

			// Open a connection to the API
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// Read the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Parse the response to get the exchange rate
			String responseString = response.toString();
			int startIndex = responseString.indexOf(targetCurrency) + 5;
			int endIndex = responseString.indexOf("}", startIndex);
			return responseString.substring(startIndex, endIndex);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

/*
 * This code sends a GET request to the Open Exchange Rates API endpoint with
 * the necessary parameters (app ID, base currency, and target currency). The
 * API returns a JSON response containing the exchange rate data. The code then
 * parses the JSON response to extract the exchange rate and prints it to the
 * console. Make sure to replace YOUR_APP_ID with your own app ID from the Open
 * Exchange Rates API. You can also modify the baseCurrency and targetCurrency
 * variables to use different currencies.
 */