package pyramidJava;
import java.util.Random;

public class intMeth {

   static Random rand = new Random();

    public static int stringToInt(String str){
        return Integer.parseInt(str);
    }

    public static String intToString(int num){
        return Integer.toString(num); //|| return String.valueOf(totalMod);
    }
    public static double getPercent(double is, double of) {return (is/of)*100; }

    public static int combineIntegers(int num1, int num2) {
        int multiplier = 1;
        while (multiplier <= num2) {
            multiplier *= 10;
        }
        return num1 * multiplier + num2;
    }
    public static int getDigitAtIndex(int num, int index) {
            int current = 0;
            while (num != 0) {
                int digit = num % 10;
                if (current == index) {
                    return digit;
                }
                num /= 10;
                current++;
            }
            return -1;
        }
    public static int gcd(int num1, int num2) {
    while (num2 != 0) {
        int temp = num1 % num2;
        num1 = num2;
        num2 = temp;
    }
    return num1;
    }

    
    public static int factorial(int num) {
    int result = 1;
    for (int i = 2; i <= num; i++) {
        result *= i;
    }
    return result;
    }

    public static int reduceLargerNumberToSmallerNumberLength(int value, int tens) {
            int subtract = value / (tens * 10);
            subtract *= (tens * 10);

            return value - subtract;
        }

        
        
    public static int getLargestDiff(int a, int b) {
        int value = 0;
        int minValue = Math.min(a, b);
        int tens = getTens(minValue); // in tens -> 10, 100, 1000, 10000
        int c = reduceLargerNumberToSmallerNumberLength(Math.max(a, b), tens);
        // example if the largest value is 123456 and the smaller is 4567
        // this function returns 3456 (it removes the first two numbers)


        while (c > 0 || minValue > 0) {
            int tempValueFromLargeNumber = (c / tens) * tens;
            int tempValueFromMinValue = (minValue / tens) * tens;

            value += Math.max(tempValueFromMinValue, tempValueFromLargeNumber);
            c = c - tempValueFromLargeNumber;
            minValue = minValue - tempValueFromMinValue;

            tens /= 10;

        }

        return value;
    }

    public static int getTens(int value) {
        int tens = 0;
        while (value >= 10) {
            value = value / 10;
            tens += 1;
        }
        return (int)Math.pow(10, tens); // Math.pow returns double, so we need to convert it to an int by casting
    }

    public static int intLength(int num) {
        int numZero = 0;
        for (int i = 1; num >= Math.pow(10, i); i++) {
            numZero++;
        }
        return numZero + 1;
    }
    
    public static int largerDigits(int a, int b) {
        int aZero = intLength(a), bZero = intLength(b);
        int maxLength = Math.min(aZero, bZero);
        int finalNum = 0;
        for (int i = 1; i <= maxLength; i++) {
            int cur = maxLength - i;
            if (getDigitAtIndex(a, cur) > getDigitAtIndex(b, cur)) {
                finalNum = combineIntegers(finalNum, getDigitAtIndex(a, cur));
            } else {
                finalNum = combineIntegers(finalNum, getDigitAtIndex(b, cur));
            }
    
        }
        return finalNum;
    }
    
    public static int getRandomMinZeroMaxExlusive(int max){
        return rand.nextInt(max);
    }//if 10 is entered for max than min = 0 and max = 9
    
    public static int getRandomMinOneMaxInclusive(int max){
        return rand.nextInt(max)+1;
    }//if 10 is entered for max than min = 1 and max = 10
    
    public static int getRandomNumberInclusive(int min, int max) { 
               return rand.nextInt(max - min + 1) + min;
    }//if 1 is min and 10 is max than min return is 1 and max return is 10
    
    public static int getRandomNumberExclusive(int min, int max) {
               return rand.nextInt(max - min) + min;
    }//if 1 is min and 10 is max than min return is 1 and max return is 9

    public static int getRandomNumberExclusiveMinInclusiveMax(int min, int max) {
               return rand.nextInt(max - min + 1) + 1 + min;
    }//if 1 is min and 10 is max than min return is 2 and max return is 10 

    public static int getRandomNumberExclusiveMinMaxExclusive(int min, int max) {
               return rand.nextInt(max - min - 1) + 1 + min;
    }////if 1 is min and 10 is max than min return is 2 and max return is 9 


    public static int D4(){ return rand.nextInt(4)+1; }

    public static int D6(){ return rand.nextInt(6)+1; }

    public static int D8(){ return rand.nextInt(8)+1; }

    public static int D10(){ return rand.nextInt(10)+1; }

    public static int D12(){ return rand.nextInt(12)+1; }

    public static int D20(){ return rand.nextInt(20)+1; }

    public static int D100(){ return rand.nextInt(100)+1; }

        
} 
