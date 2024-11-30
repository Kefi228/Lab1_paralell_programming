package Application;

import Constants.Constants;
import FileGenerator.FileGenerator;
import Operations.ParallelOperations;

import java.util.Scanner;

public class ApplicationController {
    public static void run(){
        Scanner scanner = new Scanner(System.in);

        int command, multiplier;
        do{
            System.out.println("Выберите операцию для проведения анализа:");
            System.out.println("1-умножение");
            System.out.println("2-возведение в квадрат");
            System.out.println("3-факториал");
            System.out.println("4-фиббоначи");
            System.out.println("5-параллельное умножение с потоками разной длины");

            command = scanner.nextInt();

            switch (command){
                case 1:
                    System.out.print("Введите множитель: ");
                    multiplier = scanner.nextInt();
                    for (Integer n : Constants.N) {
                        FileGenerator.generateFile(Constants.inputFile + n + ".txt", n);
                        ParallelOperations.multiplyParallelOperations(multiplier, n);
                    }
                    break;
                case 2:
                    for (Integer n : Constants.N) {
                        FileGenerator.generateFile(Constants.inputFile + n + ".txt", n);
                        ParallelOperations.powto2ParallelOperations(n);
                    }
                    break;
                case 3:
                    for (Integer n : Constants.N) {
                        FileGenerator.generateFile(Constants.inputFile + n + ".txt", n);
                        ParallelOperations.factorialParallelOperations(n);
                    }
                    break;
                case 4:
                    for (Integer n : Constants.N) {
                        FileGenerator.generateFile(Constants.inputFile + n + ".txt", n);
                        ParallelOperations.fibbonachiParallelOperations(n);
                    }
                    break;
                case 5:
                    System.out.println("Введите множитель:");
                    multiplier = scanner.nextInt();
                    for (Integer n : Constants.N) {
                        FileGenerator.generateFile(Constants.inputFile + n + ".txt", n);
                        ParallelOperations.unEvenThreadParallelOperations(multiplier, n);
                    }
                    break;
                default:
                    System.out.println("Неверный формат ввода");
                    break;
            }
        }
        while (command <= 5 && command >= 1);

    }
}
