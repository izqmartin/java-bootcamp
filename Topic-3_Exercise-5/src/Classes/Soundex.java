package Classes;

public class Soundex {
	
	    public String SoundexConverter(String text) { 
	        char[] letter = text.toUpperCase().toCharArray();
	        char firstLetter = letter[0];

	        // convert letters to numeric code
	        for (int i = 0; i < letter.length; i++) {
	            switch (letter[i]) {
	            
	                case 'B':	letter[i] = '1'; 
								break;								
	                case 'C':	letter[i] = '2'; 
	                			break;	                			
	                case 'D':	letter[i] = '3'; 
	                			break;  			
	                case 'F':	letter[i] = '1'; 
								break;
	                case 'G':	letter[i] = '2'; 
	                			break;	
	                case 'J':	letter[i] = '2'; 
        						break;		
	                case 'K':	letter[i] = '2'; 
								break;
	                case 'L':   letter[i] = '4'; 
	                			break;
	                case 'M':	letter[i] = '5'; 
	                			break;
	                case 'N':   letter[i] = '5';
	                			break;
	                case 'P':	letter[i] = '1'; 
        						break;	
	                case 'Q':	letter[i] = '2'; 
	                			break;
	                case 'R':   letter[i] = '6'; 
	                			break; 
	                case 'S':	letter[i] = '2'; 
	                			break;
	                case 'T':   letter[i] = '3'; 
	                			break;
	                case 'V':  	letter[i] = '1'; 
	                			break; 
	                case 'X':	letter[i] = '2'; 
	                			break;
	                case 'Z':   letter[i] = '2'; 
	                			break;
	                default:    letter[i] = '0'; 
	                			break;
	            }
	        }

	        // remove duplicates
	        String string = "" + firstLetter;
	        for (int i = 1; i < letter.length; i++)
	            if (letter[i] != letter[i-1] && letter[i] != '0')
	                string += letter[i];	

	        // pad with 0's or truncate
	        string = string + "0000";
	        return string.substring(0, 4);
	    }

	
}
