class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int planted = 0;
        int length = flowerbed.length;

        if (n == 0){ 
            return true;
        }

        if (length == 1 && n == 1){
            if (flowerbed[0] == 0){ 
                return true; 
            }else{ 
                return false; 
            }
        }

        for (int i = 0; i < length; i++){
            boolean currentZero = (flowerbed[i] == 0);
            boolean leftZero = (i == 0 || flowerbed[i - 1] == 0);
            boolean rightZero = (i == length - 1 || flowerbed[i + 1] == 0);

            if (currentZero && leftZero && rightZero){
                flowerbed[i] == 1;
                planted++;
            }

            if (planted == n){ 
                return true; 
            }
        }
        return false;
    }
}
