package Service;

import Pojo.ParkingLot;
import Pojo.ParkingSpot;
import Pojo.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.TRUE;

public class ParkingLotService implements IParkingLotService {

    //Park Vehicle
    @Override
    public Integer parkVehicle(ParkingLot parkingLot, Vehicle vehicle) {

        //Check Space Available
        if(parkingLot.getParkingSlotQueue().isEmpty())
            return -1;

        //Check For Duplicate
        if(parkingLot.getRegistrationNumberToSlotMap().get(vehicle.getRegistrationNumber())!=null){
            return -2;
        }

        //Give Lot And Update Parking Lot
        int slot = parkingLot.getParkingSlotQueue().poll();
        updateParkingLotOnCarAddition(parkingLot,vehicle,slot);
        return slot;
    }

    //Free Parking Spot
    @Override
    public Boolean leaveVehicle(ParkingLot parkingLot, int slot) {

        //Check slot<=sizeOfTheParkingSlot and Slot Already Free
        if(parkingLot.getNumberOfSlot()<slot || !parkingLot.getSlotOccupied().get(slot)){
            return false;
        }

        //Free Slot
        updateParkingLotOnCarDeletion(parkingLot,slot);
        return true;
    }

    //Display Parking Lot
    @Override
    public List<ParkingSpot> displayParkingLot(ParkingLot parkingLot) {

        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        ParkingSpot parkingSpot = null;
        int numberOfSpot = parkingLot.getNumberOfSlot();
        Map<Integer,Boolean> slotOccupy = parkingLot.getSlotOccupied();

        for(int i=1 ; i<=numberOfSpot ; i++){
            if(slotOccupy.get(i)){
                parkingSpotList.add(getparkingSpot(i,parkingLot.getSlotToVehicleMap().get(i)));
            }
        }

        return parkingSpotList;
    }

    //Parking Spot Based On Color
    @Override
    public List<ParkingSpot> fetchParkingSpotBasedOnColor(ParkingLot parkingLot, String color) {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        int numberOfSpot = parkingLot.getNumberOfSlot();

        for(int i=1 ; i<=numberOfSpot ; i++){
            if(parkingLot.getSlotOccupied().get(i)){
                Vehicle vehicle = parkingLot.getSlotToVehicleMap().get(i);
                if(color.equalsIgnoreCase(vehicle.getColor()))
                    parkingSpotList.add(getparkingSpot(i,vehicle));
            }
        }

        return parkingSpotList;
    }

    //Slot Based On Registration Number
    @Override
    public Integer fetchSlotBasedOnRegistrationNumber(ParkingLot parkingLot, String registrationNumber) {
        Integer slot = parkingLot.getRegistrationNumberToSlotMap().get(registrationNumber);
        return slot==null?-1:slot;
    }


    // --------------------------------> Helper Function <---------------------------------------------//

    private void updateParkingLotOnCarAddition(ParkingLot parkingLot, Vehicle vehicle , int slot) {
        parkingLot.getSlotOccupied().put(slot,TRUE);
        parkingLot.getSlotToVehicleMap().put(slot,vehicle);
        parkingLot.getRegistrationNumberToSlotMap().put(vehicle.getRegistrationNumber(),slot);
    }

    private void updateParkingLotOnCarDeletion(ParkingLot parkingLot, int slot) {
        parkingLot.getParkingSlotQueue().add(slot);
        parkingLot.getSlotOccupied().put(slot,false);
        Vehicle vehicle = parkingLot.getSlotToVehicleMap().get(slot);
        parkingLot.getSlotToVehicleMap().remove(slot);
        parkingLot.getRegistrationNumberToSlotMap().remove(vehicle.getRegistrationNumber());
    }

    private ParkingSpot getparkingSpot(int spotNumber , Vehicle vehicle){
        return new ParkingSpot(spotNumber,vehicle.getRegistrationNumber(),vehicle.getColor());
    }

}
