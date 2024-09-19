package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> payers = new ArrayList<>();	
		
		System.out.print("Enter the number of tax payers: ");
		int p = sc.nextInt();
		
		for(int i = 1; i <= p; i++) {
			System.out.printf("Tax Payer #%d:\n", i);
			System.out.print("Individual or Company (i/c): ");
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			Double anualIncome = sc.nextDouble();
			if (c == 'i') {
				System.out.print("Health Expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				payers.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else {
				System.out.print("Number of Employees: ");
				Integer numberOfEmployees = sc.nextInt();
				payers.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		
		System.out.println("\nTAXES PAID:\n");
		
		Double sum = 0.0;
		
		for (TaxPayer taxPayer : payers) {
			System.out.println(taxPayer.getName() + ": $" + String.format("%.2f", taxPayer.tax()));
			sum += taxPayer.tax();
		}
		
		System.out.printf("TOTAL TAXES: %.2f", sum);
		
		sc.close();
	}

}
