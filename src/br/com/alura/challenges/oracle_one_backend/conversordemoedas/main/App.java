package br.com.alura.challenges.oracle_one_backend.conversordemoedas.main;

import java.util.Scanner;

import br.com.alura.challenges.oracle_one_backend.conversordemoedas.CurrencyConverter;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Selecione a moeda de origem:");
		System.out.println("1 - Euro");
		System.out.println("2 - Real");
		int originCurrency = scanner.nextInt();

		double exchangeRate = 0;

		switch (originCurrency) {
		case 1: {
			CurrencyConverter converter = new CurrencyConverter();
			exchangeRate = converter.getRates("EUR");
			break;
		}
		case 2: {
			CurrencyConverter converter = new CurrencyConverter();
			converter.getRates("BRL");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + originCurrency);
		}

		System.out.print("Digite o valor: ");
		double valueIn = scanner.nextDouble();
		double valueOut = valueIn * exchangeRate;
		System.out.println("O valor em dólares é: " + valueOut);
	}
}
