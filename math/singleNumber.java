class Solution {
    public int singleNumber(int[] nums) {
        int x1=0,x2=0,mask=0;
        for(int item:nums){
            x2 = x2^(x1&item);
            x1 = x1^item;
            mask = ~(x1&x2);
            x2 &= mask;
            x1 &= mask; 
        }
        return x1;
    }
}