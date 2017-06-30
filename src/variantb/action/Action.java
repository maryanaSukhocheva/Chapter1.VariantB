/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package variantb.action;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author SLAVA
 */
public class Action {
   String pattern = "(\\s)+|($)";
   
    /**
     *
     * @return String[] masNum  - numbers' array 
     */
    public int[] Numbers() {
        boolean result;
        int number;
        String[] masNum = null;
        int[] mas=null;
        try (Scanner scan = new Scanner(System.in)) {
            result = false;
            String str = scan.nextLine();
            for (String retval : str.split(pattern)) {
                try {
                    if (!retval.isEmpty()) {
                        number = Integer.valueOf(retval);
                        result = true;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Неверный формат чисел!");
                    result = false;
                    break;
                }
            }
            scan.close();
            if (result) {
                masNum = str.split(pattern);
                mas=new int[masNum.length];
                for (int i=0;i<masNum.length;i++){
                    mas[i]=Integer.valueOf(masNum[i]);
                }
            }
        }
        return mas;
    }  
    
     /**
     * Chapter1.VariantB.one 
     * @param mas numbers' array
     */
    public static void ChetnNechetNumbers(int[] mas) {
        
        String chetnNumbers="";
        String nechetnNumbers="";
        for (int number:mas) {
            if(number%2==0){
                chetnNumbers=chetnNumbers+" "+String.valueOf(number);
            } else {
                nechetnNumbers=nechetnNumbers+" "+String.valueOf(number);
            }
         }
        System.out.println("Задание 1. На консоль вывести четные и нечетные числа.");
        System.out.println("Четные числа: "+chetnNumbers);
        System.out.println("Нечетные числа: "+nechetnNumbers);
        System.out.println();
     }    
          
       public void minMaxNumbers(int[] mas) {
        int  currentNum=mas[0];
        int min = mas[0];
        int max = mas[0];
        for (int i=1; i<mas.length;i++) {
            currentNum = mas[i];
            if(min>currentNum){
                min=currentNum;
            } 
            if(max<currentNum){
               max=currentNum;
            }
         }
        System.out.println("Задание 2. На консоль вывести наибольшее и наименьшее число.");
        System.out.println("Наибольшее число: "+String.valueOf(max));
        System.out.println("Наименьшее число: "+String.valueOf(min));
        System.out.println();
     } 
       
     public static void divisionThreeNine(int[] mas) {
         String divThree="";
         for (int number:mas) {
           if((number%3==0) || (number%9==0)){
                divThree=divThree+" "+String.valueOf(number);
            }
         }
        System.out.println("Задание 3. На консоль вывести числа, которые делятся на 3 или на 9.");
        System.out.println("Числа, которые делятся на 3 или на 9: "+divThree);
          System.out.println();
     }   
     
     public static void divisionFiveSeven(int[] mas) {
         String divNum="";
         for (int number:mas) {
            if ((number%5==0) && (number%7==0)){
                divNum=divNum+" "+String.valueOf(number);
            }
         }
        System.out.println("Задание 4. На консоль вывести числа, которые делятся на 5 и на 7.");
        System.out.println("Числа, которые делятся на 5 и на 7: "+divNum);
          System.out.println();
     }   
     
     public static void sortNumbers(int[] mas) {
        boolean result;
        int temp; 
        int j = 0;
        do {
            result = false;
            j++;
            for (int i = 0; i < mas.length - j; i++) {
                if (Math.abs((long) mas[i]) < Math.abs((long) mas[i + 1])) {
                    temp = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = temp;
                    result = true;
                }
            }
        } while (result);
        System.out.println("Задание 5. На консоль вывести элементы, расположенные"
                + " методом пузырька по убыванию модулей.");
        System.out.println(Arrays.toString(mas));
       System.out.println();
    }
     
      public static void uniqueThreeDigit(int[] mas) {
        int digit1, digit2, digit3;
        String unNum="";
        for (int number : mas) {
            digit1 = number / 100;
            digit2 = number / 10 % 10;
            digit3 = number % 10;
            // Ищем трехзначные числа
            if ((number >= 100 && number <= 999)
                    || (number <= -100 && number >= -999)) {
                if ((digit1 != digit2) && (digit2 != digit3)
                        && (digit1 != digit3)) {
                    unNum=unNum+" "+String.valueOf(number);
                }
            }
        }
        System.out.println("Задание 6. На консоль вывести все трехзначные числа,"
                + " в десятичной записи которых нет одинаковых цифр.");
        System.out.println("Все трехзначные числа, в десятичной записи которых нет одинаковых цифр - "+unNum);
        System.out.println();
    }
      
    public static int findGreatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void GreatestCommonDivisor(int[] mas) {
        int result = mas[0];
        if (result!= 0) {
             for (int i = 1; i < mas.length; i++) {
                result = findGreatestCommonDivisor(result, mas[i]);
            }
           System.out.println("Задание 7. На консоль вывести наибольший общий"
                   + " делитель и наименьшее общее кратное этих чисел.");
        System.out.println("Наибольший общий делитель: " + result);
        System.out.println();
         
        }
    }
    
    
     public static int findLeastCommonMultiple(int a, int b) {
        return a * (b / findGreatestCommonDivisor(a, b));
    }

    /**
     *
     * @param
     * @return 
     */
    public static void findLeastCommonMultiple(int[] mas) {
        int result = mas[0];
        if (result == 0) {
            System.out.println("Наименьшее общее кратное: " + result);
        } else {
            for (int i = 1; i < mas.length; i++) {
                if (mas[i] == 0) {
                    break;
                }
                result = findLeastCommonMultiple(result, mas[i]);
            }
        }
        System.out.println("Наименьшее общее кратное: " + result);
    }
  
    
    public static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 != 0) {
            return true;
        }
        final double NumberSqrt = Math.ceil(Math.sqrt(number));
        for (long i = 3; i <= NumberSqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return false;
    }

    public static void findPrimeNumbers(int[] mas) {
        String outNum ="";
        for (int number : mas) {
            if (isPrimeNumber(number)) {
                outNum=outNum+" "+String.valueOf(number);
            }
        }
        System.out.println("Задание 8. На консоль вывести простые числа.");
        System.out.println("Простые числа: " + outNum);
        System.out.println();
    } 
}
