import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;



public class Geektrust {

    static int total_fastag_amount;
    static int total_toll;
    static int total_cash_amount;
    static int total_discount;

    private static List<VehiclesTollCharges> vehiclesTollChargesList = new ArrayList<>();

    public static Map<String,Integer> vehicleNumber(List<String> vehicleNumberList){
        Map<String,Integer> find = new LinkedHashMap<>();
        for(String i: vehicleNumberList) {
            if(find.containsKey(i)) {
                find.put(i, find.get(i)+1);
            }else {
                find.put(i, 1);
            }
        }
        return find;
    }

    public static void tollPerVehicles(String vehicle,int toll) {
        for(VehiclesTollCharges vt : vehiclesTollChargesList) {
            if(vt.getVehicle().equals(vehicle)){
                vt.setTotalAmount(vt.getTotalAmount()+toll);
                return;
            }
        }
        vehiclesTollChargesList.add(new VehiclesTollCharges(vehicle,toll));
    }
//    public static void updateBalance(Map<String,Integer> fastag_balance,int total_amount,int discount_price,int no_of_vehicles,int flatFees,
//                                     List<String>vehiclesList,int index, Map.Entry<String, Integer> m,Map<String,Integer> vehicleDetails ) {
//        if(fastag_balance.containsKey(m.getKey())) {
//
//            if(total_amount+discount_price > fastag_balance.get(m.getKey())) {
//
//                int fastag_vehicles = VehiclesHavingFastag.vehiclesHavingFastag(vehiclesList.get(index),fastag_balance.get(m.getKey()), vehicleDetails);
//                total_fastag_amount += fastag_balance.get(m.getKey());
//                int nonfastag_vehicles =	no_of_vehicles-fastag_vehicles;
//                total_cash_amount+= nonfastag_vehicles*flatFees+(total_amount+discount_price)-fastag_balance.get(m.getKey());
//                total_toll+= total_amount+discount_price+(no_of_vehicles-fastag_vehicles)*flatFees;
//                fastag_balance.put(m.getKey(),0);
//            }else {
//
//                total_fastag_amount += total_amount+discount_price;
//                fastag_balance.put(m.getKey(), fastag_balance.get(m.getKey())-(total_amount+discount_price));
//                total_toll+= total_amount+discount_price;
//            }
//        }else {
//
//            total_cash_amount+=total_amount+discount_price+no_of_vehicles*flatFees;
//            total_toll+= total_amount+discount_price+no_of_vehicles*flatFees;
//        }
//
//    }
public static void updatingValue(Map<String,Integer> fastTagBalance,int fullPrice,int discountedPrice,int noOfVehicle,int flatFee,
                                 List<String>vehicleList,int index, Map.Entry<String, Integer> m,Map<String,Integer> vehicleDetails ) {
    if(fastTagBalance.containsKey(m.getKey())) {

        if(fullPrice+discountedPrice > fastTagBalance.get(m.getKey())) {
            // Here we are checking total price for that particular vehicle to pay the toll is greater than balance it has in there fastag.

            int passWithFastag = VehiclesHavingFastag.vehiclesHavingFastag(vehicleList.get(index),fastTagBalance.get(m.getKey()), vehicleDetails);
            // Above line will give you the total vehicle passes with fastag balance only.

            total_fastag_amount += fastTagBalance.get(m.getKey());
            // Above line will add total amount collected by the fasttag that vehicle have.

            int passWithoutFastTag =	noOfVehicle-passWithFastag;
            // Above line will give total number of vehicle need to pass without fasttag.

            total_cash_amount+= passWithoutFastTag*flatFee+(fullPrice+discountedPrice)-fastTagBalance.get(m.getKey());
            // Above line will give the total price need to pay in cash including 40 fee for cash flat fee charge.

            total_toll+= fullPrice+discountedPrice+(noOfVehicle-passWithFastag)*flatFee;
            // Above line will add the total toll in total.
            fastTagBalance.put(m.getKey(),0);
            // Above line will make the fasttag balance 0 because total price need to pay is greater than balance in fasttag.
        }else {
            // Here we our fastag balance is greater so we will pay with fastag only.
            total_fastag_amount += fullPrice+discountedPrice;
            fastTagBalance.put(m.getKey(), fastTagBalance.get(m.getKey())-(fullPrice+discountedPrice));
            // Above code is updating the fastag Balance.
            total_toll+= fullPrice+discountedPrice;
            // Above code to add all the price in total.
        }
    }else {
        // Here we don't have the fastag for this vehicle so we will pay with cash.
        total_cash_amount+=fullPrice+discountedPrice+noOfVehicle*flatFee;
        // Above line will give total amount collected with cash.
        total_toll+= fullPrice+discountedPrice+noOfVehicle*flatFee;
        // We are adding same in total.
    }

}
    public static String numberOfVehicle(List<String> vehicleList ) {

        Map<String,Integer> map = new LinkedHashMap<>();
        for(String i: vehicleList) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            }else {
                map.put(i, 1);
            }
        }
        Collections.sort(vehiclesTollChargesList,new Comparator<VehiclesTollCharges>() {
            @Override
            public int compare(VehiclesTollCharges v1 , VehiclesTollCharges v2) {
                if(v1.getTotalAmount()>v2.getTotalAmount()) {
                    return -1;
                }else if(v1.getTotalAmount()<v2.getTotalAmount()){
                    return 1;
                }else {
                    return v1.getVehicle().compareTo(v2.getVehicle());
                }
            }
        });

        String vehicleCount  = "";

        for(VehiclesTollCharges v : vehiclesTollChargesList) {
            vehicleCount += v.getVehicle()+" "+map.get(v.getVehicle())+"\n";
        }
        return vehicleCount;

    }
    public static void main(String[] args)  {
        try {
            FileInputStream fis = new FileInputStream("sample_input//input4.txt");
            Scanner sc = new Scanner(fis);

            Map<String,Integer> fastag_balance = new LinkedHashMap<>();
            List<String> vehicle_number = new ArrayList<>();
            List<String> vehicles_list = new ArrayList<>();

            while (sc.hasNextLine()) {

                String fastTag = "FASTAG";
                String nonfastag = "COLLECT_TOLL";
                String fastTagAndNonfastag = sc.next();

                if(fastTagAndNonfastag.equals(fastTag)) {
                    String vehicles_number = sc.next();
                    int fastagBalance = sc.nextInt();
                    fastag_balance.put(vehicles_number,fastagBalance);

                } else if(fastTagAndNonfastag.equals(nonfastag)) {
                    String vehicle = sc.next();
                    String numberPlate = sc.next();

                    vehicles_list.add(vehicle);
                    vehicle_number.add(numberPlate);
                }
            }
            List<String> list_vehicles =  MappingVehicle.mappingVehicles(vehicles_list,vehicle_number);

            CalculateTollCharges.calculateToll(list_vehicles,fastag_balance,vehicle_number);

            Print.collectionsSummary(vehicles_list);

            sc.close();
        } catch (IOException e) {
        }
    }
}
