package gamma.datamodel.players;

import java.util.List;
import java.util.function.Supplier;

import sierra.injection.Inject;
import sierra.injection.Named;

public class PlayerFactory implements Supplier<IPlayer> {

	private final List<String> nameList;
	private int currentName;
	
	@Inject
	public PlayerFactory(@Named("Players") List<String> nameList) {
		super();
		this.nameList = nameList;
		this.currentName = 0;
	}

	@Override
	public IPlayer get() {
		return new Player(nameList.get(currentName++));
	}

}
