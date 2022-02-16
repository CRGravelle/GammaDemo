package gamma;

import gamma.datamodel.players.IPlayer;
import gamma.datamodel.players.PlayerModule;
import gamma.datamodel.playingCards.IPlayingCard;
import gamma.game.GameModule;
import gamma.game.IDealer;
import gamma.utils.ResourceModule;
import sierra.application.SAILauncher;
import sierra.application.SierraApplication;
import sierra.injection.Inject;
import sierra.injection.Requires;
import sierra.logging.SAILogger;
import sierra.logging.SierraLoggingLevel;
import sierra.logging.SierraLoggingModule;

@Requires({ SierraLoggingModule.class, GameModule.class, PlayerModule.class, ResourceModule.class })
public class GammaDemo implements SAILauncher {

	public static void main(String[] args) {
		SierraApplication.launch(GammaDemo.class, args);
	}

	private final SAILogger logger;

	@Inject
	private final IPlayer player1 = null;
	@Inject
	private final IPlayer player2 = null;

	@Inject
	private final IDealer dealer = null;

	@Inject
	public GammaDemo(SAILogger logger) {
		super();
		this.logger = logger;
	}

	@Override
	public void launch() {
		logger.level(SierraLoggingLevel.INFO).key("Gamma Demo").message("Starting Gamma Demo").log();

		logger.level(SierraLoggingLevel.INFO).key("Gamma Demo").message("Players")
				.token("First Player", player1.getName()).token("Second Player", player2.getName()).log();

		dealer.deal(player1, player2);

		logger.level(SierraLoggingLevel.INFO).key("Gamma Demo").message("Beggining game of War").log();
		while (player1.getCards() > 0 && player2.getCards() > 0) {
			IPlayingCard card1 = player1.drawCard();
			IPlayingCard card2 = player2.drawCard();

			logger.level(SierraLoggingLevel.DEBUG).key("Gamma Demo").message("Playing Cards")
					.token(player1.getName(), card1).token(player2.getName(), card2);

			if (card1.compareTo(card2) > 0) {
				player1.giveCard(card1);
				player1.giveCard(card2);
				logger.token("Winner", player1);
			} else {
				player2.giveCard(card2);
				player2.giveCard(card1);
				logger.token("Winner", player2);
			}
			logger.log();
		}

		logger.level(SierraLoggingLevel.INFO).key("Gamma Demo").message("Game has finished");
		if (player1.getCards() > 0) {
			logger.token("Winner", player1);
		} else {
			logger.token("Winner", player2);
		}
		logger.log();

	}

}
