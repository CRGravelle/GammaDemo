package gamma.datamodel.playingCards;

public class PlayingCard implements IPlayingCard {

	private final Suit suit;
	private final Value value;

	public PlayingCard(final Suit suit, final Value card) {
		super();
		this.suit = suit;
		this.value = card;
	}

	@Override
	public Suit getSuit() {
		return suit;
	}

	@Override
	public Value getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value + " of " + suit;
	}

	@Override
	public int compareTo(IPlayingCard o) {
		if (this == o) {
			return 0;
		} else {
			int valueComparison = Integer.compare(value.ordinal(), o.getValue().ordinal());
			return valueComparison != 0 ? valueComparison : Integer.compare(suit.ordinal(), o.getSuit().ordinal());
		}
	}

}
