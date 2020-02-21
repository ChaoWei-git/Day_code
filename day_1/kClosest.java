import java.net.PortUnreachableException;
import java.util.PriorityQueue;

// class Solution {
//     public int[][] kClosest(int[][] points, int K) {
//         Arrays.sort(points,new Comparator<int[]>() {
//             @Override
//             public int compare(int[] x, int[] y) {
//                 // int[] one = (int[])x;
//                 // int[] two = (int[])y;
//                 if(one[0]*one[0]+one[1]*one[1] < two[0]*two[0]+two[1]*two[1]){
//                     return 1;
//                 } else if(one[0]*one[0]+one[1]*one[1] > two[0]*two[0]+two[1]*two[1]){
//                     return -1;
//                 } else {
//                     return 0;
//                 }
//             }
//         });
//         return Arrays.copyOfRange(points, 0, K);
//     }
// }

// class Solution {
//     public int[][] kClosest(int[][] points, int K) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
//         for(int[] item:points){
//             pq.offer(item);
//             if(pq.size()>K) pq.poll();
//         }
//         int[][] res = new int[K][2];
//         while(K>0){
//             res[--K]=pq.poll();
//         }
//         return res;
//     }
// }

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int left=0,right=points.length-1,len =points.length;
        while(left<=right){
            int mid = patition(points,left,right);
            if(mid==K) break;
            else if(mid<K) left = mid+1;
            else right = mid-1;
        }
        return Arrays.copyOfRange(points,0,K);
    }
    //partition
    private int patition(int[][] points,int left,int right){
        int[] piovt  = points[left];
        while(left<right){
            while(left<right && compare(points[right],piovt)>=0)right--;
            points[left] = points[right];
            while(left<right && compare(points[left],piovt)<=0)left++;
            points[right] = points[left];
        }
        points[left]=piovt;
        return left;
    }
    private int compare(int[] p1,int[] p2){
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}