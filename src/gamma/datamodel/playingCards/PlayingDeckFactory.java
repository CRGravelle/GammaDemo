package gamma.datamodel.playingCards;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import sierra.injection.Inject;

public class PlayingDeckFactory implements Supplier<List<IPlayingCard>> {

	@Inject
	public PlayingDeckFactory() {
		super();
	}

	@Override
	public List<IPlayingCard> get() {
		List<IPlayingCard> playingDeck = new ArrayList<IPlayingCard>();

		for (Suit suit : Suit.values()) {
			for (Value value : Value.values()) {
				playingDeck.add(new PlayingCard(suit, value));
			}
		}

		return playingDeck;
	}

}
