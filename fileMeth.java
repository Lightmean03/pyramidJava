package pyramidJava;
import java.util.*;
import java.io.*;
public class fileMeth{

    public static int getLines(Scanner file){
        int lines = 0;
        while(file.hasNextLine()){
            file.nextLine();
            lines++;
        }
        return lines;
    }

    public static void listAppend0099() throws FileNotFoundException{ 
        Scanner console = new Scanner(System.in);
        System.out.println("Enter Wordlist\nFileName --> ");
        File org = new File(console.nextLine());
        System.out.println("Enter the name of the output filename\nnew FileName --> ");
        PrintStream output = new PrintStream(new File(console.nextLine()));
        console.close();
        Scanner sc = new Scanner((org));
        String tmp;
        while(sc.hasNextLine()){
            tmp = sc.nextLine();
            for(int i =0; i <10;i++){
              for(int j =0; j <10;j++){
                  output.printf("%s%d%d\n",tmp,i,j);
              }
            }
        }
        sc.close();
      }

    public static void copyFileToUpper()throws IOException{
        Scanner console = new Scanner(System.in);
        System.out.println("Enter name of the file to copy\nFileName --> ");
        File org = new File(console.nextLine());
        System.out.println("Enter the name of the new filename\nnew FileName --> ");
        PrintStream output = new PrintStream(new File(console.nextLine()));
        console.close();
        Scanner sc = new Scanner((org));
        while(sc.hasNextLine()){
            output.println((sc.nextLine().toUpperCase()));
        }
        sc.close();
      }

    public static void textCount(Scanner file){
        int lines = 0, letters = 0, longestLine = 0;
        String line = ""; String cur;
        while(file.hasNextLine()){
            cur = file.nextLine();
            letters += cur.length();
            if(cur.length() > longestLine){
                line = cur;
                longestLine = cur.length();
                System.out.println(cur);
                
            }
            lines++;
        }
        System.out.println("Total lines            = " + lines);
        System.out.println("Total chars            = "+ letters);
        System.out.println("Length of longest line = "+ longestLine);
        System.out.println("Longest line           = "+ line);
    }

    public static void fixSpacing(Scanner file){
        String cur; String newCur = " ";
        while(file.hasNextLine()){
            cur = " "; 
            cur += file.nextLine();
           //System.out.println(cur);
            for(int i = 0; i < cur.length(); i++){
                if(i == cur.length()-1){
                    newCur += cur.charAt(i);
                    break; 
                }else if(!(cur.charAt(i)==(' ') && cur.charAt(i+1)== (' '))){
                    newCur += cur.charAt(i);
                } 
            }
            System.out.println(newCur);
            newCur = " ";
            
        }
    }

    public static void evenNumbers(String str){
        Scanner nsc = new Scanner(str);
        int totalNums = 0, evenNums = 0, sum = 0;

            while(nsc.hasNext()){
            int tmp; 
            if(nsc.hasNextInt()){
                tmp = nsc.nextInt();
                totalNums++;
                sum += tmp;
                    if(tmp%2==0){
                        evenNums++;
                }
            } else {  nsc.next(); }
        }
            nsc.close();
           System.out.println("Total numbers  = " + totalNums); 
           System.out.println("of numbers = " + sum);
           System.out.println("Total evens    = " + evenNums);
           System.out.println("Percent evens  = "+ (int)(((double)evenNums/totalNums)*100)+ "%");


    }

    public static void fileWrite(String fileName, String content) throws FileNotFoundException{
        PrintStream out = new PrintStream(new File(fileName));
        out.print(content);
    }

    public static String fileToString(Scanner file){
        String str = "";
        while(file.hasNextLine()){
            str += file.nextLine();
            str += "\n";
        }
        file.close();
        return str;
    }

    public static String fileToString(Scanner file, String lineSep){
        String str = "";
        while(file.hasNextLine()){
            str += file.nextLine();
            str += lineSep;
        }
        file.close();
        return str;
    }


    public static void matchIndex(Scanner file){ 
        //compares the first line of the file (target line) to every other line 
        String first = file.nextLine();
        int line = 1;
        while(file.hasNextLine()){
            line++;
            String compare = file.nextLine(); 
            ArrayList<Integer> matching = new ArrayList<Integer>();
            for(int i = 0; i < Math.min(first.length(),compare.length()); i++){
                if(compare.charAt(i)==first.charAt(i)){
                    matching.add(i);
                } 
            }
            if (matching.size()==0){
                System.out.println("target and "+line + " none"); 
            }else{
                System.out.println("target and "+line + " " +matching.toString());
            }
        }
    }

   public static void fileToArrList(Scanner file, ArrayList<String> list){
        list.clear();
        ArrayList<String> L = new ArrayList<String>();
        while(file.hasNextLine()){
            L.add(file.nextLine());
        }
        list.addAll(L);
       // System.out.println(list.toString());
   }

   public static void sortFileLines(Scanner inputFile, PrintStream outFile){
        ArrayList<String> fileStr = new ArrayList<String>();
        fileToArrList(inputFile, fileStr);
        for(String line : fileStr){
            ArrayList<String> tmpL = new ArrayList<String>();
            arrMeth.strToArrList(line," ",tmpL);
            Collections.sort(tmpL);
            outFile.println(strMeth.removeBrackAndComma(tmpL.toString()));
        }
   }

   public static void fileWriter() throws FileNotFoundException{
    Scanner sc = new Scanner(System.in);
    System.out.println("enter file name as name.txt");
    PrintStream out = new PrintStream(new File(sc.next()));
    System.out.println("Write to your file, type QUIT! to exit, hit enter for new line");
    String line = "";
    while(true){
        line = sc.next();
        if(line.equals("QUIT!")){ break; }
        out.println(line);
    }
    sc.close();
   }

}