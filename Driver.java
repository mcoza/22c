import java.util.Iterator;
import java.util.Scanner;

public class Driver {

	
	public static void main(String[] args) 
	{		
        System.out.println("Welcome to Social Disaster.");
        interactWithUser();
	}  // end main
	
	
	public static void display(DictionaryInterface<String, Profile> dictionary)
    {
        Iterator<String> keyIterator   = dictionary.getKeyIterator();
        Iterator<Profile> valueIterator = dictionary.getValueIterator();

        while (keyIterator.hasNext() && valueIterator.hasNext())
        {
             
           printProfile( valueIterator.next());
            System.out.println("------------------------------");
        }
        System.out.println();
    } // end display
	
	
	public static void printProfile(Profile userProfile)
    {
        System.out.println("Name: " + userProfile.getName());
        System.out.println("Status: " + userProfile.getStatus());
        System.out.println("Friends: " + userProfile.getFriends().getLength()+" "+ userProfile.getFriends().toString());

    }//end print profile
	
	
	public static void displayStartMenu()
	{
	
		System.out.print("\nChoose from these options:\n\n"
		
				+ "1. Create Profile\n"
				+ "2. Exit Social Disaster\n"
				+ "Enter Choice: ");
				
	}//end Display Start menu
	
	
	
	public static void displayMenu(Profile userProfile) 
	{
		System.out.println("\nUser Profile");
		printProfile(userProfile);
		
		System.out.print("\nChoose from the options:\n"				
	
				+"1. Edit Profile\n"
				+ "2. Search for a profile\n"
				+ "3. Add or Remove friends\n"
				+ "4. Exit\n"
				
				+ "Enter Choice: ");
			
	}//end display menu
	
	
	public static void editProfile(Profile userProfile) 
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		boolean askAgain=true;	
		while(askAgain)
		{					
			System.out.print("\nTo Edit your Profile; Choose from these options:\n\n"
				
				+ "1. Change Profile Name\n"
				+ "2. Change "+ userProfile.getStatus() + " status\n"
				+ "3. Back\n"							
				+ "Enter  Choice: ");
		
			int answer=sc.nextInt();
			
			if (answer==1) 
			{
			System.out.println("\nEnter your Name: "+sc.nextLine());   	
	    	String newName=sc.nextLine();
	    	userProfile.setName(newName);
			}
			
			
			else if(answer==2) 
			{
				boolean askStatus = true;
                while(askStatus)
                {
                    System.out.println("\nEnter 1 to set status as Online.");
                    System.out.println("Enter 2 to set status as Offline.");
                    System.out.println("Enter 3 to set status as Busy.");
                    System.out.println("Enter 0 to go back.");
                    
                    int newStatus = sc.nextInt();
                 
                    switch(newStatus)
                    {
                    case 1:
                        userProfile.setOnlineStatus();
                        System.out.println("Confirmed status has been changed to: "+userProfile.getName());
                        break;
                    case 2:
                        userProfile.setOfflineStatus();
                        System.out.println("Confirmed status has been changed to: "+userProfile.getName());
                        break;
                    case 3:
                        userProfile.setBusyStatus();
                        System.out.println("Confirmed status has been changed to: "+userProfile.getName());
                        break;
                    case 0:
                        askStatus = false; 
                        break;
                    }//end switch
                    
                }//end while
				
			}//end else if
			
			else if (answer==3)break;
			
		}//end while
		
	}//end edit profile
	
	
	public static void populateList(DictionaryInterface<String, Profile> dictionary)
	{
		
		Profile Batman= new Profile("Batman");
		Profile SpiderMan= new Profile("SpiderMan");
		Profile Hulk= new Profile("Hulk");
		
		dictionary.add("Batman", Batman);
		dictionary.add("SpiderMan",SpiderMan);
		dictionary.add("Hulk", Hulk);
		
		Hulk.addFriend(Batman);
		Batman.addFriend(SpiderMan);
		SpiderMan.addFriend(Hulk);
		
	}// end populate list

	
	public static void friendEdit(DictionaryInterface<String, Profile> dictionary, Profile userProfile)
	{
		Scanner sc = new Scanner(System.in);
         
         String name;
        
       int action= -1;
         while(action!=0) 
         {       
        	 System.out.println("\nEnter 1 to add friend.");
             System.out.println("Enter 2 to remove friend.");
             System.out.println("Enter 0 to go back.");
             int ans = sc.nextInt();
             
        	 switch(ans)
        	 {
 			
 				case 1:
 					searchProfiles(dictionary);
 					
 					System.out.println ("Enter the person you'd like to add: ");
 					sc.nextLine();
 					name=sc.nextLine();
 			
 					if (addFriend(dictionary,userProfile,name))
 					{
 						System.out.println("succesfully added friend");
 					}					
 					else
 					{
 						System.out.println("user does not exist");
 					}
 					
 					break;
 				
 				case 2:
 					System.out.println ("enter name of person youd like to remove");
 					sc.nextLine();
 					name=sc.nextLine();
 					
 					System.out.println(removeFriend(dictionary,userProfile,name));
 					break;
        
 		
        	}
         }
	
   }
	
	
	
	public static String removeFriend(DictionaryInterface<String, Profile>dictionary,Profile userProfile,String name) 
	{
		
		String state= "error";
			
			if(dictionary.contains(name)) 
			{
			
				boolean successful=userProfile.removeFriend(dictionary.getValue(name));
			
				if(successful==true)
					state="Successfully removed friend";
				
				else
					state="This user is not on your friends list";
			}
		
			else 
			{
				state="This user does not exist";			
			}
			
		return state;
		
	}//end remove friend
	
	public static boolean addFriend(DictionaryInterface<String, Profile>dictionary,Profile userProfile,String name) 
	{
		
		boolean successful=true;
			if(dictionary.contains(name)) 
			{
			
			userProfile.addFriend(dictionary.getValue(name));
			}
		
			else
			{
			successful=false;
			}
			
		return successful;
	}//end add friend
	
	public static void searchProfiles(DictionaryInterface<String, Profile> dictionary) {
		
		System.out.println("\nFriends within Network\n");
		
		display(dictionary);
		System.out.println("______________________________");
		
	}//end search profiles
	
	
	public static void interactWithUser()
    {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        boolean numbersNotOneOrTwo = true;
        while(numbersNotOneOrTwo)
        {
            displayStartMenu();

            int ans = sc.nextInt();
           
            if (ans == 1)
            {             
                numbersNotOneOrTwo = false;
            }
            
            else if (ans == 2)
            {
                System.out.println("Thank you for being a disaster");
                System.exit(0);
            }
            else
            {
                System.out.println("\nTry Again ");
                System.out.println("____________________________ ");
            }//end if
            
        }//end while

       
        DictionaryInterface<String, Profile> userList = new HashedDictionary<>();
     
        //creating profile
    	System.out.println("\nEnter your Name: "+sc.nextLine());   	
    	String userName=sc.nextLine();
    	Profile userProfile= new Profile(userName);
    	
    	userList.add(userName,userProfile);
    	populateList(userList);
    	
    	int action=-1;
    	
    	while(action!=4)
    	{
    	
    		displayMenu(userProfile);
        
    		action=sc.nextInt();
    	
    	
    		switch(action) 
    		{
    		
    		case -1:
    			System.out.println("error");
    			break;
    		case 1:
    			editProfile(userProfile);
    			break;
    		case 2:
    			searchProfiles(userList);
    			break;
    		case 3:
    			friendEdit(userList, userProfile);
    			break;
    		
    		}//end switch 		
    		
    	}//end while
    	System.out.println("thank you");
     
    }//end interactWithUser
	
}//end driver
