package org.example;

import java.io.*;
import java.util.Arrays;

public class AppData2 implements Serializable {
    String[] header;
    int[][] data;

    public AppData2(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }


    public void saveAsObj(AppData2 appData2, File file) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
            os.writeObject(appData2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AppData2 loadAsObj(File file) {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
            return (AppData2) is.readObject();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "AppData2{" +
                "header=" + Arrays.toString(header) +
                ", data=" + Arrays.deepToString(data) +
                '}';
    }
}
