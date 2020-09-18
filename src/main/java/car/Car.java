package main.java.car;


// Car class to hold the cartype and reg Number, depoisit and price per day
public class Car {

	private String carType;
	private String registerNumber;
	private int deposit;
	private int price;

	// Enum Can be used to get the cartype. Could be used in future if required. 
	// Right now not used for now
	enum CarType 
	{ 
	    SEDAN, SUV, VAN; 
	} 
	// Comstructor to initialise the attributes
	public Car(String carTypeParam, String registerNumberParam,
			int depositParam, int priceParam) {
		carType = carTypeParam;
		registerNumber = registerNumberParam;
		deposit = depositParam;
		price = priceParam;
	}

	public String getCarType() {
		return carType;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public int getDeposit() {
		return deposit;
	}

	public int getPrice() {
		return price;
	}

	

}
