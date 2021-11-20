package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Reader {
    static public Map<String, String> readUserFile() {

        Map<String, String> auth = new HashMap<>();

        String [] database = new String[10];
        int totalLength =0;
        try {
            // need to modify the file path and name according to your program
            FileInputStream fstream = new FileInputStream("src\\com\\company\\users.txt");

            // create a bufferedreader
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                // Print the content on the console
//                System.out.println ("Current line:"+strLine);
                database[totalLength] = strLine;
                totalLength++;

                String[] splited = strLine.split(" ");
                String name = splited[0];
                String password = splited[1];
                auth.put(name, password);
//                System.out.println("name:" + name+" and " +"password:"+password+"\n");
            }

            //Close the input stream
            fstream.close();

            return auth;
        } catch (Exception e) {
            System.err.println("Error:"+e.getMessage());
            return null;
        }
//
//        // backup the data to the backup.txt
//        try {
//            //might to update the filename and path
//            File fout = new File("src\\backup.txt");
//            FileOutputStream fstream = new FileOutputStream(fout);
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fstream));
//
//            //please keep track of the database length
//            for (int j =0; j<totalLength;j++)
//            {
//                bw.write(database[j]);
//                bw.newLine();
//            }
//            bw.close();
//
//            return null;
//        }catch (Exception e) {
//            System.err.println("Error:"+e.getMessage());
//        }
    }
}
