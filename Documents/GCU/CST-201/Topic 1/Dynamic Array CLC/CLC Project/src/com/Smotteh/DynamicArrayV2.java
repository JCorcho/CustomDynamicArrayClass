package com.Smotteh;

/* @Author Jacob Corcho
 * @Version 4/4/2020
 * The purpose of this class is to serve as a custom DynamicArray. This is essentially a watered down version
 * of the built in ArrayList class by java.
 *
 * CST-201 FOR GROUP OF: | JACOB CORCHO | CASEY HUZ | BRYDON JOHNSON |
 */


public class DynamicArrayV2 {
    private Object[] data; //initial array.
    private int size; //holds highest non null index.

    //the following method "adds" an Object to our array passed as an argument.
    public void add(Object obj) {
        try { //try to set the next non null index to the obj argument passed.
            data[size] = obj;
            size++;
        } catch (IndexOutOfBoundsException e) { //if the index is out of bounds then we will resize use recursion to call add.
            resizeArray();
            add(obj);
        }
    }

    public void add(int index, Object obj) {
        try { //try to shift the components of each index to one index higher.
            for(int i = size - 1; i >= index; i--) { //loop through each index from the position of size-1.
                data[i + 1] = data[i]; //data[at index i+1] is equal to data at index i(shifting the position essentially)
            }
            data[index] = obj; //now put the obj argument passed at the newly open index of the "index" argument passed.
            size++; //add one to the size int since we have added a new non null index to the array.
        } catch (IndexOutOfBoundsException e) { //if the index is out of bounds then we will resize use recursion to call add.
            resizeArray();
            add(obj);
        }
    }

    public void remove(Object obj) {
        //remove logic (beyond the scope of this project).
    }

    //"resize" the array to double its current length
    private void resizeArray() {
        Object[] bigger = new Object[data.length * 2]; //new array which is one index larger than the previous array.
        //loop through each index of the original "data" array.
        //essentially this loop will "copy" the data to the new array to each respective index.
        for (int i = 0; i < data.length; i++) {
            bigger[i] = data[i]; //sets the current index of the data array to the relative index of the new array.

            //change pointer to new array
            data = bigger;       //the smaller array is now garbage collected and no longer accessible.
        }
    }

    //returns size of non null indexes in the array.
    public int size() { return size; } //0(1) time

    //get object at index.
    public Object get(int index) { //0(1) time
        try {
            return data[index];
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    //default constructor
    public DynamicArrayV2() {
        data = new Object[1];
        size = 0;
    }
}
