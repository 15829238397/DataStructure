package 回溯算法;

/**
 * 
 * 题目要求：
 * 
 * 现在有一个二维数组，元素为字符。求能否在二维数组中得到一条通路连接的元素为给定的字符串。
 *
 */
public class Demo {

	//思路分析1：
	//	这是典型的回溯算法。首先我们要定义一个与二位数组等大的boolean类型的数组。用来表示元素是否被占用。
	//	首先我们要找到一个元素等于给定字符串的首位字符，然后探索其上下左右是否等于给定数组的下一个元素。并没被占用。
	//	则，我们的函数就会从找到的点向四周延伸出去，遇到不符合条件则停止，当当前节点的四个延伸都走不通，那么回到上一步
	//	，对下一个符合条件的做检测。
	
	public static boolean hasPath (char[][] datas , String data) throws Exception {
		
		
		int rows ;
		int cols ;
		
		if(datas == null || datas.length == 0 || data == null || data.length() == 0) {
			throw new Exception("二维数组为空，不合法的参数") ;
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
		
		
		//如果此点符合条件，那么对其四周进行检测
		if( 0 <= row && row < rows && 0 <= col && col < cols && data.charAt(pathlength) == datas[row][col] && !(visited[row][col]) ) {
			pathlength ++ ; 
			visited[row][col] = true ;
			
			//检查四周有没有符合条件的路。
			hasPath = hasPathCode(datas , rows , cols , row+1 , col , data) 
					||hasPathCode(datas , rows , cols , row , col+1 , data)
					||hasPathCode(datas , rows , cols , row-1 , col , data)
					||hasPathCode(datas , rows , cols , row , col-1 , data) ;
			
			//另寻他路
			if(!hasPath) {
				pathlength -- ;
				visited[row][col] = false ;
			}
			
		}
		
		return hasPath ;
	}
	
	//测试代码
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
