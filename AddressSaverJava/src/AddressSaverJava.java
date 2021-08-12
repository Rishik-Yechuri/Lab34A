import javax.swing.text.Document;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddressSaverJava {
    public static void main(String[] args) throws IOException {
        //Creates an arraylist of words to replace in the sales document
        ArrayList<String> thingsToReplace = new ArrayList<String>(Arrays.asList("<DATE>","<NAME>","<ADDRESS>","<CITY>","<STATE>","<ZIPCODE>"));
        //Loops through each person
        for(int y=1;y<=11;y++) {
            //Gets the data from the Address file
            String line = "";
            try (Stream<String> lines = Files.lines(Paths.get("Address.csv"))) {
                line = lines.skip(y).findFirst().get();
            } catch (IOException e) {
                System.out.println(e);
            }
            //Splits the information into an array
            String[] replacementInfo = line.split(",");
            //Uses the persons name to create the document name
            String documentName = replacementInfo[0].substring(0,1) + "_" + replacementInfo[1] + "_JAVA";
            //Copies SalesLetter to TemplateFile
            copyFile(new File("SalesLetter.dat"),new File("TemplateFile.dat"));
            //Loops through thingsToReplace
            for (int x = 0; x < thingsToReplace.size(); x++) {
                //Stores what to replace it with
                String stringReplacement = "";
                /*Depending on the data field,stringReplacement is set to the correct value
                For example if the data field is "<NAME>",the replacement will be Billy Bob.
                But if the data field is "<CITY>,the replacement will be Frisco"*/
                switch (thingsToReplace.get(x)) {
                    case "<DATE>":
                        Format f = new SimpleDateFormat("MM/dd/yy");
                        String strDate = f.format(new Date());
                        stringReplacement = strDate;
                        break;
                    case "<NAME>":
                        stringReplacement = replacementInfo[0] + " " + replacementInfo[1];
                        break;
                    case "<ADDRESS>":
                        stringReplacement = replacementInfo[2];
                        break;
                    case "<CITY>":
                        stringReplacement = replacementInfo[3];
                        break;
                    case "<STATE>":
                        stringReplacement = replacementInfo[4];
                        break;
                    case "<ZIPCODE>":
                        stringReplacement = replacementInfo[5];
                        break;
                }
                //Replaces the field with the proper information
                modifyFile("TemplateFile.dat", thingsToReplace.get(x), stringReplacement);
            }
            //Changes the "<YOURNAME>" field to "Rishik Yechuri"
            modifyFile("TemplateFile.dat", "<YOURNAME>", "Rishik Yechuri");
            //Converts TemplateFile to a byte array
            byte[] bytes = Files.readAllBytes(Paths.get("TemplateFile.dat"));
            //Creates a new file using the modified TemplateFile
            OutputStream out = new FileOutputStream(documentName);
            out.write(bytes);
            out.close();
        }
    }
    //A function to copy a file to another file
    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }
        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new RandomAccessFile(sourceFile,"rw").getChannel();
            destination = new RandomAccessFile(destFile,"rw").getChannel();

            long position = 0;
            long count    = source.size();

            source.transferTo(position, count, destination);
        }
        finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
        }
    }
    //A function to replace a string in a file with another string
    public static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                reader.close();
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
