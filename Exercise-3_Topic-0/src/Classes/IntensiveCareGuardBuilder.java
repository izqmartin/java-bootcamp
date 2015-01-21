package Classes;

public class IntensiveCareGuardBuilder implements RoomBuilder{
	private Room room;
	
	public IntensiveCareGuardBuilder(){
		room = new Room();
	}
	
	@Override
	public void buildWall(){
		room.setWall("Intensive care guard Wall");
	}
	
	@Override
	public void buildRoof(){
		room.setRoof("Intensive care guard Roof");
	}
	@Override
	public void buildFloor(){
		room.setFloor("Intensive care guard Floor");
	}
	@Override
	public void buildDoor(){
		room.setDoor("Intensive care guard Door");
	}
	@Override
	public void buildWindow(){
		room.setWindow("Intensive care guard Window");
	}
	@Override
	public void assignName(){
		room.setName("Intensive care guard");
	}
	@Override
	public Room getRoom(){
		return room;
	}
}
