package Processor;

import Constant.CommandConstant;
import Constant.ParkingSpotConstant;
import Pojo.ParkingLot;
import Pojo.ParkingSpot;
import Pojo.Vehicle;
import Service.ParkingLotService;
import Util.CommandValidator;
import Util.CommonValidator;
import Util.ResponseCreator;

import java.util.List;

public abstract class AbstractProcessor extends CommandConstant {

    private ParkingLotService parkingLotService = new ParkingLotService();
    private ParkingLot parkingLot;

    //Method To Be Implemented For Getting The Respective Data
    public abstract void process() throws Exception;

    //Core Switch
    public boolean validateAndProcess(String inputString) throws Exception {

        String[] inputStringArray = inputString.split(" ");
        String command = inputStringArray[0];

        switch (command) {

            case CREATE: {
                CommandValidator.validateCommand(CREATE, inputStringArray.length);
                int numberOfParkingSlots = Integer.parseInt(inputStringArray[1]);
                parkingLot = new ParkingLot(numberOfParkingSlots);
                ResponseCreator.generateCreateResponse(numberOfParkingSlots);
                break;
            }

            case PARK: {
                CommandValidator.validateCommand(PARK, inputStringArray.length);
                CommonValidator.checkParkingLotCreation(parkingLot);
                String registrationNumber = inputStringArray[1];
                String color = inputStringArray[2];
                int slot = parkingLotService.parkVehicle(parkingLot, new Vehicle(registrationNumber, color));
                ResponseCreator.generateParkResponse(slot);
                break;
            }

            case LEAVE: {
                CommandValidator.validateCommand(LEAVE, inputStringArray.length);
                CommonValidator.checkParkingLotCreation(parkingLot);
                int slotNumber = Integer.parseInt(inputStringArray[1]);
                boolean leaveStatus = parkingLotService.leaveVehicle(parkingLot, slotNumber);
                ResponseCreator.generateLeaveResponse(slotNumber, leaveStatus);
                break;
            }

            case STATUS: {
                CommandValidator.validateCommand(STATUS, inputStringArray.length);
                CommonValidator.checkParkingLotCreation(parkingLot);
                ResponseCreator.generateStatusResponse(parkingLotService.displayParkingLot(parkingLot));
                break;
            }

            case FETCH_CAR_FROM_COLOR: {
                CommandValidator.validateCommand(FETCH_CAR_FROM_COLOR, inputStringArray.length);
                CommonValidator.checkParkingLotCreation(parkingLot);
                String color = inputStringArray[1];
                List<ParkingSpot> parkingSpotList = parkingLotService.fetchParkingSpotBasedOnColor(parkingLot, color);
                ResponseCreator.generateResponseBasedOnColor(parkingSpotList, ParkingSpotConstant.REGISTRATION_NUMBER);
                break;
            }

            case FETCH_SLOT_FROM_COLOR: {
                CommandValidator.validateCommand(FETCH_SLOT_FROM_COLOR, inputStringArray.length);
                CommonValidator.checkParkingLotCreation(parkingLot);
                String color = inputStringArray[1];
                List<ParkingSpot> parkingSpotList = parkingLotService.fetchParkingSpotBasedOnColor(parkingLot, color);
                ResponseCreator.generateResponseBasedOnColor(parkingSpotList, ParkingSpotConstant.SLOT);
                break;
            }

            case FETCH_SLOT_FROM_REG_NO: {
                CommandValidator.validateCommand(FETCH_SLOT_FROM_REG_NO, inputStringArray.length);
                CommonValidator.checkParkingLotCreation(parkingLot);
                String registrationNumber = inputStringArray[1];
                int slot = parkingLotService.fetchSlotBasedOnRegistrationNumber(parkingLot, registrationNumber);
                ResponseCreator.generateSpotBasedOnRegistrationNumberResponse(slot);
                break;
            }

            case EXIT:{
                return false;
            }

            default: {
                System.out.println("Incorrect Command");
            }
        }
        return true;
    }

}
