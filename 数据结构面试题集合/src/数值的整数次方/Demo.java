package ��ֵ�������η�;

/**
 * 
 * ����ֵ�������η�
 *
 */
public class Demo {

	//˼·һ��
	//��Ҫ���ǵ��η����Ĳ�ͬ��������η���Ϊ0;��ô��Ϊ1 ;���η���Ϊ1;��ô��Ϊbase ;��baseΪ0;��ô��Ϊ0 ;
	//���ǵ�Ŀ���ǻ��һ������exponent�η�����ô���exponent�Ǹ�ż�������ǾͿ��������exponent/2�η���ֵȻ��ƽ����
	//����Ǽ��������ǿ��Եõ�exponent/2�η���ֵȻ��ƽ����Ȼ�����base��Ҳ����
	//
	//a^n = a^(n/2) * a^(n/2)  (nΪż��)
	//a^n = a^(n/2) * a^(n/2) * a  (nΪ����)
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
