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
        ArrayList<String> thingsToReplace = new ArrayList<String>(Arrays.asList("<DATE>","<NAME>","<ADDRESS>","<CITY>","<STATE>","<ZIPCODE>"));
        for(int y=1;y<=11;y++) {
            copyFile(new File("SalesLetter.dat"),new File("TemplateFile.dat"));
            for (int x = 0; x < thingsToReplace.size(); x++) {
                String line = "";
                try (Stream<String> lines = Files.lines(Paths.get("Address.csv"))) {
                    line = lines.skip(y).findFirst().get();
                    System.out.println(line);
                } catch (IOException e) {
                    System.out.println(e);
                }
                String[] replacementInfo = line.split(",");
                String stringReplacement = "";
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
                modifyFile("TemplateFile.dat", thingsToReplace.get(x), stringReplacement);
            }
            modifyFile("TemplateFile.dat", "<YOURNAME>", "Rishik Yechuri");
            byte[] bytes = Files.readAllBytes(Paths.get("TemplateFile.dat"));
            String nameOfPDF = "Output" + y;
            OutputStream out = new FileOutputStream(nameOfPDF);
            out.write(bytes);
            out.close();
        }
    }
    public static String getPDF() throws IOException {

        File file = new File("TemplateFile.dat");
        FileInputStream stream = new FileInputStream(file);
        byte[] buffer = new byte[8192];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int bytesRead;
        while ((bytesRead = stream.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        System.out.println("it came back"+baos);
        byte[] buffer1= baos.toByteArray();
        String fileName = "Gigachadtest.pdf";

        //stream.close();


        FileOutputStream outputStream =
                new FileOutputStream(fileName);

        outputStream.write(buffer1);

        return fileName;

    }
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
