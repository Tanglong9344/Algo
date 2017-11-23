package search;

import java.util.Arrays;
import java.util.Random;

/**
 * ˳�����
 * �������
 * @author ����
 */
public class OrdinalSearch {
	final static int N = 100000;//������Ŀ
	final static int R = 10000;//���ݷ�Χ
	final static int CNT = 100;//��������
	public static void main(String[] args) {
		//��ʼ������
		int[] searchTable = new int[N+1];
		Random random = new Random();
		for(int i=1;i<N+1;i++){
			searchTable[i] = random.nextInt(R);
		}
		System.out.println("���ұ�"+Arrays.toString(searchTable));
		int key;//Ŀ������
		int pos;//����λ��
		int avg=0;//ƽ������ʱ��
		long start;//��ʼʱ��
		long end;//����ʱ��
		for(int i=0;i<CNT;i++){
			key = searchTable[random.nextInt(N+1)];
			start = System.nanoTime();//��¼��ʼʱ��
			pos = binarySearch(searchTable,key);
			end = System.nanoTime();//��¼����ʱ��
			avg+= end-start;
			if(0 == pos){
				System.out.println("δ�ҵ�Ŀ������"+key);
			}else{
				System.out.println("Ŀ������"+key+"�������е�λ����"+pos);
			}
		}
		System.out.println(CNT+"�β��ҵ�ƽ������ʱ�䣺"+avg/CNT+"����");
	}

	/**
	 * ��������㷨
	 * @param searchTable
	 * @param key
	 * @return ����Ŀ�������ڲ��ұ��е�λ��
	 */
	static int binarySearch(int[] searchTable,int key){
		int len = searchTable.length;
		int times = 0;
		for(int i=0;i<len;i++){
			times++;
			if(key == searchTable[i]){
				System.out.println("���Ҵ�����"+times);
				return i;//�ҵ�����
			}
		}
		System.out.println("���Ҵ�����"+times);
		return 0;//δ�ҵ�����
	}
}