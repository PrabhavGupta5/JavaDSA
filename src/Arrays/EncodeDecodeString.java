package Arrays;
import java.util.*;

public class EncodeDecodeString {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length())
                    .append("#")
                    .append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            int j = i;

            while(s.charAt(j) != '#') // we want to get the length thats why
                j++;

            int len = Integer.parseInt(s.substring(i, j)); // to extract the length of that word
            String word = s.substring(j + 1, j + 1 + len);
            result.add(word);

            i = j + 1 + len; // to move to the next block
        }

        return result;

    }
}
