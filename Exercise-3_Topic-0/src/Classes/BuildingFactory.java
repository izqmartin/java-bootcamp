package Classes;

public class BuildingFactory {
	
	
		public Building getBuilding(String type, String name){
			Building building=null;
			switch(type){
			case "Hospital":	building = new Hospital(name);
								return building;
			}
			return building;
		}
}
