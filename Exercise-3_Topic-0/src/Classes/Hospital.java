package Classes;

import java.util.ArrayList;

public class Hospital extends Building{
	
		private String hospitalName;
		
		public Hospital(String name){
			hospitalName=name;
			// build Intensive care guard room and insert in Arraylist
			RoomBuilder intensiveCareGuard = new IntensiveCareGuardBuilder();
			RoomDirector roomDirector =  new RoomDirector(intensiveCareGuard);
			roomDirector.constructRoom();
			rooms = new ArrayList<Room>();
			rooms.add(roomDirector.getRoom());
			
			// build Main hall room and insert in Arraylist
			RoomBuilder mainHall = new MainHallBuilder();
			roomDirector = new RoomDirector(mainHall);
			roomDirector.constructRoom();
			super.rooms.add(roomDirector.getRoom());
		
		}

		public String getHospitalName() {
			return hospitalName;
		}

		public void setHospitalName(String hospitalName) {
			this.hospitalName = hospitalName;
		}

		@Override
		public String toString() {
			return "Hospital [hospitalName=" + hospitalName + ", rooms=" + rooms + "]";
		}
		
		
		
		
}
