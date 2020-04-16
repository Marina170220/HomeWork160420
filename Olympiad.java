package kompjuterIya.lesson150420;

//Призеры олимпиады
//По результатам олимпиады участники награждаются дипломами. Набравшие одинаковые баллы получают дипломы одинаковой степени.
//Призером олимпиады считается участник, получивший диплом не хуже III степени.
//По результатам олимпиады определите количество призеров.
//Вход: натуральное число призеров (N < 100) и далее N натуральных чисел – результаты участников.
//Выход: одно число – число призеров.

import java.util.Random;

public class Olympiad {
    public static void main(String[] args) {
        Random random = new Random();
        int amountOfСompetitors = random.nextInt(100);
        int[] results = new int[amountOfСompetitors];
        int a;
        int firstResult = 0;
        int secondResult = 0;
        int thirdResult = 0;
        int amountOfFirstPlaceDiplomas = 0;
        int amountOfSecondPlaceDiplomas = 0;
        int amountOfThirdPlaceDiplomas = 0;
        int totalAmountOfWinners = 0;

        System.out.println("Количество участников " + amountOfСompetitors);
        System.out.println("Результаты участников:");
        for (int i = 0; i < results.length; i++) {
            results[i] = random.nextInt(50);
            System.out.print(results[i] + " ");
        }
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results.length - i - 1; j++) {
                if (results[j] < results[j + 1]) {
                    a = results[j];
                    results[j] = results[j + 1];
                    results[j + 1] = a;
                }
            }
        }
        System.out.println("\nРезультаты участников в порядке убывания: ");
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }
        firstResult = results[0];
        amountOfFirstPlaceDiplomas++;
        System.out.println("\nЛучший результат:" + firstResult);

        for (int i = 1; i < results.length - 1; i++) {
            if (results[i] == firstResult) {
                amountOfFirstPlaceDiplomas++;
            } else if (results[i] < firstResult) {
                secondResult = results[i];
                break;
            }
        }
        for (int i = 1; i < results.length - 1; i++) {
            if (results[i] == secondResult) {
                amountOfSecondPlaceDiplomas++;
            } else if (results[i] < secondResult) {
                thirdResult = results[i];
                break;
            }
        }
        for (int i = 1; i < results.length - 1; i++) {
            if (results[i] == thirdResult) {
                amountOfThirdPlaceDiplomas++;
            }
        }
        totalAmountOfWinners = amountOfFirstPlaceDiplomas + amountOfSecondPlaceDiplomas + amountOfThirdPlaceDiplomas;
        System.out.println("\nКоличество дипломов первой степени: " + amountOfFirstPlaceDiplomas);
        System.out.println("Количество дипломов второй степени: " + amountOfSecondPlaceDiplomas);
        System.out.println("Количество дипломов третьей степени: " + amountOfThirdPlaceDiplomas);
        System.out.println("Общее число призёров: " + totalAmountOfWinners);

    }
}
