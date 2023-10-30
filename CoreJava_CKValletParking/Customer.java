package CKValletParking;

public class Customer {
	private String customerName;
	private String phone;
	private Vehicle vehicle;

	public Customer(String customerName, String phone, Vehicle vehicle) {
		this.customerName = customerName;
		this.phone = phone;
		this.vehicle = vehicle;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String toString() {
		vehicle.toString() ;
		System.out.println("Customer name   :: "+ customerName);
		System.out.println("Customer phone  :: "+ phone);
		return "" ;
	}
}
