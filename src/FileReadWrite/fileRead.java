/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReadWrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is responsible for reading our Technical Documentation
 * @author Rajesh Ghosh
 * @since 2017-03-10
 */
public class fileRead {

    /**
     * @see ReadTecnicalFile() this method is reading our text file.
     * @throws IOException
     */
    public static String ReadTecnicalFile() throws IOException{
        Path myFile = null;
        byte[] byteArray = null;
        try {
            myFile = Paths.get(ClassLoader.getSystemResource("resources/TechnicalDoc.txt").toURI());
        } catch (URISyntaxException ex) {
            Logger.getLogger(fileRead.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        boolean myFileExists = Files.exists(myFile,new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
        System.out.println(myFileExists);
        if(!myFileExists){
            System.out.println("Sorry.! your file does not exists.!");
        }
        else
        {
           byteArray = Files.readAllBytes(myFile);
          
      }
        return new String(byteArray);
    }

    /**
     *
     * @see MatchFromDictonary() this method is matching the word with the dictionary
     * @throws IOException 
     */
    public static void MatchFromDictonary() throws IOException{
        fileWrite fw = new fileWrite();
        List <String> dictinaryList = new ArrayList<String>();
        String Str,data;
        int position = 0,flag =0;
        String[] arr = new String [100000010];
       
        
        
        File file = new File(ClassLoader.getSystemResource("resources/dictonary.txt").getFile());
        FileReader reader = new FileReader(file);
        BufferedReader in = new BufferedReader(reader);
        //BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
        while((Str = in.readLine()) != null){
               dictinaryList.add(Str);
               
           }
           String[] stringArr = dictinaryList.toArray(new String[0]);
       /*Parsing Sentence from the input document*/
       System.out.println("******-----***------***-----******\nTecnical Documentation\n******-----***------***-----******");
       String input = ReadTecnicalFile();
       String[] SplitText = input.split("\\s+");
       System.out.println("Number of Word : "+SplitText.length);
       for(String text :SplitText){
       text = text.replaceAll("[^\\w]", "");
       //text = text.toLowerCase();
       //This one printing all the reading words from doc.
       //System.out.println(text);
       
        /*Parsing from the dictionary*/ 
        for( int i=0;i<stringArr.length;i++)
        {
          data = stringArr[i];
          String[] words = data.split("\\|");
          position = words.length;
          for (int j = 0; j < position-1; j++) 
          {
              if (text.toLowerCase().equals(words[j])) {
                   //This one printing all the translating words from doc.
                  //System.out.println(words[position-1]);
                  if(flag == 0)
                  {
                   fw.WriteInTextFile(words[position-1]);
                   flag=1;  
                  }
                }
              
              
           } 
          
        }
        
        flag=0;
       }
    
    }
    
  
}
