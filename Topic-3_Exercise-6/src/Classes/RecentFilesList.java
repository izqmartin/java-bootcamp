package Classes;

import java.util.ArrayList;


public class RecentFilesList {
	
	ArrayList<Entry> list = new ArrayList();
	
	public void Open(Entry file){
		int flag=0;
		for(int i=0;i<=list.size()-1;i++){
			if(list.get(i).getTitle().equals(file.getTitle())){
				list.remove(i);
				list.add(file);
				flag=1;
			}
		}
		if(flag==0){
			if(list.size()<10){
				list.add(file);
			}
			else{
				list.remove(0);
				list.add(file);
			}
		}
		}
	
	public void Delete(Entry file){
		for(int i=0;i<=list.size()-1;i++){
			if(list.get(i).getTitle().equals(file.getTitle())){
				list.remove(i);
			}
		}
		}
	
	public void Show(){
		System.out.println("\nList of Recent Posts: " + list);
	}
	
	@Override
	public String toString(){
		return "List of Recent Posts: " + list;
	}
}


