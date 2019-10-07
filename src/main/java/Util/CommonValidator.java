package Util;

import Pojo.ParkingLot;

public class CommonValidator {

    public static void checkParkingLotCreation(ParkingLot parkingLot) throws Exception {

        if(parkingLot==null){
            throw new Exception("Parking Lot Not Created");
        }
    }
}
