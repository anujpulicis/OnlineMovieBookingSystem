import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.



public class Main {

    public String GenerateID(String Name)
    {
        int min=100;
        int max=1000000;
         int range=max-min;

        int num=(int)(Math.random() * range) + min;

         String id=String.valueOf(num)+Name;

         return id;
    }

    public static void main(String[] args) {

        Main MainObj=new Main();
        MovieCatalog movieManager=new MovieCatalog();
        UserManager userManager=new UserManager();

        Scanner sc=new Scanner(System.in);

        while (true)
        {
            System.out.println("Press 1 for Movie Management");
            System.out.println("Press 2 for User Management");
            System.out.println("Press 3 for Exit");

            int option=sc.nextInt();

            if(option==1)
            {
                while(true) {
                    System.out.println("Press 1 for Add Movie");
                    System.out.println("Press 2 for Remove Movie");
                    System.out.println("Press 3 for Display All Movie");
                    System.out.println("Press 4 for Exit");
                    int MO= sc.nextInt();

                    if(MO==4)
                        break;

                    switch (MO)
                    {
                        case 1:
                        {
                            movieManager.AddMovie();

                            break;
                        }
                        case 2:
                        {
                            System.out.println("Removing Movie name from out Database: Please Enter The Movie name");
                            sc.nextLine();
                            String movieName=sc.nextLine();
                            movieManager.RemoveMovie(movieName);
                            break;
                        }
                        case 3:
                        {
                            movieManager.DisplayAllMovie();
                            break;
                        }

                    }
                }
            }
            else if(option==2)
            {
                while (true)
                {


                    System.out.println("Press 1 for Add User");
                    System.out.println("Press 2 for Remove User");
                    System.out.println("Press 3 for Display All User");
                    System.out.println("Press 4 for movie Booking");
                    System.out.println("Press 5 for Exit");


                    int UO=sc.nextInt();

                    if(UO==5)
                        break;

                    switch (UO)
                    {
                        case 1:{
                            userManager.AddUser();
                            break;
                        }
                        case 2:{
                            Scanner input=new Scanner(System.in);
                            System.out.println("Fro Removing User data from our data bases Please Enter their Mail-Id");
                            String Email=input.nextLine();
                            userManager.RemoveUser(Email);
                            break;
                        }
                        case 3:
                        {
                            userManager.DisplayUser();
                            break;
                        }
                        case 4:
                        {
                            //String booking_id, String dateAndTime, String movie_booked,int row,int col

                            Scanner input=new Scanner(System.in);

                            System.out.println("Enter movie name");
                            String movieName=input.nextLine();

                            Movie movieObj=MovieCatalog.getInstance(movieName);

                            if(movieObj!=null)
                            {
                                System.out.println("Seat Status for This Movie ");
                                movieObj.DisplayMovieDetails();
                            }
                            else
                            {
                                System.out.println("No Such Movie Exit in our Databases");
                                break;
                            }

                            String booking_id=MainObj.GenerateID(movieName);
                            String Dateandtime;
                            System.out.println("Enter Date and Time ");
                            Dateandtime=input.nextLine();
                            System.out.println("Enter the no of Seat you want to book ");
                            int noSeat=input.nextInt();
                            List<pair> seat=new ArrayList<pair>();
                            while(noSeat>0) {
                                int row, col;
                                System.out.println("Enter the value of row and col of seat");
                                row = input.nextInt();
                                col = input.nextInt();

                                seat.add(new pair(row,col));
                                noSeat--;
                            }
                            input.nextLine();
                            String email;
                            System.out.println("Enter Email of User");

                            email=input.nextLine();
                            User userobj=(User) UserManager.getInstanceofUser(email);

                            if(userobj!=null)
                            {
                                Booking bookObj=new Booking();
                                boolean flag=bookObj.booking(booking_id,Dateandtime,movieName,seat);
                                if(flag==true)
                                    userobj.BookMovie(bookObj);
                                else
                                {
                                    System.out.println("Something Wrong ");
                                }

                            }
                            else
                            {
                                System.out.println("Email is Incorrect  ");
                            }

                            break;

                        }
                    }

                }
            }
            else {
                break;
            }

        }

    }
}

/*

                            try {

                                System.out.println("Enter Movie Name");
                                String movieName= (String)sc.nextLine();
                                Movie movieObj=MovieCatalog.getInstance(movieName);
                                if(movieObj==null)
                                {
                                    System.out.println("No Such Movie Exit in our Databases");
                                }


                                System.out.println("Seat Status for This Movie ");
                                assert movieObj != null;
                                movieObj.DisplayMovieDetails();
                                String booking_id=MainObj.GenerateID(movieName);
                                String Dateandtime;
                                System.out.println("Enter Date and Time ");
                                Dateandtime=sc.nextLine();
                                int row,col;
                                System.out.println("Enter the value of row and col of seat");
                                row= sc.nextInt();
                                col= sc.nextInt();

                                String email;
                                System.out.println("Enter Email of User");
                                email=sc.nextLine();
                                User userobj=UserManager.getInstanceofUser(email);

                                if(userobj!=null)
                                {
                                    Booking bookObj=new Booking();
                                    bookObj.booking(booking_id,Dateandtime,movieName,row,col);
                                    userobj.BookMovie(bookObj);

                                }
                                else
                                {
                                    System.out.println("Email is Correct  ");
                                }


                            }
                            catch (Exception e)
                            {
                                System.out.println("Exception Cought in Main Function or in  case Number 5");
                                e.printStackTrace();
                            }
                            break;
                        }
 */