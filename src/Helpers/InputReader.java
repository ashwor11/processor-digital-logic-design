package Helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* EXAMPLE USAGE:
  
    InputReader reader = new InputReader();
         
    while(reader.isFileOver() == false) {
        List<String> line = reader.getNextSplittedLine();
        // use the line here
    }
 
 */

public class InputReader {

    private String filePath = "./src/input.txt";
    private List<List<String>> splittedLines = new ArrayList<>();
    private List<String> allLines;
    private List<String> oneLine;

    public InputReader() {
        allLines = readInputFile(filePath);
        splitTheLines();
    }
    

    public List<String> getNextSplittedLine(){
        List<String> SplittedLine = new ArrayList<>();
        SplittedLine = splittedLines.get(0);
        splittedLines.remove(0);
                
        return SplittedLine;       
    }

    public boolean isFileOver(){
        if(splittedLines.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }  


//#region private methods
    private List<String> readInputFile(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return lines;
    }

    private void splitTheLines(){
        for (String line : allLines) {
            oneLine = new ArrayList<>(); 

            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].trim();
                oneLine.add(words[i]);
            }

            splittedLines.add(oneLine);
        }
    }
//#endregion
    


}