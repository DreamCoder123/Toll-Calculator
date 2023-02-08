import java.util.List;

public class Print {
    public static void collectionsSummary(List<String> vehiclesList) {

        System.out.println("TOTAL_COLLECTION "+ Geektrust.total_toll+" "+ Geektrust.total_discount);
        System.out.println("PAYMENT_SUMMARY "+ Geektrust.total_fastag_amount+" "+ Geektrust.total_cash_amount);
        System.out.println("VEHICLE_TYPE_SUMMARY");
        String vehicleCount = Geektrust.numberOfVehicle(vehiclesList);
        System.out.println(vehicleCount);
    }
}
