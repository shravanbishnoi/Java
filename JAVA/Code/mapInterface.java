/*
 * This file is created for practice mapInterface. 
 * 
 * Author: Shravan
 * Date: 05-03-2023
 */
import java.util.*;

public class mapInterface {
    public static void main(String[] args) {
        // Creating a HashMap object
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
    
        // Adding elements to map
        map.put(1, "Shravan");
        map.put(2, "Divyansh");
        map.put(3, "Bishnoi");
        System.out.println(map);

        // Adding elements to hm
        hm.put(1, "Shravan");
        hm.put(2, "Ram");
        hm.put(5, "Ram");
        hm.put(4, "Subhash");
        System.out.println(hm);

        // Combining two hashmaps
        map.putAll(hm);
        // removing entries based on key
        map.remove(1);
        // removing entries based on values
        map.values().remove("Ram");
        map.values();

        // printing all elements of the map
        System.out.println(map);
    }
}