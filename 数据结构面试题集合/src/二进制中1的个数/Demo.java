package 二进制中1的个数;

/**
 * 
 * 输入一个整数，输出该数二进制表示中1的个数，例如：把9表示成二进制是1001，那么函数输出2
 *
 */
public class Demo {

	//思路一：
	//除非n==0;那么二进制表示中必然存在1。
	//我们可以发现当我们给一个整数-1时，这个整数二进制表示中最右面的1将变为0，而其右边如果有0将全变为1；
	//此时我们将(n-1) & n ，可以直接消除掉最右面的1。
	//重复至n==0，循环次数即为1的个数。
	public static int getNumOfOne(int n) {
		
		int num = 0 ;
		
		while(n!=0) {
			num ++ ;
			n = (n-1) & n ;
		}
		
		return num ;
	}
	
	//测试代码
	public static void main(String[] args) {
		System.out.println(getNumOfOne(9));
		System.out.println(getNumOfOne(1));
		System.out.println(getNumOfOne(0x7fffffff));
		System.out.println(getNumOfOne(0xffffffff));
		System.out.println(getNumOfOne(0x80000000));
		System.out.println(getNumOfOne(0));
		System.out.println(getNumOfOne(-5));
	}
	
}
