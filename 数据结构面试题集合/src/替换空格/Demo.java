package �滻�ո�;

/**
 * 
 * ��Ŀ����ʵ��һ�����������ַ����е�ÿ���ո��滻�ɡ�%20�����������롰we are family���滻�ɡ�we%20are%20family��
 * 
 */

public class Demo {

	//˼·һ��
//	���ڣ�ת�����ַ����Ȼ�����������Ҫȷ�����Ƿ����㹻�Ŀռ�����ת��������顣
//	ȷ���ж��ٸ��ո�ÿ���ո��ԭ����һλ�ַ����ȣ����3λ�ַ����ȡ��������ǿ��Եõ�ת������ַ����ȡ�
//	���Ǵ������ĩβ��ʼת����
//	���ü��������㵱ǰ���ж��ٸ��ո�δת����
	public String demo1(String data) {
	
		int num = 0 ;
		int addLength = 0 ;
		
		//�ȶԴ����data�����п�
		if( data == null || data.equals("") || data.length() == 0) {
			return null ;
		}
		
		//ת����char���顣
		char[] datas = data.toCharArray() ;
		
		//����data�пո������
		for(int i = 0 ; i < datas.length ; i++) {
			if(datas[i] == ' ') {
				num ++ ;
			}
		}
		
		//������Ҫ�����ĳ���
		addLength = num*2 ;
		
		//�½�Ŀ���ַ����顣
		char[] datas1 = new char[addLength + datas.length];
		
		//�Ӻ���ǰ����datas���顣����ת��
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
