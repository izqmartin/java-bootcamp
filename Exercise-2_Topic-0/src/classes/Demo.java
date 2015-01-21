package classes;

public class Demo {
	public static void main(String[] args) {

		HouseBuilder houseBuilder = new BrickHouseBuilder();
		HouseDirector houseDirector = new HouseDirector(houseBuilder);
		houseDirector.constructHouse();
		House house = houseDirector.getHouse();
		System.out.println("House is: \n" + house);
		
	}
}
