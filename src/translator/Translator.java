/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translator;

import FileReadWrite.fileRead;
import FileReadWrite.fileWriteTime;
import creatingdoc.DocumentioanTest;
import java.io.IOException;

/**
 *
 * @author Rajesh Ghosh
 * @version 1.0
 * @since 2017-03-10
 */
public class Translator {

    /**
     *<p>in main() method we are declaring object for all class from different package<br>
     * and also calling methods and passing data. </p>
     * @param args default argument
     * @throws java.io.IOException
     */
    public static void main(String [ ] args) throws IOException
    {
     
     
        DocumentioanTest dt = new DocumentioanTest();
        dt.DisplayMessage("Hey this is a test.!");
        System.err.println("Sum of passing interges : "+dt.add(10, 5));
        /*
        *Testing DIctonary data reading.
        */
        fileRead fr = new fileRead();
        fileWriteTime ft = new fileWriteTime();
        
        
        long startTime = System.currentTimeMillis(); 
        fr.MatchFromDictonary();
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time for translating 10000 words : "+totalTime);
        
        
        String tT =  "Time for translating 10000 words : "+totalTime;
        ft.WriteInTextFile(tT);
        
       
    }
}
