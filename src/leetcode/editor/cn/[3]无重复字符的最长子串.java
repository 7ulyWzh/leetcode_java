package leetcode.editor.cn;//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5429 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<Character>();

        // 定义右指针
        int right = 0, i = 0, res = 0;
        // 左指针为i
        while(right <s.length()){
            while(right < s.length() && occ.contains(s.charAt(right)) == false) {  // 不是重复的字符
                occ.add(s.charAt(right));
                res = Math.max(res, right - i + 1);
                right++;
            }
            // 执行到此处，表明哈希表中已经存有字符c了
            while(right < s.length() && occ.contains(s.charAt(right))){
                // 左指针向右移动1
                occ.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String string = "aaaaabcd";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring(string));

    }
}






//leetcode submit region end(Prohibit modification and deletion)
