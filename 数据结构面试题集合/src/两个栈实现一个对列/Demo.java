package 两个栈实现一个对列;

import java.util.Stack;

/**
 * 题目要求：
 * 
 * 用两个栈实现一个队列。队列的声明如下：请实现他的两个功能
 * appenfTail 和deleteHead，分别完成在为节点添加和在队列头部删除功能
 */


public class Demo<T> {

	//题目分析：
//	定义两个stack，暂定为A栈 , B栈
//	当压入元素时，我们将元素都压入A栈。
//	当需要删除队列头元素时，我们可以将A栈的元素全部取出并压入B栈。
//	此时B栈中的栈顶元素就是最初压入的元素。要删除的话，抛出栈顶元素即可
//	所以我们在删除队尾，需要判断B栈为空，如果不为空那么直接抛出栈顶元素。
//	如果为空，将A栈元素一一抛出在压入B栈
	
	private Stack<T> appendStack = new Stack<T>() ;
	private Stack<T> deleteStack = new Stack<T>() ;
	
	public void appendfTail(T t) {
		
		appendStack.push(t) ;
		
	}
	
	public T deleteHead() throws Exception {
		
		if(deleteStack.isEmpty()) {
			while(!appendStack.isEmpty()) {
				deleteStack.push(appendStack.pop()) ;
			}
		}
		
		if(deleteStack.isEmpty()) {
			throw new Exception("队列为空 ， 不能删除") ;
		}
		
		return deleteStack.pop() ;
		
	}
	
	public static void main(String[] args) {
		
		Demo<String> demo = new Demo<>() ;
		
		demo.appendfTail("我");
		demo.appendfTail("爱");
		demo.appendfTail("学");
		demo.appendfTail("习");
		
		for(int i = 0 ; i < 4 ; i++) {
			
			try {
				System.out.println(demo.deleteHead());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("------------------------------------");
		
		try {
			System.out.println(demo.deleteHead());
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
			
	}
	
}
