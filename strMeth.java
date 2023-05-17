package pyramidJava;
import java.util.*;
public class strMeth {

    public static boolean negativeSum(String nums){
        int sum = 0, trys = 0;
        Scanner sc = new Scanner(nums);
        while(sc.hasNext()){
            if(sc.hasNextInt()){
                sum += sc.nextInt();
                trys++; 
                if(sum<0){ break; }
            } else{ sc.next(); }
        }
        sc.close();
        if(sum >= 0){
            System.out.println("no negative sum");
            return false;
        }else{
            System.out.printf("%d after %d steps",sum,trys);
            return true;
        }
        
    }

    public static void boyGirl(String nums){
        int bsum = 0, gsum = 0, index =0, boys = 0, girls =0;
        Scanner sc = new Scanner(nums);
        while(sc.hasNext()){
            if(sc.hasNextInt()){
                if(index%2==0){
                    bsum += sc.nextInt();
                    boys++;
                } else{
                    gsum+=sc.nextInt();
                    girls++;
                }
                index++;
            }else{
                sc.next();
            }
        }
        System.out.printf("%d boys, %d girls\nBoys sum: %d\nGirls sum: %d\n",boys,girls,index,bsum,gsum);
        sc.close();
    }


    public static void printStrings(Scanner scanner) { 

        while (scanner.hasNext()) { 
        
            int num = scanner.nextInt(); 
            
            String str = scanner.next(); 
            
            String result = ""; 
            
            for (int i = 0; i < num; i++) { 
            
                 result += str; 
            
            } 
        
        System.out.println(result); 
        
        } 
    }

    public static String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
    
    public static String removeDuplicates(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (result.indexOf(c) == -1) {
                result += c;
            }
        }
        return result;
    }

  public static String removeBrackAndComma(String str){
        str = str.replace("[","");
        str =str.replace("]", "");
        str =str.replace(",","");
        return str;
   }

   public static String sortLine(String line){
        ArrayList<String> list = new ArrayList<String>();
        arrMeth.strToArrList(line, " ",list); 
        Collections.sort(list);
        return list.toString();
   } 
    


}
