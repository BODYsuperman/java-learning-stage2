package com.alex.d4_algorithm;

public class BinarySearch {
    public static void main(String[] args) {

    }

    public  static  int binarySearch(int[] arr , int target){
        if(arr == null) return -1;

        int left = 0;
        int right = arr.length -1;
        while (left <= right){

            int mid = left + (right -left)/2;
            if(target == arr[mid]){
                return mid;
            }
            else if(target > arr[mid]){
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }

        return -1;
    }
}
