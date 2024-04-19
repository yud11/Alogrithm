package leetcode.tree;


import structure.TreeNode;

import java.util.HashMap;

/**
 * @autor yud1
 * @date 2024/4/17 15:49
 */
public class _105_buildTree {

    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            valToIndex.put(inorder[i], i);
        }
        return buildTree(preorder,inorder,0,n-1,0,n-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        // base case
        if (preStart > preEnd || inStart > inEnd) return null;
        if (preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        Integer index = valToIndex.get(root.val);
        root.left = buildTree(preorder, inorder,preStart+1,preStart + index - inStart,inStart, index -1);
        root.right = buildTree(preorder, inorder,preStart + index - inStart + 1,preEnd,index+1, inEnd);
        return root;
    }
}
