package pyramidJava;
import java.util.*;
public class arrMeth {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // Print a new line at the end
    }
    

    public static int findMin(int[] arr){// returns min value in array
        int min = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    public static int findMax(int[] arr) { // returns max value in array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    

    public static int[] vowelCount(String str){
        int[] arr = new int[5];
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for(int i=0; i<arr.length; i++) { 
            for(int j=0; j<str.length();j++){
                if (str.charAt(j) == vowels[i]){ arr[i]++; }
            }
        }        
        return arr;
    }

    public static void rotateRight(int[] arr){
        int[] newList = new int[arr.length];
        newList[0] = arr[arr.length-1];
        for(int i=1; i<arr.length; i++) {
            newList[i] = arr[i-1];
        }
        for(int i=0; i<arr.length; i++) {
            arr[i] = newList[i];
        }
    }
    
    public static void rotateLeft(int[] arr) {
        int[] newList = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            newList[i] = arr[i + 1];
        }
        newList[arr.length - 1] = arr[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newList[i];
        }
    }

    public static boolean isSorted(double[] arr){
        for(int i =1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]){ return false; }
            if(i+1 == arr.length && arr[i-1] > arr[i]){ return false; }
        }
        return true;
    }

    public static boolean isSorted(int[] arr){
        for(int i =1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]){ return false; }
            if(i+1 == arr.length && arr[i-1] > arr[i]){ return false; }
        }
        return true;
    }
    
    public static boolean isSorted(ArrayList<Integer> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) > list.get(i+1)){ return false; }
        }
        return true;
    }

    public static boolean isUnique(int[]list){ 
        int [] listCopy = Arrays.copyOf(list,list.length); 
        Arrays.sort(listCopy); 
        for(int i = 0; i<listCopy.length-1; i++ ){ 
            if(listCopy[i]==listCopy[i+1]){ 
                return false; 
            } 
        } 
        return true; 
    } 

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void bubbleSort(int[ ] a) {
    for(int pass = 1; pass < a.length; pass++) {
      for(int i = 0; i < a.length - 1; i++) {
        if(a[i] > a[i + 1]) 
          swap(a, i, i + 1);
      }
    }
  }

    public static int binarySearch(int[] a, int min, int max, int target) {
    while (min <= max) {
        int mid = (min + max) / 2;
        System.out.println("high=" + max + " mid=" + mid + " low=" + min);
        if (a[mid] < target) {
            min = mid + 1;
        } else if (a[mid] > target) {
            max = mid - 1;
        } else {
            return mid;   // target found
        }
    }
    return -(min + 1);    // target not found
  }        

    public static void insertionSort(int[ ] a) {
    for (int i = 1; i < a.length; i++) { 
      int elementValue = a[i], j = i; 
      while (j > 0 && a[j - 1] > elementValue) { 
        a[j] = a[j - 1];     // shift right 
        j--;                 // remember insert point
      } 
      a[j] = elementValue; 
      System.out.println("Pass " +  i + ": " + Arrays.toString(a)); 
    }
  }

  public static String[] joiner(String[] a1, String[] a2){
    //joing arrays putting longer word + smaller word for each index of new array 
        String [] a3 = new String[Math.min(a1.length,a2.length)];
        for(int i =0; i < a3.length; i++){
            if(a2[i].length()>a1[i].length()){
                a3[i] = a2[i]+a1[i];
            }else{
                a3[i] = a1[i]+a2[i];
            
            }
            
        }
        return a3;
    }

    public static char[] vowelsBeforeConsonants(char[] a1){
        char a2[] = new char[a1.length];
        char a3[] =new char[a1.length];
        int vowelCount = 0, constCount = 0;
        for(int i = 0; i < a1.length; i++){
            switch(a1[i]){
                case 'a': 
                    a2[vowelCount] = 'a';
                    vowelCount++;
                    break;
                case 'e':
                    a2[vowelCount] = 'e';
                    vowelCount++;
                    break;
                case 'i': 
                    a2[vowelCount] = 'i';
                    vowelCount++;
                    break;
               case 'o': 
                       a2[vowelCount] = 'o';
                    vowelCount++;
                    break;
              case 'u': 
                    a2[vowelCount] = 'u';
                    vowelCount++;
                    break;
             default: 
                a3[constCount] = a1[i];
                constCount++;
                break;
         }
        }
        for (int i = 0; i < constCount; i++){
            System.out.println(i);
            a2[vowelCount + i] = a3[i]; 
        }
        return a2;
    }

    public static void flip2(ArrayList<String> list){
        ArrayList<String> a = new ArrayList<String>();
        int mod;
        if (list.size()%2 ==0){ mod = 0; } else { mod = -1; }
        for(int i = 0; i < list.size() + mod; i+=2){
                a.add(list.get(i+1));
                a.add(list.get(i));
        }
        if(mod == -1){
            a.add(list.get(list.size()-1));
        }
       list.clear();
       list.addAll(a);
    }

    
    public static void shorten(ArrayList<Integer> list){
        //adds adjacent groups of ints into 1 element, and replaces list
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for(int i = 0; i < list.size(); i++){
            int cur = 0;
            if(i+1 >= list.size()){
                list2.add(list.get(i));
                break;
            }
            if(list.get(i)== list.get(i+1)){
                int mod = 0;
                while(list.get(i)== list.get(i+mod)){
                    cur += list.get(i);
                    if(mod +i < list.size()){
                        mod++;
                    }else{ break;}
                }
                i+=mod-1; 
            }else{
                cur = list.get(i);
            }
            list2.add(cur);
        }
        list.clear();
        list.addAll(list2);
    }

   public static String[] strToArr(String str, String sep){
        String arr[] = str.split(sep);
        return arr; 
   }

   public static void strToArrList(String str, String sep, ArrayList<String> list){
        list.clear();
        ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(strToArr(str, sep)));
        list.addAll(arrList);
   }


} 

        

    

