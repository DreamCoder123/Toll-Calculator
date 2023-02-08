import java.util.HashMap;
import java.util.Map;

public class TollChargesChart {
    public static Map<String,Integer> vehiclesDetails(){

        Map<String,Integer>vehiclesDetails = new HashMap<>();
        vehiclesDetails.put("TRUCK",200);
        vehiclesDetails.put("BUS",200);
        vehiclesDetails.put("VAN",100);
        vehiclesDetails.put("CAR",100);
        vehiclesDetails.put("RICKSHAW",100);
        vehiclesDetails.put("SCOOTER",50);
        vehiclesDetails.put("MOTORBIKE",50);
        return vehiclesDetails;

    }
}
