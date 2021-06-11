package company.apple;

import java.util.*;
public class TimeStampInterviewQuestion {



    public static void main(String[] args) {
        log(1, "app", "App starting..");
        log(2, "net", "Network stack initialized");
        log(4, "db", "Connecting to db....");
        log(5, "app", "Property files read");
        log(6, "app", "App - Loading modules");
        log(7, "db", "Connection Successsful");
        log(9, "net", "Listening on Port");
        log(11, "db", "App started");
    }

    /**
     * make sure that not more than one messages of the same category is printed in less that 5 seconds
     * @param time - in seconds
     * @param msgCategory
     * @param msg
     */

    private static Map<String, Integer> map = new HashMap<>();
    private static int period = 5;

    private static void log(int time, String msgCategory, String msg) {
        if (map.containsKey(msgCategory)) {
            if (time >= map.get(msgCategory)) {
                System.out.println(msgCategory + ": " + msg);
                map.put(msgCategory, time + period);
            }
        } else {
            System.out.println(msgCategory + ": " + msg);
            map.put(msgCategory, time + period);
        }

    }


/**

 Design elevator system

 1) The user will have a tablet in which level to enter the level they want to go.
 2) Elevator will ask backend server which is the next floor to go.
 3) Dashboard to review all the elevators current situations.

 POST request/requestElevator?eventId=123
 Request body
 {
 "eventId" : 123,
 "fromLevel": 2,
 "toLevel" : 40,
 "timeStamp" : 123214124
 }

 Response
 {
 "elevatorId" : 3,
 "estimateTime" : 20
 }

 POST request/nextDestination?elevatorId=7

 Request body
 {
 "currentLevel" : 7,
 "remainWeight" : 10
 }

 */
}
