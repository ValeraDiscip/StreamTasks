package org.example;

import java.io.*;

public class AppDataBytes {
    private String[] header;
    private int[][] data;

    public AppDataBytes(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void saveToFile(AppDataBytes appDataBytes, File file) {
        try (BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file))) {
            String header = String.join("; ", appDataBytes.getHeader());
            os.write(header.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (int[] datum : appDataBytes.getData()) {
                for (int i = 0; i < datum.length; i++) {
                    if (i == 0) {
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append(datum[i]);
                    if (i != datum.length - 1) {
                        stringBuilder.append("; ");
                    }
                }
            }
            String dataOut = String.valueOf(stringBuilder);
            os.write(dataOut.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public AppDataBytes load(File file) {
        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(file))) {
            int element;
            StringBuilder stringBuilder = new StringBuilder();
            while ((element = is.read()) != -1) {
                stringBuilder.append((char) element);
            }
            String str = String.valueOf(stringBuilder);
            String[] strings = str.split("; ");
            String[] header;
            int[][] data;
            for (int i = 0; i < strings.length; i++) {

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
