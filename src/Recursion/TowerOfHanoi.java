package Recursion;


// Solved using Recursion
// https://www.youtube.com/watch?v=l45md3RYX7c&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=11
public class TowerOfHanoi {
    public static void main(String[] args) {
        int N = 3;
        towerOfHanoi(N, 'A', 'C', 'B' );
    }

    // As an example take n = 3
// First we move disc 1 and 2 from source to helper (a recursive call for n-1 discs)
// then move the third disc from source to destination
// and finally take disc 1 and 2 from helper to destination.
    public static void towerOfHanoi(int n, char source, char helper, char destination){
        if(n==1){
            System.out.println("Move disc 1 from "+source+" to "+ destination);
            return;
        }
        towerOfHanoi(n-1, source, destination, helper);
        System.out.println("Move disc "+ n +" from "+source+" to "+ destination);
        towerOfHanoi(n-1, helper, source, destination);
    }

// Time Complexity: T(n) = 2T(n-1) + T(1)

}
