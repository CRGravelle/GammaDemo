package gamma.datamodel.players;

import java.util.LinkedList;
import java.util.List;

import gamma.datamodel.playingCards.IPlayingCard;

public class Player implements IPlayer {

	private final String name;
	
	private final List<IPlayingCard> deck;
	
	public Player(String name) {
		super();
		this.name = name;
		this.deck = new LinkedList<IPlayingCard>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getCards() {
		return deck.size();
	}

	@Override
	public IPlayingCard drawCard() {
		return deck.remove(0);
	}

	@Override
	public void giveCard(IPlayingCard card) {
		deck.add(card);
	}

	@Override
	public String toString() {
		return name;
	}

}
