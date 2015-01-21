package Classes;

import java.util.ArrayList;

public abstract class Building {
	
	protected ArrayList<Room> rooms;

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	

	@Override
	public String toString() {
		return "Building [rooms=" + rooms + "]";
	}
	
	

}
