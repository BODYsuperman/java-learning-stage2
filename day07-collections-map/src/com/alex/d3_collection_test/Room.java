package com.alex.d3_collection_test;

import java.util.*;

public class Room {


    private List<Card> deck = new ArrayList<>();



    {

        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int size = 0;
        for (String rank : ranks) {

            for (String suit : suits) {

                Card c = new Card(rank, suit, size+1);
                deck.add(c);
            }
            size++;

        }
        deck.add(new Card(" ", "小王", ++size));
        deck.add(new Card(" ", "大王", ++size));
        System.out.println("cards is "+ deck);

    }



    public  void sortCards(List<Card> cards){
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o2.getSize() - o1.getSize();
            }
        });
    }



    public void Start(){


        //洗牌
        Collections.shuffle(deck);
        System.out.println("shuffle card is " + deck);

        //发牌
        List<Card> p1 = new ArrayList<>();
        List<Card> p2 = new ArrayList<>();
        List<Card> p3 = new ArrayList<>();

        for (int i = 0; i < deck.size() -3; i++) {

            Card c = deck.get(i);
            if(i%3 == 0){
                p1.add(c);
            }
            else if(i%3 == 1){
                p2.add(c);
            }
            else if(i%3 == 2){
                p3.add(c);
            }
        }

        List<Card> lastThreeCards = deck.subList(deck.size() -3, deck.size());
        Random random = new Random();
        int landlord = random.nextInt(3);
        List<Card> landlordCards = null;

        switch (landlord) {
            case 0:
                p1.addAll(lastThreeCards);
                landlordCards = p1;
                System.out.println("玩家1成为地主");
                break;
            case 1:
                p2.addAll(lastThreeCards);
                landlordCards = p2;
                System.out.println("玩家2成为地主");
                break;
            case 2:
                p3.addAll(lastThreeCards);
                landlordCards = p3;
                System.out.println("玩家3成为地主");
                break;
        }


        sortCards(p1);
        sortCards(p2);
        sortCards(p3);

        System.out.println("p1: "+ p1);
        System.out.println("p2 " + p2);
        System.out.println("p3" + p3);


    }
}
