/*
 * Written by Isaac White
 */
public class MinHeap  <T extends Comparable<T>>
{
private T[] heap;
public static final int DEF_SIZE = 128;
private int lastIndex; // first null element
	
	public MinHeap()
	{
		init(DEF_SIZE);
	}
	public MinHeap(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		if(size>0)
			{
				heap = (T[])(new Comparable[size]);
				lastIndex = 0;
			}
		else
			init(DEF_SIZE);
	}
	public void add(T aData)
	{
		if(lastIndex >= heap.length) // means we have no empty spaces left in array, the heap
			return;
		heap[lastIndex] = aData;
		bubbleUp();
		lastIndex++;
	}
	private void bubbleUp()
	{
		int index = lastIndex;
		while(index > 0 && heap[(index-1)/2].compareTo(heap[index])>0) // if parent is greater than child
		{
			T temp = heap[(index-1)/2]; // temp = parent data
			heap[(index-1)/2] = heap[index]; // replaces parents data with child data
			heap[index] = temp; // replaces child data with parent data
			index = (index-1)/2; // changes index to parent index with the new data is they are swapped
		}
	}
	public T remove()
	{
		if(lastIndex == 0) // empty tree
			return null;
		T ret = heap[0]; // store root
		heap[0] = heap[lastIndex-1];
		heap[lastIndex-1] = null;
		lastIndex--;
		bubbleDown();
		return ret;
	}
	private void bubbleDown()
	{
		int index = 0;
		while(index*2+1 < lastIndex) // within bounds of tree
		{
			int smallIndex = index*2+1;
			if(index*2+2 < lastIndex && heap[index*2+1].compareTo(heap[index*2+2])>0)// left child is greater than right child
					smallIndex = index*2+2;
			if(heap[index].compareTo(heap[smallIndex])>0) // if heap at replace index is greater than heap at smallindex
			{
				T temp = heap[index];
				heap[index] = heap[smallIndex];
				heap[smallIndex] = temp;
			}
			else
				break;
			index = smallIndex;
		}
	}
	public void print()
	{
		for(T h : heap) // for each element (h) in the heap
		{
			if(h == null)
				break;
			System.out.println(h);
		}
	}
	public void heapSort(T[] array)
	{
		if(array == null)
			return;
		MinHeap<T> mHeap = new MinHeap<T>(array.length);
		for(int i = 0;i<array.length;i++) // add each array element to the heap
			mHeap.add(array[i]);
		for(int i=0;i<array.length;i++)
			array[i] = mHeap.remove();
	}
	public T peek()
	{
		T ret = heap[0];
		return ret;
	}
}

			
	

