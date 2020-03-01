class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0,b=0;
        for(int item:nums) bitmask ^=item;
        int diff = bitmask &(-bitmask);
        for(int item:nums) if((diff&item)!=0)b^=item;
        return new int[]{b,bitmask^b};
    }
}