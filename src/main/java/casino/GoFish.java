package casino;

import javax.smartcardio.Card;

public class GoFish {

    Player players[] = new Player[4];

    for(i = 0; i < 4; i++)
        players[i] = new Player();

    Deck deck = new Deck();

    deck.shuffle();

    //each player gets 7 cards
    for(i = 0; i < 7; i++)
        for(j = 0; j < 4; j++)
    {
        Card c = deck.drawCard();
        players[j].addFromDeck(c);
    }

    boolean finished = false;
        int turn = 0;

        do
    {
        Card c = players[turn].nextGuess();
        int p = players[turn].fromWhom();
        boolean hasCard = players[p].containsCard(
                c.getNumber());
                players[turn].addFromOpponent(c);
    }
    else if (deck.hasCards())
    {
        c = deck.drawCard();
        players[j].addFromDeck(c);
    }
}while (!finished);
