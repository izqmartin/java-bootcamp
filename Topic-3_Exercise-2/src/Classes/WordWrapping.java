package Classes;

import java.util.ArrayList;

public class WordWrapping {
	
	public int spacesIndex=0;
	public double cantOfWords=0;
	ArrayList<String> list = new ArrayList<String>();
	
	
	public ArrayList<String> wordWrap(String testString, int rowLength) {
		
		
		// Base Case
		if(rowLength >= testString.length()){
			String aux1 ='"' + testString + '"' + " "; 
			list.add(aux1);
			//return list;
		}
		else{
			// String without spaces
			spacesIndex=testString.indexOf(" ", 0);
			if(spacesIndex == -1){
				String aux2 = '"' + testString.substring(0, rowLength) + '"' + " ";
				list.add(aux2);
				aux2=testString.substring(rowLength);
				testString=aux2;
				wordWrap(aux2,rowLength);
			}
			else{
				//The String has spaces but the words are larger than the row length
				spacesIndex=testString.indexOf(" ", 0);
				if(spacesIndex >= rowLength) {
					String aux3 = '"' + testString.substring(0, rowLength) + '"' + " ";
					list.add(aux3);
					aux3=testString.substring(rowLength);
					testString=aux3;
					wordWrap(aux3,rowLength);
				}
				else{
					//The String has spaces and the words are smaller than the row length
					spacesIndex=testString.indexOf(" ", 0);
					int indexAux = spacesIndex;
					
					while(spacesIndex<=rowLength && spacesIndex!=-1){
						indexAux=spacesIndex;
						spacesIndex=testString.indexOf(" ", spacesIndex+1);
					}
					spacesIndex=indexAux;
					
					String aux4 = '"' + testString.substring(0, spacesIndex) + '"' + " ";
					list.add(aux4);
					aux4=testString.substring(spacesIndex+1);
					testString=aux4;
					wordWrap(aux4,rowLength);
				}
			}
		}
		return list;
	}
}
