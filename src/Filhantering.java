import java.io.*;
import java.util.ArrayList;

public class Filhantering {
    public static void main(String[] args){
        BufferedReader infile = openTextFileForReading("message.txt");
        ArrayList<String> filecontent = readAllText(infile);
        DataOutputStream outfile = openBinaryFileForWriting("crypt.txt");
        writeTextToBinary(filecontent, outfile);
    }

    private static void writeTextToBinary(ArrayList<String> filecontent, DataOutputStream outfile) {
        for(int i = 0; i < filecontent.size(); i++){
            try {
                outfile.write(filecontent.get(i).getBytes());
            } catch (IOException e) {
                System.out.println("Failed to write");
                e.printStackTrace();
            }
        }
    }


    private static DataOutputStream openBinaryFileForWriting(String filename) {
        DataOutputStream outfile;
        try {
            outfile = new DataOutputStream(new FileOutputStream(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file for writing, using terminal instead!");
            outfile = new DataOutputStream(System.out);
        }
        return outfile;
    }

    private static ArrayList<String> readAllText(BufferedReader infile) {
        ArrayList<String> text = new ArrayList<>();
        String line = null;
        try {
            line = infile.readLine();
            while(line != null){
                text.add(line);
                line = infile.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    private static BufferedReader openTextFileForReading(String filename) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, use keyboard instead!");
            in = new BufferedReader(new InputStreamReader(System.in));
        }
        return in;
    }

}
