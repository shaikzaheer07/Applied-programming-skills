class Solution {
    public static int lengthOfLastWord(String s) {
        
        String[] str = s.split(" ");
        int last = str.length -1;
        String f = str[last];
        return f.length();
    }
}