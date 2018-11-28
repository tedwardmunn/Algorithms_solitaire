package Solitare;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static Stack<Card> sourcePile;

    public static SmallPile pile1 = new SmallPile();
    public static SmallPile pile2 = new SmallPile();
    public static SmallPile pile3 = new SmallPile();
    public static SmallPile pile4 = new SmallPile();
    public static SmallPile pile5 = new SmallPile();
    public static SmallPile pile6 = new SmallPile();
    public static SmallPile pile7 = new SmallPile();
    public static SmallPile pile8 = new SmallPile();
    public static SmallPile pile9 = new SmallPile();
    public static SmallPile pile10 = new SmallPile();

    public static ArrayList<SmallPile> smallPiles = new ArrayList<SmallPile>();//addint this redundancy fixed an issue
    public static ArrayList<Card> availableCards = new ArrayList<Card>(10);

    public static RestPile spadeRest1 = new RestPile("spades");//index 0
    public static RestPile spadeRest2 = new RestPile("spades");//1
    public static RestPile heartRest1 = new RestPile("hearts");//2
    public static RestPile heartRest2 = new RestPile("hearts");//3
    public static RestPile clubRest1 = new RestPile("clubs");//4
    public static RestPile clubRest2 = new RestPile("clubs");//5
    public static RestPile diamondRest1 = new RestPile("diamonds");//6
    public static RestPile diamondRest2 = new RestPile("diamonds");//7

    public static ArrayList<RestPile> restPiles = new ArrayList<RestPile>(8);
    public static ArrayList<Card> cardsWanted = new ArrayList<>(8);//there are max 8 possible cards besides aces that we could look for

    public static Stack<Card> cardsMoved = new Stack<>();
    public static ArrayList<Card> branchesToCheck = new ArrayList<>();

    public static int count = 0;
    public static int countMax = 0;

    public static boolean done = false;

    public static void setup(){
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
//        System.out.println("DECK NUMBER 1:");
//        printDeck(deck1);
//        System.out.println("DECK NUMBER 2:");
//        printDeck(deck2);
        shuffle(deck1);
//        System.out.println("deck 1 shuffled:");
//        printDeck(deck1);
        shuffle(deck2);
//        System.out.println("deck 2 shuffled:");
//        printDeck(deck2);
        sourcePile = stackDecks(deck1,deck2);
//        printPile(sourcePile);
        makeSmallPiles();
//        printSmallPiles(smallPiles);
        makeRestPiles(restPiles);
    }

    public static void printDeck(Deck deckIn1){
        int i,numTemp;
        Card tempCard;
        String kindTemp, suitTemp;
        for (i = 0; i<deckIn1.getSize(); i++){
            for (i = 0; i<deckIn1.getSize(); i++){
                tempCard = deckIn1.getCard(i);
                kindTemp = tempCard.getKind();
                suitTemp = tempCard.getSuit();
                numTemp = tempCard.getNumber();
                System.out.println("Card: " + i + " Kind: " + kindTemp + " Suit: " + suitTemp + " Number: " + numTemp);
            }
        }
    }

    public static void shuffle (Deck deckIn){
        ArrayList<Integer> cardNumbers = new ArrayList<Integer>();
        int i;
        int tempIndex;
        Card tempCard1;
        Card tempCard2;
//        System.out.println("the index values are:");
        for (i = 0; i<52; i++){
            cardNumbers.add(i);
//            System.out.println(cardNumbers.get(i));
        }
        Collections.shuffle(cardNumbers);
//        System.out.println("the shuffled index values are:");
        for (i = 0; i<52; i++){
//            System.out.println(cardNumbers.get(i));
        }
        for (i = 0; i<52; i++){
            tempIndex = cardNumbers.get(i);
            tempCard1 = deckIn.getCard(i);
            tempCard2 = deckIn.getCard(tempIndex);
            deckIn.insertCard(i,tempCard2);
            deckIn.insertCard(tempIndex, tempCard1);
        }
    }

    public static Stack<Card> stackDecks(Deck deckIn1, Deck deckIn2){
        Stack<Card> pile = new Stack<Card>();
        int i,indexCounter = 0;
        Card tempCard;
        for (i=0; i<52;i++){
            indexCounter++;
            tempCard = deckIn1.getCard(i);
            tempCard.setIndex(indexCounter);
            pile.push(tempCard);
        }
        for (i=0; i<52;i++){
            indexCounter++;
            tempCard = deckIn2.getCard(i);
            tempCard.setIndex(indexCounter);
            pile.push(tempCard);
        }
        return pile;
    }

    public static void printPile(Stack<Card> pileIn){
        ArrayList<Card> newList = new ArrayList<>(pileIn);
        int pileSize = newList.size();
        Card tempCard;
        System.out.println("\n \n ");
        System.out.println("The stacks contents are:");
        for (int i = 0; i< pileSize; i++){//is pile size the highes index or highest index + 1 / number of objects
            tempCard = newList.get(i);
            tempCard.printCard();
        }
    }

    public static void makeSmallPiles(){//create 10 stacks of size 4 //globally define, put into a new arraylist
        smallPiles.add(pile1);
        smallPiles.add(pile2);
        smallPiles.add(pile3);
        smallPiles.add(pile4);
        smallPiles.add(pile5);
        smallPiles.add(pile6);
        smallPiles.add(pile7);
        smallPiles.add(pile8);
        smallPiles.add(pile9);
        smallPiles.add(pile10);
        //maybe done use new here

        ArrayList<Card> newList = new ArrayList<>(sourcePile);
        int cardDealCount = 10*4;//4 cards for each pile
        int pileToAddTo;
        Card tempCard;
        for (int i = 0; i<cardDealCount;i++){//make less than because we are adding one extra to the first pile
            pileToAddTo = i%10;
            tempCard = newList.get(i);
            tempCard.setIndex(i%10);
            smallPiles.get(pileToAddTo).add(new Card(tempCard));
        }
    }

    public static void printSmallPiles(ArrayList<SmallPile> smallPiles){
        int size = smallPiles.size();
        for (int i = 0 ; i<size;i++){
            System.out.println("\n \n"+ "The contents of pile " + (i+1) + " are:");
            smallPiles.get(i).printSmallPile(smallPiles.get(i));
        }
    }

    public static void makeRestPiles(ArrayList<RestPile> restPiles){
        restPiles.add(spadeRest1);
        restPiles.add(spadeRest2);
        restPiles.add(heartRest1);
        restPiles.add(heartRest2);
        restPiles.add(clubRest1);
        restPiles.add(clubRest2);
        restPiles.add(diamondRest1);
        restPiles.add(diamondRest2);

        spadeRest1.add(new Card(0,1,-1));
        spadeRest2.add(new Card(0,1,-1));
        heartRest1.add(new Card(0,2,-1));
        heartRest2.add(new Card(0,2,-1));
        clubRest1.add(new Card(0,3,-1));
        clubRest2.add(new Card(0,3,-1));
        diamondRest1.add(new Card(0,4,-1));
        diamondRest2.add(new Card(0,4,-1));
    }
    //spades, spades, hearts, hearts, club, club, diamonds, diamonds



    /*----------------------------------------------------
    ALGORITHM BEGINS HERE
    ----------------------------------------------------*/

    //suit numbers spades, hearts, clubs, diamonds



    public static void getAvailableCards(){
        availableCards.clear();
        for(int i = 0; i<10;i++){
            if(smallPiles.get(i).getSmallPile().empty()==false) {
                smallPiles.get(i).getSmallPile().peek().setIndex(i);
                availableCards.add(smallPiles.get(i).getSmallPile().peek());
            }
        }
    }

    public static void printAvailabelCards(){
        Card tempCard;
        System.out.println("Available cards are: \n");
        for(int i=0;i<9;i++){
            tempCard = availableCards.get(i);
            System.out.println("Number " + tempCard.getNumber() + " Suit " + tempCard.getSuitNumber() + " Index " + tempCard.getIndex());
        }
    }


    public static void printRestPiles(){
        System.out.println("\nThe rest piles contents are:\n");
        for(int i = 0; i<8;i++){//eight piles here
            restPiles.get(i).printRestPile();
        }
    }

    public static void getNextCardsWanted(){
        cardsWanted.clear();
        Card tempCard;
        for(int i = 0; i<8;i++){
            if(restPiles.get(i).getFinalPile().empty() ==false){
                cardsWanted.add(restPiles.get(i).getFinalPile().peek());
            }
        }
        //return an arraylist of cards that we want to find in the next set of available cards
        //instead of returning one just create one thats global
    }

    public static void printNextCardsWanted() {
        //should do an iterator for this one because size varies

        if (cardsWanted.isEmpty()==false) {
            System.out.println("Cards wanted next are\n");
            for (Card card : cardsWanted) {
                int number = card.getNumber();
                int suitnumber = card.getSuitNumber();
                System.out.println("number " + (number +1)+ " suit " + suitnumber);
            }
            System.out.println("\n");

        }
        else{
            System.out.println("Game over cause no aces");
            System.exit(69);
        }
    }

    public static int next(){
        done = true;//set and change at the end
//        System.out.println("THE MAX NUMBER OF CARDS MOVED IS: " + (countMax));//counts first time that call is made
//        System.out.println("THE NUMBER OF CARDS MOVED IS: " + (count));//counts first time that call is made
        getAvailableCards();//gets next cards wanted
        getNextCardsWanted();
//        printRestPiles();
//        printNextCardsWanted();
//        printAvailabelCards();
        //need to create an arraylist and add the values because we dont know how large its going to be
        //if there is a card in cards wanted that matches available cards do something
        for(int j = 0; j<cardsWanted.size()-1;j++){//for(Card cardWanted: cardsWanted){
            Card cardWanted = cardsWanted.get(j);
            for(int i=0;i<availableCards.size()-1;i++){//for some reason thinks that available card is the one that was just pushed
                Card available = availableCards.get(i);//for(Card available: availableCards){
                if(available.getNumber()== cardWanted.getNumber()+1 && available.getSuitNumber()==cardWanted.getSuitNumber() && available.getPlaced()==false) {
                    //set boolean placed
//                    available.setPlaced(true);
//                    branchesToCheck.add(new Card(available));
//                    Card temp = available;
                    cardsMoved.push((available));//might actually have to copy, seems like moving this
                    place(available);
                }
            }
        }
        getAvailableCards();//gets next cards wanted
        getNextCardsWanted();
        for(int j = 0; j<cardsWanted.size()-1;j++){//for(Card cardWanted: cardsWanted){
            Card cardWanted = cardsWanted.get(j);
            for(int i=0;i<availableCards.size()-1;i++){
                Card available = availableCards.get(i);
                if(available.getNumber()== cardWanted.getNumber()+1 && available.getSuitNumber()==cardWanted.getSuitNumber() && available.getPlaced()==true) {
                    //set boolean placed
//                    available.setPlaced(true);
//                    branchesToCheck.add(available);//need to FUUCKING update this pile
//                    Card temp = available;
                    cardsMoved.push(available);
                    place(available);
                }
            }
        }
        for(Card check: branchesToCheck){
            if(check.getPlaced() == false){
                //if there is one that hasnt been placed we need to branch
                done = false;
            }
        }
        if(done == false){
            branch();
        }

//        branch();//should this be conditional
        return 0;
//        System.out.println("THE MAX NUMBER OF CARDS MOVED IS: " + (countMax));//counts first time that call is made
//        System.exit(42);//exits if no cards availble to push
    }

    public static void place(Card cardAvailable){//can use this if we push a card with number 0 first
        branchesToCheck.add(cardAvailable);//need to FUUCKING update this pile
        count = count + 1;
        if(count>countMax){
            countMax = count;
        }
        for(RestPile rest:restPiles){
            if(rest.check().getSuitNumber()==cardAvailable.getSuitNumber() && rest.check().getNumber() == (cardAvailable.getNumber()-1)) {
                if(smallPiles.get(cardAvailable.getIndex()).getSmallPile().empty()==false){
                rest.add(smallPiles.get(cardAvailable.getIndex()).remove());//error here
//                smallPiles.get(cardAvailable.getIndex()).removeNoReturn();
                next();//call recursively
                }
            }
        }
    }

    public static void branch(){
        count = 0;
        if(cardsMoved.size() == 0){
            next();
        }
        else if(cardsMoved.size() == 1){
            for(RestPile restPiles: restPiles) {
                if (cardsMoved.peek().getSuitNumber() == restPiles.getFinalPile().peek().getSuitNumber() && cardsMoved.peek().getNumber() == restPiles.getFinalPile().peek().getNumber()) {
                    restPiles.getFinalPile().pop();
                }
            }
            cardsMoved.peek().setPlaced(true);
            smallPiles.get(cardsMoved.peek().getIndex()).getSmallPile().add(cardsMoved.pop());
            next();
        }
        else if(cardsMoved.size()>1){
            while(cardsMoved.size() != 1){
                for(RestPile restPiles: restPiles){
                    if(cardsMoved.peek().getSuitNumber() == restPiles.getFinalPile().peek().getSuitNumber() && cardsMoved.peek().getNumber() == restPiles.getFinalPile().peek().getNumber()){
                        restPiles.getFinalPile().pop();
                    }
                }
                Card temp = cardsMoved.pop();
                if(cardsMoved.peek().getPlaced()==true){
                    temp.setPlaced(true);
                }
//            branchesToCheck.add(cardsMoved.peek());//need to FUUCKING update this pile
                smallPiles.get(temp.getIndex()).getSmallPile().add(temp);
            }
            for(RestPile restPiles: restPiles) {
                if (cardsMoved.peek().getSuitNumber() == restPiles.getFinalPile().peek().getSuitNumber() && cardsMoved.peek().getNumber() == restPiles.getFinalPile().peek().getNumber()) {
                    restPiles.getFinalPile().pop();
//                smallPiles.get(cardsMoved.peek().getIndex()).getSmallPile().add(cardsMoved.pop());
                }
            }
            cardsMoved.peek().setPlaced(true);
            smallPiles.get(cardsMoved.peek().getIndex()).getSmallPile().add(cardsMoved.pop());
            next();
//        return 2;
        }
//        return 3;
    }

    public static void resetBoard(){
        countMax = 0;
        availableCards.clear();
        sourcePile.clear();
        cardsMoved.clear();
        branchesToCheck.clear();
        cardsWanted.clear();
        for(SmallPile pile:smallPiles){
            pile.getSmallPile().clear();
        }
//        smallPiles.clear();
        for(RestPile pile:restPiles){
            pile.getFinalPile().clear();
        }
//        restPiles.clear();
        done = false;
    }

    public static void executeAlgorithm(){
//        next();
//        System.out.println("\nTHE NUMBER OF CARDS MOVED IS: " + (countMax));//counts first time that call is made
//        System.out.println("\n---------------------------------------------------------------------------");
//        System.out.println("Running algorithm many times:");
//        System.out.println("---------------------------------------------------------------------------");

//        for(int i = 0; i<=1000;i++){
//            //create functions to clear the rest piles and stuff
//            resetBoard();
//            setup();
//            next();
//            System.out.println(countMax);
//        }
        int iterationNumber = 0;
        while(countMax<15){
            //create functions to clear the rest piles and stuff
            resetBoard();
            setup();
            next();
            iterationNumber = iterationNumber+1;
            System.out.println(countMax);
        }
        System.out.println("Number of iterations is: " + iterationNumber);

    }

    public static void main(String[] args){

        setup();
        executeAlgorithm();
    }
}
