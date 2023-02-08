public class VehiclesTollCharges {
    private String vehicle;
    private int total_amount;


    public VehiclesTollCharges(String string, int i) {
        // TODO Auto-generated constructor stub
        this.vehicle = string;
        this.total_amount = i;
    }

    public String getVehicle() {
        return vehicle;
    }
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getTotalAmount() {
        return total_amount;
    }
    public void setTotalAmount(int totalAmount) {
        this.total_amount = totalAmount;
    }
    public VehiclesTollCharges() {
        super();
    }


    @Override
    public String toString() {
        return "VehicleAndTotalAmount [vehicle=" + vehicle + ", totalAmount=" + total_amount + "]";
    }

}
