package 动态规划and贪心算法;

/**
 * 
 * 题目要求：
 * 给你一根长度为n的绳子，请把绳子剪成m段（m , n ）都是正整数，（n>1&m>1）
 * 每段绳子的长度为k[0],k[1],k[2],...,k[m]。请问k[0]*k[1]*k[2]*...*k[m]的最大值。
 * 例如绳子是长度为8，我们把它剪成的长度分别为2,3,3的三段，此时得到的最大的乘积是18。
 *
 */
public class Demo {

	//思路一：
	//动态规划。先从最低处开始计算乘积并将每个数可以剪切后得到的成绩最大值进行存储。
	//当计算后面的值的时候利用已经存储好的最大值，计算所有可能的结果并保留最大的。
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

	//贪心算法
	//这次我们来换一个思路，我们可以知道当(n>=5)时，存在(2*(n-2))>n和(3*(n-3))>n。
	//又因为当n>=5 时有 3*(n-3)>=2*(n-2)，所以我们应该尽量剪出3来得到最大值。
	//当长度为4时，2*2最大。
	//时间复杂度与空间复杂度都是O（1）
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
	
	//测试代码
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
