package BinarySearch;

public class KokoEatsBanana {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/koko-eating-bananas/description/
    // https://www.youtube.com/watch?v=qyfekrNni90&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=13
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            //int right = Arrays.stream(piles).max().getAsInt();
            int right = Integer.MAX_VALUE;
            int ans = right;

            while (left<=right){
                int mid = left + (right - left)/2;
                if(totalHours(piles, h, mid)){
                    ans = mid;
                    right = mid - 1;
                }
                else
                    left = mid + 1;
            }
            return ans;
        }

        public boolean totalHours(int[] piles, int h, int k){
            long hours = 0;
            for (int p : piles){
                hours = hours + p/k;
                if(p%k !=0)
                    hours ++;
            }
            return hours <= h;
        }
    }
}
