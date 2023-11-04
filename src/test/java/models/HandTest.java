
package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class HandTest {

private Hand handTest;

@Test
public void getValueTest(){
handTest = new Hand();

Card card1 = new Card(Card.Suit.DIAMONDS,Card.Rank.FIVE);
Card card2 = new Card(Card.Suit.HEARTS,Card.Rank.SIX);

handTest.addCard(card1);
handTest.addCard(card2);

assertEquals(11,handTest.getValue());


}


}
