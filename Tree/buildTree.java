/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*int preStart = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null; 
        return construct(preorder,inorder,0,inorder.length-1);
    }
    private TreeNode construct(int[] preorder,int[] inorder,int inStart,int inEnd){
        if(preStart>=preorder.length || inStart>inEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int mid = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==preorder[preStart]) mid = i;
        }
        preStart++;
        node.left = construct(preorder,inorder,inStart,mid-1);
        node.right = construct(preorder,inorder,mid+1,inEnd);
        return node;
    }*/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || inorder.length==0 || preorder.length==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length==1) return root;
        int breakindex = -1;
        for(int i=0;i<inorder.length;i++) { if(inorder[i]==preorder[0]) { breakindex=i; break;} }
        int[] subleftpre  = Arrays.copyOfRange(preorder,1,breakindex+1);
        int[] subleftin   = Arrays.copyOfRange(inorder,0,breakindex);
        int[] subrightpre = Arrays.copyOfRange(preorder,breakindex+1,preorder.length);
        int[] subrightin  = Arrays.copyOfRange(inorder,breakindex+1,inorder.length);
        root.left  = buildTree(subleftpre,subleftin);
        root.right = buildTree(subrightpre,subrightin);
        return root;
    }

}