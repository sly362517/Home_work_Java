package Home_work_Java.home_work6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class mainNotebook {
    public static void main(String[] args) {
        notebook notebook_1 = new notebook(8, 500, "Windows", "silver");
        notebook notebook_2 = new notebook(16, 1000, "MacOS", "silver");
        notebook notebook_3 = new notebook(16, 500, "Windows", "black");
        notebook notebook_4 = new notebook(32, 1000, "MacOS", "white");
        notebook notebook_5 = new notebook(64, 2000, "Windows", "black");
        notebook notebook_6 = new notebook(16, 500, "MacOS", "black");
        ArrayList<notebook> notebooks = new ArrayList<>(
                Arrays.asList(notebook_1, notebook_2, notebook_3, notebook_4, notebook_5, notebook_6));
        System.out.println(
                "Здравствуйте! Для подбора параметров ноутбука введите последовательно критерии вашего выбора!");
        Map<String, Integer> mapOptions = new HashMap<>();
        mapOptions.put("amountRam", 0);
        mapOptions.put("hardDiskCapacity", 0);
        mapOptions.put("systemOperating", 0);
        mapOptions.put("colour", 0);
                notebook.printInvitationForUser(mapOptions);
        Scanner scn = new Scanner(System.in);

        int numberOption = -1;
        Set<Integer> setNumbersOptions = new HashSet<>();

        while (numberOption != 0) {
            if (setNumbersOptions.size() == 0) {
                numberOption = scn.nextInt();
                if (!notebook.checkNumberOption(numberOption, setNumbersOptions)) {
                    break;
                }
                setNumbersOptions.add(numberOption);
            }

            if (numberOption == 1) {
                System.out.println("Введите минимальный объем ОЗУ! ");
                int minAmountRam = scn.nextInt();
                mapOptions.put("amountRam", minAmountRam);
                notebook.printInvitationForUser(mapOptions);
                numberOption = scn.nextInt();

                if (!notebook.checkNumberOption(numberOption, setNumbersOptions)) {
                    break;
                }
                setNumbersOptions.add(numberOption);
            }

            if (numberOption == 2) {
                System.out.println("Введите минимальный объем ЖД! ");
                int minHardDiskCapacity = scn.nextInt();
                mapOptions.put("hardDiskCapacity", minHardDiskCapacity);
                notebook.printInvitationForUser(mapOptions);
                numberOption = scn.nextInt();

                if (!notebook.checkNumberOption(numberOption, setNumbersOptions)) {
                    break;
                }
                setNumbersOptions.add(numberOption);
            }

            if (numberOption == 3) {
                System.out.println("Для выбора \"Windows\" введите 1,\n для выбора \"MacOS\" введите 2:\n");
                int numberSystemOperating = scn.nextInt();
                if (numberSystemOperating != 1 && numberSystemOperating != 2) {
                    System.out.println("Ввели некорректный номер системы!");
                } else {
                    mapOptions.put("systemOperating", numberSystemOperating);
                    notebook.printInvitationForUser(mapOptions);
                    numberOption = scn.nextInt();

                    if (!notebook.checkNumberOption(numberOption, setNumbersOptions)) {
                        break;
                    }
                    setNumbersOptions.add(numberOption);
                }
            }

            if (numberOption == 4) {
                System.out.println(
                        "Для выбора цвета \"серебристый\" введите 1,\n для выбора \"белый\" введите 2:\n, для выбора \"черный\" введите 3:\n");
                int numberColour = scn.nextInt();
                if (numberColour < 1 && numberColour > 3) {
                    System.out.println("Ввели некорректный номер цвета!!!");
                } else {
                    mapOptions.put("colour", numberColour);
                    if (setNumbersOptions.size() == 4) {
                        break;
                    }
                    notebook.printInvitationForUser(mapOptions);
                    numberOption = scn.nextInt();
                    if (!notebook.checkNumberOption(numberOption, setNumbersOptions)) {
                        break;
                    }
                }
            }
        }

        ArrayList<notebook> setResult = notebook.getNotebookSetByOptions(notebooks, mapOptions);
        if (setResult.size() == 0) {
            System.out.println("К сожалению, по выбранным вами критериям ноутбуков нет!!!");
        } else {
            System.out.println("По выбранным вами критериям мы можем предложить следующий список ноутбуков:");
            System.out.println(setResult);
        }
        scn.close();
    }
}
