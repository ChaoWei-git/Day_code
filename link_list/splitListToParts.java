/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int count = 0;
        ListNode p = root;
        while(p!=null){
            count ++;
            p = p.next;
        }
        int split_number = count/k;
        p = root;
        ListNode cur_head = root,pre = null;
        int cur_count = 0,cur_list = 0;
        while(p!=null){
            pre = p;
            p = p.next;
            cur_count++;
            int sub = cur_list<count%k? 1:0;
            if(cur_count==(split_number + sub)){
                pre.next = null;
                result[cur_list++] = cur_head;
                cur_head = p;
                cur_count = 0;
            }
        }
        return result;


    }
}