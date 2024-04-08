package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {
    String[] header;
    int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void saveToFile(AppData appData, File file) {
        try (PrintWriter dataOut = new PrintWriter(new FileWriter(file))) {
            String header = String.join("; ", appData.getHeader());
            dataOut.write(header);
            StringBuilder stringBuilder = new StringBuilder();
            for (int[] elements : appData.data) {
                for (int i = 0; i < elements.length; i++) {
                    if (i == 0) {
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append(elements[i]);
                    if (i != elements.length - 1) {
                        stringBuilder.append("; ");
                    }
                }
            }
            String data = stringBuilder.toString();
            dataOut.write(data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AppData load(File file) {
        String[] header;
        int[][] data;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            header = reader.readLine().split("; ");
            String str;

            ArrayList<String> arrayList = new ArrayList<>();
            while ((str = reader.readLine()) != null) {
                String[] strings = str.split("; ");
                arrayList.addAll(Arrays.asList(strings));
            }
            data = new int[1][arrayList.size()];
            int x = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                data[0][i] = Integer.parseInt(arrayList.get(i));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new AppData(header, data);
    }


    @Override
    public String toString() {
        return "AppData{" +
                "header=" + Arrays.toString(header) +
                ", data=" + Arrays.deepToString(data) +
                '}';
    }
}
