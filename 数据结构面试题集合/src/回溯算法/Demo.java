package �����㷨;

/**
 * 
 * ��ĿҪ��
 * 
 * ������һ����ά���飬Ԫ��Ϊ�ַ������ܷ��ڶ�ά�����еõ�һ��ͨ·���ӵ�Ԫ��Ϊ�������ַ�����
 *
 */
public class Demo {

	//˼·����1��
	//	���ǵ��͵Ļ����㷨����������Ҫ����һ�����λ����ȴ��boolean���͵����顣������ʾԪ���Ƿ�ռ�á�
	//	��������Ҫ�ҵ�һ��Ԫ�ص��ڸ����ַ�������λ�ַ���Ȼ��̽�������������Ƿ���ڸ����������һ��Ԫ�ء���û��ռ�á�
	//	�����ǵĺ����ͻ���ҵ��ĵ������������ȥ������������������ֹͣ������ǰ�ڵ���ĸ����춼�߲�ͨ����ô�ص���һ��
	//	������һ����������������⡣
	
	public static boolean hasPath (char[][] datas , String data) throws Exception {
		
		
		int rows ;
		int cols ;
		
		if(datas == null || datas.length == 0 || data == null || data.length() == 0) {
			throw new Exception("��ά����Ϊ�գ����Ϸ��Ĳ���") ;
		}
		
		rows = datas.length ;
		cols = datas[0].length ;
		
		visited = new boolean[rows][cols] ;
		pathlength = 0 ;
		
		for(int i = 0 ; i < rows ; i++ ) {
			for(int j = 0 ; j < cols ; j++) {
				
				if(hasPathCode(datas , rows , cols , i , j , data)) {
					return true ;
				}
			}
		}
		
		
		return false ;
	}
	
	static int pathlength ;
	static boolean[][] visited ;
	public static boolean hasPathCode(char[][] datas , int rows , int cols , int row , int col , String data ) {
		boolean hasPath = false;
		if(pathlength == data.length()) {
			return true ;
		}
		
		
		//����˵������������ô�������ܽ��м��
		if( 0 <= row && row < rows && 0 <= col && col < cols && data.charAt(pathlength) == datas[row][col] && !(visited[row][col]) ) {
			pathlength ++ ; 
			visited[row][col] = true ;
			
			//���������û�з���������·��
			hasPath = hasPathCode(datas , rows , cols , row+1 , col , data) 
					||hasPathCode(datas , rows , cols , row , col+1 , data)
					||hasPathCode(datas , rows , cols , row-1 , col , data)
					||hasPathCode(datas , rows , cols , row , col-1 , data) ;
			
			//��Ѱ��·
			if(!hasPath) {
				pathlength -- ;
				visited[row][col] = false ;
			}
			
		}
		
		return hasPath ;
	}
	
	//���Դ���
	public static void main(String[] args) {
		char[][] datas = {
							{'a','s','d','f'},
							{'z','x','c','v'},
							{'q','w','e','r'},
							{'z','x','c','v'}
							} ;
		
		char[][] datas1 = {
							{'a','a','a','a'},
							{'a','a','a','a'},
							{'a','a','a','a'},
							{'a','a','a','a'}
							} ;
		
		char[][] datas2 = {
							{'a','s','d','f'}
							} ;
		
		String data = "dcxwe" ;
		String data1 = "aaaaa" ;
		String data2 = "fds" ;
		
		try {
			System.out.println( hasPath(datas, data) );
			System.out.println("oooooooooooooooooooooooooooooooo");
			System.out.println( hasPath(datas1, data1) );
			System.out.println("oooooooooooooooooooooooooooooooo");
			System.out.println( hasPath(datas2, data2) );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
