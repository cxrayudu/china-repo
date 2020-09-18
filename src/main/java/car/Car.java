package main.java.car;



public class Car {

	//private String make;
	//private String model;
	private String carType;
	private String registerNumber;
	private int deposit;
	private int price;

	enum CarType 
	{ 
	    SEDAN, SUV, VAN; 
	} 
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
