package gamma.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gamma.datamodel.players.IPlayer;
import gamma.datamodel.playingCards.IPlayingCard;
import sierra.injection.Inject;
import sierra.logging.SAILogger;
import sierra.logging.SierraLoggingLevel;

public class Dealer implements IDealer {

	@Inject
	private final Random rand = null;

	private final SAILogger logger;
	private List<IPlayingCard> deck;

	@Inject
	public Dealer(SAILogger logger, List<IPlayingCard> deck) {
		super();
		this.logger = logger;
		this.deck = deck;
	}

	@Override
	public void deal(IPlayer... players) {
		shuffleDeck();
		dealDeck(players);
	}

	private void shuffleDeck() {
		logger.level(SierraLoggingLevel.INFO).key("Gamma Demo").message("Shuffling Deck").log();
		List<IPlayingCard> shuffledDeck = new ArrayList<IPlayingCard>();
		while (deck.size() > 0) {
			IPlayingCard card = deck.remove(rand.nextInt(deck.size()));
			shuffledDeck.add(card);
			logger.level(SierraLoggingLevel.DEBUG).key("Gamma Demo").message("Added card to shuffled deck")
					.token("Card", card).log();
		}
		this.deck = shuffledDeck;
	}

	private void dealDeck(IPlayer... players) {
		logger.level(SierraLoggingLevel.INFO).key("Gamma Demo").message("Dealing Deck").log();
		int currentPlayer = 0;

		while (deck.size() > 0) {
			IPlayingCard card = deck.remove(0);
			players[currentPlayer].giveCard(card);
			logger.level(SierraLoggingLevel.DEBUG).key("Gamma Demo").message("Dealt card to player").token("Card", card)
					.token("Player", players[currentPlayer]).log();
			currentPlayer = (currentPlayer + 1) % players.length;
		}
	}

}
