package Factory;

import Constant.ProcessorConstant;
import Processor.AbstractProcessor;
import Processor.ConsoleProcessor;
import Processor.FileProcessor;

public class ProcessorFactory extends ProcessorConstant {

    public AbstractProcessor getProcessor(String type , String file){

        switch (type){
            case FILE:
                return new FileProcessor(file);

            case CONSOLE:
                return new ConsoleProcessor();
        }

        return new ConsoleProcessor();
    }


}
