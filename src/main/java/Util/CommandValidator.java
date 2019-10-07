package Util;


import Constant.CommandConstant;

public class CommandValidator extends CommandConstant{


    public static boolean validateCommand(String command , int length) throws Exception {

        if(command.equalsIgnoreCase(PARK) && length==3){
                return true;
        }

        else if((command.equalsIgnoreCase(CREATE) || command.equalsIgnoreCase(LEAVE)
                || command.equalsIgnoreCase(FETCH_CAR_FROM_COLOR) || command.equalsIgnoreCase(FETCH_SLOT_FROM_COLOR)
                || command.equalsIgnoreCase(FETCH_SLOT_FROM_REG_NO))&& length==2){

                return true;
        }


        else if(command.equalsIgnoreCase(STATUS) && length==1){
                return true;
        }

        throw new Exception("Invalid Command");
    }

}
