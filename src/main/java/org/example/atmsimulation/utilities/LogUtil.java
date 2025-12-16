package org.example.atmsimulation.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtil {
    private String fileName = "logs/app.log";

    public void writer(String level, String source, String message) {
        File logFile = new File("logs/app.log");
        try {
            if (!logFile.exists()) {
                logFile.getParentFile().mkdirs();
                logFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Log dosyası oluşturulamadı: " + e.getMessage());
        }
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String text = "[" + timeStamp + "]" +
                "[" + level + "]" +
                "[" + source + "]"
                + message;
        new File("logs").mkdirs();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("File has not written: " + e.getMessage());
        }
    }
}
