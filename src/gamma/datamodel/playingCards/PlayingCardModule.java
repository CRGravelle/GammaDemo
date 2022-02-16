package gamma.datamodel.playingCards;

import java.util.List;

import sierra.injection.SAIBinder;
import sierra.injection.SAIModule;
import sierra.injection.SierraTypeLiterals;

public class PlayingCardModule implements SAIModule {

	public PlayingCardModule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void configure(SAIBinder binder) {
		/*
		 * Again, we bind the Playing Deck Factory as a singleton.
		 */
		binder.bind(PlayingDeckFactory.class).toSingleton(PlayingDeckFactory.class);
		/*
		 * The injection library is capable of binding type literals as well, as seen
		 * below.
		 */
		binder.bind(SierraTypeLiterals.make(List.class, IPlayingCard.class)).toProvider(PlayingDeckFactory.class);
	}

}
