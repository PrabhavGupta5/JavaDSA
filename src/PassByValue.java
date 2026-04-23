import java.util.List;

import java.util.*;
public class PassByValue {
    public static void main(String[] args) {
 // Create a map of list of integers, now I want to update one value in a map and print the map
        HashMap<Integer, List<Integer> > map = new HashMap<>();
        map.put(4, new ArrayList<>(Arrays.asList(5,5)));
        map.put(6, new ArrayList<>(Arrays.asList(6,5)));
        map.put(2, new ArrayList<>(Arrays.asList(2,5)));

        // key : 2, add 7 in the list for that key
        map.get(2).add(7);
//        map.getOrDefault(3, new ArrayList<>()).add(7);
        map.putIfAbsent(3,new ArrayList<>());
        map.put(3, map.getOrDefault(3,new ArrayList<>())).add(7);




       // map.put(3, new ArrayList<>(Arrays.asList(2,5)));

        for(int key : map.keySet())
            System.out.println(key + " " + map.get(key));
        Map<Integer,Integer> map2=new HashMap<>();

            map2.put(3,7);
        map2.compute(3,(k,v)-> v+1);
        for (int val : map2.values())
            System.out.println("val in map2 " + val);
        for (int key : map2.keySet()) {
            System.out.println("Key in map2: " + key);
        }

        for(int key : map2.keySet())
            System.out.println(key + " " + map2.get(key));


        int a = 5;
        inc(a);
        System.out.println(a);

        int[] arr = {11, 3, 69, 6};
        System.out.println(min(arr));
        System.out.println(max(arr));

        List<Integer> list = Arrays.asList(2,5,5,2); // storing it as array
        List<Integer> arrList = new ArrayList<>(list);
        List<Integer> linList = new LinkedList<>(list);
        List<Integer> list2 = List.of(2,5,6,2);  // Immutable list

        arrList.add(2);
//        list.add(2);
//        list.remove(2);
//        list2.remove(Integer.valueOf(5));
//        list.set(2,56);
//        linList.set(2,25);
        System.out.println(linList);
        System.out.println(list.indexOf(5));
        System.out.println(list.lastIndexOf(5));

        System.out.println(list);
        System.out.println(list2);





        Queue<Integer> que = new LinkedList<>();

    }
    static void inc(int x) { x++; }

    static int min(int[] num){
        int min = num[0];
        for (int i= 1 ; i < num.length ; i++ ){
            if(num[i]<min)
                min = num[i];
        }
        return min;

    }

    static int max(int[] num){
        int max = num[0];
        for (int i= 1 ; i < num.length ; i++ ){
            if(num[i]> max)
                max = num[i];
        }
        return max;

    }

}
