package Classes;

public class Test {
	public static void main(String[] args){
		BuildingFactory buildingFactory = new BuildingFactory();
		
		Building hospital = buildingFactory.getBuilding("Hospital", "Principal Hospital");
		
		System.out.println("Hospital 1: " + hospital);
	}
}
