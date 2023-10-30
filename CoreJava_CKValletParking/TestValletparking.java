package CKValletParking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/*
 * EPIK VALET PARKING

Instructions:
You have one hour to finish this assignment.
You can use any editor to write the program.
You have to submit the .java file to us within the time span.
Please name the file that you are going to submit as follows:
<first name>_<last name>.java
eg:-John_Doe.java


Write a JAVA program to perform all the given functionalities along with possible validations.

checkIn() function takes 
1-vehicle no.
2-vehicle type
3-vehicle model
4-phone no.
5-customer name
6-check in time
as input when customer checks in.

In displayValetParkingList() function displays the details of vehicle like
1-vehicle no.
2-vehicle type
3-vehicle model
4-phone no.
5-customer name
6-check in time
7-check out time

In searchForVehicle() function displays the vehicle details
by vehicle number

In checkOut() function calculate the total amount to be paid. 
-Charge Rs.10 for time between 0-30 mins, and post that charge Rs. 10 for every 30 minutes. 
(For example a person woud pay Rs.10 for 20 minutes, For 31 minutes he would pay Rs.20 i.e. Rs10 for first 30 minutes and Rs.10 for next 30 minutes)

-Display the total amount to be paid, vehicle details and total duration to the customer

 */
public class TestValletparking {
	static ValletParking vp = new ValletParking();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		selectOption();
		sc.close();
	}

	public static void selectOption() {
		System.out
				.println("Welcome to Ck Vallet Parking Application\n=================================================");
		boolean flag = true;
		while (flag) {
			System.out.println("Select the Option\n=============================\n" + "1) Add Check-in \n"
					+ "2) Display all the vehicle details \n" + "3) Search Vehicle by Vehicle number \n"
					+ "4) Check-out \n" + "5) Generate the Bill \n" + "6) Exit \n");
			try {
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					updatecheckIn();
					break;
				case 2:
					vp.displayValletParkingList();
					break;
				case 3:
					SearchByVehicleNumber();
					break;
				case 4:
					checkOut();
					break;
				case 5:
					generateBill();
					break;
				case 6:
					flag = false;
					break;
				default:
					System.out.println("Invalid choice");
				}
			} catch (Exception e) {
				System.err.println("Invalid Input...!");
				sc.nextLine();
			}

		}
		System.out.println("Thank you for visiting. Visit again...\n==============================================");
	}

	public static void updatecheckIn() {
		System.out.println("Enter the Customer name");
		String name = sc.nextLine();
		System.out.println("Enter the Customer Number");
		String phone = sc.nextLine();
		System.out.println("Enter the Vehicle number");
		int vehicleNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Vehicle Type");
		String vehicleType = sc.nextLine();
		System.out.println("Enter the Vehicle model");
		String vehicleModle = sc.nextLine();
		vp.checkIn(new CheckIn(LocalDate.now(), LocalTime.now().withNano(0), null,
				new Customer(name, phone, new Vehicle(vehicleNumber, vehicleType, vehicleModle))));
	}

	public static void SearchByVehicleNumber() {
		System.out.println("Enter the Vehicle number");
		int vehicleNumber = sc.nextInt();
		vp.SearchByVehicleNumber(vehicleNumber);

	}

	public static void checkOut() {
		System.out.println("Enter the Vehicle number");
		int vehicleNumber = sc.nextInt();
		vp.checkOut(vehicleNumber, LocalTime.now().withNano(0));

	}

	public static void generateBill() {
		System.out.println("Enter the Vehicle number");
		int vehicleNumber = sc.nextInt();
		vp.getBill(vehicleNumber);

	}

}
