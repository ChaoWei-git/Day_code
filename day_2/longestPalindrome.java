class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty()) return s;
        int left = 0;
        int right = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = n-2;i>=0;i--){
            dp[i][i] = true;
            for(int j=i+1;j<n;j++){
                dp[i][j] = (s.charAt(i)==s.charAt(j))&&(j-i<3 ||dp[i+1][j-1]);
                if(dp[i][j]&&right-left<j-i){
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1);
    }
}