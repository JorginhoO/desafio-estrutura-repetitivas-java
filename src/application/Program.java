package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double weightedSum = 0.0;
        double womenHeightSum = 0.0;
        double tallestHeight = 0.0;
        double numberOfMen = 0.0;
        double numberOfWomen = 0.0;
        String tallestName = "";

        System.out.print("Qual a quantidade de atletas? ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("Digite os dados do atleta numero " + (i + 1) + ":");
            sc.nextLine();
            System.out.print("Nome: ");
            String name = sc.nextLine();

            char sex;
            System.out.print("Sexo: ");
            do {
                sex = sc.next().charAt(0);
                if (sex != 'F' && sex != 'M')
                    System.out.print("Valor invalido! Favor digitar F ou M: ");
            } while (sex != 'F' && sex != 'M');

            double height;
            System.out.print("Altura: ");
            do {
                height = sc.nextDouble();
                if (height <= 0) {
                    System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                }
            } while (height <= 0);

            double weight;
            System.out.print("Peso: ");
            do {
                weight = sc.nextDouble();
                if (weight <= 0) {
                    System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                }
            } while (weight <= 0);

            weightedSum += weight;

            if (height > tallestHeight) {
                tallestName = name;
                tallestHeight = height;
            }
            if (sex == 'M') {
                numberOfMen++;
            }

            if (sex == 'F') {
                womenHeightSum += height;
                numberOfWomen++;
            }
        }

        double averageWeight = weightedSum / N;

        double percentageMen = 100.0 * numberOfMen / N;

        System.out.println();
        System.out.println("RELATÓRIO:");
        System.out.printf("Peso médio dos atletas: %.2f%n", averageWeight);
        System.out.println("Atleta mais alto: " + tallestName);
        System.out.printf("Porcentagem de homens: %.1f%%%n", percentageMen);
        if (numberOfWomen == 0) {
            System.out.println("Não há mulheres cadastradas");
        } else {
            double averageWomenHeight = womenHeightSum / numberOfWomen;
            System.out.printf("Altura média das mulheres: %.2f ", averageWomenHeight);
        }
        sc.close();
    }
}
