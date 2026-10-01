    class Solution {
        private boolean isVowel (char c){
            return "aeiouAEIOU".indexOf(c) != -1;
        }
        public void swap(char[] chars, int i, int j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        public String reverseVowels(String s) {
            int end = s.length() - 1;
            int i = 0;
            int j = end;

            char[] chars = s.toCharArray();

            while (i < j){
                while(i < j && !isVowel(chars[i])){
                    i++;
                }
                while(i < j && !isVowel(chars[j])){
                    j--;
                }
                if (i < j){
                    swap(chars, i, j);
                    i++;
                    j--;
                }
            }
            return new String(chars);
        }
    }