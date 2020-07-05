import io.vavr.collection.List;

import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {
        /**Zad. 1 Co to jest programowanie funkcyjne?
         * Programowanie funkcyjne to jedna z filozofii programowania. Paradygmat funkcyjny to model, wzorzec
         * myślenia o programie. W tym przypadku programujemy wykorzystując funkcje, czyli fragment kodu, który
         * przyjmuje argumenty i zwraca wynik.Przykładowo jeśli funkcja przyjmuje argument będący listą,
         * to nie modyfikuje w żaden sposób źródła tego argumentu. Działa na jego kopii.
         * W programowaniu funkcyjnym funkcje możemy traktować jako wartości. Możemy przekazywać je jako
         * parametry lub tworzyć z nich programy poprzez odpowiednie zestawienie ich w ciąg. Można to porównać
         * do linii produkcyjnej. Funkcje to kolejne maszyny otrzymujące dane na wejściu i generujące wynik będący
         * wejściem do kolejnej funkcji.Kolejną ważną koncepcją jest niemutowalność stanu.
         * Oznacza to, że raz zdefiniowana zmienna co do swojej wartości nie ulega zmianie.
         *  Jeśli chcemy ją jakoś zmodyfikować, konieczne jest utworzenie kopii.
         * */
        /**Zad. 2 Proszę zrealizować dowolny program w Clojure lub Javie wykorzystujący domknięcia.*/
        Multiplier multiplication = (x, y) -> x*y;
        Multiplier division = (x, y) -> x/y;
        Multiplier addition = (x,y) -> x+y;
        Multiplier subtraction = (x,y) -> x-y;

        double a = multiplication.numbers(5,2);
        System.out.println(a);
        double b = division.numbers(9,3);
        System.out.println(b);
        double c = addition.numbers(4,120);
        System.out.println(c);
        double d = subtraction.numbers(24,10);
        System.out.println(d);
        double e = division.numbers(addition.numbers(5,5),multiplication.numbers(8,7));
        System.out.println(e);


        /**Zad. 3 Proszę napisać w Clojure lub Javie procedurę, która przyjmuje listę
         zbiorów i generuje iloczyn kartezjański (cross-product) tych zbiorów.*/

        System.out.println(generateCrossProduct(List.of(1,2,4),List.of(2,3,4),List.of("a","b","c")));


    }

    public static List generateCrossProduct(List ...lists) {
        java.util.List list = new ArrayList();
        int solutions = 1;
        for(int i = 0; i < lists.length; solutions *= lists[i].length(), i++);
            for (int i = 0; i < solutions; i++) {
                int j = 1;
                for (List set : lists) {
                System.out.print(set.get((i/j)%set.length()) + " ");
                    list.add(set.get((i / j) % set.length()));
                    j *= set.length();
                }
                System.out.println();
            }
        return List.of(list);
    }

}
