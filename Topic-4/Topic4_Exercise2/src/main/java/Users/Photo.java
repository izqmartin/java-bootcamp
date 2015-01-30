package Users;

import java.util.ArrayList;
/**
 * Class photo contain link to the url an array with likes
 * @author Martin
 *
 */
public class Photo {

	private String link;
	private ArrayList<String> likes;
	
	public Photo(String link){
		this.link=link;
		likes = new ArrayList<String>();
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public ArrayList<String> getLikes() {
		return likes;
	}

	public void setLikes(ArrayList<String> likes) {
		this.likes = likes;
	}
	
	/**
	 * Do like or unlike in the photo.
	 * @param userName name of the user who like 
	 */
	public void Like(String userName){
		if(!likes.contains(userName)){
		likes.add(userName);
		}
		else{
			likes.remove(userName);
		}
	}


	@Override
	public String toString() {
		return "Photo [link=" + link + ", Likes("+likes.size()+")=" + likes + "]";
	}
	
	
}
