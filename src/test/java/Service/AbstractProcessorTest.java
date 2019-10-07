package Service;

import Constant.ProcessorConstant;
import Factory.ProcessorFactory;
import Processor.AbstractProcessor;
import org.junit.Test;

public class AbstractProcessorTest {

    private String createStatement = "create_parking_lot 6";
    private String parkStatement = "park KA-01-HH-1234 White";
    private String leaveStatement = "leave 1";
    private String statusStatement = "status";
    private String regNoFromColor = "registration_numbers_for_cars_with_colour White";
    private String slotFromColor = "slot_numbers_for_cars_with_colour White";
    private String slotFromRegNo = "slot_number_for_registration_number KA-01-HH-1234";

    private AbstractProcessor processor;
    private ProcessorFactory processorFactory = new ProcessorFactory();
    private String console = ProcessorConstant.CONSOLE;

    @Test
    public void statementTest() throws Exception {
        processor = processorFactory.getProcessor(console,"");
        processor.validateAndProcess(createStatement);
        processor.validateAndProcess(parkStatement);
        processor.validateAndProcess(statusStatement);
        processor.validateAndProcess(regNoFromColor);
        processor.validateAndProcess(slotFromColor);
        processor.validateAndProcess(slotFromRegNo);
        processor.validateAndProcess(leaveStatement);
    }


}
