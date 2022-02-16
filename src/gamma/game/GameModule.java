package gamma.game;

import gamma.datamodel.playingCards.PlayingCardModule;
import gamma.utils.ResourceModule;
import sierra.injection.Requires;
import sierra.injection.SAIBinder;
import sierra.injection.SAIModule;

@Requires({ ResourceModule.class, PlayingCardModule.class })
public class GameModule implements SAIModule {

	public GameModule() {
		super();
	}

	@Override
	public void configure(SAIBinder binder) {
		/*
		 * Binding an implementation of the Dealer. Here we choose not to bind it as a
		 * singleton, primarily for demonstration purposes, but also because of how the
		 * constructor was defined to take an instance of a deck.
		 */
		binder.bind(IDealer.class).toImplementation(Dealer.class);
	}

}
