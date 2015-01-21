package Classes;

public class RoomDirector {

	private RoomBuilder roomBuilder = null;
	
	public RoomDirector(RoomBuilder roomBuilder){
		this.roomBuilder=roomBuilder;	
	}
	
	public void constructRoom(){
		roomBuilder.buildDoor();
		roomBuilder.buildWall();
		roomBuilder.buildFloor();
		roomBuilder.buildRoof();
		roomBuilder.buildWindow();
		roomBuilder.assignName();
	}
	
	public Room getRoom(){
		return roomBuilder.getRoom();
	}
	
}
