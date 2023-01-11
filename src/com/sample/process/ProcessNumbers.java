package com.sample.process;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessNumbers {
    public static void main(String[] args) throws IOException {
        System.out.println("Please Enter a Number :");
        Scanner scanner = new Scanner(System.in);

        //Reading first input parameter
        String number = scanner.nextLine();
        int numb = Integer.parseInt(number);

        List<Integer> list = readNumbersFromFile("src/com/sample/process/input_numbers.txt");

        System.out.println("Should Result be  written to a file ? ( y / n )");
        //Reading Second input parameter
        String charactor = scanner.nextLine();

        if(numb%2 == 0 && charactor.equals("y")){
            List<Integer> evenList = new ArrayList<>();
            for (Integer i:list) {
                if (i%2==0){
                    evenList.add(i);
                }

            }
            writeNumbersToFile(evenList);
        }else if(numb%2 == 0){
            for (Integer i:list) {
                if (i%2==0){
                    System.out.println(i);
                }

            }
        }
        else{
            if(charactor.equals("y")){
                List<Integer> oddList = new ArrayList<>();
                for (Integer i:list) {
                    if (i%2==1){
                        //writeNumber(i);
                        oddList.add(i);
                    }

                }
                writeNumbersToFile(oddList);
            }else {
                for (Integer i:list) {
                    if (i%2==1){
                        System.out.println(i);
                    }

                }
            }

        }


    }

    private static List<Integer> readNumbersFromFile(String filename) throws IOException {
        BufferedReader br = null;
        List<Integer> list = new ArrayList<>();
        try {

            br = new BufferedReader(new FileReader(filename));

            String Int_line;

            while ((Int_line = br.readLine()) != null) {
                int In_Value = Integer.parseInt(Int_line);
                list.add(In_Value);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally
        {
            try{
                if(br!=null)
                    br.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedReader"+ex);
            }
        }
        return list;
    }

    private static void writeNumbersToFile(List<Integer> list) throws IOException {
        BufferedWriter bw = null;
        try {

            File file = new File("src/com/sample/process/output_numbers.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            for (Integer i:list
                 ) {
                bw.newLine();
                bw.write(""+i);
            }

            bw.newLine();
            bw.flush();
        }catch (Exception ex){

            ex.printStackTrace();
        }finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }
}
