package Util;

import Constant.ParkingSpotConstant;
import Pojo.ParkingSpot;

import java.util.List;

public class ResponseCreator {

    //Create-Response
    public static void generateCreateResponse(int numberOfParkingSlots) {
        if(numberOfParkingSlots==0){

        }else{
            System.out.println("Created a parking lot with "+ numberOfParkingSlots+" slots");
        }
    }

    //Park-Response
    public static void generateParkResponse(int slot) {
        if(slot==-1){
            System.out.println("Sorry, parking lot is full");
        }else if(slot==-2){
            System.out.println("Duplicate parking");
        }else{
            System.out.println("Allocated slot number: "+slot);
        }
    }

    //Leave-Response
    public static void generateLeaveResponse(int slot,boolean leaveStatus) {
        if(leaveStatus){
            System.out.println("Slot number "+ slot+ " is free");
        }else{
            System.out.println("Not Able To Free Slot "+ slot);
        }
    }

    //Status Response
    public static void generateStatusResponse(List<ParkingSpot> parkingSpotList) {
        if(parkingSpotList.isEmpty()){
            System.out.println("Parking Lot Is Empty");
        }else{
            System.out.print("Slot No.\tRegistration No.\tColor\n");
            ParkingSpot parkingSpot;
            for(int i=0 ; i<parkingSpotList.size() ; i++) {
                parkingSpot = parkingSpotList.get(i);
                System.out.println(parkingSpot.getSlot() + "\t" + parkingSpot.getRegistrationNumber() + "\t" + parkingSpot.getColor());
            }
        }
    }

    //Fetch ParkingSpot Based On Color
    public static void generateResponseBasedOnColor(List<ParkingSpot> parkingSpotList, String parkingSpotVariable) {

        if(parkingSpotList.isEmpty()){
            System.out.println("Not found");
        }

        else{
            for (int i = 0; i < parkingSpotList.size(); i++) {

                if(ParkingSpotConstant.SLOT.equalsIgnoreCase(parkingSpotVariable)){
                    if((i == parkingSpotList.size() - 1)) {
                        System.out.print(parkingSpotList.get(i).getSlot());
                    } else {
                        System.out.print(parkingSpotList.get(i).getSlot() + ", ");
                    }
                }

                else if (ParkingSpotConstant.REGISTRATION_NUMBER.equalsIgnoreCase(parkingSpotVariable)){
                    if((i == parkingSpotList.size() - 1)){
                        System.out.print(parkingSpotList.get(i).getRegistrationNumber());
                    }else{
                        System.out.print(parkingSpotList.get(i).getRegistrationNumber() + ", ");
                    }
                }
            }
        }
        System.out.println();
    }

    // REG_NO -> SPOT
    public static void generateSpotBasedOnRegistrationNumberResponse(int slot) {
        if(slot==-1){
            System.out.println("Not found");
        }else{
            System.out.println(slot);
        }
    }
}
