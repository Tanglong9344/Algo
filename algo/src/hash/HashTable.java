package hash;

import java.util.ArrayList;
import java.util.List;

import filter.PrimeNumber;

/**
 * 哈希表简单实现
 * @author 唐龙
 */
public final class HashTable{
	final static int HASH_SIZE = 500;//哈希表大小
	final static int DIVISOR = maxPrimNumber(HASH_SIZE );//除数
	private List<ArrayList<HashKV>> hash = new ArrayList<ArrayList<HashKV>>();//哈希表

	public HashTable(){
		//哈希表初始化
		for(int i=0;i<HASH_SIZE;i++){
			hash.add(new ArrayList<HashKV>());
		}
	}

	//根据HASH_SIZE获取最大质数
	private static int maxPrimNumber(int num){
		int n = num;
		while(!PrimeNumber.primeNumberJudge(n)){n--;}
		return n;
	}
	//哈希函数
	//除留余数法
	private int hash(String key){
		return key.hashCode()%DIVISOR;
	}

	//数据插入
	public boolean putValue(String key,String value){
		ArrayList<HashKV> datas = hash.get(hash(key));
		int pos = getPos(key);
		//根据哈希函数找到key对应的位置，插入键值对
		//如果key已经存在则更新数据
		if(-1 != pos){
			return datas.set(pos,new HashKV(key,value))==null?false:true;
		}
		return datas.add(new HashKV(key,value));
	}

	//数据获取
	public String getValue(String key){
		//根据哈希函数找到key对应的位置，获取键值对列表
		//如果key不存在，返回null
		ArrayList<HashKV> datas = hash.get(hash(key));
		int pos = getPos(key);
		if(-1 != pos){
			return datas.get(pos).value;
		}
		return null;
	}

	//查找键值对列表,获取key的位置
	private int getPos(String key){
		ArrayList<HashKV> datas = hash.get(hash(key));
		int len = datas.size();
		HashKV hashKV;
		//遍历键值对列表,查找key的位置
		//如果key不存在，返回-1
		for(int i=0;i<len;i++){
			hashKV = datas.get(i);
			if(key.equals(hashKV.key)){
				return i;
			}
		}
		return -1;
	}
}

/**
 * 键值对
 */
final class HashKV{
	String key;
	String value;

	public HashKV(){}

	public HashKV(String key,String value){
		this.key=key;
		this.value=value;
	}

	@Override
	public String toString(){
		return key+","+value;
	}
}