package codingProblems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class cashRegister {
	final static double PENNY = 0.01;             
    final static double NICKEL = 0.05;             
    final static double DIME = 0.10;               
    final static double QUARTER = 0.25;  
    final static double HALF_DOLLAR = 0.50;             
    final static double ONE = 1.00;             
    final static double TWO = 2.00;               
    final static double FIVE = 5.00;
    final static double TEN = 10.00;               
    final static double TWENTY = 20.00;
    final static double FIFTY = 50.00;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null) {
          String[] fields = s.split(";");          
          System.out.println(getCashChange(Float.parseFloat(fields[0]), Float.parseFloat(fields[1])));
        }
    }
    private static String getCashChange(float price, float cash) {
        if (cash < price) { return "ERROR"; }
        if (cash == price) { return "ZERO"; }
        float cashBack = cash - price;

        StringBuilder change = new StringBuilder();

        while (cashBack > 0.01f) {
            if (cashBack >= 100.0f) {
                change.append("ONE HUNDRED");
                cashBack -= 100.0f;
            } else if (cashBack >= 50.0f) {
                change.append("FIFTY");
                cashBack -= 50.0f;
            } else if (cashBack >= 20.0f) {
                change.append("TWENTY");
                cashBack -= 20.0f;
            } else if (cashBack >= 10.0f) {
                change.append("TEN");
                cashBack -= 10.0f;
            } else if (cashBack >= 5.0f) {
                change.append("FIVE");
                cashBack -= 5.0f;
            } else if (cashBack >= 2.0f) {
                change.append("TWO");
                cashBack -= 2.0f;
            } else if (cashBack >= 1.0f) {
                change.append("ONE");
                cashBack -= 1.0f;
            } else if (cashBack >= 0.5f) {
                change.append("HALF DOLLAR");
                cashBack -= 0.5f;
            } else if (cashBack >= 0.25f) {
                change.append("QUARTER");
                cashBack -= 0.25f;
            } else if (cashBack >= 0.1f) {
                change.append("DIME");
                cashBack -= 0.1f;
            } else if (cashBack >= 0.05f) {
                change.append("NICKEL");
                cashBack -= 0.05f;
            } else {
                change.append("PENNY");
                cashBack -= 0.01f;
            }
            change.append(",");
        }
        change.setLength(change.length() - 1);
        return change.toString();
    }
}