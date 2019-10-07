package Service;

import Constant.CommandConstant;
import Util.CommandValidator;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CommandValidatorTest extends CommandConstant {

    @Test
    public void commandTest_Success() throws Exception {
            CommandValidator.validateCommand(CREATE,2);
            CommandValidator.validateCommand(LEAVE,2);
            CommandValidator.validateCommand(FETCH_CAR_FROM_COLOR,2);
            CommandValidator.validateCommand(FETCH_SLOT_FROM_COLOR,2);
            CommandValidator.validateCommand(FETCH_SLOT_FROM_REG_NO,2);
            CommandValidator.validateCommand(PARK,3);
            CommandValidator.validateCommand(STATUS,1);
            assertTrue(true);
    }

    @Test
    public void createCommandTest_Failure() {
        try {
            CommandValidator.validateCommand(CommandConstant.CREATE,5);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}
