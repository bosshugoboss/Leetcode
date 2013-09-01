
public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean positive = x >= 0;
        String s = positive ? String.valueOf(x) : String.valueOf(-x);
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        return positive ? Integer.valueOf(new String(str)) : (-1) * Integer.valueOf(new String(str));
    }
}
