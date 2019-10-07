package Service;

import Constant.ProcessorConstant;
import Factory.ProcessorFactory;
import Processor.AbstractProcessor;
import Processor.ConsoleProcessor;
import Processor.FileProcessor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class ProcessorFactoryTest extends ProcessorConstant {

    private String file = FILE;
    private String filePath = "test.txt";
    private String console = CONSOLE;

    private ProcessorFactory factory = new ProcessorFactory();

    private FileProcessor fileProcessorTest = new FileProcessor("test.txt");
    private ConsoleProcessor consoleProcessorTest = new ConsoleProcessor();

    @Test
    public void fileProcessorTest(){

        AbstractProcessor processor = factory.getProcessor(FILE,"test.txt");
        assertThat(processor,instanceOf(AbstractProcessor.class));
        assertThat(fileProcessorTest,instanceOf(AbstractProcessor.class));
    }

    @Test
    public void consoleProcessorTest(){
        AbstractProcessor processor = factory.getProcessor(console,"");
        assertThat(processor,instanceOf(AbstractProcessor.class));
        assertThat(consoleProcessorTest,instanceOf(AbstractProcessor.class));
    }

}
