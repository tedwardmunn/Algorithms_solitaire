//package Solitare;
//
//import java.util.*;
//
//public class Pile {
//    Stack<Card> pile;
//
//    Pile(ArrayList<Deck> deckIn, int pileSize){
////        int size = deckIn.size();
//        for (int i= 0; i<=pileSize; i++){
//           Card tempCard =  deckIn.get(i).getCard(i);
//            pile.push(tempCard);
//        }
//    }
//
//    Pile(Stack<Card> stackIn, int pileSize){
//        for (int i= 0; i<=pileSize; i++){
//            Card tempCard = stackIn.pop();
//            pile.push(tempCard);
//        }
//    }
//
//    public void pilePop(){
//        return pile.getPile.pop();
//    }
//
//    public Stack<Card> getPile(){
//        return pile;
//    }
//
//    public void printPile(Stack<Card> pileIn){
//        Card tempCard;
//        Stack<Card> tempStack = new Stack<Card>();
//        System.out.println("The stacks contents are");
//        while(pileIn.pop() != null){
//            tempCard =  pileIn.pop();
//            tempStack.push(tempCard);
//            tempCard.printCard(tempCard);
//        }
//        while(tempStack.pop() != null){
//            tempCard = tempStack.pop();
//            pileIn.push(tempCard);
//        }
//    }
//
//    public void printPile(Pile pileIn){
//        Card tempCard;
//        Stack<Card> tempStack = new Stack<Card>();
//        System.out.println("The stacks contents are");
//        while(pileIn.pop() != null){
//            tempCard =  pileIn.pop();
//            tempStack.push(tempCard);
//            tempCard.printCard(tempCard);
//        }
//        while(tempStack.pop() != null){
//            tempCard = tempStack.pop();
//            pileIn.push(tempCard);
//        }
//    }
//    //create a method to add the two stacks together, or just use piles after the initial stack is made
//
////
////    Pile(ArrayList<Card> cardsIn){
////        int size = cardsIn.size();
////        for (int i= 0; i<=size; i++){
////            Card tempCard =  cardsIn.get(i);
////            pile.push(tempCard);
////        }
////    }
//}
