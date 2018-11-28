package Solitare;
import java.util.*;

public class Deck {//is deck just a global array list of Cards reskinned?
    String[] suits  =  {"hearts", "diamonds", "clubs", "spades"};
    String[] kinds = {"ace","two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
    int[] numbers  = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    ArrayList<Card> deckList = new ArrayList<Card>();

    Deck(){//creates a deck of cards organized from low to high (aces low), hearts, diamonds, clubs, spades

        int i,j, numberTemp, indexTemp = 0;
        String suitTemp,kindTemp;
        for (i = 0; i<4; i++) {//we do <4 instead of <=4 because 0,1,2,3
            suitTemp = suits[i];
            for (j = 0; j < 13; j++) {
                indexTemp++;
                kindTemp = kinds[j];
                numberTemp = numbers[j];
                deckList.add(new Card(kindTemp, suitTemp, numberTemp, indexTemp));
            }//end inner for
        }//end outer for
    }//end constructor

    Deck (ArrayList<Card> listIn){
        deckList = listIn;
    }

    int getSize(){
        return deckList.size();
    }

    ArrayList<Card> getDeck(){
        return deckList;
    }

    Card getCard(int index){
        return deckList.get(index);
    }

    void insertCard(int index, Card cardIn){
        deckList.set(index, cardIn);
    }

//    Boolean hasNext(Deck deckIn){
////        if(deckIn.get)
//    }

}//end class
