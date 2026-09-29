class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int w1_length = word1.length();
        int w2_length = word2.length();

        for (int i = 0, j = 0; i < w1_length || j < w2_length; i++, j++){
            if (i < w1_length){
                result.append(word1.charAt(i));
            }
            if (j < w2_length){
                result.append(word2.charAt(j));
            }
        }

        return result.toString();     
    }
}