/**
 * 
 */
package main.java.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author China Rayudu
 *
 */
class BookCarTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}
	List<Car> availableCars = new ArrayList<Car>();
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		availableCars.add(new Car("Sedan", "S123456", 300, 30));
		availableCars.add(new Car("SUV", "Suv5432", 500, 50));
		availableCars.add(new Car("Van", "Van7654", 600, 60));
		
		Scanner input = new Scanner(System.in);
		
		
	}

	/**
	 * Test method for {@link main.java.car.BookCar#main(java.lang.String[])}.
	 */
	@Test
	final void testMain() {
		boolean firstFlag = true;
		String carType = "Sedan";
		Scanner input = new Scanner(System.in);
		Auxiliary aux = new Auxiliary();
		aux.setAvailable(true);
		aux.setCar(new Car("Sedan", "S123456", 300, 30));
		Car selectedCar = aux.getCar();
		
		BookCar.ContinueBooking(input, carType, selectedCar, availableCars);
	}

}
