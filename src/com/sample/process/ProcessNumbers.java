package com.sample.process;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessNumbers {
    public static void main(String[] args) throws IOException {
        processNumbers();
    }

    private static void processNumbers() throws IOException {
        System.out.println("please enter your input:");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] arr = input.split(" ");
//        System.out.println(input.substring(12));
//        System.out.println(arr.length);

        if(arr.length==2){
            String second = arr[1];
           processNumb(second);


        }else if(arr.length==3){
            String second = arr[1];
            String third = arr[2];
            ProcessNumbs(second,third);
        }
    }

    private static void processNumb(String second) throws IOException {
        Scanner scanner = new Scanner(System.in);
        if(isInteger(second)){
            System.out.println("Please enter list of numbers(space separated integers) :");
            String nextInput = scanner.nextLine();
//            int number = Integer.parseInt(second);
            String[] strNumb = nextInput.split(" ");
            int number = strNumb.length;

            if(number%2==0){
                List<Integer> evenList = new ArrayList<>();
                for (String s:strNumb) {
                    int num = Integer.parseInt(s);
                    if(num%2==0){
                        evenList.add(num);
                    }
                }
                for (Integer i:evenList) {
                    System.out.println(i);
                }
            }else{
                List<Integer> oddList = new ArrayList<>();
                for (String s:strNumb) {
                    int num = Integer.parseInt(s);
                    if(num%2==1){
                        oddList.add(num);
                    }
                }
                for (Integer i:oddList) {
                    System.out.println(i);
                }
            }
        }else{
            if(second.substring(0,5).equalsIgnoreCase("input")){
                List<Integer> list = readNumbersFromFile("src/com/sample/process/input.txt");

                if(list.size()%2==0){
                    List<Integer> evenList = new ArrayList<>();
                    for (Integer i:list) {

                        if(i%2==0){
                            evenList.add(i);
                        }
                    }
                    for (Integer x:evenList) {
                        System.out.println(x);
                    }
                }else{
                    List<Integer> oddList = new ArrayList<>();
                    for (Integer i:list) {

                        if(i%2==1){
                            oddList.add(i);
                        }
                    }
                    for (Integer x:oddList) {
                        System.out.println(x);
                    }
                }


            }


        }
    }

    private static void ProcessNumbs(String second,String third) throws IOException {
        Scanner scanner = new Scanner(System.in);
        if(isInteger(second)){
            System.out.println("Please enter list of numbers(space separated integers) :");
            String nextInput = scanner.nextLine();
//            int number = Integer.parseInt(second);
            String[] strNumb = nextInput.split(" ");
            int number = strNumb.length;

            if(number%2==0){
                List<Integer> evenList = new ArrayList<>();
                for (String s:strNumb) {
                    int num = Integer.parseInt(s);
                    if(num%2==0){
                        evenList.add(num);
                    }
                }
                writeNumbersToFile(evenList);
            }else{
                List<Integer> oddList = new ArrayList<>();
                for (String s:strNumb) {
                    int num = Integer.parseInt(s);
                    if(num%2==1){
                        oddList.add(num);
                    }
                }
                writeNumbersToFile(oddList);
            }
        }else{
            if(second.substring(0,5).equalsIgnoreCase("input")){
                List<Integer> list = readNumbersFromFile("src/com/sample/process/input.txt");

                if(list.size()%2==0){
                    List<Integer> evenList = new ArrayList<>();
                    for (Integer i:list) {

                        if(i%2==0){
                            evenList.add(i);
                        }
                    }
                    writeNumbersToFile(evenList);
                }else{
                    List<Integer> oddList = new ArrayList<>();
                    for (Integer i:list) {

                        if(i%2==1){
                            oddList.add(i);
                        }
                    }
                    writeNumbersToFile(oddList);
                }


            }


        }
    }

    private static boolean isInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException ex){
            return false;
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

            File file = new File("src/com/sample/process/output.txt");

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
