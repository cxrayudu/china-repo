package main.java.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author China Rayudu
 * Assumed positive test cases for testing purposes, So Please test with correct data
 * This Class for booking the reservation for a customer
 * This class Uses Car class and Auxiliary class
 */
/**
 * @author China Rayudu
 *
 */
public class BookCar {

	static boolean firstFlag = true;
	static {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Car> availableCars = new ArrayList<Car>();
		availableCars.add(new Car("Sedan", "S123456", 300, 30));
		availableCars.add(new Car("SUV", "Suv5432", 500, 50));
		availableCars.add(new Car("Van", "Van7654", 600, 60));
		
		Scanner input = new Scanner(System.in);
		
		Car selectedCar = null;
		boolean isCarTypeAvailable = false;
		System.out.print("Enter Type of Car to rent(Sedan/SUV/Van) : ");
		String carType = input.nextLine();
		
		Auxiliary aux = getSelectedCar(carType, availableCars);
		selectedCar = aux.getCar();
		isCarTypeAvailable = aux.isAvailable();
		firstFlag = false;
		//for (Car s : availableCars) {
		if (isCarTypeAvailable) {
			ContinueBooking(input, carType, selectedCar, availableCars);
		}else {
			System.out.println("CarTye not available: ");
			System.out.println(" Do you change the Car Type ? (Y/N) :");
			String yesNo = input.nextLine();
			if(yesNo.equalsIgnoreCase("Y")) {
				firstFlag = true;
				ContinueBooking(input, carType, selectedCar, availableCars);
			}else {
				System.out.println("Servicing Next available Customer: ");
				firstFlag = true;
				ContinueBooking(input, carType, selectedCar, availableCars);
			}
		}
			
	}

	/**
	 * @param input
	 * @param carType
	 * @param selectedCar
	 */
	 static void ContinueBooking(Scanner input, String carType, Car selectedCar, List<Car> availableCars) {
		//This block executes first time only
		 boolean isCarTypeAvailable = false;
		if(firstFlag) {
		    input = new Scanner(System.in);
			System.out.print("Enter Type of Car to rent(Sedan/SUV/Van) : ");
			carType = input.nextLine();
			Auxiliary aux = getSelectedCar(carType, availableCars);
			selectedCar = aux.getCar();
			isCarTypeAvailable = aux.isAvailable();
		}
		System.out.println("Car Type " + carType + " is available");
		System.out.print("Enter number of days: ");
		int days = 0;
		try {
		  days = input.nextInt();
		}catch(Exception e) {
			System.out.println(" Days shoukd be a number");
			System.out.print("Enter number of days: ");
			days = input.nextInt();
		}
	
		System.out.println("***************Details*****************");
		int cost = (days * selectedCar.getPrice()) + selectedCar.getDeposit();
		System.out.println("Deposit  DailyRate  Duration  TotalCost");
		System.out.println(selectedCar.getDeposit() + "       " + selectedCar.getPrice()+ "            " + days + "        " + cost);
		System.out.print("Proceed to rent?( Yes / No ): ");
		String dec = input.next();
		if (dec.equalsIgnoreCase("Yes") || dec.equalsIgnoreCase("Y")) {
			System.out.println("Enter Customer Name: ");
			String name = input.next();
			System.out.println("Enter Licence Number: ");
			String licemcenum = input.next();
				System.out.println("************Customer Receipt*************");
			System.out.println("Name   LIC-NO   CarRegNo    Duration   TCost");
			System.out.println(name + "   " + licemcenum + "   " + carType
			+ "   " + selectedCar.getRegisterNumber() + "   " + days + "   "+cost);
			System.out.println("Servicing Next available Customer: ");
			firstFlag = true;
			ContinueBooking(input, null, selectedCar, availableCars);
		} else if (dec.equals("No")) {
			System.out.println("Servicing Next available Customer: ");
			firstFlag = true;
			ContinueBooking(input, null, selectedCar, availableCars);
		}
	
	}
	// Returns Auxiliary wrapper class
	// private method to get the Car of selected car type and availability wrapper class
	private static  Auxiliary getSelectedCar(String carType, List<Car> availableCars){
		
		Car selectedCar = null;
		boolean isCarTypeAvailable = false;
		for (Car s : availableCars) {
			if (carType.equalsIgnoreCase(s.getCarType())) {
				isCarTypeAvailable = true;
				selectedCar = s;
			}
		}
		Auxiliary aux = new Auxiliary();
		aux.setCar(selectedCar);
		aux.setAvailable(isCarTypeAvailable);
		return aux;
	}

}

//This Class is a wrapper class for two attributes , car and isavilablecar Attributes
class Auxiliary{
	
	private Car car;
	private boolean isAvailable;
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
}
