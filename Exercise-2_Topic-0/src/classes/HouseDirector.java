package classes;

public class HouseDirector {
	private HouseBuilder houseBuilder = null;

	public HouseDirector(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	public void constructHouse() {
		houseBuilder.buildWall();
		houseBuilder.buildRoof();
		houseBuilder.buildFloor();
		houseBuilder.buildWindow();
		houseBuilder.buildDoor();
	}

	public House getHouse() {
		return houseBuilder.getHouse();
	}
}
