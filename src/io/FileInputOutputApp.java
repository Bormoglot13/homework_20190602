/*

1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция:
   ArrayList<InputStream> al = new ArrayList<>();...
   Enumeration<InputStream> e = Collections.enumeration(al);
3. Реализовать консольную авторизацию в банкомат
    - ввод с консоли логина и пароля
    - список логинов и паролей хранится в List
    - Записать в файл время, дату и логин входа

    - Создать метод просмотра логов по входу



 */

package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class FileInputOutputApp {

    public static void main(String[] args) {
        writeToFile();
        readFromFile();
        fromMultipleFilesToOneFile(new String[]{"file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"},"outFile.txt");
    }

    public static void readFromFile(){
        try(InputStream is = new FileInputStream("file1.txt")){
            int x;
            while ((x = is.read()) != -1){
                System.out.println((byte) x);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }


    public static void writeToFile(){
        byte[] arr = {10,15,30,45,78};
        OutputStream os = null;
        try{
            os = new FileOutputStream("file1.txt");
            os.write(arr);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFromFileWriteToFile(InputStream is,OutputStream os){
        try{
            int x;
            while ((x = is.read()) != -1){
                os.write((byte) x);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }


    public static void fromMultipleFilesToOneFile(String[] inputFileNames,String outputFile){

        ArrayList<InputStream> al = new ArrayList<>();
        try {
            for (String fileName: inputFileNames
                 ) {
                al.add(new FileInputStream(fileName));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Enumeration<InputStream> e = Collections.enumeration(al);
        try( OutputStream os = new FileOutputStream(outputFile)) {
            while (e.hasMoreElements()) {
                InputStream is = e.nextElement();
                readFromFileWriteToFile(is,os);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
