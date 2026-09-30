import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int highestCount = candies[0];

        for (int candy : candies){
            if (candy > highestCount){
                highestCount = candy;
            }
        }

        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < candies.length; i++){
            if (candies[i] + extraCandies >= highestCount){
                result.add(true);
            }else{
                result.add(false);
            }
        }

        return result;
    }
}