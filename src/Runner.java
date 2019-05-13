import com.alan.TextFileIO.TextFileReader;
import com.alan.data.model.Movie;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.List;

import static com.alan.XMLFIleIO.XMLfileWriter.*;

public class Runner {

    public static void main(String[] args) {
        // write your code here
        TextFileReader sx = new TextFileReader();
        List<Movie> myMovies = sx.readFile("Movies.txt");

        try {
            create("movies.xml", myMovies);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
