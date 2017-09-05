package ��̬�滮and̰���㷨;

/**
 * 
 * ��ĿҪ��
 * ����һ������Ϊn�����ӣ�������Ӽ���m�Σ�m , n ����������������n>1&m>1��
 * ÿ�����ӵĳ���Ϊk[0],k[1],k[2],...,k[m]������k[0]*k[1]*k[2]*...*k[m]�����ֵ��
 * ���������ǳ���Ϊ8�����ǰ������ɵĳ��ȷֱ�Ϊ2,3,3�����Σ���ʱ�õ������ĳ˻���18��
 *
 */
public class Demo {

	//˼·һ��
	//��̬�滮���ȴ���ʹ���ʼ����˻�����ÿ�������Լ��к�õ��ĳɼ����ֵ���д洢��
	//����������ֵ��ʱ�������Ѿ��洢�õ����ֵ���������п��ܵĽ�����������ġ�
	public static int getMaxResult(int length) {
		
		int[] res = null ;
		int max = 0 ;
		
		if(length < 2 ) {
			return 0 ;
		}
		
		if(length == 2) {
			return 1 ;
		}
		
		if(length == 3) {
			return 2 ;
		}
		
		res = new int[length+1] ;
		res[0] = 0 ;
		res[1] = 1 ;
		res[2] = 2 ;
		res[3] = 3 ;
		
		for(int i = 4 ; i <= length ; i ++) {
			max = 0 ;
			for(int j = 1 ; j <= i/2 ; j++) {
				
				int r = res[j] * res[i-j] ;
				
				if(max < r) {
					max = r ;
					res[i] =max ;
				}
				
			}
			
		}
		
		max = res[length] ;

		return max ;
		
	}

	//̰���㷨
	//�����������һ��˼·�����ǿ���֪����(n>=5)ʱ������(2*(n-2))>n��(3*(n-3))>n��
	//����Ϊ��n>=5 ʱ�� 3*(n-3)>=2*(n-2)����������Ӧ�þ�������3���õ����ֵ��
	//������Ϊ4ʱ��2*2���
	//ʱ�临�Ӷ���ռ临�Ӷȶ���O��1��
	public static int getMaxResult1 (int length) {
		
		if(length < 2 ) {
			return 0 ;
		}
		
		if(length == 2) {
			return 1 ;
		}
		
		if(length == 3) {
			return 2 ;
		}
		
		int timesOf3 = length/3 ;
		if(length - timesOf3*3 == 1) {
			timesOf3 -= 1 ;
		}
		
		int timesOf2 = (length - timesOf3*3)/2 ;
		
		return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2)) ;
	}
	
	//���Դ���
	public static void main(String[] args) {
		
		long curTime = System.nanoTime() ;
		
		System.out.println(getMaxResult(1));
		System.out.println(getMaxResult(3));
		System.out.println(getMaxResult(8));
		System.out.println(getMaxResult(50));
		System.out.println(System.nanoTime() - curTime);
		System.out.println("**************************************************");
		curTime = System.nanoTime() ;
		System.out.println(getMaxResult1(1));
		System.out.println(getMaxResult1(3));
		System.out.println(getMaxResult1(8));
		System.out.println(getMaxResult1(50));
		System.out.println(System.nanoTime() - curTime);
		
		
	}
	
	
}
