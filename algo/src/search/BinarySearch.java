package search;

import java.util.Arrays;
import java.util.Random;

/**
 * ���ֲ���
 * ֻ������˳��洢�ṹ��˳���
 * @author ����
 */
public class BinarySearch {
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
		//��С��������
		Arrays.sort(searchTable);
		System.out.println("���ұ���"+Arrays.toString(searchTable));
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
	 * ���ֲ����㷨
	 * @param searchTable
	 * @param key
	 * @return ����Ŀ�������ڲ��ұ��е�λ��
	 */
	static int binarySearch(int[] searchTable,int key){
		int low = 1;
		int high = searchTable.length-1;
		int mid;
		int times = 0;//ͳ�Ʋ��Ҵ���
		while(low<=high){
			times++;
			mid = (low + high)/2;
			if(key == searchTable[mid]){
				System.out.println("���Ҵ�����"+times);
				return mid;//�ҵ�����
			}else if(key < searchTable[mid]){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		System.out.println("���Ҵ�����"+times);
		return 0;//δ�ҵ�����
	}
}