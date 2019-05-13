package com.alan.XMLFIleIO;

import com.alan.data.model.Movie;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLfileWriter {
    public static void create(String fileName, List<Movie> myMovies) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        // creating the root element, and attaching it to the doc
        Element movies = doc.createElement("MOVIES");
        doc.appendChild(movies);

        // looping throw the movies, and creating movie children for the root
        for(int i = 0; i <= myMovies.size() - 1 ; i++){
            Element movie = doc.createElement("MOVIE");

            // giving an ID to every movie
            Attr movieID = doc.createAttribute("id");
            movieID.setValue(Integer.toString(i));
            movie.setAttributeNode(movieID);

            // creating child tag of NAME, and assigning the value to it
            Element name = doc.createElement("NAME");
            name.appendChild(doc.createTextNode(myMovies.get(i).getName()));
            movie.appendChild(name);

            // creating child tag of RATED, and assigning the value to it
            Element rated = doc.createElement("RATED");
            rated.appendChild(doc.createTextNode(myMovies.get(i).getRated()));
            movie.appendChild(rated);

            // creating child tag of TIMES, and assigning the value to it
            Element times = doc.createElement("TIMES");
            String[] timesOfMovie = myMovies.get(i).getTimes();
            for(int j = 0; j <= timesOfMovie.length - 1; j++){
                Element time = doc.createElement("TIME");
                time.appendChild(doc.createTextNode(timesOfMovie[j]));
                times.appendChild(time);
            }
            movie.appendChild(times);

            // creating child tag of RELEASE-DATE, and assigning the value to it
            Element releaseDate = doc.createElement("RELEASE-DATE");
            releaseDate.appendChild(doc.createTextNode(myMovies.get(i).getReleaseTime()));
            movie.appendChild(releaseDate);

            // creating child tag of RUN-TIME, and assigning the value to it
            Element runTIme = doc.createElement("RUN-TIME");
            runTIme.appendChild(doc.createTextNode(myMovies.get(i).getRunTime()));
            movie.appendChild(runTIme);

            // creating child tag of RUN-TIME, and assigning the value to it
            Element genre = doc.createElement("GENRE");
            genre.appendChild(doc.createTextNode(myMovies.get(i).getGenre()));
            movie.appendChild(genre);

            // creating child tag of STARS, and assigning the STAR/values to it
            Element stars = doc.createElement("STARS");
            String[] starsOfMovie = myMovies.get(i).getStars();
            for(int j = 0; j <= starsOfMovie.length - 1; j++){
                Element star = doc.createElement("STAR");
                star.appendChild(doc.createTextNode(starsOfMovie[j]));
                stars.appendChild(star);
            }
            movie.appendChild(stars);


            // creating child tag of DIRECTORS, and assigning the DIRECTOR/values to it
            Element directors = doc.createElement("DIRECTORS");
            String[] directorsOfMovie = myMovies.get(i).getDirectors();
            for(int j = 0; j <= directorsOfMovie.length - 1; j++){
                Element director = doc.createElement("DIRECOTOR");
                director.appendChild(doc.createTextNode(directorsOfMovie[j]));
                directors.appendChild(director);
            }
            movie.appendChild(directors);

            // creating child tag of PRODUCERS, and assigning the PRODUCER/values to it
            Element producers = doc.createElement("PRODUCERS");
            String[] producersOfMovie = myMovies.get(i).getProduces();
            for(int j = 0; j <= producersOfMovie.length - 1; j++){
                Element producer = doc.createElement("PRODUCER");
                producer.appendChild(doc.createTextNode(producersOfMovie[j]));
                producers.appendChild(producer);
            }
            movie.appendChild(producers);

            // creating child tag of WRITERS, and assigning the WRITE/values to it
            Element writers = doc.createElement("WRITERS");
            String[] writersOfMovie = myMovies.get(i).getWriters();
            for(int j = 0; j <= writersOfMovie.length - 1; j++){
                Element writer = doc.createElement("WRITER");
                writer.appendChild(doc.createTextNode(writersOfMovie[j]));
                writers.appendChild(writer);
            }
            movie.appendChild(writers);

            // creating child tag of STUDIO, and assigning the value to it
            Element studio = doc.createElement("STUDIO");
            studio.appendChild(doc.createTextNode(myMovies.get(i).getStudio()));
            movie.appendChild(studio);


            // movie element is ready to be added to the root
            movies.appendChild(movie);
        }

        DOMSource inputDoc = new DOMSource(doc);
        StreamResult outputFile = new StreamResult(new File(fileName));

        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer t = tFactory.newTransformer();
        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        t.setOutputProperty(OutputKeys.INDENT, "yes");

        t.transform(inputDoc, outputFile);

    }
}
