package com.practice.basics1.resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadCsvFile {

    HashMap<String, String> data = new HashMap<>();

  public HashMap<String, String> getTestDataFromCsv(String filePath) throws FileNotFoundException {

      try ( BufferedReader br = new BufferedReader(new FileReader(filePath))) {

          String line;
          while ((line = br.readLine()) != null)
          {
              String[] parts = line.split(",");
              if (parts.length == 2){
                  data.put(parts[0].trim(), parts[1].trim());
              }

          }

      }catch (IOException e) {
          e.printStackTrace();
      }

    return data;

  }


}
