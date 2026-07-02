package Greedy.Intervals;
import java.util.*;

// This is solved by Line sweep algorithm
// https://www.youtube.com/watch?v=zKSDKQ-ifmI
// Take a map, put the events
//

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], map.getOrDefault(intervals[i][0], 0) + 1);
            map.put(intervals[i][1], map.getOrDefault(intervals[i][0], 0) - 1);
        }

        int rooms = 0;
        int maxOverlap = 0;

        for(int delta : map.values()){
            rooms = rooms + delta;
            maxOverlap = Math.max(rooms, maxOverlap);

        }

        return maxOverlap;
    }

    // example : [0,30]
    //[5,10]
    //[15,20]
    // meeting starts  -> +1
    // meeting ends    -> -1
    // output: 2

    // Time: room
    // 0  -> +1
    //5  -> +1
    //10 -> -1
    //15 -> +1
    //20 -> -1
    //30 -> -1


    // GFG Version:
    public int minMeetingRooms(int[] start, int[] end) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < start.length; i++) {
            map.put(start[i], map.getOrDefault(start[i], 0) + 1);
        }

        for(int i = 0; i < end.length; i++) {
            map.put(end[i], map.getOrDefault(end[i], 0) - 1);
        }

        int rooms = 0;
        int maxOverlap = 0;

        for(int delta : map.values()){
            rooms = rooms + delta;
            maxOverlap = Math.max(rooms, maxOverlap);
        }

        return maxOverlap;
    }
}
