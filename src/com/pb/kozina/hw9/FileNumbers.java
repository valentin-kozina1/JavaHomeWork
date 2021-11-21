package com.pb.kozina.hw9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileNumbers {
    Path numbers = Paths.get("C:\\Users\\Master\\Desktop\\IT\\Java\\numbers.txt");
    Path oddnumbers = Paths.get("C:\\Users\\Master\\Desktop\\IT\\Java\\odd-numbers.txt");
    public void createNumbersFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(numbers);) {
            for (int i = 0; i < 10; i++) {
                for (int k = 0; k < 10; k++) {
                    int a = (int) (Math.random() * 99)+1;
                    writer.write(a + " ");
                }
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       public void createOddNumbersFile() {
            try (BufferedReader reader = Files.newBufferedReader(numbers);
                 BufferedWriter writer = Files.newBufferedWriter(oddnumbers)) {
                String line;
                String[] number;
                while((line = reader.readLine()) != null) {
                    number = line.split(" ");
                    for (int i = 0; i < number.length; i++) {
                        if (i%2 == 1) {
                            writer.write("0 ");
                        } else {
                            writer.write( number[i] + " ");
                        }
                    }
                    writer.newLine();
                }

            } catch (Exception ex) {
                System.out.println("Error with file read: " + ex);
            }

        }
    }

