package kompjuterIya.lesson150420;

//Рекламная акция
//В сети магазинов "Н-Аудио" проводится рекламная акция. Каждый второй товар – бесплатно.
//Естественно, кассирам дано указание пробивать товары в таком порядке, чтобы магазин потерял как можно меньше денег.
//По списку товаров определите максимальную сумму в чеке.
//Вход: натуральное число товаров (N < 1000) и далее N натуральных чисел – цены товаров.
//Выход: одно число – максимальная сумма чека.

import java.util.Random;
import java.util.Arrays;

public class Promotion {
    public static void main(String[] args) {
        Random random = new Random();
        int positionInCheck = 1;
        int checkSum = 0;
        int maxCheck = 1;
        int amountOfCustomers = 1 + random.nextInt(10 - 1 + 1);
        int[] shoppingCart = new int[random.nextInt(30)];
        int[] check = new int[shoppingCart.length];
        int[] sumsOfChecks = new int[amountOfCustomers];

        System.out.println("Количество покупателей: " + amountOfCustomers);

        for (int c = 0; c < amountOfCustomers; c++) {
            System.out.println("\n\nПокупатель " + (c + 1));
            System.out.println("Цены товаров в корзине: ");


            for (int i = 0; i < shoppingCart.length; i++) {
                shoppingCart[i] = random.nextInt(1000);
                System.out.print(shoppingCart[i] + " ");
            }

            if (shoppingCart.length >= 2) {
                Arrays.sort(shoppingCart);

                System.out.println("\nЦены, отсортированные по возрастанию:");
                for (int i = 0; i < shoppingCart.length; i++) {
                    System.out.print(shoppingCart[i] + " ");
                }
                while (positionInCheck < shoppingCart.length - 1) {
                    for (int i = 0; i < (shoppingCart.length / 2); i++) {
                        check[positionInCheck] = shoppingCart[i];
                        check[positionInCheck] = 0;
                        positionInCheck += 2;
                    }
                }

                positionInCheck = 0;
                while (positionInCheck < shoppingCart.length - 1) {
                    for (int i = shoppingCart.length / 2; i < shoppingCart.length; i++) {
                        check[positionInCheck] = shoppingCart[i];
                        checkSum += check[positionInCheck];
                        positionInCheck += 2;
                        sumsOfChecks[c] = checkSum;
                    }
                }

                System.out.println("\nЧек на оплату: ");
                for (int i = 0; i < check.length; i++) {
                    System.out.print(check[i] + " ");
                }
                System.out.print("\nСумма по чеку: " + checkSum);
            }
        }

        System.out.print("\nСуммы по всем чекам: ");

        for (int i = 0; i < sumsOfChecks.length; i++) {
            if (sumsOfChecks[i] > maxCheck) {
                maxCheck = sumsOfChecks[i];
            }

            System.out.print(sumsOfChecks[i] + " ");
        }

        System.out.println("\nМаксимальный чек:" + maxCheck);
    }
}



