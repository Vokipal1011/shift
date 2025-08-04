package org.example;

import java.io.*;
import java.math.BigInteger;

public class WriteInFile {

    public static void writeInFile(String string, File integers, File doubles, File strings, boolean append) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(string));

        BufferedWriter writerIntegers = new BufferedWriter(new FileWriter(integers, append));
        BufferedWriter writerDouble = new BufferedWriter(new FileWriter(doubles,append));
        BufferedWriter writerString = new BufferedWriter(new FileWriter(strings,append));

        while (reader.ready()) {
            String line = reader.readLine();
            try {
                long bigInt = Long.parseLong((line));
                writerIntegers.write(line);
                writerIntegers.newLine();
            } catch (NumberFormatException e1) {
                try {
                    double doubleValue = Double.parseDouble(line);
                    writerDouble.write(String.valueOf(doubleValue));
                    writerDouble.newLine();
                } catch (NumberFormatException e2) {
                    writerString.write(line);
                    writerString.newLine();
                }
            }
        }

        reader.close();
        writerIntegers.close();
        writerDouble.close();
        writerString.close();
    }
}
