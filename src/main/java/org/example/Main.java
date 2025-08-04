package org.example;

import java.io.*;


import static org.example.Stats.maxStats;
import static org.example.Stats.minStats;
import static org.example.WriteInFile.writeInFile;


public class Main {
    public static void main(String[] args) throws IOException {


        String pathFileToSave = null;
        File intFile = null;
        File doubleFile = null;
        File stringFile = null;

        Boolean needToAdd = false;

        String defaultPath = System.getProperty("user.dir");
        String prefixFileName = null;

        Boolean minStat = false;
        Boolean maxStat = false;


        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-p")) {
                if (i + 1 >= args.length) {
                    System.out.println("Не хватает аргумента после -p");
                    break;
                }

                if (args[i + 1].matches("^[^\\\\/:*?\"<>|]+$")) {
                    prefixFileName = args[i + 1];
//                    System.out.println("Ваш префикс " + prefixFileName);
                    i++;
                } else {
                    System.out.println("Исходные данные не приняты. Префикс должен не содержать запрещённых знаков \\ / : * ? \" < > | для наименования файла");
                    break;
                }
            }

            if (args[i].equals("-o")) {
                String rawPath = args[i + 1];

                if (rawPath.matches("^[^*?\"<>|]+$")) {
                    if (!rawPath.endsWith("/") && !rawPath.endsWith("\\")) {
                        rawPath += File.separator;
                    }
                    pathFileToSave =defaultPath + rawPath.replace("\\", "/");
//                    System.out.println("Файлы будут сохраняться в: " + pathFileToSave);
                    i++;

                    File directory = new File(pathFileToSave);
                    if (!directory.exists()) {
                        boolean created = directory.mkdirs();
//                        if (created) {
//                            System.out.println("Папка для сохранения создана: " + pathFileToSave);
//                        } else {
//                            System.out.println("Не удалось создать папку: " + pathFileToSave);
//                            return;
//                        }
                    }

                } else {
                    System.out.println("Исходные данные не приняты. Путь к сохранению файлов не должен содержать * ? \" < > | ");
                    break;
                }
            }

            if (args[i].equals("-a")) {
                needToAdd = true;
            }

            if (args[i].equals("-s")) {
                minStat = true;
            }
            if (args[i].equals("-f")) {
                maxStat = true;
            }

            if (args[i].contains(".txt")) {
                intFile = new File(pathFileToSave + prefixFileName + "integers.txt");
                doubleFile = new File(pathFileToSave + prefixFileName + "doubles.txt");
                stringFile = new File(pathFileToSave + prefixFileName + "strings.txt");

                if (!needToAdd) {
                    writeInFile(args[i], intFile, doubleFile, stringFile, false);
//                    System.out.println("Файл учтен, исходники перезаписаны");
                    needToAdd = true;
                } else {
                    writeInFile(args[i], intFile, doubleFile, stringFile, true);
//                    System.out.println("Файл учтён с добавлением");
                }
            }

        }


        if (maxStat) {
            minStats(intFile, doubleFile, stringFile);
            maxStats(intFile, doubleFile, stringFile);
        } else if (minStat) {
            minStats(intFile, doubleFile, stringFile);
        }

        if(intFile.length()==0) {
            intFile.delete();
        }
        if(doubleFile.length()==0) {
            doubleFile.delete();
        }
        if(stringFile.length()==0) {
            stringFile.delete();
        }


    }
}

