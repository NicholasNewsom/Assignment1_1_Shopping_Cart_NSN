
import java.util.Arrays;

public final class ResizableArrayBag<T> implements BagInterface<T>
{
	private T[] bag;
	private int numberOfEntries;
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	/** Creates an empty bag whose initial capacity is 25. */
	public ResizableArrayBag() 
	{
		this(DEFAULT_CAPACITY);
	}

	/** Creates an empty bag having a given initial capacity.
	    @param initialCapacity  The integer capacity desired. */
	public ResizableArrayBag(int initialCapacity)
	{
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempBag = (T[])new Object[initialCapacity]; // Unchecked cast
      bag = tempBag;
      numberOfEntries = 0;
      integrityOK = true;
	}

	/** Creates a bag containing given entries.
	    @param contents  An array of objects. */
   public ResizableArrayBag(T[] contents) 
   {
      checkCapacity(contents.length);
      bag = Arrays.copyOf(contents, contents.length);
      numberOfEntries = contents.length;
      integrityOK = true;
   }
       
	/** Adds a new entry to this bag.
       @param newEntry  The object to be added as a new entry.
       @return  True. */
	public boolean add(T newEntry)
	{
		checkintegrity();
      if (isArrayFull())
      {
         doubleCapacity();
      } // end if
      
      bag[numberOfEntries] = newEntry;
      numberOfEntries++;
      
      return true;
	} // end add

	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray() 
	{
		checkintegrity();
      
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = bag[index];
      }
      
      return result;
	}
   
	/** Sees whether this bag is empty.
       @return  True if this bag is empty, or false if not. */
	public boolean isEmpty()
	{
      return numberOfEntries == 0;
	}
   
	/** Gets the current number of entries in this bag.
       @return  The integer number of entries currently in this bag. */
	public int getCurrentSize()
	{
      return numberOfEntries;
	}
   
	/** Counts the number of times a given entry appears in this bag.
       @param anEntry  The entry to be counted.
       @return  The number of times anEntry appears in this ba. */
	public int getFrequencyOf(T anEntry)
	{
		checkintegrity();
      int counter = 0;
      
      for (int index = 0; index < numberOfEntries; index++)
      {
         if (anEntry.equals(bag[index]))
         {
            counter++;
         }
      } 
      
      return counter;
	} 
   
	/** Tests whether this bag contains a given entry.
       @param anEntry  The entry to locate.
       @return  True if this bag contains anEntry, or false otherwise. */
   public boolean contains(T anEntry)
	{
		checkintegrity();
      return getIndexOf(anEntry) > -1; // or >= 0
	}
   
	/** Removes all entries from this bag. */
	public void clear()
	{
      while (!isEmpty())
         remove();
	} 
	
	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal
       was successful, or null. */
	public T remove()
	{
		checkintegrity();
      T result = removeEntry(numberOfEntries - 1);
      return result;
	} 
	
	/** Removes one occurrence of a given entry from this bag.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
	public boolean remove(T anEntry)
	{
		checkintegrity();
      int index = getIndexOf(anEntry);
      T result = removeEntry(index);
      return anEntry.equals(result);
	} 
   
 	/** Locates a given entry within the array bag.
	 *Returns the index of the entry, if located,
	 *or -1 otherwise.
     *Precondition: checkintegrity has been called.*/
	 private int getIndexOf(T anEntry)
	{
		int where = -1;
		boolean found = false;
		int index = 0;
      
      while (!found && (index < numberOfEntries))
		{
			if (anEntry.equals(bag[index]))
			{
				found = true;
				where = index;
			}
         index++;
		} 
      
      /** Assertion: If where > -1, anEntry is in the array bag, and it
       *equals bag[where]; otherwise, anEntry is not in the array.*/
      
		return where;
	}
   
   /** Removes and returns the entry at a given index within the array.
    *If no such entry exists, returns null.
    * Precondition: 0 <= givenIndex < numberOfEntries.
    * Precondition: checkintegrity has been called.*/
	private T removeEntry(int givenIndex)
	{
		T result = null;
      
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = bag[givenIndex];          
         int lastIndex = numberOfEntries - 1;
         bag[givenIndex] = bag[lastIndex];  
         bag[lastIndex] = null;            
         numberOfEntries--;
		}
      
      return result;
	} 
   
   /** checks if array is full
    * 
    * @returnReturns true if the array bag is full, or false if not.
    */
	private boolean isArrayFull()
	{
		return numberOfEntries >= bag.length;
	} 
   
   /**
    *  Doubles the size of the array bag.
    *   Precondition: checkInitialization has been called.
    */
	private void doubleCapacity()
	{
      int newLength = 2 * bag.length;
      checkCapacity(newLength);
      bag = Arrays.copyOf(bag, newLength);
	}
   
   /**
    *  Throws an exception if the client requests a capacity that is too large.
    * @param capacity
    */
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                                         "allowed maximum of " + MAX_CAPACITY);
   }
   
   /**
    *  Throws an exception if receiving object is not initialized.
    */
   private void checkintegrity()
   {
      if (!integrityOK)
         throw new SecurityException ("ArrayBag object is corrupt.");
   }
}
