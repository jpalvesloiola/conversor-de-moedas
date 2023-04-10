package br.com.conversordemoedas.main;

import javax.swing.JOptionPane;

import br.com.conversordemoedas.modelo.OpenExchangeRatesAPI;
import br.com.conversordemoedas.modelo.Options;

public class App {

	public static void main(String[] args) {
		Options first = Options.FIRST;
		Options second = Options.SECOND;
		Options third = Options.THIRD;
		int option = second.ordinal();
		while (option == second.ordinal()) {
			option = first.ordinal();
			Object[] possibleValues = { "Conversosr de moedas", "Conversor de temperatura" };
			Object selectedValue = JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu",
					JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
			if (selectedValue == null) {
				option = third.ordinal();
			}
			while (option == first.ordinal()) {
				if (selectedValue.equals("Conversosr de moedas")) {
					var inputValue = JOptionPane.showInputDialog("Insira um valor:");
					if (inputValue != null) {
						while (!validatesCurrency(inputValue)) {
							JOptionPane.showMessageDialog(null, "Valor inválido!", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							inputValue = JOptionPane.showInputDialog("Insira um valor:");
						}
						Object[] possibleCurrencies = { "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN",
								"BAM", "BB,", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP",
								"BYR", "BZD", "CAD", "CDF", "CHF", "CKD", "CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK",
								"DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "FJD", "FKP", "FOK", "GBP", "GEL", "GGP",
								"GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HTG", "HUF", "IDR", "ILS", "IMP",
								"INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KID", "KMF",
								"KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL",
								"MGA", "MKD", "MMK", "MNT", "MOP", "MRO", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD",
								"NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG",
								"QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLL",
								"SOS", "SRD", "SSP", "STD", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD",
								"TVD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VND", "VUV", "WST", "XAF", "XCD",
								"XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL" };
						Object selectedCurrency = JOptionPane.showInputDialog(null, "Ecolha uma opção", "Moedas ao redor do mundo",
								JOptionPane.INFORMATION_MESSAGE, null, possibleCurrencies, possibleCurrencies[0]);
						String result = currencyConvertes((String) selectedCurrency, (String) inputValue);

						JOptionPane.showMessageDialog(null, "O valor da conversão é de $ " + result, "Resultado",
								JOptionPane.INFORMATION_MESSAGE);
						option = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Selecione uma opção",
								JOptionPane.YES_NO_CANCEL_OPTION);
						System.out.println(option);

						if (option == 1) {
							JOptionPane.showMessageDialog(null, "Programa finalizado.", "Informação",
									JOptionPane.INFORMATION_MESSAGE);
							
						} else if (option == 2) {
							JOptionPane.showMessageDialog(null, "Programa concluído.", "Informação",
									JOptionPane.INFORMATION_MESSAGE);
						} 
					}else {
						option = second.ordinal();
					}
					
				}else if (selectedValue.equals("Conversor de temperatura")) {
					JOptionPane.showMessageDialog(null, "Programa em desenvolvimento...", "Informação",
							JOptionPane.INFORMATION_MESSAGE);
					option = second.ordinal();
				}
			}

			

		}

	}

//	public static void showInputDialog(String ... outputValue ) {
//		Object[] possibleValues = { outputValue, outputValue };
//		Object selectedValue = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE,
//				null, possibleValues, possibleValues[0]);
//	}

	public static boolean validatesCurrency(String currency) {
		currency.replaceAll("[^[+-]?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?]", "");
		if (!(currency.matches("[+-]?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?"))) {
			return false;
		}
		return true;
	}

	public static String currencyConvertes(String selectedCurrency, String inputValue) {
		OpenExchangeRatesAPI exchange = new OpenExchangeRatesAPI(selectedCurrency);
		String result;

		double rate = Double.parseDouble(exchange.getRate());
		double value = Double.parseDouble(inputValue);

		result = String.valueOf(rate * value);

		return result;
	}
}