public class blackJack{
    public static void main(String[] args){
        int money;
        int bet;
        boolean userWins;
        boolean blackJack;
        
        TextIO.putln("Welcome to Black Jack");
        TextIO.putln("The Table Minimum is 10$");
        
        money = 1000; //user starts with 1000$
        bet = 0;
        
        while(true){
            while(true){
                if (money < 10){ //checks to make sure user has enough money to play
                    TextIO.putln("You are out of money.");
                    break;
                }
                TextIO.putln("\nMoney: " + money + "$");//display how much moeny user has
                TextIO.putln("Place your bet.");
                bet = TextIO.getlnInt(); //gets bet amount from user
                //check for valid bet
                if (bet > money)
                    TextIO.putln("Enter valid amount");
                else if (bet < 10)
                    TextIO.putln("The table mimimum is 10$");
                else
                    break;
            }//end while
                
                //check for win
                userWins = playBlackJack();
                if (userWins)
                    money = money + bet;
                else
                    money = money - bet;
        }//end while
    
    }//end main()


    //playBlackJack
    static boolean playBlackJack(){
        Deck deck;
        blackJackHand userHand;
        blackJackHand dealerHand;

        deck = new Deck(); //create deck of cards
        userHand = new blackJackHand(); // create user hand
        dealerHand = new blackJackHand(); // create dealer hand

        //shuffle deck
        deck.shuffle();

        //deal cards
        dealerHand.addCard(deck.dealCard());
        userHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        userHand.addCard(deck.dealCard());


        //play
        while(true){
        //show Dealer Cards
        TextIO.putln("\nDealer is showing the " + dealerHand.getCard(1) + "\n");
            
        //show users cards
        TextIO.putln("You have the" + userHand.printHand());
        TextIO.putln("You have " + userHand.getHandValue() + "\n");
        
        //check for black jack
        if (dealerHand.getHandValue() == 21){
            TextIO.putln("Dealer has 21.\n You Lose.");
            return false;
        }
        else if(userHand.getHandValue() == 21){
            TextIO.putln("Black Jack!");
            return true;
        }
            
        //hit or stand?
        TextIO.putln("Would you like to (H)it or (S)tand?");
        char hitStand;

        //check for valid input
        while(true){
        hitStand = TextIO.getlnChar();
            if (hitStand != 'h' && hitStand != 'H' && hitStand != 's' && hitStand != 'S'){
            TextIO.putln("Invalid input");
            }
        else
            break;
        }

        if (hitStand == 'h' || hitStand == 'H'){
            Card newCard = deck.dealCard();
            TextIO.putln("\nYour card is the " + newCard);
            userHand.addCard(newCard);
            TextIO.putln("You now have " + userHand.getHandValue());
            if(userHand.getHandValue() > 21){
                TextIO.putln("Bust");
                TextIO.putln("Dealer had " + dealerHand.getHandValue());
                return false;
            }
        }
        else
            break;

        }//end while loop

        //check winner
        TextIO.putln("\nDealer has the" + dealerHand.printHand());
        TextIO.putln("Dealer has " + dealerHand.getHandValue());
        while(dealerHand.getHandValue() <= 16){
        Card newCard = deck.dealCard();
        TextIO.putln("\nDealer is dealt a " + newCard);
        dealerHand.addCard(newCard);
        TextIO.putln("\nDealer has the" + dealerHand.printHand());
        TextIO.putln("Dealer now has " + dealerHand.getHandValue());

        //check if dealer bust
        if(dealerHand.getHandValue() > 21){
        TextIO.putln("Dealer busted!\nYou Win!");
        return true;
        }

        }//end while loop

        //winner
        if(dealerHand.getHandValue() == userHand.getHandValue()){
            TextIO.putln("You Push.");
            return false;
        }
        else if(dealerHand.getHandValue() > userHand.getHandValue()){
            TextIO.putln("You Lose.");
            return false;
        }
        else{
            TextIO.putln("You Win!");
            return true;
        }
    }//end playBlackJack
}//end BlackJackClass

