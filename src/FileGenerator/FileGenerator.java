package FileGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    private String fileName;
    private int count;

    public FileGenerator(String fileName, int count) {
        this.fileName = fileName;
        this.count = count;
    }

    public void generateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= count; i++) {
                writer.write(i + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public int getCount() {
        return count;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

