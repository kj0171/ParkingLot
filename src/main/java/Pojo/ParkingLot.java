package Pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ParkingLot {

    private int numberOfSlot;
    private PriorityQueue<Integer> parkingSlotQueue;
    private Map<Integer, Boolean> slotOccupied;
    private Map<Integer,Vehicle> slotToVehicleMap;
    private Map<String,Integer> registrationNumberToSlotMap;

    //Default Constructor
    public ParkingLot(){

    }

    //Parameterized Constructor
    public ParkingLot(int numberOfSlot){
        this.numberOfSlot = numberOfSlot;
        this.parkingSlotQueue = new PriorityQueue<Integer>();
        this.slotOccupied = new HashMap<Integer, Boolean>();
        this.slotToVehicleMap = new HashMap<Integer, Vehicle>();
        this.registrationNumberToSlotMap = new HashMap<String, Integer>();
        for (int i=1 ; i<=numberOfSlot ; i++){
            parkingSlotQueue.add(i);
            slotOccupied.put(i,false);
        }
    }

    //Getters
    public int getNumberOfSlot() {
        return numberOfSlot;
    }

    public PriorityQueue<Integer> getParkingSlotQueue() {
        return parkingSlotQueue;
    }

    public Map<Integer, Boolean> getSlotOccupied() {
        return slotOccupied;
    }

    public Map<Integer, Vehicle> getSlotToVehicleMap() {
        return slotToVehicleMap;
    }

    public Map<String, Integer> getRegistrationNumberToSlotMap() {
        return registrationNumberToSlotMap;
    }
}
