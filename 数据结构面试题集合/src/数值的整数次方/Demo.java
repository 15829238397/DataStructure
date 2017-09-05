package 数值的整数次方;

/**
 * 
 * 求数值的整数次方
 *
 */
public class Demo {

	//思路一：
	//需要考虑到次方数的不同情况。当次方数为0;那么答案为1 ;当次方数为1;那么答案为base ;当base为0;那么答案为0 ;
	//我们的目标是获得一个数的exponent次方，那么如果exponent是个偶数，我们就可以先算出exponent/2次方的值然后平方。
	//如果是计数。我们可以得到exponent/2次方的值然后平方，然后乘上base。也就是
	//
	//a^n = a^(n/2) * a^(n/2)  (n为偶数)
	//a^n = a^(n/2) * a^(n/2) * a  (n为奇数)
	public static double power(double base , int exponent) {
		
		double result = 0 ;
		
		if(exponent < 0 ) {
			result = PowerWithUsignedExponent(base , (0-exponent)) ;
			result = 1 / result ;
		}else {
			result = PowerWithUsignedExponent(base , (exponent)) ;
		}
		
		return result ;
	}
	
	public static double PowerWithUsignedExponent(double base , int exponent) {
		
		if(base == 0) {
			return 0 ;
		}
		
		if( exponent == 0 ) {
			return 1 ;
		}
		
		if(exponent == 1) {
			return base ;
		}
		
		double result = PowerWithUsignedExponent(base , exponent>>1 ) ;
		result *= result ;
		if((exponent & 0x1) == 1) {
			result *= base ;
		}
		
		return result ;
	}
	
	public static void main(String[] args) {
		
		System.out.println(power(2,2));
		System.out.println(power(0,2));
		System.out.println(power(2,0));
		System.out.println(power(2,1));
		System.out.println(power(-2,2));
		System.out.println(power(2,-2));
		System.out.println(power(-2,-2));
		
	}
	
}
