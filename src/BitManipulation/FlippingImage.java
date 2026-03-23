package BitManipulation;

// https://leetcode.com/problems/flipping-an-image/?envType=problem-list-v2&envId=2jextkyj
public class FlippingImage {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int [] row: image) {
            // swap and xor at the same time
            for(int i= 0; i < (image[0].length + 1) / 2; i++) {
                int temp = row[i] ^ 1; // flip the bit at the same time while swapping
                row[i] = row[image[0].length - i -1] ^ 1;
                row[image[0].length - i -1] = temp;
            }
        }
        return image;
    }
}
