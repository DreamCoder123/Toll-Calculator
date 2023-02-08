
import java.util.Map;
import java.util.List;

public class CalculateTollCharges {
    public static void calculateToll(List<String> vehiclesList, Map<String,Integer> fastagBalance, List<String> vehiclesNumberList) {

        Map<String,Integer> map_vehicle_no = Geektrust.vehicleNumber(vehiclesNumberList);
        Map<String,Integer> vehicle_details = TollChargesChart.vehiclesDetails();

        int flatFees = 40;
        int index = 0;

        for(Map.Entry<String, Integer> i: map_vehicle_no.entrySet()) {

            int crosses_vehicle = i.getValue();
            if(crosses_vehicle%2 == 0) {

                int vehicleToll = vehicle_details.get(vehiclesList.get(index));
                int fullPrice = (crosses_vehicle/2*vehicleToll);
                int discountedPrice = (crosses_vehicle/2*(vehicleToll/2));
                Geektrust.total_discount+= discountedPrice;
                Geektrust.tollPerVehicles(vehiclesList.get(index),fullPrice+discountedPrice);
                Geektrust.updatingValue(fastagBalance,fullPrice, discountedPrice, crosses_vehicle,flatFees,
                        vehiclesList, index,i,vehicle_details );
            }else {

                int vehicleToll = vehicle_details.get(vehiclesList.get(index));
                int discountedPrice = (((int)(crosses_vehicle/2))*(vehicleToll/2));
                int final_price = (((int)(crosses_vehicle/2)+1)*vehicleToll);
                Geektrust.total_discount+= discountedPrice;
                Geektrust.tollPerVehicles(vehiclesList.get(index),final_price+discountedPrice);
                Geektrust.updatingValue(fastagBalance,final_price, discountedPrice, crosses_vehicle,flatFees,
                        vehiclesList, index,i,vehicle_details );
            }
            index++;
        }
    }
}
