class Solution {
    public int gdc(int a, int b){
        if (b == 0){
            return a;
        }
        return gdc(b, a%b);
    }
    public String gcdOfStrings(String str1, String str2) {
        int str1_length = str1.length();
        int str2_length = str2.length();

        int gdc = gdc(str1_length, str2_length);

        String str1_concat = str1.concat(str2);
        String str2_concat = str2.concat(str1);

        if (str1_concat.equals(str2_concat)){
            return str1_concat.substring(0, gdc);
        }
        return "";
    }
}