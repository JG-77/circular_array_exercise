package com.revature;

import java.util.Arrays;
import java.util.Iterator;

public class CircularArrayExercise<Obj> implements Iterable<Obj> {

    public Obj[] circArr; //array of obj
    public int head =0; //first element in array
    public int arrSize; //size of array
    public int last;

    public CircularArrayExercise(Obj[] circArr) {
        this.circArr = circArr;
        this.arrSize = circArr.length;
        this.last = arrSize-1;
    }

    //find the element are specified index
    public Obj getElement(int index){
        return circArr[index];
    }

    //find array size
    public int findLength(){
        return arrSize;
    }

    //return first element in array
    public Obj getFirst(){
        return circArr[head];
    }

    //find last element
    public Obj getLast(){
        return circArr[last];
    }

    //return the circular array
    public Obj[] getArr(){
        return circArr;
    }

    //shift every element forward one index: array[2] --> array[3]
    public void cycleUpOne(){
        Obj placeHolder = circArr[last]; //create placeholder to hold last element

        for(int i = last; i>0;i--){ //start from last element
            circArr[i]= circArr[i-1]; //current element is given next element's value
        }

        //last element is moved to first index
        circArr[0]=placeHolder;
    }

    //shift every element down one index
    public void cycleDownOne(){
        Obj placeHolder = circArr[head]; //create placeholder to hold first element

        for(int i = 0; i<last-1;i++){ //start from[0] and stop at 2nd to last element
            circArr[i]=circArr[i+1]; //current el is given next el's value
        }
        circArr[last] = placeHolder; //last element given placeholder value
    }


    @Override
    public Iterator<Obj> iterator() {
        //convert array to stream
        return Arrays.stream(circArr).iterator();
    }
}
