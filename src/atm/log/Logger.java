package atm.log;

import java.io.*;
import java.sql.Timestamp;

public  class Logger {
    public static FileLogger fileLogger;


    public static void log(String text,String level){
        if (fileLogger == null)
            fileLogger = new FileLogger();
        fileLogger.writeToFile(new Timestamp(System.currentTimeMillis()) + " " + level + " " + text + System.lineSeparator());
    }

    public static void close(){
        fileLogger.close();
    }


}


class FileLogger{
    OutputStream os = null;
    String logFile = "login.log";

    public FileLogger() {
        try {
            os = new FileOutputStream(logFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String text){
        try {
            os.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void close(){
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}