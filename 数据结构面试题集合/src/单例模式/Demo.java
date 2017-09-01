package 单例模式;

/**
 * 
 * 实现简单的单例模式
 * 
 */
public class Demo {

	
	/**
	 *	饿汉式单例模式：
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
	 * 懒汉式单例模式
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
