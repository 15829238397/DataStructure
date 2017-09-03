package 重建二叉树;

import java.util.Arrays;

/**
 * 
 * 输入二叉树的前序遍历和中序遍历结果，重建二叉树，假设前序和中序遍历中都不含有重复的数字，
 * 例如输入的前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}重建出二叉树。
 * 
 */
public class Demo {

	//思路一：
//	对先序与中序进行分析
//	先序：1,2,4,7,3,5,6,8
//	中序：4,7,2,1,5,3,8,6
//	通过上面的先序序列，我们可以确定根节点的值为1
//	通过中序序列我们可以知道，4,7,2属于左子树5,3,8,6属于右字树
//	同样的方法我们可以得到左右字树当成一个整体去逐步构造。
	
	public static BinaryTreeNode constructCore(int[] preOrder , int[] inOrder) throws Exception {
		
		if(preOrder == null || inOrder == null) {
			return null ;
		}
		
		if(preOrder.length != inOrder.length) {
			throw new Exception("长度不一样 ， 非法的输入") ;
		}
		
		BinaryTreeNode root = new BinaryTreeNode() ;
		
		for(int i = 0 ; i < preOrder.length ; i++) {
			
			if(inOrder[i] == preOrder[0]) {
				root.data = inOrder[i] ;
				
				System.out.println(root.getData());
				
				root.left = constructCore(Arrays.copyOfRange(preOrder, 1, 1+i) ,
						Arrays.copyOfRange(inOrder, 0, i)) ;
				root.right = constructCore(Arrays.copyOfRange(preOrder, i+1, preOrder.length) ,
						Arrays.copyOfRange(inOrder, i, inOrder.length)) ;
			}
			
		}
		
		return root ;
		
	}
	
	//测试代码
	public static void main(String[] args) {
		
		int[] preOrder = {1,2,4,7,3,5,6,8} ;
		int[] inOrder = {4,7,2,1,5,3,8,6} ;
		
		try {
			BinaryTreeNode root = constructCore(preOrder, inOrder) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class BinaryTreeNode{
		
		private BinaryTreeNode left ;
		private BinaryTreeNode right ;
		private Object data ;
		
		public BinaryTreeNode getLeft() {
			return left;
		}
		public void setLeft(BinaryTreeNode left) {
			this.left = left;
		}
		public BinaryTreeNode getRight() {
			return right;
		}
		public void setRight(BinaryTreeNode right) {
			this.right = right;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		
		
		
	}
	
}
