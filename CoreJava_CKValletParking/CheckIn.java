package CKValletParking;

import java.time.LocalDate;
import java.time.LocalTime;

public class CheckIn {
	private LocalDate checkInDate ;
	private LocalTime checkIn ;
	private LocalTime checkOut ;
	private Customer customer ;
	private double totalBill ;
	private String status ;
	public CheckIn(LocalDate checkInDate, LocalTime checkIn, LocalTime checkOut, Customer customer) {
		this.checkInDate = checkInDate;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.customer = customer;
		this.status = "Not Paid" ;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDate() {
		return checkInDate;
	}
	public void setDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalTime getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalTime checkIn) {
		this.checkIn = checkIn;
	}
	public LocalTime getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalTime checkOut) {
		this.checkOut = checkOut;
	}
	public String toString() {
		customer.toString() ;
		System.out.println("Check-in date   :: " + checkInDate );
		System.out.println("Check-in Time   :: " + checkIn );
		System.out.println("Check-out Time  :: " + checkOut );
		System.out.println("Status          :: " + status );
		return "" ;
	}
}
