package Classes;

public class Room {

		private String name;
		private String wall;
		private String floor;
		private String roof;
		private String door;
		private String window;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getWall() {
			return wall;
		}
		public void setWall(String wall) {
			this.wall = wall;
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
		@Override
		public String toString() {
			return "Room [name=" + name + ",\n wall=" + wall + ",\n floor=" + floor + ",\n roof=" + roof + ",\n door=" + door + ",\n window="
					+ window + ".]";
		}
		
		
		
}
