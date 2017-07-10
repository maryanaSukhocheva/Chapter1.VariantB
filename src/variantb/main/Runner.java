/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package variantb.main;

import variantb.action.Action;

/**
 *
 * @author SLAVA
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Введите несколько целых чисел и нажмите <Enter>:");
       Action action = new Action();
        int[] masNum = action.numbers();
        if (masNum!= null) {
            action.chetnNechetNumbers(masNum); //четные и нечетные числа
            action.minMaxNumbers(masNum); // наибольшее и наименьшее число
            action.divisionThreeNine(masNum); //Числа, которые делятся на 3 или на 9
            action.divisionFiveSeven(masNum); //Числа, которые делятся на 5 и на 7.
            action.sortNumbers(masNum); //Элементы, расположенные методом пузырька по убыванию модулей.
            action.uniqueThreeDigit(masNum);//Все трехзначные числа, в десятичной записи которых нет одинаковых цифр
            action.greatestCommonDivisor(masNum); //Наибольший общий делитель 
            action.findLeastCommonMultiple(masNum); //наименьшее общее кратное этих чисел.
            action.findPrimeNumbers(masNum); //Простые числа
       } else {
              System.out.println("Вы не ввели числа!");
        }
    
       
             
    }
}
