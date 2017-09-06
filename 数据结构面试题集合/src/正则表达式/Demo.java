package 正则表达式;

/**
 * 题目要求：
 * 
 * 请实现一个函数用来匹配包含‘.’和‘*’的正则表达式，其中'.'表示一个任意字符，而‘*’表示上一个字符出现任意次。
 *
 */
public class Demo {

	//思路一：
//	检验正则表达式是否规范
//	首先，对比字符串和正则表达式的第一个字符是否相等，相等则向后推一位。
//	遇到.直接各进一位
//	当遇到*时,检测字符串的字符是否符合条件，若是直接循环跳过，完毕之后整个表达式跳过模板。
	
	public static boolean CheckRegular(char[] text , char[] regular) throws Exception {
		
		if(regular == null || regular[0] == '*') {
			throw new Exception("正则表达式为空，或者正则表达式不规范") ;
		}
		
		for(int j = 0 , i = 0 ; i < regular.length ; i ++) {
			
			System.out.println("匹配" + text[j] + "与" + regular[i]);
			//说明text已经对比结束但是regular还有值则
			if(j == text.length ) {
				
				if(regular[i] == '*') continue ;
				if(regular[i] != '*' && i+1<regular.length && regular[i+1] == '*') {
					i++ ;
					continue ;
				}
				
				return false ;
				
			}
			
			//字符串与正则表达式当前位置匹配
			if(regular[i] == text[j] || regular[i] == '.') {
				j++ ;
				continue ;
			}
			
			//此时说明字符串中已经有一个字符与‘*’之前的字符匹配
			if(regular[i] == '*') {
				while( j < text.length && text[j] == regular[i-1]) {
					j++ ;
				}
				continue ;
			}
			
			//如果当前值不匹配,此时应该检查是否后面有一个‘*’
			if(regular[i] != text[j]) {
				if(i+1 < regular.length && regular[i+1] == '*') {
					i++ ;
					continue ;
				}else {
					return false ;
				}
			}
			
		}
		
		return true ;
	}
	
	public static void main(String[] args) throws Exception {
		char[] text = {'a','a','b','c','s'} ;
		char[] regular = {'.' , 'a','*','b','c','.'} ;
		System.out.println(CheckRegular(text, regular));
		
		char[] text1 = {'a','a','a','a','s'} ;
		char[] regular1 = {'.' , 'a','*','b','*','.'} ;
		System.out.println(CheckRegular(text1, regular1));
		
		char[] text2 = {'a','a','a','a','s'} ;
		System.out.println(CheckRegular(text2, regular));
		
	}
	
}
