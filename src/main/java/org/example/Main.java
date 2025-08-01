package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String defaultPath = System.getProperty("user.dir");
        String prefixFileName = null;

        String fileOne = null;
        Boolean minStat = false;
        Boolean maxStat = false;

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String incomingData = consoleReader.readLine();
        consoleReader.close();

        String[] initialData = incomingData.split(" ");

        for (int i = 0; i < initialData.length; i++) {
            System.out.println(initialData[i]);
            if (initialData[i].equals("-p")) {
                if (i + 1 >= initialData.length) {
                    System.out.println("Не хватает аргумента после -p");
                    break;
                    }

                if (!initialData[i + 1].matches("^[^\\\\/:*?\"<>|]+$")) {
                    prefixFileName = initialData[i + 1];
                    System.out.println("Ваш префикс " + prefixFileName);
                    i++;
                } else {
                    System.out.println("Исходные данные не приняты. Префикс должен не содержать запрещённых знаков \\ / : * ? \" < > | для наименования файла");
                    break;
                }
            }
            if (initialData[i].equals("-o")) {
                if (!initialData[i + 1].matches("^[^*?\"<>|]+$")) {
                    String pathFileToSave = initialData[i + 1];
                } else {
                    System.out.println("Исходные данные не приняты. Путь к сохранению файлов не должен содержать * ? \" < > | ");
                    break;
                }
            }

            if (initialData[i].contains(".txt")) {

                if (fileOne == null) {
                    fileOne = initialData[i];
                } else {
                    String fileTwo = initialData[i];
                }
            }
        }

        BufferedReader reader = new BufferedReader(new FileReader(fileOne));

        String integers = prefixFileName + "integers.txt";
        String doubles = prefixFileName + "doubles.txt";
        String strings = prefixFileName + "strings.txt";
        BufferedWriter writerIntegers = new BufferedWriter(new FileWriter(integers));
        BufferedWriter writerDouble = new BufferedWriter(new FileWriter(doubles));
        BufferedWriter writerString = new BufferedWriter(new FileWriter(strings));


        while (reader.ready()) {
            String line = reader.readLine();
            try {
                writerIntegers.write(Integer.parseInt(line));
                writerIntegers.newLine();
            } catch (NumberFormatException e1) {
                try {
                    double doubleValue = Double.parseDouble(line);
                    writerDouble.write(String.valueOf(doubleValue));
                    writerIntegers.newLine();
                } catch (NumberFormatException e2) {
                    writerString.write(line);
                    writerIntegers.newLine();
                }
            }
        reader.close();
        writerIntegers.close();
        writerDouble.close();
        writerString.close();

        }

        reader.close();


    }
}
