import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});


    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        // 利用nums本身充当hashtable
        for (int num :
                nums) {
            int x = (num - 1) % n;  // 有重复的数字（例如3出现了2次），需要先对n取余得到原值
            nums[x] += n;
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n){
                list.add(i + 1);
            }
        }
        return list;
    }
}