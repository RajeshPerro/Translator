/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReadWrite;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
    This class is responsible for writing in a text file after translating words from dictionary
 * @author Rajesh Ghosh
 * @since 2017-03-10
 */
public class fileWriteTime {
    
    /**
     *<p>Method WriteInTextFile() is creating and writing translated words in a text file</p>
     * @param data this is variable contains the final output after translating text
     * @throws IOException
     */
    public static void WriteInTextFile(String data) throws IOException
    {
        Path myFile = null;
        try {
            myFile = Paths.get(ClassLoader.getSystemResource("resources/TimeInformation.txt").toURI());
        } catch (URISyntaxException ex) {
            Logger.getLogger(fileRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean myFileExists = Files.exists(myFile,new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
        
        if(!myFileExists){
            System.out.println("Sorry.! your file does not exists.!");
        }
        else
        {
            //System.out.println("Writing in File...done!");
            data = data+"\n";
            Files.write(myFile, data.getBytes(),StandardOpenOption.APPEND);
           // Files.write(myFile, data.getBytes(), StandardCharsets.UTF_8,StandardOpenOption.APPEND);
            
      }
    }
    
}
