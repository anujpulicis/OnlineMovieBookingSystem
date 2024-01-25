import javax.naming.Name;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Properties: User ID, Name, Email, Booked Movies (a list of movies booked by the user).
Methods: Book a movie, Display user details.
 */


public class User {

    private String user_id;
    private String Name;
    private String Email;
    private  Set<Booking> st;

    public User(String user_id, String name, String email) {
        this.user_id = user_id;
        Name = name;
        Email = email;
        this.st=new HashSet<Booking>();
    }

    public void BookMovie(Booking MovieName)
    {
        this.st.add(MovieName);
    }

    public void UserDetails(){

        System.out.println("----------User Details-------------");
        System.out.println("Name : "+this.Name);
        System.out.println("User -ID "+this.user_id);
        System.out.println("Email : "+this.Email);
        System.out.println("Movie Booked by this User ");

        if(!st.isEmpty())
        {
//            for(Booking m:this.st)
//            {
               this.st.forEach((m)->{
                System.out.println("Movie Name : "+m.getMovie_booked());
                System.out.println("Booking id : "+m.getBooking_id());
                System.out.println("Date and Time : "+m.getDateAndTime());
                System.out.print("Seat Number [Row, Col] : ");
                 m.getAllocatedSeat().forEach((ele)-> System.out.println("["+ele.getfirst()+" "+ele.getsecond()+"]"));
                 System.out.println();
               });
//            }
        }
        else {
            System.out.println("None Movie Booked by this User");
        }


        System.out.println();
        System.out.println("--------------------------------------");
    }


}
