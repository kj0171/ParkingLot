package Service;

import Pojo.ParkingLot;
import Pojo.ParkingSpot;
import Pojo.Vehicle;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ParkingLotServiceTest {

    private Vehicle vehicle1 = new Vehicle("MH14-DW-3493","white");
    private Vehicle vehicle2 = new Vehicle("MH14-DW-3494","black");
    private Vehicle vehicle3 = new Vehicle("MH14-DW-3495","red");
    private Vehicle vehicle4 = new Vehicle("MH14-DW-3496","red");
    private Vehicle copyVehicle1 = vehicle1;

    private ParkingLot parkingLot1 = new ParkingLot(1);
    private ParkingLot parkingLot2 = new ParkingLot(3);
    private ParkingLot parkingLot3 = new ParkingLot(4);

    private IParkingLotService parkingLotService = new ParkingLotService();


    @Test
    //No Parking After Parking Slot
    public void parkingSlotFullTest() {
        int slot = parkingLotService.parkVehicle(parkingLot1,vehicle1);
        assertEquals(slot,1);
        slot = parkingLotService.parkVehicle(parkingLot1,vehicle2);
        assertEquals(slot,-1);
    }

    @Test
    //Duplicate Car Parking
    public void duplicateCarParkingTest(){
        parkingLotService.parkVehicle(parkingLot2,vehicle1);
        int slot = parkingLotService.parkVehicle(parkingLot2,copyVehicle1);
        assertEquals(slot,-2);
    }

    @Test
    //Leave Car Failure Cases ( Slot Already Empty && Slot > Total Number Of Slots Available)
    public void leaveCarFailureTest(){
        parkingLotService.parkVehicle(parkingLot1,vehicle1);
        assertTrue(parkingLotService.leaveVehicle(parkingLot1,1));
        assertFalse(parkingLotService.leaveVehicle(parkingLot1,1));
        assertFalse(parkingLotService.leaveVehicle(parkingLot1, 4));
    }

    @Test
    //Correct Slot Occupied After Certain Spot is Empty
    public void correctSlotTest(){
        int slot;
        slot = parkingLotService.parkVehicle(parkingLot2,vehicle1);
        assertEquals(slot,1);
        slot=parkingLotService.parkVehicle(parkingLot2,vehicle2);
        assertEquals(slot,2);
        slot=parkingLotService.parkVehicle(parkingLot2,vehicle3);
        assertEquals(slot,3);
        // 1 , 2 , 3
        assertTrue(parkingLotService.leaveVehicle(parkingLot2,2));
        // 1,_ ,3
        assertTrue(parkingLotService.leaveVehicle(parkingLot2,3));
        // 1 , _ , _
        slot = parkingLotService.parkVehicle(parkingLot2,vehicle3);
        // 1 , 2 , _
        assertEquals(2,slot);
        assertTrue(parkingLotService.leaveVehicle(parkingLot2,1));
        // _ , 2 , _
        slot = parkingLotService.parkVehicle(parkingLot2,vehicle2);
        // 1 , 2 , _
        assertEquals(slot,1);
    }

    @Test
    //Color -> RegNo,Slot
    public void colorToRegNumberTest(){
        parkingLotService.parkVehicle(parkingLot3,vehicle1);
        parkingLotService.parkVehicle(parkingLot3,vehicle2);
        parkingLotService.parkVehicle(parkingLot3,vehicle3);
        parkingLotService.parkVehicle(parkingLot3,vehicle4);

        List<ParkingSpot> parkingSpotList = parkingLotService.fetchParkingSpotBasedOnColor(parkingLot3,"blue");
        assertTrue(parkingSpotList.isEmpty());

        parkingSpotList = parkingLotService.fetchParkingSpotBasedOnColor(parkingLot3,"red");
        assertEquals(parkingSpotList.size(),2);
        assertEquals(parkingSpotList.get(0).getRegistrationNumber(),"MH14-DW-3495");
        assertEquals(parkingSpotList.get(1).getRegistrationNumber(),"MH14-DW-3496");
        assertEquals(parkingSpotList.get(0).getSlot(),3);
        assertEquals(parkingSpotList.get(1).getSlot(),4);
    }

    @Test
    //Reg_No -> Slot
    public void registrationNumberToSlotTest(){
        parkingLotService.parkVehicle(parkingLot3,vehicle1);
        parkingLotService.parkVehicle(parkingLot3,vehicle2);
        parkingLotService.parkVehicle(parkingLot3,vehicle3);
        parkingLotService.parkVehicle(parkingLot3,vehicle4);

        int slot = parkingLotService.fetchSlotBasedOnRegistrationNumber(parkingLot3,"ABC");
        assertEquals(slot,-1);
        slot = parkingLotService.fetchSlotBasedOnRegistrationNumber(parkingLot3,"MH14-DW-3494");
        assertEquals(slot,2);
        slot = parkingLotService.fetchSlotBasedOnRegistrationNumber(parkingLot3,"MH14-DW-3495");
        assertEquals(slot,3);
        parkingLotService.leaveVehicle(parkingLot3,3);
        slot = parkingLotService.fetchSlotBasedOnRegistrationNumber(parkingLot3,"MH14-DW-3495");
        assertEquals(slot,-1);
    }


}




