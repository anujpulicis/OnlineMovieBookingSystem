import java.util.*;

/*
Maintain a collection of users.
Methods: Add a user, Remove a user, Display all users.
 */
public class UserManager {

    static Set<String> st;
    static Map<String, User> mp;


    UserManager(){

        st=new HashSet<String>();
        mp=new HashMap<String, User>();

    }

    public  void AddUser(){

        System.out.println("Enter the details of User: ");
        String user_id;
        String Name;
        String Email;
        System.out.println("User Id ");
        Scanner sc=new Scanner(System.in);
        user_id=sc.nextLine();
        if(user_id.isEmpty())
        {
            System.out.println("User_id can't be null");
            return;
        }

        System.out.println("Name of User ");
        Name= sc.nextLine();
        if(Name.isEmpty())
        {
            System.out.println("Name can't be null");
            return;
        }
        System.out.println("Email of User ");
        Email=sc.nextLine();

        int index=Email.indexOf("@");

        if(index==-1)
        {
            System.out.println("Email Format is Not Correct !! Please Enter in this way abc@gmail.com ");
            return;
        }
        else if(!Email.substring(index).equals("@gmail.com"))
        {

            System.out.println("Email Format is Not Correct !! Please Enter in this way abc@gmail.com ");
            return;
        }

        if(st.contains(Email))
        {
            System.out.println("This Email is Already Contains by some of user !! Please Change ");
        }
        else
        {
            st.add(Email);
            User obj=new User(user_id,Name,Email);
            mp.put(Email,obj);
            System.out.println("User Added Successfully ");

        }
    }

    public void RemoveUser(String Email)
    {
        if(mp.containsKey(Email))
        {
            mp.remove(Email);
            st.remove(Email);
            System.out.println("User Removed from our Databases Successfully");
        }
        else
        {
            System.out.println("This Email is Not Exist in mine Data Bases ");
        }

    }

    public void DisplayUser()
    {

        System.out.println("All User Details : "+mp.size());

        if(mp.size()>0)
        {
            for(Map.Entry<String, User> data:mp.entrySet())
            {
                User obj=(User) data.getValue();
                obj.UserDetails();
            }
        }
        else
        {
            System.out.println("User database is Empty !! ");
        }


    }

    static  User getInstanceofUser(String Email)
    {
        if(mp.containsKey(Email))
        {
            return mp.get(Email);
        }
        else
        {
            return null;
        }
    }


}
