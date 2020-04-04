package com.Smotteh;

/* @Author Jacob Corcho
 * @Version 4/4/2020
 * The purpose of this class is to serve as a custom DynamicArray. This is essentially a watered down version
 * of the built in ArrayList class by java.
 *
 * CST-201 FOR GROUP OF: | JACOB CORCHO | CASEY HUZ | BRYDON JOHNSON |
 */

public class DynamicArray {
    private Object[] data; //initial array.

    //the following method "adds" an Object to our array passed as an argument.
    public void add(Object obj) {

        Object[] bigger = new Object[data.length + 1]; //new array which is one index larger than the previous array.

        //loop through each index of the original "data" array.
        //essentially this loop will "copy" the data to the new array to each respective index.
        for (int i = 0; i < data.length; i++) {
            bigger[i] = data[i]; //sets the current index of the data array to the relative index of the new array.

            //change pointer to new array
            data = bigger;       //the smaller array is now garbage collected and no longer accessible.
            data[data.length - 1] = obj; //set the argument passed through the method as the final index of the array.
        }


    }
}
