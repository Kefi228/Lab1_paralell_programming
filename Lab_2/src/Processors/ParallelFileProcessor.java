package Processors;

import Operations.Operation;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelFileProcessor {
    private String inputFile;
    private String outputFile;
    private Operation operation;
    private int threads;

    public ParallelFileProcessor(String inputFile, String outputFile, Operation operation, int threads) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.operation = operation;
        this.threads = threads;
    }

    public ParallelFileProcessor(String inputFile, String outputFile,  Operation operation) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.threads = threads;
    }

    public void processInParallel() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));
            int totalNumbers = lines.size();
            int partitionSize = (int) Math.ceil((double) totalNumbers / threads);
            ExecutorService executor = Executors.newFixedThreadPool(threads);

            long startTime = System.nanoTime();

            for (int i = 0; i < threads; i++) {
                final int start = i * partitionSize;
                final int end = Math.min(start + partitionSize, totalNumbers);

                if (start < end) {
                    executor.submit(() -> {
                        try (FileWriter writer = new FileWriter(outputFile, true)) {
                            for (int j = start; j < end; j++) {
                                int number = Integer.parseInt(lines.get(j).trim());
                                writer.write(operation.apply(number) + "\n");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }

            executor.shutdown();
            while (!executor.isTerminated()) {
            }

            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            System.out.println(" " + duration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processWithUnevenDistribution(int firstThreadLimit) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));
            int totalNumbers = lines.size();
            ExecutorService executor = Executors.newFixedThreadPool(2);

            executor.submit(() -> {
                try (FileWriter writer = new FileWriter(outputFile, true)) {
                    for (int j = 0; j < firstThreadLimit; j++) {
                        int number = Integer.parseInt(lines.get(j).trim());
                        writer.write((operation.apply(number)) + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            executor.submit(() -> {
                try (FileWriter writer = new FileWriter(outputFile, true)) {
                    for (int j = firstThreadLimit; j < totalNumbers; j++) {
                        int number = Integer.parseInt(lines.get(j).trim());
                        writer.write((operation.apply(number)) + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            executor.shutdown();
            while (!executor.isTerminated()) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


