package hash;

/**
 * HashTabl测试
 * @author 唐龙
 */
public class HashTableTest {
	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		//数据存储
		hashTable.putValue("Hello","HashTable");
		hashTable.putValue("null","I am null");
		hashTable.putValue("123","abc");
		//数据获取
		System.out.println(hashTable.getValue("Hello"));
		System.out.println(hashTable.getValue("null"));
		System.out.println(hashTable.getValue("123"));

		//相同key的数据存储
		hashTable.putValue("Hello","哈希表");
		System.out.println(hashTable.getValue("Hello"));
	}
}