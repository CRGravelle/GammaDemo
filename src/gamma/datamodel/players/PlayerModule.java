package gamma.datamodel.players;

import java.util.ArrayList;
import java.util.List;

import sierra.injection.SAIBinder;
import sierra.injection.SAIModule;
import sierra.injection.SierraTypeLiterals;

public class PlayerModule implements SAIModule {

	public PlayerModule() {
		super();
	}

	@Override
	public void configure(SAIBinder binder) {
		/*
		 * This causes the Player Factory itself to only ever have one instance rather
		 * than a new one being created for every request.
		 */
		binder.bind(PlayerFactory.class).toSingleton(PlayerFactory.class);
		/*
		 * Any time a player is requested, the injection library will use the singleton
		 * Player Factory.
		 */
		binder.bind(IPlayer.class).toProvider(PlayerFactory.class);

		/*
		 * Create a list of potential names for players.
		 */
		List<String> nameList = nameList();

		/*
		 * The injection library allows you to bind to a Type Literal. In this case, a
		 * List of Strings. It also Allows you to name that list so that you can
		 * potentially bind multiple Lists of Strings for different purposes.
		 */
		binder.bind(SierraTypeLiterals.make(List.class, String.class)).named("Players").toInstance(nameList);
	}

	private List<String> nameList() {
		List<String> nameList = new ArrayList<String>();
		nameList.add("Casey");
		nameList.add("Katlyn");
		nameList.add("Dylan");
		nameList.add("Sarah");
		nameList.add("Sam");
		nameList.add("Bobby");
		nameList.add("Mec");
		nameList.add("Laura");
		nameList.add("Aly");
		return nameList;
	}

}
