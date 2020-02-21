import java.util.Arrays;
import java.util.Stack;

class QuickSort{
    //递归版本
    public static void rQuickSort(int[] nums,int left,int right){
        if(left>=right) return ;
        int mid = partition(nums, left, right);
        //mid 取左侧，所以闭区间应该取到mid
        rQuickSort(nums, left, mid-1);
        rQuickSort(nums, mid+1, right);
    }
    //非递归版本
    public static void quickSort(int[] nums, int left, int right){
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while(!stack.isEmpty()){
            int r = stack.pop();
            int l = stack.pop();
            int mid = partition(nums, l, r);
            if(mid>l){
                stack.push(l);
                stack.push(mid-1);
            } 
            if(mid<r){
                stack.push(mid+1);
                stack.push(r);
            }
        }
    }
    public static int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int less = left;
        for(int i=left+1;i<=right;i++){
            if(nums[i]<pivot) swap(nums,i,++less);
        }
        swap(nums,left,less);
        return less;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,3,1,5,7};
        quickSort(test,0,test.length-1);
        System.out.println("Final array:");
        System.out.println(Arrays.toString(test));
    }
}