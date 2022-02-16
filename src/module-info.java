module gamma {
	// Sierra Engine Requirements
	requires transitive sierra;

	exports gamma to sierra;
	exports gamma.game to sierra;
	exports gamma.datamodel.players to sierra;
	exports gamma.datamodel.playingCards to sierra;
	exports gamma.utils to sierra;
	
	opens gamma to sierra;
	opens gamma.game to sierra;
}