package Classes;

import java.util.ArrayList;

public class Blog {
	private ArrayList<Entry> list= new ArrayList<Entry>();
	private RecentFilesList recentEntrys = new RecentFilesList();
	
	
	
	public ArrayList<Entry> getList() {
		return list;
	}

	public void setList(ArrayList<Entry> list) {
		this.list = list;
	}

	public RecentFilesList getRecentEntrys() {
		return recentEntrys;
	}

	public void setRecentEntrys(RecentFilesList recentEntrys) {
		this.recentEntrys = recentEntrys;
	}

	public String PostEntry(String title,String text,String tag){
		Entry entry=new Entry(title,text,tag);
		list.add(entry);
		System.out.println("\nAll posts: " + list);
		recentEntrys.Open(entry);
		recentEntrys.Show();
		return recentEntrys.toString();
	}
	
	public void DeleteEntry(String title,String text,String tag){
		Entry entry=new Entry(title,text,tag);
		for(int i=0;i<=list.size()-1;i++){
			if(list.get(i).getTitle().equals(entry.getTitle())){
				list.remove(i);
			}
		}
		System.out.println(list);
		recentEntrys.Delete(entry);
		recentEntrys.Show();
	}
	
	public void UpdateEntry(String title,String text,String tag){
		Entry entry=new Entry(title,text,tag);
		for(int i=0;i<=list.size()-1;i++){
			if(list.get(i).getTitle().equals(entry.getTitle())){
				list.get(i).setText(entry.getText());
				list.get(i).setTag(entry.getTag());
			}
		}
		System.out.println(list);
		recentEntrys.Open(entry);
		recentEntrys.Show();
	}
	
	public String TagSearch(String tag){
		ArrayList<Entry> tagList = new ArrayList<Entry>();
		Entry entry=new Entry("","",tag);
		for(int i=0;i<=list.size()-1;i++){
			if(list.get(i).getTag().equals(entry.getTag())){
				entry=list.get(i);
				tagList.add(entry);
			}
		}
		System.out.println("\n TAG Search \""+ tag + "\" : " + tagList);
		return "TAG Search \""+ tag + "\" : " + tagList;
	}
	
	public String AllTags(){
		ArrayList<String> tagList = new ArrayList<String>();
		String tag=list.get(0).getTag();
		tagList.add(tag);
		for(int i=0;i<=list.size()-1;i++){
			for(int j=0;j<=tagList.size()-1;j++){
				if(!list.get(i).getTag().equals(tagList.get(j))){
					tagList.add(list.get(i).getTag());
				}
			}
			
		}
		System.out.println("\n TAG List : " + tagList);
		return "TAG List : " + tagList;
	}
}
