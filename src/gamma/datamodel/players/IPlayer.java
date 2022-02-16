package gamma.datamodel.players;

import gamma.datamodel.playingCards.IPlayingCard;

public interface IPlayer {

	public String getName();

	public int getCards();

	public IPlayingCard drawCard();

	public void giveCard(IPlayingCard card);

}
