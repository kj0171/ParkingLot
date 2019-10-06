package Pojo;

public class ParkingSpot extends Vehicle {

    private int slot;

    public ParkingSpot(int slot,String registrationNumber,String color){
        super(registrationNumber,color);
        this.slot = slot;
    }

    public int getSlot() {
        return slot;
    }
}
