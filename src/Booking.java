/*
Properties: Booking ID, Date and Time, Movie booked, User making the booking.
Methods: Display booking details.
 */

import java.util.ArrayList;
import java.util.List;

public class Booking {

    private String booking_id;
    private String DateAndTime;
    private String movie_booked;

    private List<pair> seat;

    // s stand for seat



    public boolean booking(String booking_id, String dateAndTime, String movie_booked,List<pair> s) {
        this.booking_id = booking_id;
        this.DateAndTime = dateAndTime;
        this.movie_booked = movie_booked;


        Movie obj=(Movie) MovieCatalog.getInstance(movie_booked);
        System.out.println("Reached in Booking Method "+s);
        boolean allSeatAvailable =s.stream().allMatch((ele)->{
            String status=obj.getSeatStatus(ele.getfirst(),ele.getsecond());
            return status.equals("A");
        });

        if(!allSeatAvailable)
        {
            System.out.println("Please Enter Valid Row and Column for Seat  ");
            return false;
        }
        this.seat=new ArrayList<>();
        System.out.println("Status for Seat -> "+allSeatAvailable);
        try {
            s.forEach((ele)->{

                String status=obj.getSeatStatus(ele.getfirst(),ele.getsecond());

                if(status.equals("A"))
                {
                    int row=ele.getfirst();
                    int col=ele.getsecond();
                    obj.BookedSeat(row,col);
                    seat.add(new pair(row,col));

                }
                else if(status.equals("B"))
                {
                    System.out.println("That seat is Already booked ");
                }
                else {
                    System.out.println("Please Enter valid Row or Column");
                }
            });
        }
        catch (Exception e)
        {
            System.out.println("May Be Object is NUll ");
            e.printStackTrace();
        }
        return  true;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getDateAndTime() {
        return DateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        DateAndTime = dateAndTime;
    }

    public String getMovie_booked() {
        return movie_booked;
    }

    public void setMovie_booked(String movie_booked) {
        this.movie_booked = movie_booked;
    }

    public List<pair> getAllocatedSeat()
    {
        return this.seat;
    }
}

