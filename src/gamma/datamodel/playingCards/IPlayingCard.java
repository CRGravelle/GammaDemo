package gamma.datamodel.playingCards;

public interface IPlayingCard extends Comparable<IPlayingCard> {

	public Suit getSuit();
	
	public Value getValue();
	
}
