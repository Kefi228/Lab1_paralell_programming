package Operations;

import Application.ApplicationController;
import Constants.Constants;
import Processors.ParallelFileProcessor;
import FileGenerator.FileGenerator;

import java.util.Scanner;

public class ParallelOperations {

    public static void multiplyParallelOperations(int multiplier, int n) {
        for (Integer m : Constants.M) {
            ParallelFileProcessor parallelProcessor = new ParallelFileProcessor
                    (Constants.inputFile + n + ".txt", Constants.outputParallelFile + n + "_" + m +
                            "_multiply" + ".txt", number -> Integer.toString(number * multiplier), m);
            parallelProcessor.processInParallel();
        }
    }

    public static void powto2ParallelOperations(int n) {
        for (Integer m : Constants.M) {
            ParallelFileProcessor parallelProcessor = new ParallelFileProcessor
                    (Constants.inputFile + n + ".txt", Constants.outputParallelFile + n + "_" + m +
                            "_pow2" + ".txt", number -> Integer.toString((int) Math.pow(number, 2)), m);
            parallelProcessor.processInParallel();
        }
    }

    public static void factorialParallelOperations(int n){
        for (Integer m : Constants.M) {
            ParallelFileProcessor parallelProcessor = new ParallelFileProcessor(Constants.inputFile + n + ".txt", Constants.outputParallelFile
                        + n + "_" + m + "_factorial.txt", number -> Methods.factorial(number).toString(), m);
                parallelProcessor.processInParallel();
        }
    }

    public  static void fibbonachiParallelOperations(int n){
        for (Integer m : Constants.M) {
            ParallelFileProcessor parallelProcessor = new ParallelFileProcessor(Constants.inputFile + n + ".txt",
                    Constants.outputParallelFile + n + "_" + m + "_fibbonachi.txt", number ->
                    Methods.fibonacci(number).toString(), m);
                parallelProcessor.processInParallel();
        }
    }

    public static void unEvenThreadParallelOperations(int multiplier, int n){
        for (Integer m : Constants.M) {
        ParallelFileProcessor parallelProcessor = new ParallelFileProcessor(Constants.inputFile + ".txt",
                Constants.outputParallelUnevenFile, number -> Integer.toString(number * multiplier));
        parallelProcessor.processWithUnevenDistribution(2);
        System.out.println("Многопоточная обработка с неравным количеством элементов в потоке завершена:" +
                Constants.outputParallelUnevenFile);
        }
    }

}



