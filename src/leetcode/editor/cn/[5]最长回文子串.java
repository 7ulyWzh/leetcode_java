package leetcode.editor.cn;//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3624 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    public String longestPalindrome(String s) {

        // 二维数组，元素值代表以索引为首尾的子字符串是否回文
        int[][] dp = new int[s.length()][s.length()];
        // 初始化所有长度为1的子字符串为回文字符串
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        char[] chars = s.toCharArray();

        int maxLen = 1;
        int begin = 0;
        // 枚举左边界
        for (int left = 0; left < s.length(); left++) {
            // 枚举子串长度
            for (int L = 2; L < s.length(); L++) {
                int right = left + L - 1;  // 右边界
                // 判断右边界是否到末尾
                if(right >= s.length()){
                    break;
                }

                if(chars[left] == chars[right]){  // 左 == 右
                    // 边界条件
                    if (L == 2){
                        dp[left][right] = 1;
                    }else {
                        dp[left][right] = dp[left + 1][right - 1];  // 从短向长动态规划
                        // 记录最大
                        if(L > maxLen){
                            maxLen = L;
                            begin = left;
                        }
                    }
                }else{  // 左 ！= 右
                    break;  // 当前长度已经不是回文，则更长的更不会是
                }
            }
            
        }

        return s.substring(begin, begin + maxLen - 1);
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("11234321111"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
