package Operations;

import Application.ApplicationController;
import Constants.Constants;
import Processors.ParallelFileProcessor;
import FileGenerator.FileGenerator;

import java.util.Scanner;

public class ParallelOperations {

    private int m;
    private String inputFile;
    private String outputFile;
    private Operation operation;

    public ParallelOperations(String inputFile, String outputFile, Operation operation) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.operation = operation;
    }

    public ParallelOperations(String inputFile, String outputFile, Operation operation, int m) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.operation = operation;
        this.m = m;
    }

    public void processInParallel() {
        ParallelFileProcessor parallelProcessor = new ParallelFileProcessor(inputFile, outputFile,
                number -> operation.apply(number), m);
        parallelProcessor.processInParallel();
    }

    public  void processWithUnevenDistribution(){
        ParallelFileProcessor parallelProcessor = new ParallelFileProcessor(inputFile, outputFile,
                number -> operation.apply(number));
        parallelProcessor.processWithUnevenDistribution(2);
    }

    public int getM() {
        return m;
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

}



