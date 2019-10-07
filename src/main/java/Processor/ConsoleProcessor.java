package Processor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleProcessor extends AbstractProcessor{

    @Override
    public void process() throws Exception {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String inputString = bufferRead.readLine();
            boolean flag = validateAndProcess(inputString);
            if(!flag)
                break;
        }
    }
}
