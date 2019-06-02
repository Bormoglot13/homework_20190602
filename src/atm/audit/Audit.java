package atm.audit;

import java.io.*;

public class Audit {


    public static void findMatchByLine(String matchStr){
        try(FileInputStream fstream = new FileInputStream("login.log");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream))){
            String strLine;
            while ((strLine = br.readLine()) != null){
                if (strLine.contains(matchStr))
                    System.out.println(strLine);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
