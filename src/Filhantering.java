import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Filhantering {
    public static void main(String[] args){
        PrintWriter outfile_message = openFileForWriting("message.txt");
        writeRandomNumbers(outfile_message);
        BufferedReader infile = openTextFileForReading("message.txt");
        ArrayList<String> filecontent = readAllText(infile);
        DataOutputStream outfile_crypt = openBinaryFileForWriting("crypt.txt");
        writeTextToBinary(filecontent, outfile_crypt);
    }

    private static PrintWriter openFileForWriting(String filename) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter outfile = new PrintWriter(bw);
        return outfile;
    }

    private static void writeRandomNumbers(PrintWriter outfile) {
        int x;
        Random r = new Random();

        for (int i = 0 ; i < 1920*1080 ; i++) {
            x = r.nextInt(0xffffff);
            outfile.println(x);
        }
    }

    private static void writeTextToBinary(ArrayList<String> filecontent, DataOutputStream outfile) {
        for(int i = 0; i < filecontent.size(); i++){
            try {
                int number = Integer.parseInt(filecontent.get(i));
                outfile.writeInt(number);
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
