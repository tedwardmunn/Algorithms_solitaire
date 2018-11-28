package Solitare;
import java.util.*;
public class SmallPile {
    Stack<Card> small;

    SmallPile(){
        small = new Stack<>();
    }

    void add(Card cardIn){
        small.push(cardIn);
    }

    Card remove(){
        return small.pop();
    }

    void removeNoReturn(){small.pop();}

    Stack<Card> getSmallPile(){
        return small;
    }

    Card peek(){ return small.peek();}

    void printSmallPile(SmallPile pileIn){
        ArrayList<Card> newList = new ArrayList<>(pileIn.getSmallPile());
        int pileSize = newList.size();
        Card tempCard;
//        System.out.println("\n \n ");
//        System.out.println("The contents of " + pileIn + " are:");//for some reason not giving name
        for (int i = 0; i< pileSize; i++){//is pile size the highes index or highest index + 1 / number of objects
            tempCard = newList.get(i);
            tempCard.printCard();
        }
    }
}
