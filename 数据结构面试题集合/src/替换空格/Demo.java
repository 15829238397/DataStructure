package 替换空格;

/**
 * 
 * 题目：请实现一个函数，将字符串中的每个空格替换成“%20”，例如输入“we are family”替换成“we%20are%20family”
 * 
 */

public class Demo {

	//思路一：
//	由于，转换后字符长度会变大，首先我们要确定，是否有足够的空间容纳转换后的数组。
//	确定有多少个空格。每个空格从原来的一位字符长度，变成3位字符长度。于是我们可以得到转换后的字符长度。
//	我们从数组的末尾开始转换。
//	设置计数器计算当前还有多少个空格未转换。
	public String demo1(String data) {
	
		int num = 0 ;
		int addLength = 0 ;
		
		//先对传入的data进行判空
		if( data == null || data.equals("") || data.length() == 0) {
			return null ;
		}
		
		//转换成char数组。
		char[] datas = data.toCharArray() ;
		
		//计算data中空格的数量
		for(int i = 0 ; i < datas.length ; i++) {
			if(datas[i] == ' ') {
				num ++ ;
			}
		}
		
		//计算需要新增的长度
		addLength = num*2 ;
		
		//新建目的字符数组。
		char[] datas1 = new char[addLength + datas.length];
		
		//从后向前遍历datas数组。进行转换
		int k = datas1.length-1 ;
		for(int j = datas.length-1 ; j >= 0 ; j-- ) {
			
			if(datas[j] == ' ') {
				datas1[k--] = '0' ;
				datas1[k--] = '2' ;
				datas1[k--] = '%' ;
			}else {
				datas1[k--] = datas[j] ;
			}
			
		}
		
		return String.valueOf(datas1) ;
		
	}
	
	public static void main(String[] args) {
		
		Demo demo = new Demo() ;
		
		String data = null ;
		
		System.out.println( demo.demo1("i love you") );
		System.out.println( demo.demo1("") );
		System.out.println( demo.demo1(" ") );
		System.out.println( demo.demo1("i   love you") );
		System.out.println( demo.demo1("   ") );
		System.out.println( demo.demo1(data) );
	}
	
}
