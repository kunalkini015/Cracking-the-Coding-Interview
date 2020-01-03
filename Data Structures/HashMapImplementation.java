package crackingTheCodingInterview;

import java.util.*;
public class HashMapImplementation {
	LinkedList<Link> bucket[];
	int bucketLength=100;
	class Link{
		int key,value;
		
		Link(int key,int value)
		{
			this.key = key;
			this.value = value;
			
		}
	}
	HashMapImplementation()
	{
		bucket = new LinkedList[this.bucketLength];
		for(int i=0;i<100;i++)
			bucket[i] = new LinkedList<Link>();
	}
	
	
	void put(int key,int value)
	{
		int index = key % this.bucket.length;
		this.bucket[index].add(new Link(key,value));
	}
	
	int get(int key) throws NullPointerException
	{
		int index = key % this.bucketLength;
		LinkedList<Link> listOfNodes = this.bucket[index];
		boolean flag = false;
		int value=0;
		for(Link node:listOfNodes)
		{
			if(node.key == key)
				{
				flag = true;
				value =  node.value;
				break;
				}
		}
		if(flag == false)
			throw new NullPointerException("Key Error");
		else
			return value;
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		HashMapImplementation hm = new HashMapImplementation();
		
		// adding values
		hm.put(1,100);
		hm.put(2,200);
		
		// retrieving a valid key should return 100
		
		System.out.println(hm.get(1));
	
		
		System.out.println(hm.get(2));
		
		hm.put(3, 2000);
		System.out.println(hm.get(3));
		
		// retrieving an invalid key, should throw null pointer exception
		System.out.println(hm.get(4));
		

	}

}
