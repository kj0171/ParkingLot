package Service;

import Pojo.ParkingLot;
import Util.CommonValidator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommonValidatorTest {

    private ParkingLot parkingLot  = new ParkingLot(3);
    private ParkingLot parkingLot1;

    @Test
    //ParkingLot Null Test
    public void parkingSpotNullTest(){

        try {
            CommonValidator.checkParkingLotCreation(parkingLot1);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    //ParkingLot Not Null Test
    public void parkingLotNotNullTest() throws Exception {
        CommonValidator.checkParkingLotCreation(parkingLot);
        assertTrue(true);
    }


}
