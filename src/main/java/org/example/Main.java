package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import static com.google.common.util.concurrent.Futures.transform;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<String>(Arrays.asList("$10", "$30", "$40",
                "$50", "$60", "$70"));


        ArrayList<Integer> newList = new ArrayList<Integer>();
       for (int i=0; i<stringList.size(); i++)
        {
//            stringList.set(i, stringList.get(i).substring(1));
            newList.add(Integer.valueOf(stringList.get(i).substring(1)));

            System.out.println(stringList.get(i));
        }




        System.out.println(newList.get(0)+ newList.get(1) );
        }

}
