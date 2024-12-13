package Application;

import Constants.Constants;
import FileGenerator.FileGenerator;
import Operations.*;

import java.util.Scanner;

public class ApplicationController {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        int N = 0;
        int M = 0;
        int command, multiplier;
        FileGenerator fileGenerator;
        ParallelOperations parallelOperations;

        do {

            System.out.println("Выберите операцию для проведения анализа:");
            System.out.println("1-умножение");
            System.out.println("2-возведение в квадрат");
            System.out.println("3-факториал");
            System.out.println("4-фиббоначи");
            System.out.println("5-параллельное умножение с потоками разной длины");

            command = scanner.nextInt();
            if (command <= 5 && command >= 1) {
                System.out.println("Введите количество элементов N:");
                N = scanner.nextInt();
                System.out.println("Введите количество потоков M:");
                M = scanner.nextInt();
            }
            switch (command) {
                case 1:
                    System.out.print("Введите множитель: ");
                    multiplier = scanner.nextInt();
                    fileGenerator = new FileGenerator(Constants.inputFile + N + ".txt", N);
                    fileGenerator.generateFile();
                    parallelOperations = new ParallelOperations(Constants.inputFile + N + ".txt",
                            Constants.outputParallelFile + N + "_" + M +  "_multiply" + ".txt",
                            new MultiplyOperation(multiplier),M);
                    parallelOperations.processInParallel();
                    break;
                case 2:
                    fileGenerator = new FileGenerator(Constants.inputFile + N + ".txt", N);
                    fileGenerator.generateFile();
                    parallelOperations = new ParallelOperations(Constants.inputFile + N + ".txt",
                            Constants.outputParallelFile + N + "_" + M +  "_powto2" + ".txt",
                            new PowerOperation(),M);
                    parallelOperations.processInParallel();
                    break;
                case 3:
                    fileGenerator = new FileGenerator(Constants.inputFile + N + ".txt", N);
                    fileGenerator.generateFile();
                    parallelOperations = new ParallelOperations(Constants.inputFile + N + ".txt",
                            Constants.outputParallelFile + N + "_" + M +  "_factorial" + ".txt",
                            new FactorialOperation(),M);
                    parallelOperations.processInParallel();
                    break;
                case 4:
                    fileGenerator = new FileGenerator(Constants.inputFile + N + ".txt", N);
                    fileGenerator.generateFile();
                    parallelOperations = new ParallelOperations(Constants.inputFile + N + ".txt",
                            Constants.outputParallelFile + N + "_" + M +  "_fibonacci" + ".txt",
                            new FibonacciOperation(),M);
                    parallelOperations.processInParallel();
                    break;
                case 5:
                    System.out.println("Введите множитель:");
                    multiplier = scanner.nextInt();
                    fileGenerator = new FileGenerator(Constants.inputFile + N + ".txt", N);
                    fileGenerator.generateFile();
                    parallelOperations = new ParallelOperations(Constants.inputFile + N + ".txt",
                            Constants.outputParallelFile + N + "_" + M +  "_multiply" + ".txt",
                            new MultiplyOperation(multiplier));
                    parallelOperations.processWithUnevenDistribution();
                    break;
                default:
                    System.out.println("Неверный формат ввода");
                    break;
            }
        }
        while (command <= 5 && command >= 1);
    }
}
