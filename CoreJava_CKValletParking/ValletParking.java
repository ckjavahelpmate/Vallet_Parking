package CKValletParking;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ValletParking {
	ArrayList<CheckIn> checkins = new ArrayList<>();

	/*
	 * checkIn() function takes 1-vehicle no. 2-vehicle type 3-vehicle model 4-phone
	 * no. 5-customer name 6-check in time as input when customer checks in.
	 */
	public void checkIn(CheckIn checkIn) {
		System.out.println("*********************************************************");
		for (CheckIn checkIn1 : checkins) {
			if (checkIn1.getCustomer().getVehicle().getVehicleNumber() == checkIn.getCustomer().getVehicle()
					.getVehicleNumber() && checkIn1.getCheckOut() == null) {
				System.out.println("Vehicle Number : " + checkIn1.getCustomer().getVehicle().getVehicleNumber()
						+ " is Already checkedIn and not checked out");
				return;
			}
		}
		checkins.add(checkIn);
		System.out.println("*********************************************************");
//		System.out.printf(
//				"%-10s is Checked in at :: %5s\n",checkIn.getCustomer().getCustomerName() ,checkIn.getCheckIn());
	}

	/*
	 * In displayValetParkingList() function displays the details of vehicle like
	 * 1-vehicle no. 2-vehicle type 3-vehicle model 4-phone no. 5-customer name
	 * 6-check in time 7-check out time
	 */
	public void displayValletParkingList() {
		if (checkins.size() == 0) {
			System.out.println("*********************************************************");
			System.err.println("No check-in available");
			System.out.println("*********************************************************");
			return;
		}
		for (CheckIn checkIn : checkins) {
			System.out.println("*********************************************************");
			checkIn.toString();
			System.out.println("*********************************************************");
		}
	}

	/*
	 * In searchForVehicle() function displays the vehicle details by vehicle number
	 */
	public void SearchByVehicleNumber(int vehicleNumber) {
		if (checkins.size() == 0) {
			System.err.println("No check-in available");
		} else {
			boolean flag = true;
			for (CheckIn checkIn : checkins) {
				System.out.println("*********************************************************");
				if (checkIn.getCustomer().getVehicle().getVehicleNumber() == vehicleNumber) {
					checkIn.toString();
					System.out.println("*********************************************************");
					flag = false;
				}
			}
			if (flag) {
				System.err.println("No vehicle found with the number " + vehicleNumber);
			}
		}
	}

	/*
	 * In checkOut() function calculate the total amount to be paid. -Charge Rs.10
	 * for time between 0-30 mins, and post that charge Rs. 10 for every 30 minutes.
	 * (For example a person woud pay Rs.10 for 20 minutes, For 31 minutes he would
	 * pay Rs.20 i.e. Rs10 for first 30 minutes and Rs.10 for next 30 minutes)
	 * 
	 * -Display the total amount to be paid, vehicle details and total duration to
	 * the customer
	 */
	public void checkOut(int vehicleNumber, LocalTime localTime) {
		System.out.println("*********************************************************");
		if (checkins.size() == 0) {
			System.err.println("No check-in available");
		} else {
			boolean flag = true;
			for (CheckIn checkIn : checkins) {
				if (checkIn.getCustomer().getVehicle().getVehicleNumber() == vehicleNumber) {
					if (checkIn.getCheckOut() != null) {
						System.err.println(vehicleNumber + " is already checked out");
						return;
					} else {
						checkIn.setCheckOut(localTime);
						long mins = ChronoUnit.MINUTES.between(checkIn.getCheckIn(), checkIn.getCheckOut());
						if (mins >= 0 && mins <= 30) {
							checkIn.setTotalBill(10);
						} else {
							checkIn.setTotalBill(mins % 30 == 0 ? (mins / 30) * 10 : (mins / 30) * 10 + 10);
						}
						checkIn.toString();
						System.out.println("Toatl duration  :: " + mins + " minutes");
						System.out.println("Toatl bill      :: " + checkIn.getTotalBill() + "Rs");
						flag = false;
					}
				}
			}
			if (flag) {
				System.err.println("No vehicle found with the number " + vehicleNumber);
			}
		}
		System.out.println("*********************************************************");
	}

	/*
	 * Print Receipt
	 */
	public void getBill(int vehicleNumber) {
		System.out.println("*********************************************************");
		if (checkins.size() == 0) {
			System.err.println("No check-in available");
		} else {
			boolean flag = true;
			for (CheckIn checkIn : checkins) {
				if (checkIn.getCustomer().getVehicle().getVehicleNumber() == vehicleNumber) {
					if (checkIn.getCheckOut() == null) {
						System.err.println(vehicleNumber + " is not Checked-out. plz check-out first to generate bill");
						System.out.println("*********************************************************");
						return;
					}
					checkIn.setStatus("Paid");
					long mins = ChronoUnit.MINUTES.between(checkIn.getCheckIn(), checkIn.getCheckOut());
					if (mins >= 0 && mins <= 30) {
						checkIn.setTotalBill(10);
					} else {
						checkIn.setTotalBill(mins % 30 == 0 ? (mins / 30) * 10 : (mins / 30) * 10 + 10);
					}
					checkIn.toString();
					System.out.println("Toatl duration  :: " + mins + " minutes");
					System.out.println("Toatl bill      :: " + checkIn.getTotalBill() + "Rs");
					flag = false;
				}
			}
			if (flag) {
				System.err.println("No vehicle found with the number " + vehicleNumber);
			}
		}
		System.out.println("*********************************************************");
	}
}
