package classes;

public class House {
	
	private String wall;
	private String door;
	private String window;
	private String floor;
	private String roof;
	
	
	public String getWall() {
		return wall;
	}
	
	public void setWall(String wall) {
		this.wall = wall;
	}
	
	public String getDoor() {
		return door;
	}
	
	public void setDoor(String door) {
		this.door = door;
	}
	
	public String getWindow() {
		return window;
	}
	
	public void setWindow(String window) {
		this.window = window;
	}
	
	public String getFloor() {
		return floor;
	}
	
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	public String getRoof() {
		return roof;
	}
	
	public void setRoof(String roof) {
		this.roof = roof;
	}
	
	public String toString(){
		return "Wall: " + wall + ",\n" + "Door: " + door + ",\n" + "Floor: " + floor + ",\n" + "Roof:" + roof + ",\n" + "Window: " + window + ".\n";
	}
	
	
	
}
