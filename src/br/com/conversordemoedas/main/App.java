package br.com.conversordemoedas.main;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import br.com.conversordemoedas.OpenExchangeRatesAPI;
public class App{
	public static void main(String[] args) {

		Object[] possibleValues = { "Conversosr de moedas", "Conversor de temperatura" };
		Object selectedValue = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE,
				null, possibleValues, possibleValues[0]);

		if (selectedValue.equals("Conversosr de moedas")) {
			var inputValue = JOptionPane.showInputDialog("Please input a value");
			while (!validatesCurrency(inputValue)) {
				inputValue = JOptionPane.showInputDialog("Please input a valid value");
			}
			Object[] possibleCurrencies = { "AED" , "AFN" , "ALL" , "AMD" , "ANG" , "AOA"
					, "ARS" , "AUD" , "AWG" , "AZN" , "BAM" , "BB," , "BDT" , "BGN"
					, "BHD" , "BIF" , "BMD" , "BND" , "BOB" , "BRL" , "BSD" , "BTN"
					, "BWP" , "BYR" , "BZD" , "CAD" , "CDF" , "CHF" , "CKD" , "CLP"
					, "CNY" , "COP" , "CRC" , "CUP" , "CVE" , "CZK" , "DJF" , "DKK"
					, "DOP" , "DZD" , "EGP" , "ERN" , "ETB" , "FJD" , "FKP" , "FOK"
					, "GBP" , "GEL" , "GGP" , "GHS" , "GIP" , "GMD" , "GNF" , "GTQ"
					, "GYD" , "HKD" , "HNL" , "HTG" , "HUF" , "IDR" , "ILS" , "IMP"
					, "INR" , "IQD" , "IRR" , "ISK" , "JEP" , "JMD" , "JOD" , "JPY"
					, "KES" , "KGS" , "KHR" , "KID" , "KMF" , "KPW" , "KRW" , "KWD"
					, "KYD" , "KZT" , "LAK" , "LBP" , "LKR" , "LRD" , "LSL" , "LYD"
					, "MAD" , "MDL" , "MGA" , "MKD" , "MMK" , "MNT" , "MOP" , "MRO"
					, "MUR" , "MVR" , "MWK" , "MXN" , "MYR" , "MZN" , "NAD" , "NGN"
					, "NIO" , "NOK" , "NPR" , "NZD" , "OMR" , "PAB" , "PEN" , "PGK"
					, "PHP" , "PKR" , "PLN" , "PYG" , "QAR" , "RON" , "RSD" , "RUB"
					, "RWF" , "SAR" , "SBD" , "SCR" , "SDG" , "SEK" , "SGD" , "SHP"
					, "SLL" , "SOS" , "SRD" , "SSP" , "STD" , "SYP" , "SZL" , "THB"
					, "TJS" , "TMT" , "TND" , "TOP" , "TRY" , "TTD" , "TVD" , "TWD"
					, "TZS" , "UAH" , "UGX" , "USD" , "UYU" , "UZS" , "VND" , "VUV"
					, "WST" , "XAF" , "XCD" , "XOF" , "XPF" , "YER" , "ZAR" , "ZMW"
					, "ZWL" };
			Object selectedCurrency = JOptionPane.showInputDialog(null, "Choose one", "Input",
					JOptionPane.INFORMATION_MESSAGE, null, possibleCurrencies, possibleCurrencies[0]);
			System.out.println(currencyConvertes((String) selectedCurrency, (String) inputValue));
		}

	}

	public static boolean validatesCurrency(String currency) {
		currency.replaceAll("[^[+-]?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?]", "");
		if (!(currency.matches("[+-]?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?"))) {
			return false;
		}
		return true;
	}
	
	public static String currencyConvertes(String selectedCurrency, String inputValue) {
		OpenExchangeRatesAPI exchange = new OpenExchangeRatesAPI(selectedCurrency);
		
		return new BigDecimal(exchange.getRate()).toString();
//		BigDecimal targetCurrancy = new BigDecimal(selectedCurrency);
//		String result = exchangeRate.multiply(targetCurrancy).toString();
//		return result;
	}
}