package Solitare;


public class Card {
    String kind, suit;
    int number, index,suitNumber;// ace = 1, jack = 11, queen 12, king 13
    boolean placed;

    Card(){
        kind = "blank";
        suit = "blank";
        suitNumber = 0;//1 spades, 2 hearts, 3 clubs, 4 diamonds
        number = 0;
        index = -1;
        placed = false;
    }

    Card(int numberIn, int suitNumberIn, int indexIn){
        kind = "blank";
        suit = "blank";
        suitNumber = suitNumberIn;
        number = numberIn;
        index = indexIn;
        placed = false;
    }

    Card(Card cardIn){
        kind = cardIn.getKind();
        suit = cardIn.getSuit();
        if(suit == "spades"){
            suitNumber = 1;
        }
        else if(suit == "hearts"){
            suitNumber = 2;
        }
        else if(suit == "clubs"){
            suitNumber = 3;
        }
        else if(suit == "diamonds"){
            suitNumber = 4;
        }
        number = cardIn.getNumber();
        index = cardIn.getIndex();
        placed = false;
    }

    Card(String kindIn, String suitIn, int numberIn, int indexIn){
        kind = kindIn;
        suit = suitIn;
        if(suit == "spades"){
            suitNumber = 1;
        }
        else if(suit == "hearts"){
            suitNumber = 2;
        }
        else if(suit == "clubs"){
            suitNumber = 3;
        }
        else if(suit == "diamonds"){
            suitNumber = 4;
        }
        number = numberIn;
        index = indexIn;
        placed = false;
    }

    void setPlaced(boolean in){
        placed = in;
    }

    boolean getPlaced(){
        return placed;
    }

    String getKind(){
        return kind;
    }

    String getSuit(){
        return suit;
    }

    int getSuitNumber(){return suitNumber;}

    int getNumber(){
        return number;
    }

    int getIndex(){return index;}

    void setIndex(int newIndex){
        index = newIndex;
    }

    public void printCard(){//is there a way to do this without passing an object in
        String kindTemp = this.getKind();
        String suitTemp = this.getSuit();
        int numTemp = this.getNumber();
        int indexTemp = this.getIndex();
        System.out.println(" Kind: " + kindTemp + " Suit: " + suitTemp + " Number: " + numTemp + " Index: " + indexTemp);
    }
}
