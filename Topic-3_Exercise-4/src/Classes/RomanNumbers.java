package Classes;

public class RomanNumbers {

	public String IntToRoman(int number) {
		String s = "";
		while (number >= 1000) {		//calculate numbers >=1000 and add to string "s"
			s += "M";
			number -= 1000;
		}
		while (number >= 900) {			//calculate numbers >=900 and add to string "s"
			s += "CM";
			number -= 900;
		}
		while (number >= 500) {			//calculate numbers >=500 and add to string "s"
			s += "D";
			number -= 500;
		}
		while (number >= 400) {			//calculate numbers >=400 and add to string "s"
			s += "CD";
			number -= 400;
		}
		while (number >= 100) {			//calculate numbers >=100 and add to string "s"
			s += "C";
			number -= 100;
		}
		while (number >= 90) {			//calculate numbers >=90 and add to string "s"
			s += "XC";
			number -= 90;
		}
		while (number >= 50) {			//calculate numbers >=50 and add to string "s"
			s += "L";
			number -= 50;
		}
		while (number >= 40) {			//calculate numbers >=40 and add to string "s"
			s += "XL";
			number -= 40;
		}
		while (number >= 10) {			//calculate numbers >=10 and add to string "s"
			s += "X";
			number -= 10;
		}
		while (number >= 9) {			//calculate numbers >=9 and add to string "s"
			s += "IX";
			number -= 9;
		}
		while (number >= 5) {			//calculate numbers >=5 and add to string "s"
			s += "V";
			number -= 5;
		}
		while (number >= 4) {			//calculate numbers >=4 and add to string "s"
			s += "IV";
			number -= 4;
		}
		while (number >= 1) {			//calculate numbers >=1 and add to string "s"
			s += "I";
			number -= 1;
		}
		return s;
	}
	
	public int RomanToInt(String roman){
		int integ=0;
		char[] rom= roman.toCharArray();
		for(int i=0;i<rom.length;i++){
			switch(rom[i]){
			case 'M': integ+=1000;
						break;
			case 'C': integ+=100;
						break;
			case 'L': integ+=50;
						break;
			case 'X': integ+=10;
						break;
			case 'V': integ+=5;
						break;
			case 'I': integ+=1;
						break;
			}
		}
		return integ;
	}
	
}
