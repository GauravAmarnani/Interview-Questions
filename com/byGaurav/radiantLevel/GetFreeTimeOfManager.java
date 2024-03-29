/*
    Q. Make a software that takes busy time of 2 managers through out their day and provides a list of potential times
    when they're both free and can have a meeting with each other.

    User will provide Busy Timing of 2 Managers.

    Example: Manager 1: 10:00 to 10:30
                        11:30 to 12:00
                        13:30 to 15:30
                        16:30 to 17:00
                        17:30 to 18:30
                        19:00 to 20:00.

             Manager 2: 10:00 to 11:00
                        11:30 to 13:30
                        14:30 to 16:30
                        17:00 to 18:00
                        19:00 to 20:00.

    Now they both will have a Working time as well:
    Example: Manager 1: 8:00 to 21:00.

             Manager 2: 9:00 to 21:30.

    We have to provide user with a list of times when they're both free and can have a meeting.

 */

package com.byGaurav.radiantLevel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

/**
 * @author Gaurav Amarnani.
 */

public class GetFreeTimeOfManager {

    //Methods :
    public static List<List<Object>> getAllPossibleFreeTime(Set<Object> user1 , Set<Object> user2 , String user1Bound , String user2Bound) {
        List<Integer> boundTime = getBoundTime(user1Bound , user2Bound);
        List<List<Object>> finalList;
        user1.addAll(user2);
        List<List<Integer>> unmodifiedList = new ArrayList(user1);
        for(int i = 0; i < unmodifiedList.size(); i++)
            unmodifiedList.set(i , getSimplifiedTime(unmodifiedList.get(i)));
        if(unmodifiedList.contains(null))
            return null;
        unmodifiedList.sort(new Comparator<>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        List<List<Integer>> modifiedList1;
        List<List<Integer>> modifiedList2;
        modifiedList1 = getModifiedList(unmodifiedList);
        if(modifiedList1 == null)
            return null;
        else {
            modifiedList2 = getFinalModifiedList(modifiedList1);
            if (boundTime.get(0) < modifiedList1.get(0).get(0)) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(boundTime.get(0));
                temp.add(modifiedList1.get(0).get(0));
                modifiedList2.add(0, temp);
            }
            if (boundTime.get(1) > modifiedList1.get(modifiedList1.size() - 1).get(1)) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(modifiedList1.get(modifiedList1.size() - 1).get(1));
                temp.add(boundTime.get(1));
                modifiedList2.add(modifiedList2.size(), temp);
            }
            finalList = getUnsimplifiedTime(modifiedList2);
            return finalList;
        }
    }

    public static List<Integer> getBoundTime(String user1Bound , String user2Bound) {
        List<Integer> boundTime = new ArrayList<>(2);
        List<Integer> bound1 = getSimplifiedTime(user1Bound);
        List<Integer> bound2 = getSimplifiedTime(user2Bound);
        if(bound1 != null && bound2 != null) {
            if(bound1.get(0) > bound2.get(0)) {
                if(bound1.get(1) < bound2.get(1)) {
                    boundTime.add(bound1.get(0));
                    boundTime.add(bound1.get(1));
                }
                else {
                    boundTime.add(bound1.get(0));
                    boundTime.add(bound2.get(1));
                }
            }
            else {
                if(bound1.get(1) < bound2.get(1)) {
                    boundTime.add(bound2.get(0));
                    boundTime.add(bound1.get(1));
                }
                else {
                    boundTime.add(bound2.get(0));
                    boundTime.add(bound2.get(1));
                }
            }
        }
        return boundTime;
    }

    public static List<List<Integer>> getFinalModifiedList(List<List<Integer>> modifiedList) {
        List<List<Integer>> temp = new ArrayList<>();
        for(int i = 0; i < modifiedList.size(); i++) {
            if ((i + 1) < modifiedList.size()) {
                Integer i1 = (modifiedList.get(i).get(1));
                Integer i2 = (modifiedList.get(i+1).get(0));
                ArrayList<Integer> moreTemp = new ArrayList<>(2);
                moreTemp.add(i1);
                moreTemp.add(i2);
                temp.add(moreTemp);
            }
        }
        return temp;
    }

    public static List<List<Integer>> getModifiedList(List<List<Integer>> unmodifiedList) {
        boolean flag = true;
        int i = 0;
        while(flag && i == unmodifiedList.size()) {
            flag = false;
            if(i < unmodifiedList.size() && (i+1) <= unmodifiedList.size()) {
                if (unmodifiedList.get(i).get(0) == unmodifiedList.get(i + 1).get(0)) {
                    if(unmodifiedList.get(i).get(1) >= unmodifiedList.get(i + 1).get(1)) {
                        unmodifiedList.remove(i + 1);
                        flag = true;
                        i = 0;
                    }
                    else {
                        unmodifiedList.remove(i);
                        flag = true;
                        i = 0;
                    }
                }
                if (unmodifiedList.get(i).get(1).equals(unmodifiedList.get(i + 1).get(0))) {
                    Integer i1 = unmodifiedList.get(i).get(0);
                    Integer i2 = unmodifiedList.get(i + 1).get(1);
                    ArrayList<Integer> temp = new ArrayList();
                    temp.add(i1);
                    temp.add(i2);
                    unmodifiedList.set(i , temp);
                    unmodifiedList.remove(i+1);
                    flag = true;
                    i = 0;
                }
                else if(unmodifiedList.get(i).get(1) > unmodifiedList.get(i + 1).get(0)){
                    if(unmodifiedList.get(i).get(1) > unmodifiedList.get(i + 1).get(1)) {
                        unmodifiedList.remove(i+1);
                        flag = true;
                        i = 0;
                    }
                    else {
                        Integer i1 = unmodifiedList.get(i).get(0);
                        Integer i2 = unmodifiedList.get(i+1).get(1);
                        ArrayList<Integer> temp = new ArrayList();
                        temp.add(i1);
                        temp.add(i2);
                        unmodifiedList.set(i , temp);
                        unmodifiedList.remove(i + 1);
                        flag = true;
                        i = 0;
                    }
                }
                i++;
            }
        }
        return unmodifiedList;
    }

    public static List<Integer> getSimplifiedTime(Object userTime) {
        List<Integer> returnList = new ArrayList<>(2);
        String temp = (String) userTime;
        String[] time = temp.split(",");
        String[] startTime = time[0].split(":");
        String[] endTime = time[1].split(":");
        try {
            String startHour = startTime[0];
            String startMinutes = startTime[1];
            String endHour = endTime[0];
            String endMinutes = endTime[1];
            returnList.add((Integer.parseInt(startHour) * 60) + Integer.parseInt(startMinutes));
            returnList.add((Integer.parseInt(endHour) * 60) + Integer.parseInt(endMinutes));
        }
        catch (Exception e) {
            return null;
        }
        return returnList;
    }

    public static List<List<Object>> getUnsimplifiedTime(List<List<Integer>> modifiedList2) {
        List<List<Object>> finalTime = new ArrayList<>();
        for (List<Integer> integers : modifiedList2) {
            for (int j = 0; j < 2; j++) {
                Integer hours1 = integers.get(j) / 60;
                int mins1 = integers.get(j) % 60;
                String time1;
                if (mins1 == 0)
                    time1 = hours1 + ":" + mins1 + "0";
                else
                    time1 = hours1 + ":" + mins1;
                Integer hours2 = integers.get(j + 1) / 60;
                int mins2 = integers.get(j + 1) % 60;
                String time2;
                if (mins2 == 0)
                    time2 = hours2 + ":" + mins2 + "0";
                else
                    time2 = hours2 + ":" + mins2;
                ArrayList<Object> temp = new ArrayList<>(2);
                temp.add(time1 + " to " + time2);
                if((hours2+mins2) > (hours1+mins1))
                    finalTime.add(temp);
                j++;
            }
        }
        return finalTime;
    }

    public static void main(String...args) {
        Set<Object> user1 = new HashSet<>();
        Set<Object> user2 = new HashSet<>();
        String user1Bound;
        String user2Bound;
        List<List<Object>> allPossibleFreeTime;
        user1.add("10:00,10:30");
        user1.add("11:30,12:00");
        user1.add("13:30,15:30");
        user1.add("16:30,17:00");
        user1.add("17:30,18:30");
        user1.add("19:00,20:00");
        user1Bound = "8:00,21:00";

        user2.add("10:00,11:00");
        user2.add("11:30,13:30");
        user2.add("14:30,16:30");
        user2.add("17:00,18:00");
        user2.add("19:00,20:00");
        user2Bound = "9:00,21:30";

        allPossibleFreeTime = getAllPossibleFreeTime(user1 , user2 , user1Bound , user2Bound);
        if(allPossibleFreeTime == null)
            out.println("Mistake in input time.");
        else
            out.println("All the possible Meeting time : \n" + allPossibleFreeTime);
    }
}
