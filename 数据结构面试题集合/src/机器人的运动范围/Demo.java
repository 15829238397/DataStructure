package 机器人的运动范围;

/**
 * 
 * 题目要求：
 * 
 * 地上有一个m行n列的方格，一个机器人从坐标（0，0）的位置开始移动，他每次可以向左，右，上，下移动一格，但不能进入
 * 行坐标与列坐标数位之和大于K的格子。例如当k=18，机器人可以进入方格为（35,37）,因为3+5+3+7 = 18 ; 而不能进入(36,37)
 * 的格子，因为3+6+3+7 = 19 > 18 ;请问该机器人能够到达多少个格子。
 *
 */

public class Demo {

	//这也是一个回溯法的题目。
	//机器人移动可以沿着任意一条符合条件的路移动，当遇到路径边缘，返回到上一个路口，直至走完所有的路。
	static boolean[][] visiter ;
	public static int getMaxCount(int rows , int cols , int k) throws Exception {
		int maxCount = 0 ;
		
		if(rows <= 0 || cols <= 0 ) {
			throw new Exception("参数不合法") ;
		}
		
		if( k < 0 ) {
			return maxCount ;
		}
		
		if(k == 0 ) {
			maxCount = 1 ;
			return maxCount ;
		}
		
		visiter = new boolean[rows][cols] ;
		
		return go(rows , cols , 0 , 0 ,k) ; 
		
	}
	
	//计算以当前格子为出发点有多少可以走的格子
	public static int go (int rows , int cols ,int row , int col, int k) {
		int count = 0 ;
		
		if( 0 <= row && row < rows && 0 <= col && col < cols && (getDigitSum(row)+getDigitSum(col)) <= k && !(visiter[row][col]) ) {
			visiter[row][col] = true ;
			
			count = 1 + go(rows, cols, row+1, col, k)
					+ go(rows, cols, row, col+1, k)
					+ go(rows, cols, row-1, col, k)
					+ go(rows, cols, row, col-1, k) ;
		}
		
		return count ;
	} 
	
	//求一个数字位数之和
	public static int getDigitSum(int n) {
		
		int sum = 0 ;
		
		while(n > 0) {
			sum += n%10 ;
			n /= 10 ;
		}
		
		
		return sum ;
		
	}
	
	//测试代码
	public static void main(String[] args) {
		
		try {
			System.out.println(getMaxCount(23, 35, 4));
			System.out.println("00000000000000000000000000000000000000");
			System.out.println(getMaxCount(23, 35, -1));
			System.out.println("00000000000000000000000000000000000000");
			System.out.println(getMaxCount(23, 35, 0));
			System.out.println("00000000000000000000000000000000000000");
			System.out.println(getMaxCount(23, 1, 4));
			System.out.println("00000000000000000000000000000000000000");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
