package br.com.alura.challenges.oracle_one_backend.conversordemoedas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {
    public double getRates(String coin) {
        String apiKey = "95f050d224e646fc8d431d199bb37d65";
        String apiUrl = "https://openexchangerates.org/api/latest.json?app_id=" + apiKey;
        
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            
            reader.close();
            
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject rates = jsonResponse.getJSONObject("rates");
            
            return rates.getDouble(coin);         
            
            // Use as taxas obtidas para realizar conversões
        } catch (Exception e) {
            e.printStackTrace();
        }
		return 0;
        
    }
}