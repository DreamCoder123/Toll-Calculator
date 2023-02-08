import java.util.Map;

public class VehiclesHavingFastag {
    public static int vehiclesHavingFastag(String vehicles, int fastag_balance, Map<String,Integer> vehiclesInfo) {

        int Vehicle_toll = vehiclesInfo.get(vehicles);
        int vehicle_count = 0;
        int odd_even = 0;
        if(Vehicle_toll>fastag_balance) {
            return 0;
        }else {
            while( odd_even%2==1 || Vehicle_toll<=fastag_balance) {
                if(Vehicle_toll/2<=fastag_balance) {

                    fastag_balance -= Vehicle_toll/2;
                    vehicle_count++;
                }else if(odd_even%2 == 0) {

                    fastag_balance -= Vehicle_toll;
                    vehicle_count++;

                }
                odd_even++;
            }
        }
        return vehicle_count;
    }
}
