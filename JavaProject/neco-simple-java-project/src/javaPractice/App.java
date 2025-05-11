package javaPractice;

import java.util.Random;

import javaPractice.model.Deck;

public class App {

    public static void main(String[] args) throws Exception {

        // リストの宣言
        // Deck deck = new Deck();

        // deck.openAll();

        Random rand = new Random(0);
        System.out.println(rand.nextInt(10));
        System.out.println(rand.nextInt(10));
        System.out.println(rand.nextInt(10));
        System.out.println(rand.nextInt(10));
        System.out.println(rand.nextInt(10));

    }

}
