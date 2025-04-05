package com.practice.testComponents;

import com.practice.basics1.resources.ReadCsvFile;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class eComDataProvider {

    public static HashMap<String, String> data;
    public static ReadCsvFile readCsvFile;
    public static String filePath = System.getProperty("user.dir")+"/resources/testData/testDetailsData.csv";

    @DataProvider(name = "ecommerceData")
    public Object[][] getDPData(){
        data = getData();
        HashMap<String, String> data1 =  new HashMap<>();
        data1.put("url",data.get("url1"));
        data1.put("email",data.get("email1"));
        data1.put("password",data.get("password1"));
        data1.put("productName",data.get("productName1"));
        data1.put("countryNameInitials",data.get("countryNameInitials1"));
        data1.put("CountryName",data.get("CountryName1"));
        data1.put("ccExpMonth",data.get("ccExpMonth1"));
        data1.put("ccExpday",data.get("ccExpday1"));

        HashMap<String, String> data2 =  new HashMap<>();
        data2.put("url",data.get("url2"));
        data2.put("email",data.get("email2"));
        data2.put("password",data.get("password2"));
        data2.put("productName",data.get("productName2"));
        data2.put("countryNameInitials",data.get("countryNameInitials2"));
        data2.put("CountryName",data.get("CountryName2"));
        data2.put("ccExpMonth",data.get("ccExpMonth2"));
        data2.put("ccExpday",data.get("ccExpday2"));

        Object[][] objData = new Object[2][1];
        objData[0][0] = data1;
        objData[1][0] = data2;

        return objData;
    }

    public static HashMap<String, String> getData() {
        try {
            readCsvFile = new ReadCsvFile();
            data = readCsvFile.getTestDataFromCsv(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

}
