package CKValletParking;

public class Vehicle {
	private int vehicleNumber ;
	private String vehicleType ;
	private String vehicleModel ;
	public Vehicle(int vehicleNumber, String vehicleType, String vehicleModel) {
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.vehicleModel = vehicleModel;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	@Override
	public String toString() {
		System.out.println("Vehicle Number  :: " + vehicleNumber );
		System.out.println("Vehicle Type    :: " + vehicleType );
		System.out.println("Vehicle Model   :: " + vehicleModel );
		return "" ;
	}
	
}
