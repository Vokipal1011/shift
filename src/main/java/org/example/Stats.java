package org.example;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Stats {


    public static void minStats(File integers, File doubles, File strings) throws IOException {

        BufferedReader readerInteger = new BufferedReader(new FileReader(integers));
        BufferedReader readerDouble = new BufferedReader(new FileReader(doubles));
        BufferedReader readerString = new BufferedReader(new FileReader(strings));

        int countIntegers = 0;
        int countDoubles = 0;
        int countStrings = 0;

        String line;

        while ((line = readerInteger.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                countIntegers++;
            }
        }
        while ((line = readerDouble.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                countDoubles++;
            }
        }
        while ((line=readerString.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                countStrings++;
            }
        }

        int allMinStats = countIntegers + countDoubles + countStrings;

        System.out.println("Общее число записанных элементов: " + allMinStats);
        System.out.println("Из них: ");
        System.out.println("Чисел int: " + countIntegers);
        System.out.println("Чисел double: " + countDoubles);
        System.out.println("Строк: " + countStrings);

        readerInteger.close();
        readerDouble.close();
        readerString.close();

    }

    public static void maxStats(File integers, File doubles, File strings) throws IOException {

        BufferedReader readerInteger = new BufferedReader(new FileReader(integers));
        BufferedReader readerDouble = new BufferedReader(new FileReader(doubles));
        BufferedReader readerString = new BufferedReader(new FileReader(strings));

        ArrayList<Long> listIntegers = new ArrayList<>();
        ArrayList<Double> listDoubles = new ArrayList<>();
        ArrayList<String> listStrings = new ArrayList<>();

        String line;

        while ((line = readerInteger.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                listIntegers.add(Long.parseLong(line));
            }
        }
        while ((line = readerDouble.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                listDoubles.add(Double.parseDouble(line));
            }
        }
        while ((line=readerString.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                listStrings.add(line);
            }
        }

        long minInt = Collections.min(listIntegers);
        long maxInt = Collections.max(listIntegers);

        long sumInteger = 0;
        for (long list : listIntegers) {
            sumInteger += list;
        }

        long averageInteger = sumInteger / listIntegers.size();

        System.out.println("Минимальное int: " + minInt);
        System.out.println("Максимальное int: " + maxInt);
        System.out.println("Сумма всех int: " + sumInteger);
        System.out.println("Среднее int: " + averageInteger);


        double minDouble = Collections.min(listDoubles);
        double maxDouble = Collections.max(listDoubles);

        double sumDouble = 0;
        for (double list : listDoubles) {
            sumDouble += list;
        }

        double averageDouble = sumDouble / listDoubles.size();

        System.out.println("Минимальное double: " + minDouble);
        System.out.println("Максимальное double: " + maxDouble);
        System.out.println("Сумма всех double: " + sumDouble);
        System.out.println("Среднее double: " + averageDouble);


        String shortest = Collections.min(listStrings, Comparator.comparingInt(String::length));
        String longest = Collections.max(listStrings, Comparator.comparingInt(String::length));

        System.out.println("Самая коротка строка: " + shortest + "Содержит" + shortest.length() + "символов");
        System.out.println("Самая длинная строка: " + longest + "Содержит" + longest.length() + "символов");


        readerInteger.close();
        readerDouble.close();
        readerString.close();

    }
}
