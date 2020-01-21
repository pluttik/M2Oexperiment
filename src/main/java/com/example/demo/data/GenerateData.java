package com.example.demo.data;
// generates data for the four parent/child sets of entity classes

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GenerateData {
    public static void main(String[] args) {
        StringBuilder postcode = new StringBuilder();

        System.out.println(postcode);

        File myoutput = new File("/dataForEntities.txt");
        try {
            PrintWriter printWriter = new PrintWriter(myoutput);
            for (int i = 0; i < 10; i++) { //university
                char x = (char) ((int) 'A' + Math.random() * ((int) 'Z' - (int) 'A' + 1));
                for (int j = 0; j < 100; j++) { //student
                    postcode.append(x);
                    postcode.append(",");
                    postcode.append((char) ((int) 'A' + Math.random() * ((int) 'Z' - (int) 'A' + 1)));
                    postcode.append("\n");
                }
                printWriter.print(postcode);
                postcode = new StringBuilder();
            }
            printWriter.close();
        }
        catch(FileNotFoundException error) {
            System.out.println(error.getMessage());
        }

    }
}
