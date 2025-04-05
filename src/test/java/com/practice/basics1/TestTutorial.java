package com.practice.basics1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

public class TestTutorial {

    int a;
    int b;

    TestTutorial(int c, int b)
    {
        a= c;
        this.b = b;
    }

    TestTutorial(int c, int b, int d)
    {
        a= c;
        this.b = b;
        this.a = d;
    }

         static int cube(int x) {
            return x * x * x;
        }

        public static void main(String args[]){
//            TestTutorial t = new TestTutorial();
            int result=TestTutorial.cube(6);
            System.out.println(result);
            ArrayList<String> list = new ArrayList<String>(); // No type specified (unsafe)
            list.add("Hello");
            list.add("100"); // No error (Bad practice)

            String s = (String) list.get(0); // Explicit casting needed
            System.out.println(list.get(0));
            System.out.println(list.get(1));

            Hashtable a = new Hashtable();
            HashMap b = new HashMap();


        }


}
