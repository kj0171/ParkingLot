import Constant.CommandConstant;
import Constant.ProcessorConstant;
import Factory.ProcessorFactory;
import Processor.AbstractProcessor;

import java.io.IOException;

public class ParkingLotMain{

    public static void main(String[] args){
        String processorType;
        String filePath=null;

        if(args.length>0){
            processorType = ProcessorConstant.FILE;
            filePath = args[0];
        }else{
            processorType = ProcessorConstant.CONSOLE;
        }

        ProcessorFactory processorFactory = new ProcessorFactory();
        try {
            AbstractProcessor abstractProcessor = processorFactory.getProcessor(processorType, filePath);
            abstractProcessor.process();
        }catch (IOException e){
            System.out.println("Input Output Exception");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
