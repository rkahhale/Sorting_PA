/**
 * CSE 12 Program 4
 * Name: Rateb Kahhaleh
 * PID: A14252334
 * Login: cs12sgg
 */

// TODO: Properly COMMENT with javadoc
import java.lang.*;
import java.util.List;
import java.util.ArrayList;

/**
 * A class that implements merge sort for a lists of Comparabeles
 * @author Rateb Kahhaleh
 */
public class Merge12 implements Sort12
{   
    /**
     * sort(List<T> list)
     * Purpose: throws a NullPointerException if the list is null.
     * Otherwise, it calls internalMergeSort then clears the list
     * and change its elements to the sorted ones. 
     * @param List<T> list
     * @throw NullPointer Exception when the data of the 
     * list is null 
     */  
	public  <T extends Comparable<? super T>> void  sort(List<T> list)
	{
      if(list==null) { 
        throw new NullPointerException("Null argument to sort"); 
      }
       
      ArrayList<T> inputArray = new ArrayList<T>(list.size()); 
      inputArray.addAll(list); 
      
      internalMergeSort(inputArray, 0, list.size()-1);

      list.clear(); 
      list.addAll(inputArray);
          
	}
    
    /**
     * internalMergeSort(inputArray, first, last); 
     * Divides the list into smaller and then calls merge
     * to sort them in order. 
     * @param inputArray: an ArrayList that containts the elements of
     *                    the unsorted list.
     * @param first: first index of the list  
     * @param last: last index of the list 
     * 
     */  
	private  <T extends Comparable<? super T>> void 
		internalMergeSort(ArrayList<T> inputArray, int first, int last)
	{
      int mid = 0;
      if(first >= last) {
        return;
      } 
        mid = (first + last) / 2; 
        // Recursively sorts left partition
        internalMergeSort(inputArray,first, mid); 
        // Recursively sorts right partition
        internalMergeSort(inputArray, mid + 1, last);
       
        merge(inputArray,first, mid, last); 
        
	} // internalMergeSort
 
    /**
     * merge(inputArray, first, mid, last)
     * @param inputArray the lisr passed from internalMergeSort
     * @param fist the first index of that list
     * @param mid the middle eleement 
     * @param last the last element of the list 
     * Purpose: it compares the comparable elements of the list 
     * to each other then sort them in order and stores them in a temp list
     * then sets the  value of inputArray to the value of that tempArray.
     */   
	private  <T extends Comparable<? super T>> void 
		merge(ArrayList<T> inputArray,int first, int mid, int last)
	{
      int mergedSize = last - first + 1;
      int mergePos = 0;
      int leftPos = first;
      int rightPos = mid + 1;
      ArrayList<T> tempArray = new ArrayList<T>();
      // Add smallest element from left part or right part to 
      // the merged list.
      while(leftPos <= mid && rightPos <= last){
        if(inputArray.get(leftPos).compareTo(inputArray.get(rightPos))<=0) {
          T sortedElement = inputArray.get(leftPos);
          tempArray.add(mergePos, sortedElement); 
          leftPos++;
        } else { 
          T sortedElement = inputArray.get(rightPos);
          tempArray.add(mergePos, sortedElement);
          rightPos++;
        }
       mergePos++;
      }
      
      while(leftPos <= mid) { 
        T sortedElement = inputArray.get(leftPos); 
        tempArray.add(mergePos, sortedElement); 
        leftPos++;
        mergePos++;
      } 
     
      while(rightPos <= last) {
        T sortedElement = inputArray.get(rightPos);
        tempArray.add(mergePos, sortedElement); 
        rightPos++;
        mergePos++;
      } 
      // copy the meged elements back to inputArray.     
      for (mergePos = 0; mergePos < mergedSize; mergePos++) { 
        T sortedElement = tempArray.get(mergePos);
        inputArray.set((first + mergePos), sortedElement); 
      }
     
	} // Merge
}
// vim:ts=4:sw=4:sw=78
