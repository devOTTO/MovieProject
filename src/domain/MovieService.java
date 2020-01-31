package domain;
import java.util.ArrayList;

public class MovieService {
    private MovieDAO movieDataAccess;
    public MovieService() {movieDataAccess = new MovieDAO();}
    public ArrayList<Movie> getMovies() {
        ArrayList <Movie> movies = null;
        try {movies=movieDataAccess.allMovie();}
        catch(Exception e) {movies=null;}
        return movies;
    }
    public ArrayList<Movie> getMoviesByDirId(int dirId) {
        ArrayList <Movie> movies = null;
        try {movies=movieDataAccess.directorMovies(dirId);}
        catch(Exception e) {movies=null;}
        return movies;
    }
    public Movie selectedMovie(int MovieID) {
        Movie movie = null;
        try {movie=movieDataAccess.selectedMovie(MovieID);}
        catch(Exception e) {movie=null;}
        return movie;
    }
    public int Insert(Movie movie) {
        int ID = -1;
        try {ID = movieDataAccess.insert(movie);}
        catch(Exception e) {movie=null;}
        return ID;
    }
}