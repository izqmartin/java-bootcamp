package classes;

public class BrickHouseBuilder implements HouseBuilder {
	private House house;
	
	public BrickHouseBuilder() {
		house = new House();
	}
	
	@Override
	public void buildWall(){
		house.setWall("Brick Wall");
	}
	@Override
	public void buildRoof(){
		house.setRoof("Brick House Roof");
	}
	@Override
	public void buildWindow(){
		house.setWindow("brick house window");
	}
	@Override
	public void buildDoor(){
		house.setDoor("brick house door");
	}
	@Override
	public void buildFloor(){
		house.setFloor("brick house floor");
	}
	@Override
	public House getHouse(){
		return house;
	}
}
