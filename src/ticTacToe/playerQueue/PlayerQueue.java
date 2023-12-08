package playerQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/*
 * This class wasn't working so well, so I stopped working on it and used the JCF Queue
 */

/**
 * This class is intended to be used as a queue specifically intended to hold players for games.
 * As such, the queue's constructor comes with a parameter of the number of players which becomes the queue's capacity.
 * At all times, the queue cannot hold more elements than its capacity.
 * However, this capacity can be reset by calling the setNumPlayers() method.
 * @author R Nechamkin
 *
 * @param <T>
 */
public class PlayerQueue<T> implements Queue<T>{
	
	Object[] array;
	int tail;
	int size;
	int head;
	int capacity;

	public PlayerQueue(int numPlayers) {
		if (numPlayers <= 0)
			throw new IllegalArgumentException("This queue requires a game to have at least one player.");
		array = new Object[numPlayers];
		capacity = numPlayers;
		tail = 0;
		size = 0;
		head = 0;
	}
	
	/**
	 * Places an element on the queue.
	 * Following what I thought was common practice, I implemented this method in the method called add().
	 * @param element The element to be added
	 * @throws IllegalStateException if size is already equal to the total capacity
	 */
	public void enqueue(T element) {
		add(element);
	}
	
	/**
	 * Removes the head of the queue from the queue and returns it.
	 * Following what I thought was common practice, I implemented this method in the method called remove().
	 * @return the element which is currently the head of the queue
	 */
	public T dequeue() {
		return remove();
	}
	
	/**
	 * Returns, but does not remove the head of the queue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T peek() {
		if (isEmpty())
			throw new IllegalStateException("Queue is empty");
		
		return (T) array[head];
	}
	
	/**
	 * Returns true if the array is empty and false otherwise
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns the number of elements in the array
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns the maximum number of elements allowed in the array
	 * @return
	 */
	public int getNumPlayers() {
		return capacity;
	}
	
	/**
	 * Changes the number of elements allowed in the array
	 * @param numPlayers
	 * @throws IllegalStateException if numPlayers > the number of elements currently in the queue
	 */
	public void setNumPlayers(int numPlayers) {
		if (numPlayers < (head + size) % array.length)
			throw new IllegalStateException("There are more elements in the queue than the new capacity allows for.");
		
		capacity = numPlayers;

		Object[] newArray = new Object[numPlayers];		
		int index = 0;
		for (int i = head; i < head + size; i++) {
			newArray[index] = array[i % array.length];
		}
		
		head = 0;
		tail = index;
		
		array = newArray;
	}

	@Override
	public boolean contains(Object o) {
		for (int i = head; i < head + size; i++) {
			if (array[i % array.length].equals(o))
				return true;
		}

		return false;
	}

	/**
	 * I did not implement this method in my PlayerQueue class
	 * @throws RuntimeException if you try to call it on a PlayerQueue object
	 */
	@Override
	public Iterator<T> iterator() {
		throw new RuntimeException("Sorry, this method doesn't work for the class PlayerQueue");
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[size];		
		int index = 0;
		for (int i = head; i < head + size; i++) {
			result[index] = array[i % array.length];
		}
		
		return result;
	}
	
	/**
	 * I did not implement this method in my PlayerQueue class
	 * @throws RuntimeException if you try to call it on a PlayerQueue object
	 */
	@Override
	public Object[] toArray(Object[] a) {
		throw new RuntimeException("Sorry, this method doesn't work for the class PlayerQueue");
	}

	/**
	 * I did not implement this method in my PlayerQueue class
	 * @throws RuntimeException if you try to call it on a PlayerQueue object
	 */
	@Override
	public boolean remove(Object o) {
		throw new RuntimeException("Sorry, this method doesn't work for the class PlayerQueue");
	}

	@Override
	public boolean containsAll(Collection c) {
		for (Object o: c) {
			if (!contains(o))
				return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection c) {
		for (Object o: c) {
			add((T) o);
		}
		return true;
	}

	/**
	 * I did not implement this method in my PlayerQueue class
	 * @throws RuntimeException if you try to call it on a PlayerQueue object
	 */
	@Override
	public boolean removeAll(Collection c) {
		throw new RuntimeException("Sorry, this method doesn't work for the class PlayerQueue");
	}

	/**
	 * I did not implement this method in my PlayerQueue class
	 * @throws RuntimeException if you try to call it on a PlayerQueue object
	 */
	@Override
	public boolean retainAll(Collection c) {
		throw new RuntimeException("Sorry, this method doesn't work for the class PlayerQueue");
	}

	@Override
	public void clear() {
		for (int i = head; i < head + size; i++) {
			array[i % array.length] = null;
		}
	}

	@Override
	public boolean add(T e) {
		if (offer(e))
			return true;
		throw new IllegalStateException("You have already added the maximum number of players possible.");
	}

	@Override
	public boolean offer(T e) {
		if (size == capacity)
			return false;
		
		array[tail] = e;
		tail = (tail + 1) % capacity;
		size ++;
		return true;
	}

	@Override
	public T remove() {
		T element = poll();
		if (element == null)
			throw new IllegalStateException("Queue is empty");
			
		return element;
	}

	@Override
	public T poll() {
		if (isEmpty())
			return null;
		
		@SuppressWarnings("unchecked")
		T removed = (T) array[head];
		array[head] = null;
		
		head = (head + 1) % array.length;
		size --;
		return removed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T element() {
		if (isEmpty())
			throw new IllegalStateException("Queue is empty");
		
		return (T) array[head];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = head;
		for (; i < head + size -1; i++) {
			sb.append(array[i % array.length] + ",");
		}
		sb.append(array[i % array.length]);
		return sb.toString();
				
	}
	

}
