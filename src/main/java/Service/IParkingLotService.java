package Service;

import Pojo.ParkingLot;
import Pojo.ParkingSpot;
import Pojo.Vehicle;

import java.util.List;

public interface IParkingLotService {

    /*
     @Params - ParkingLot , Vehicle
     @Returns  -1, Slot Full
               -2, Duplicate Entry
               slotNumber , slotNumber to be parked
     */
    Integer parkVehicle(ParkingLot parkingLot, Vehicle vehicle);


    /*
    @Param - ParkingLot , slot
    @Returns - true , Vehicle Successfull Removed
               false , Slot Already Empty , Slot > numberOfParkingSlots
     */
    Boolean leaveVehicle(ParkingLot parkingLot, int slot);


    /*
    @Param - ParkingLot
    @Returns - List<ParkingSpot> , ParkingSpots where cars are parked
     */
    List<ParkingSpot> displayParkingLot(ParkingLot parkingLot);


    /*
    @Param - ParkingLot , color
    @Returns - List<ParkingSpot> , ParkingSpots Where cars are parked and color is same as requested of the car parked
     */
    List<ParkingSpot> fetchParkingSpotBasedOnColor(ParkingLot parkingLot, String color);


    /*
    @Param - ParkingLot , RegistrationNumber
    @Returns -1 , No registrationNumber Found
             slot , RegistrationNumber Linked To Which Slot
     */
    Integer fetchSlotBasedOnRegistrationNumber(ParkingLot parkingLot,String registrationNumber);
}
