// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int len = nums.length;
//         // 特判
//         if (len <= 1) return len;
//         // dp 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
//         int[] dp = new int[len];
//         // 遍历第 1 个数，直接放在有序数组 dp 的开头
//         dp[0] = nums[0];
//         // end 表示有序数组 dp 的最后一个已经赋值元素的索引
//         int end = 0;
//         for (int i = 1; i < len; i++) {
//             // 【逻辑 1】比 dp 数组实际有效的末尾的那个元素还大
//             if (nums[i] > dp[end]) {
//                 dp[end++] = nums[i];
//             } else {
//                 // 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
//                 int left = 0, right = end+1;
//                 while (left < right) {
//                     int mid = left + (right - left) / 2;
//                     if (dp[mid] < nums[i]) left = mid + 1;
//                     else right = mid;
//                 }
//                 dp[right] = nums[i];
//             }
//         }
//         end++;
//         return end;
//     }
// }

//dp
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        for(int index=0;index<nums.length;index++) dp[index] = 1;
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    // break;
                }
            }
            max = Math.max(dp[i],max);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}

// 下面来看一种优化时间复杂度到 O(nlgn) 的解法，这里用到了二分查找法，所以才能加快运行时间哇。思路是，先建立一个数组 ends，
// 把首元素放进去，然后比较之后的元素，如果遍历到的新元素比 ends 数组中的首元素小的话，替换首元素为此新元素，
// 如果遍历到的新元素比 ends 数组中的末尾元素还大的话，将此新元素添加到 ends 数组末尾(注意不覆盖原末尾元素)。
// 如果遍历到的新元素比 ends 数组首元素大，比尾元素小时，此时用二分查找法找到第一个不小于此新元素的位置，覆盖掉位置的原来的数字，
// 以此类推直至遍历完整个 nums 数组，此时 ends 数组的长度就是要求的LIS的长度，特别注意的是 ends 数组的值可能不是一个真实的 LIS，
// 比如若输入数组 nums 为 {4, 2， 4， 5， 3， 7}，那么算完后的 ends 数组为 {2， 3， 5， 7}，可以发现它不是一个原数组的 LIS，
// 只是长度相等而已，千万要注意这点。参见代码如下：

// 解法二：

// 复制代码
// class Solution {
// public:
//     int lengthOfLIS(vector<int>& nums) {
//         if (nums.empty()) return 0;
//         vector<int> ends{nums[0]};
//         for (auto a : nums) {
//             if (a < ends[0]) ends[0] = a;
//             else if (a > ends.back()) ends.push_back(a);
//             else {
//                 int left = 0, right = ends.size();
//                 while (left < right) {
//                     int mid = left + (right - left) / 2;
//                     if (ends[mid] < a) left = mid + 1;
//                     else right = mid;
//                 }
//                 ends[right] = a;
//             }
//         }
//         return ends.size();
//     }
// };
