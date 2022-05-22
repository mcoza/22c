
public class Profile 
{
	private String name;
	private String status;
	public AList<Profile> friends;
  
	//constructors
	public Profile()
	{
		this.name = "Humphrey Hughes";
		this.status = "Online";
		this.friends = new AList<>();
	}
		
	public Profile(String name) 
	{
		this.name = name;
		this.status = "Online";
		this.friends = new AList<>();
	}
	
	
	//Getters & Setters
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getStatus()
	{ 
	return status; 
	}
  
	public void setOnlineStatus()
	{
	this.status = "Online";
	}
	  
	public void setOfflineStatus()
	{
	this.status = "Offline";
	}
	  
	public void setBusyStatus()
	{
	this.status = "Busy";
	}
  //end getters and setters
	
	
	
	public AList<Profile>getFriends()
	{
		return friends;
	}
	
	
	public void addFriend(Profile friendToAdd) 
	{
		friends.add(friendToAdd);
	}
	

	public boolean removeFriend(Profile friendToRemove)
	{
		boolean successful=false;
		
		for(int i=0;i<friends.getLength();i++)
		{
			
			if(friends.getEntry(i)==friendToRemove) 
			{
				friends.remove(i);
				
				successful=true;
			}
			
		}
		
		return successful;
			
	}//end remove friend
	
}//end profile