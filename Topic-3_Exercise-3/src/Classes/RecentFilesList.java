package Classes;

import java.util.ArrayList;


public class RecentFilesList {
	
	ArrayList<String> list = new ArrayList();

	public void Open(String file){
		int flag=0;
		for(int i=0;i<=list.size()-1;i++){
			if(list.get(i).equals(file)){
				list.remove(i);
				list.add(file);
				flag=1;
			}
		}
		if(flag==0){
			if(list.size()<15){
				list.add(file);
			}
			else{
				list.remove(0);
				list.add(file);
			}
		}
		}
	
	@Override
	public String toString() {
		return "RecentFilesList [list=" + list + "]" +  "      cantidad de objetos:"  + list.size();
	}
	
	public String Show(){
		return toString();
	}
}


