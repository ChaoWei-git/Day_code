class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]<nums[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    
}

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==0) return -1;
        if(nums.length==1) return 0;
        return search(nums,0,nums.length-1);
    }
    private int search(int[] nums,int left,int right){
        if(left>right) return -1; 
        int mid = left + (right-left)/2;
        System.out.println("mid:"+mid);
        if(mid>0 && mid <nums.length-1&& nums[mid]>nums[mid-1]&& nums[mid]>nums[mid+1]){
                return mid;
        }else if (mid==0 && nums[mid]>nums[mid+1]){
                return mid;
        }else if (mid==nums.length-1 && nums[mid]>nums[mid-1]){
                return mid;
        }
        int left_index = search(nums,left,mid-1);
        if(left_index!=-1) return left_index;
        int right_index = search(nums,mid+1,right);
        if(right_index!=-1) return right_index;
        return -1;
    }
}