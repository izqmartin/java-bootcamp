package Classes;

public class MainHallBuilder implements RoomBuilder{

		private Room room;
		
		public MainHallBuilder(){
			room = new Room();
		}
		
		@Override
		public void buildWall(){
			room.setWall("main hall Wall");
		}
		
		@Override
		public void buildRoof(){
			room.setRoof("main hall Roof");
		}
		@Override
		public void buildFloor(){
			room.setFloor("main hall Floor");
		}
		@Override
		public void buildDoor(){
			room.setDoor("main hall Door");
		}
		@Override
		public void buildWindow(){
			room.setWindow("main hall Window");
		}
		@Override
		public void assignName(){
			room.setName("Main hall");
		}
		@Override
		public Room getRoom(){
			return room;
		}
}
