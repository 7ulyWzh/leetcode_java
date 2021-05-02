//给定一个二进制数组， 计算其中最大连续 1 的个数。 
//
// 
//
// 示例： 
//
// 
//输入：[1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组只包含 0 和 1 。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组 
// 👍 232 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int result = s.findMaxConsecutiveOnes(new int[]{0,1,1,1,0,1,0,1,1});
        System.out.println(result);
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        // 考虑动态规划
        // state[i]表示以i为末尾的数组中，最多连续1的个数
        int[] state = new int[nums.length];
        state[0] = nums[0];
        int length = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == 1){
                length++;
                if(length > state[i - 1]){  // 若累计长度比上一状态大
                    state[i] = state[i - 1] + 1; // 比上一状态+1
                }
                else{
                    state[i] = state[i - 1]; // 状态数不变
                }
            }else if (nums[i] == 0){
                // 重新计长度
                length = 0;
                state[i] = state[i - 1]; // 状态数不变
            }
        }
        return state[state.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
