package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestDataReader {
  //  "C:\Users\Mayuri\OneDrive\Desktop\Sprint 2 Amazon_Cust.xlsx"
  //  src/test/resources/Sprint 2 Amazon_Cust.xlsx
    public static void main(String[] args) throws FileNotFoundException {


      FileInputStream fileInputStream = new FileInputStream("src/test/resources/Sprint 2 Amazon_Cust.xlsx");

    }
}