package ������ʽ;

/**
 * ��ĿҪ��
 * 
 * ��ʵ��һ����������ƥ�������.���͡�*����������ʽ������'.'��ʾһ�������ַ�������*����ʾ��һ���ַ���������Ρ�
 *
 */
public class Demo {

	//˼·һ��
//	����������ʽ�Ƿ�淶
//	���ȣ��Ա��ַ�����������ʽ�ĵ�һ���ַ��Ƿ���ȣ�����������һλ��
//	����.ֱ�Ӹ���һλ
//	������*ʱ,����ַ������ַ��Ƿ��������������ֱ��ѭ�����������֮���������ʽ����ģ�塣
	
	public static boolean CheckRegular(char[] text , char[] regular) throws Exception {
		
		if(regular == null || regular[0] == '*') {
			throw new Exception("������ʽΪ�գ�����������ʽ���淶") ;
		}
		
		for(int j = 0 , i = 0 ; i < regular.length ; i ++) {
			
			System.out.println("ƥ��" + text[j] + "��" + regular[i]);
			//˵��text�Ѿ��ԱȽ�������regular����ֵ��
			if(j == text.length ) {
				
				if(regular[i] == '*') continue ;
				if(regular[i] != '*' && i+1<regular.length && regular[i+1] == '*') {
					i++ ;
					continue ;
				}
				
				return false ;
				
			}
			
			//�ַ�����������ʽ��ǰλ��ƥ��
			if(regular[i] == text[j] || regular[i] == '.') {
				j++ ;
				continue ;
			}
			
			//��ʱ˵���ַ������Ѿ���һ���ַ��롮*��֮ǰ���ַ�ƥ��
			if(regular[i] == '*') {
				while( j < text.length && text[j] == regular[i-1]) {
					j++ ;
				}
				continue ;
			}
			
			//�����ǰֵ��ƥ��,��ʱӦ�ü���Ƿ������һ����*��
			if(regular[i] != text[j]) {
				if(i+1 < regular.length && regular[i+1] == '*') {
					i++ ;
					continue ;
				}else {
					return false ;
				}
			}
			
		}
		
		return true ;
	}
	
	public static void main(String[] args) throws Exception {
		char[] text = {'a','a','b','c','s'} ;
		char[] regular = {'.' , 'a','*','b','c','.'} ;
		System.out.println(CheckRegular(text, regular));
		
		char[] text1 = {'a','a','a','a','s'} ;
		char[] regular1 = {'.' , 'a','*','b','*','.'} ;
		System.out.println(CheckRegular(text1, regular1));
		
		char[] text2 = {'a','a','a','a','s'} ;
		System.out.println(CheckRegular(text2, regular));
		
	}
	
}
