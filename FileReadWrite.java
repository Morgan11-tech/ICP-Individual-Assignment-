/**
 * @author Nana Kofi Morgan Sarpong
 * @param filename
 * @return filecontent
 * this method given the file path, reads the file into an arraylist and
 * splits it on a comma. It throws a FileNotFoundException or an IOException in case of any errors.
 */
package com.mortek;

import java.io.*;
import java.util.ArrayList;

public class FileReadWrite {

    public static ArrayList<String[]> FRead(String filename) {

        ArrayList<String[]> filecontent = new ArrayList<>();

        try {
            File path = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                filecontent.add(values);
            }
            br.close();

        } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return filecontent;
    }

    /**
     * this method is for writing to a file given the file name
     * @param filename
     * @return filename
     */
    public static String Write(String filename){
        try {
            PrintStream record = new PrintStream(filename);
            System.setOut(record);
            record.println(Node.info);
            record.println(Node.info1);
            record.println(Node.info2);
            record.println(Node.info3);
            record.println(Node.info4);
            record.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return filename;

    }}
