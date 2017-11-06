import java.util.Scanner;


public class MergeSort2 {
 
 public static void main(String[] args) {
  int[] array;
  Scanner scan = new Scanner(System.in);
  System.out.print("Enter array length: ");
  array = new int[Integer.parseInt(scan.nextLine())];
  for(int i = 0; i < array.length; i++) {
   array[i] = Integer.parseInt(scan.nextLine());
  }
  MergeSort m = new MergeSort();
  array = m.mergeSort(array);
  print(array);
 }
 public int[] mergeSort(int[] array) {
   //Varablies
   int[] ans = new int[array.length];
   int[] temp = new int[1];
   int[][] sortedArr = new int[1][];
   //Checks each element in the array
   for(int i = 0; i < array.length; i++){
     //Assigns that element to the temp array
     temp[0] = array[i];
     //Sorts the element into the sorted array
     sortedArr = merge(sortedArr, temp);
   }
   //Checks each array of arrays
   for(int j = 0; j < sortedArr.length; j++){
     //If the array isnt empty
     if(sortedArr[j].length != 0)
       //Assigns mergs the sortedArr into the final ans array.
       ans = merge(sortedArr[j], ans);
   }
   return ans;
 }
 
 public int[] merge(int[] a, int[] b) {
   //Variables
   int[] ans = new int[a.length + b.length];
   int ai = 0;
   int bi = 0;
   int i = 0;
   //While loop to itiear through the arrays
   while(i < (a.length + b.length)){
     //Checks if anything is in a.
     if(ai >= a.length){
       //Assigns the current element in b to the ans array.
       ans[i] = b[bi];
       //Increment
       i++;
       bi++;
   }
     //Checks if anything is in b.
     else if(bi >= b.length){
       //Assigns the current element in a to the ans array.
       ans[i] = a[ai];
       //Increment
       i++;
       ai++;
     }
     //Checks if the current element in a is smaller then the element in b.
     else if (a[ai] < b[bi]){
       //Assigns the current element in a to the ans array.
       ans[i] = a[ai];
       //Increment
       i++;
       ai++;
     }
     //Checks if the current element in a is bigger or equal then the element in b.
     else{
       //Assigns the current element in b to the ans array.
      ans[i]= b[bi];
      //Increment
      i++;
      bi++;
     }
   }
   return ans;
 }

   
 
 public int[][] merge(int[][] sortedArrays, int[] sorted) {
  int index = log2(sorted.length);
  if(index >= sortedArrays.length) {
   sortedArrays = expand(sortedArrays);
  }
  if(sortedArrays[index] == null) {
   sortedArrays[index] = sorted;
   return sortedArrays;
  } else {
   sorted = merge(sorted, sortedArrays[index]);
   sortedArrays[index] = null;
   return merge(sortedArrays, sorted);
  }
 }

 public int[][] expand(int[][] sortedArrays) {
  int[][] ans = new int[sortedArrays.length * 2][];
  for(int i = 0; i < sortedArrays.length; i++) {
   ans[i] = sortedArrays[i];
  }
  return ans;
 }

 public int log2(int x) {
  int c = 0;
  while(x > 1)  {  x /=2;  c++;  }
  return c;
 }

 public static void print(int[] array) {
  if(array == null)  {  System.out.println(); return;  }
  for(int i = 0; i < array.length; i++) {
   System.out.print(array[i] + "\t");
  }
  System.out.println();
 }
}