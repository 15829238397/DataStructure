package �ؽ�������;

import java.util.Arrays;

/**
 * 
 * �����������ǰ��������������������ؽ�������������ǰ�����������ж��������ظ������֣�
 * ���������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�ؽ�����������
 * 
 */
public class Demo {

	//˼·һ��
//	��������������з���
//	����1,2,4,7,3,5,6,8
//	����4,7,2,1,5,3,8,6
//	ͨ��������������У����ǿ���ȷ�����ڵ��ֵΪ1
//	ͨ�������������ǿ���֪����4,7,2����������5,3,8,6����������
//	ͬ���ķ������ǿ��Եõ�������������һ������ȥ�𲽹��졣
	
	public static BinaryTreeNode constructCore(int[] preOrder , int[] inOrder) throws Exception {
		
		if(preOrder == null || inOrder == null) {
			return null ;
		}
		
		if(preOrder.length != inOrder.length) {
			throw new Exception("���Ȳ�һ�� �� �Ƿ�������") ;
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
	
	//���Դ���
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
