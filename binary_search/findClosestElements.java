class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0,right = arr.length;
        int current = 0;
        while(left < right){
            int mid = left + (right-left)/2;
            if(arr[mid] > x){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if(right==0) current = 0;
        else current = right>=arr.length?arr.length-1:Math.abs(arr[right-1]-x)<Math.abs(arr[right]-x)?right-1:right;

        left = right = current;
        
        while(right-left+1 < k){
            System.out.println(left+":" + right);
            if(left<=0) right++;
            else if(right>=arr.length-1) left--;
            else if(Math.abs(arr[left-1]-x)<=Math.abs(arr[right+1]-x)){
                left = left-1>=0?left-1:left;
            }else{
                right = right+1<arr.length?right+1:right;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int a:Arrays.copyOfRange(arr,left,right+1)){
            result.add(a);
        }
        return result;
    }
}


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length-k;
        while(left<right){
            int mid = (left+right)>>>1;
            if (x - arr[mid] > arr[mid+k] - x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());

    }
}