package com.codekerdos.dp;

public class BinaryTreeCameras {

    private int cameras=0;
    private static final int COVERED = 0;
    private static final int HAS_CAMERA = 1;
    private static final int NEEDS_COVERAGE = 2;

    public int findCameras(TreeNode root){

        cameras = 0;
        if(dfs(root)==NEEDS_COVERAGE){
            cameras++;
        }

        return cameras;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return COVERED;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if(left == NEEDS_COVERAGE || right == NEEDS_COVERAGE){
            cameras++;
            return HAS_CAMERA;
        }else if(left == HAS_CAMERA || right == HAS_CAMERA){
            return COVERED;
        }else{
            return NEEDS_COVERAGE;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
 }

}
