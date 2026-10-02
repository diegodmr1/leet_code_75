/**
First Attempt:

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int length = words.length;
        StringBuilder result =  new StringBuilder();

        for (int i = length - 1; i >= 0; i--){
            result.append(words[i]);
            if (i != 0){
                result.append(" ");
            }  
        }
        return result.toString();
    }
}
*/

class Solution {
    public String reverseWords(String s) {
        StringBuilder result =  new StringBuilder();

        int i = s.length() - 1;
        while (i >= 0){
            while (i >= 0 && s.charAt(i) == ' '){ i--; }

            if (i >= 0){
                int end = i + 1;
                while (i >= 0 && s.charAt(i) != ' '){ i--;}
                int start = i + 1;

                if (result.length() > 0){ result.append(" "); }
                result.append(s.substring(start, end));
            }
        }
        return result.toString();
    }
}