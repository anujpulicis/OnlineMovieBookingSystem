
/*

Maintain a collection of movies.
Methods: Add a movie, Remove a movie, Display all available movies.

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieCatalog {

    static Map<String,Movie> mp1;  // Name and Reference
    private Map<String,Movie> mp2 ;            // Id and Reference.

    MovieCatalog()
    {
        mp1=new HashMap<String,Movie>();
        mp2=new HashMap<String,Movie>();
    }

    public  void AddMovie()
    {
        System.out.println("Please Enter the Details of Movie");
        String movie_ID;
        String title;
        String genre;
        String releaseDate;
        double duration;

        Scanner sc=new Scanner(System.in);

        System.out.println("Movie -Id");
        movie_ID=sc.nextLine();
        if(movie_ID.isEmpty())
        {
            System.out.println("Movie_Id can't be Empty");
            return;
        }
        System.out.println("Title");
        title=sc.nextLine();
        if(title.isEmpty())
        {
            System.out.println("Movie Title can't be Empty");
            return;
        }
        System.out.println("Gene");
        genre=sc.nextLine();
        System.out.println("Release Date");
        releaseDate= sc.nextLine();
        System.out.println("Duration (In minutes) ");
        duration=sc.nextDouble();

        //String movie_ID, String title, String genre, String releaseDate, double duration
        if(!mp1.containsKey(title))
        {
            Movie obj=new Movie(movie_ID,title,genre,releaseDate,duration);
            mp1.put(title,obj);
            System.out.println("Movie Details Added Successfully ");
        }
        else {
            System.out.println("Movie Title Already Exist in our data Bases...!");
        }

    }

    public void RemoveMovie(String title) {
        if (mp1.containsKey(title))
        {
            mp1.remove(title);
            System.out.println("Movie removed  Successfully");
        }
        else {
            System.out.println("This Movie is not Exist in our Data Bases..");

        }
    }

    public void DisplayAllMovie()
    {
        if(mp1.size()>0)
        {
            for (Map.Entry<String,Movie> data:mp1.entrySet())
            {
                Movie obj=(Movie) data.getValue();
                obj.DisplayMovieDetails();
            }
        }
        else
        {
            System.out.println("Movie database is Empty !! ");
        }
    }

    static Movie getInstance(String movieName) {
        if (mp1.containsKey(movieName))
        {
            return mp1.get(movieName);
        }
        else {
            return null;
        }
    }
}
