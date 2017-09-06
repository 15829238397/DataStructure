package 表示数值的字符串;

/**
 * 
 * 题目：
 * 请实现一个函数，用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但
 * “12e”、“1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是。
 *
 */
public class Demo {

	//思路一：
//	表示数值的字符串遵循模式A[.[B]][e|EC]或者.B[e|EC]
//	其中A表示整数部分，B表示小数部分,C表示指数部分。
	
	public static boolean isNum(String text ) {
		
		char[] data = null ;
		int index = 0 ;
		if(text == null || text.length() == 0) {
			return false ;
		}
		
		data = text.toCharArray() ;
		
		//是否有符号位存在，存在则跳过
		if(data[0] == '+' || data[0] == '-') {
			index ++ ;
		}
		
		//解析A部分是否正确
		while( index < data.length) {
			
			//查看是否“.”,如果是直接跳出。
			if(data[index] == '.') {
				index++ ;
				break ;
			}
			
			//查看是否“e|E”,如果是直接跳出，不移动下标在B部分进行处理。
			if(data[index] == 'e' || data[index] == 'E') {
				break ;
			}
			
			if(data[index] >= '0' && data[index] <= '9') {
				index++ ;
				continue ;
			}
			
			return false ;
			
		}
		
		//解析B部分是否正确	
		while( index < data.length) {
			
			//查看是否“e|E”,如果是直接跳出。
			if(data[index] == 'e' || data[index] == 'E') {
				index++ ;
				break ;
			}
			
			if(data[index] >= '0' && data[index] <= '9') {
				index++ ;
				continue ;
			}
			
			return false ;
		}
		
		//查看c部分有没有正负号，如果有跳过
		if(index < data.length && (data[index] == '+' || data[index] == '-')) {
			index ++ ;
		}
		
		//解析C部分是否正确
		while( index < data.length) {
			
			if(data[index] >= '0' && data[index] <= '9') {
				index++ ;
				continue ;
			}
			
			return false ;
		}
		
		return true ;
	}
	
	public static void main(String[] args) {
		
		String text1 = "+100" ;
		String text2 = "5e2" ;
		String text3 = "-1E-16" ;
		String text4 = "3.1416" ;
		String text5 = "1a3.14" ;
		String text6 = "+-5" ;
		String text7 = "1a3.14" ;
		
		System.out.println(isNum(text1));
		System.out.println(isNum(text2));
		System.out.println(isNum(text3));
		System.out.println(isNum(text4));
		System.out.println(isNum(text5));
		System.out.println(isNum(text6));
		System.out.println(isNum(text7));
		
	}
	
}
