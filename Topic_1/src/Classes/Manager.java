package Classes;

import Interfases.Observer;

public class Manager implements Observer {

	@Override
	public void doUpdate(String message) {
		System.out.println(message);
	}
}
