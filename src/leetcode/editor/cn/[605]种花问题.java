package leetcode.editor.cn;//假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
//
// 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
//的情况下种入 n 朵花？能则返回 true ，不能则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 1
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= flowerbed.length <= 2 * 104 
// flowerbed[i] 为 0 或 1 
// flowerbed 中不存在相邻的两朵花 
// 0 <= n <= flowerbed.length 
// 
// Related Topics 贪心算法 数组 
// 👍 344 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        boolean res = s.canPlaceFlowers(new int[]{1,0,0,0,1} ,2);
        System.out.println(res);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int zeroNum = 1;  // 0索引位置的左边可以视作没有种花
        int flowerNum = 0;
        for (int bed:
             flowerbed) {
            if (bed == 0){
                zeroNum++;  // 连0的个数加1
            }else{  // 遇到1
                flowerNum += (zeroNum-1) / 2;  // count个连0：可种 (count-1)/2 朵
                if (flowerNum >= n)
                    return true;
                else{
                    zeroNum = 0;  // 开始计算下一个连0的个数
                }
            }
        }
        zeroNum++; // 索引最后一位的右边可以视作没有种花
        flowerNum += (zeroNum-1) / 2;
        return flowerNum >= n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
