package com.internal.site.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class InternalNetworkingSite {
    String[] friendshipInput;
    String[] employeesInput;

    public InternalNetworkingSite(String[] friendshipInput, String[] employeesInput) {
        this.friendshipInput = friendshipInput;
        this.employeesInput = employeesInput;
    }

    public Map<Integer, String[]> seperateCommas(String[] input) {
        Map<Integer, String[]> result = new HashMap<>();

        IntStream.range(0, input.length).forEachOrdered(i -> result.put(i, input[i].split(",")));
        return result;
    }

    public Map<Integer, String[]> seperateEmployees(String[] employeesInput) {
        Map<Integer, String[]> commaSeperatedMap = seperateCommas(employeesInput);
        Map<Integer, String[]> resultMap = new HashMap<>();

        commaSeperatedMap.keySet().forEach(num -> {
            int index1 = Integer.parseInt(commaSeperatedMap.get(num)[0]);
            resultMap.put(index1, new String[]{String.valueOf(index1)});
        });

        return resultMap;
    }

    public Map<Integer, String[]> seperateFriendships(String[] friendshipInput) {
        Map<Integer, String[]> commaSeperatedMap = seperateCommas(friendshipInput);
        Map<Integer, String[]> resultMap = new HashMap<>();

        int i = 0;
        for (int num: commaSeperatedMap.keySet()) {
            resultMap.put(i++, commaSeperatedMap.get(num));
        }
        return resultMap;
    }

    public void associateFriends() {
        Map<Integer, String[]> sepFriendMap = seperateFriendships(friendshipInput);
        Map<Integer, String[]> sepEmpMap = seperateEmployees(employeesInput);
        Map<Integer, String> finalResultMap = new HashMap<>();

        sepFriendMap.keySet().forEach(key -> {
            Arrays.stream(sepFriendMap.get(key)).forEachOrdered(friendNum -> {
                int friendKey = Integer.parseInt(friendNum);
                String valueToSave = "";

                if (finalResultMap.containsKey(friendKey)) {
                    valueToSave = Arrays.toString(sepFriendMap.get(key)) + ", "
                            + finalResultMap.get(friendKey).replace(friendNum, "").replace(", ","");
                } else {
                    valueToSave = Arrays.toString(sepFriendMap.get(key));
                }
                valueToSave = valueToSave.replace("[", "")
                        .replace("]", "")
                        .replace(" ,", "");

                finalResultMap.put(friendKey, valueToSave);
            });
        });

        sepEmpMap.keySet().forEach(i -> {
            if (finalResultMap.containsKey(i)) {
                System.out.println(i + ": " + finalResultMap.get(i));
            } else {
                System.out.println(i + ": " + "None");
            }
        });
    }
}
