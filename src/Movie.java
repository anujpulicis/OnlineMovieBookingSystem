import java.util.Arrays;
import java.util.stream.Stream;

public class Movie {

    private String movie_ID;
    private String title;
    private String genre;

    private String releaseDate;
    private double duration;

    private String [][] Seat;

    public Movie(String movie_ID, String title, String genre, String releaseDate, double duration) {
        this.movie_ID = movie_ID;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.duration = duration;

        this.Seat=new String[11][11];

        for(int row=0;row<11;row++)
        {
            this.Seat[row][0]=Integer.toString(row);
        }

        for(int col=0;col<11;col++)
        {
            this.Seat[0][col]=Integer.toString(col);
        }
        System.out.println("Anuj before "+this.Seat.length+this.Seat[0].length);

        for(int i=1;i<11;i++)
        {
            for(int j=1;j<11;j++)
            {
                this.Seat[i][j]="A"; //Available

            }
        }

        System.out.println("Anuj before "+this.Seat.length+this.Seat[0].length);
    }

    public String getMovie_ID() {
        return movie_ID;
    }

    public void setMovie_ID(String movie_ID) {
        this.movie_ID = movie_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public  void DisplayMovieDetails()
    {
        System.out.println("----------Details-----------------");
        System.out.println("ID : "+this.movie_ID);
        System.out.println("Title : "+this.title);
        System.out.println("Genre : "+this.genre);
        System.out.println("Release Date : "+this.releaseDate);
        System.out.println("Duration : "+this.duration);

        System.out.println("Seat That are available for This Movie ");

        for(int i=0;i<11;i++)
        {
            for(int j=0;j<11;j++)
            {

                System.out.print((String)this.Seat[i][j] +" ");
//                if(i==0)
//                    System.out.print("  ");
            }
            System.out.println();
        }

//        Stream.of(this.Seat)
//                .flatMap(Stream::of)
//                .forEach((ele)->{
//
//                });

        System.out.println("----------------------------------");
    }

    public void BookedSeat(int row,int col)
    {
        try{

            this.Seat[row][col]="B";
            System.out.println("Seat Booked Successful ");
        }
        catch (Exception e)
        {
            System.out.println("Value of Row and COl Not Valid . Please Enter Between 1 to 10 Inclusive");
            e.printStackTrace();
        }
    }

    public String getSeatStatus(int row,int col)
    {
        if(row>=1 && row<=10 && col>=1 && col<=10)
        {
            return this.Seat[row][col];
        }
        else {
            return "Enter Valid Row and Column";
        }
    }
}
