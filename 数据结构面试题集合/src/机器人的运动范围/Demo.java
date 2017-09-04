package �����˵��˶���Χ;

/**
 * 
 * ��ĿҪ��
 * 
 * ������һ��m��n�еķ���һ�������˴����꣨0��0����λ�ÿ�ʼ�ƶ�����ÿ�ο��������ң��ϣ����ƶ�һ�񣬵����ܽ���
 * ����������������λ֮�ʹ���K�ĸ��ӡ����統k=18�������˿��Խ��뷽��Ϊ��35,37��,��Ϊ3+5+3+7 = 18 ; �����ܽ���(36,37)
 * �ĸ��ӣ���Ϊ3+6+3+7 = 19 > 18 ;���ʸû������ܹ�������ٸ����ӡ�
 *
 */

public class Demo {

	//��Ҳ��һ�����ݷ�����Ŀ��
	//�������ƶ�������������һ������������·�ƶ���������·����Ե�����ص���һ��·�ڣ�ֱ���������е�·��
	static boolean[][] visiter ;
	public static int getMaxCount(int rows , int cols , int k) throws Exception {
		int maxCount = 0 ;
		
		if(rows <= 0 || cols <= 0 ) {
			throw new Exception("�������Ϸ�") ;
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
	
	//�����Ե�ǰ����Ϊ�������ж��ٿ����ߵĸ���
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
	
	//��һ������λ��֮��
	public static int getDigitSum(int n) {
		
		int sum = 0 ;
		
		while(n > 0) {
			sum += n%10 ;
			n /= 10 ;
		}
		
		
		return sum ;
		
	}
	
	//���Դ���
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
