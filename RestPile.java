package Solitare;

import java.util.ArrayList;
import java.util.Stack;

public class RestPile {
    Stack<Card> rest;
    String type;

    RestPile(){
        rest = new Stack<>();
        type = "";
    }

    RestPile(String typeIn){
        rest = new Stack<>();
        type = typeIn;
    }

    void add(Card cardIn){
        rest.push(cardIn);
    }

    Card remove(){
        return rest.pop();
    }

    Stack<Card> getFinalPile(){
        return rest;
    }

    String getType(){ return type; }

    Card check(){return rest.peek();}

    void setType(String typeIn){type = typeIn;}

    boolean hasCard(){
        boolean hasCard = false;
        if(this.rest.peek() != null){//if the stack is not empty
            hasCard = true;
        }
        return hasCard;
    }

    void printRestPile(){
        ArrayList<Card> newList = new ArrayList<>(this.getFinalPile());
        int pileSize = newList.size();
        Card tempCard;
        System.out.println(this.getType() + " pile");
//        System.out.println("The contents of " + pileIn + " are:");//for some reason not giving name
        for (int i = 0; i< pileSize; i++){//is pile size the highes index or highest index + 1 / number of objects

            tempCard = newList.get(i);
            tempCard.printCard();
        }
        System.out.println("\n");

    }


}//end of class
