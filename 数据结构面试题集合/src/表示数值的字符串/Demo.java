package ��ʾ��ֵ���ַ���;

/**
 * 
 * ��Ŀ��
 * ��ʵ��һ�������������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ�����+100������5e2������-123������3.1416������-1E-16������ʾ��ֵ����
 * ��12e������1a3.14������1.2.3������+-5������12e+5.4�������ǡ�
 *
 */
public class Demo {

	//˼·һ��
//	��ʾ��ֵ���ַ�����ѭģʽA[.[B]][e|EC]����.B[e|EC]
//	����A��ʾ�������֣�B��ʾС������,C��ʾָ�����֡�
	
	public static boolean isNum(String text ) {
		
		char[] data = null ;
		int index = 0 ;
		if(text == null || text.length() == 0) {
			return false ;
		}
		
		data = text.toCharArray() ;
		
		//�Ƿ��з���λ���ڣ�����������
		if(data[0] == '+' || data[0] == '-') {
			index ++ ;
		}
		
		//����A�����Ƿ���ȷ
		while( index < data.length) {
			
			//�鿴�Ƿ�.��,�����ֱ��������
			if(data[index] == '.') {
				index++ ;
				break ;
			}
			
			//�鿴�Ƿ�e|E��,�����ֱ�����������ƶ��±���B���ֽ��д���
			if(data[index] == 'e' || data[index] == 'E') {
				break ;
			}
			
			if(data[index] >= '0' && data[index] <= '9') {
				index++ ;
				continue ;
			}
			
			return false ;
			
		}
		
		//����B�����Ƿ���ȷ	
		while( index < data.length) {
			
			//�鿴�Ƿ�e|E��,�����ֱ��������
			if(data[index] == 'e' || data[index] == 'E') {
				index++ ;
				break ;
			}
			
			if(data[index] >= '0' && data[index] <= '9') {
				index++ ;
				continue ;
			}
			
			return false ;
		}
		
		//�鿴c������û�������ţ����������
		if(index < data.length && (data[index] == '+' || data[index] == '-')) {
			index ++ ;
		}
		
		//����C�����Ƿ���ȷ
		while( index < data.length) {
			
			if(data[index] >= '0' && data[index] <= '9') {
				index++ ;
				continue ;
			}
			
			return false ;
		}
		
		return true ;
	}
	
	public static void main(String[] args) {
		
		String text1 = "+100" ;
		String text2 = "5e2" ;
		String text3 = "-1E-16" ;
		String text4 = "3.1416" ;
		String text5 = "1a3.14" ;
		String text6 = "+-5" ;
		String text7 = "1a3.14" ;
		
		System.out.println(isNum(text1));
		System.out.println(isNum(text2));
		System.out.println(isNum(text3));
		System.out.println(isNum(text4));
		System.out.println(isNum(text5));
		System.out.println(isNum(text6));
		System.out.println(isNum(text7));
		
	}
	
}
