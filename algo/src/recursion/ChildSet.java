package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * ʹ�õݹ�Ͷ�������һ�����ϵ������Ӽ�
 * ���ϵ�ÿ��Ԫ��������״̬��
 * 1.�����Ӽ�
 * 2.�������Ӽ�
 * ����һ��Ԫ����ĿΪn�ļ������Ӽ�����Ϊ2^n
 * @author ����
 */
public class ChildSet {
	final static int N = 5;//����Ԫ����Ŀ
	public static void main(String[] args) {
		List<String> set = new ArrayList<String>();
		//��ʼ��
		for(int i=0;i<N;i++){
			set.add("E"+i);
		}
		System.out.println("����:\n"+set);
		List<String> setResult = new ArrayList<String>();
		System.out.println("���ϵ������Ӽ�:");
		getChildSet(set,setResult,0);
	}

	/**
	 * �����Ӽ������
	 * @param set ����⼯��
	 * @param setResult �Ӽ����
	 * @param pos
	 */
	static <T> void getChildSet(List<T> set,List<T> setResult,int pos){
		T x;
		if(pos>=set.size()){
			System.out.println(setResult);
		}else{
			x = (T) set.get(pos);
			//ѡ��Ԫ��
			setResult.add(x);
			getChildSet(set,setResult,pos+1);
			//��ѡ��Ԫ��
			setResult.remove(x);
			getChildSet(set,setResult,pos+1);
		}
	}
}