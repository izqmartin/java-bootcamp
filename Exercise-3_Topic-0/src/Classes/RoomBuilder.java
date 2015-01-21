package Classes;


public interface RoomBuilder {
	public void assignName();
	public void buildWall();
	public void buildFloor();
	public void buildRoof();
	public void buildWindow();
	public void buildDoor();
	public Room getRoom();
}
