package entities;

public class Individual extends TaxPayer{
	
	private Double healthExpenditures;
	
	public Individual() {
		super();
	}
	
	public Individual(String name, Double anuallIncome, Double helathExpenditures) {
		super(name, anuallIncome);
		this.healthExpenditures = helathExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double helathExpenditures) {
		this.healthExpenditures = helathExpenditures;
	}

	@Override
	public Double tax() {
		Double resp;
		if (getAnualIncome() <= 20000.00) {
			if (healthExpenditures < 0) {
				resp = getAnualIncome() * 0.15;
			}
			else {
				resp = getAnualIncome() * 0.15 - (healthExpenditures / 2);
			}
		}
		else {
			if (healthExpenditures < 0) {
				resp = getAnualIncome() * 0.25;
			}
			else {
				resp = getAnualIncome() * 0.25 - (healthExpenditures / 2);
			}
		}
		return resp;
	}
}
