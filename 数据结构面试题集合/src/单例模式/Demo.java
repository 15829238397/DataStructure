package ����ģʽ;

/**
 * 
 * ʵ�ּ򵥵ĵ���ģʽ
 * 
 */
public class Demo {

	
	/**
	 *	����ʽ����ģʽ��
	 *	
	 */
	static class Demo1 {
		
		public static final Demo1 instance = new Demo1();
		
		private Demo1() {
		}
		
		public static Demo1 getInstance() {
			return instance ;
		} 
		
	}
	
	
	/**
	 * 
	 * ����ʽ����ģʽ
	 *
	 */
	static class Demo2 {
		
		public static Demo2 instance = null ;
		
		private Demo2() {
		}
		
		public static Demo2 getInstance() {
			
			if(instance == null) {
				instance = new Demo2() ;
			}
			
			return instance ;
		} 
		
	}
	
	
}
