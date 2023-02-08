import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MappingVehicle {
    public static List<String> mappingVehicles(List<String> vehicleList, List<String> numberPlateList){
        Map<String,Integer> map_vehicles = Geektrust.vehicleNumber(numberPlateList);
        List<String>  list_vehicles = new ArrayList<>();

        for(Map.Entry<String, Integer> i: map_vehicles.entrySet()) {

            String plate = i.getKey();
            char vehicle = plate.charAt(0);
            switch(vehicle) {
                case 'T':
                    list_vehicles.add("TRUCK");
                    break;
                case 'B':
                    list_vehicles.add("BUS");
                    break;
                case 'V':
                    list_vehicles.add("VAN");
                    break;
                case 'C':
                    list_vehicles.add("CAR");
                    break;
                case 'R':
                    list_vehicles.add("RICKSHAW");
                    break;
                case 'S':
                    list_vehicles.add("SCOOTER");
                    break;
                case 'M':
                    list_vehicles.add("MOTORBIKE");
                    break;
            }

        }
        return list_vehicles;

    }
}
