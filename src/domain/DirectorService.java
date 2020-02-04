package domain;
import java.util.ArrayList;

public class DirectorService {
	private DirectorDAO directorDataAccess;
    public DirectorService() {directorDataAccess = new DirectorDAO();}
    public ArrayList<Director> getDirectors() {
        ArrayList <Director> directors = null;
        try {directors=directorDataAccess.allDirector();}
        catch(Exception e) {directors=null;}
        return directors;
    }
    public Director selectedDirector(int dirId) {
    	Director director = null;
        try {director=directorDataAccess.selectedDirector(dirId);}
        catch(Exception e) {director=null;}
        return director;
    }
    public int Insert(Director director) {
        int ID = -1;
        try {ID = directorDataAccess.insert(director);}
        catch(Exception e) {director=null;}
        return ID;
    }
    public ArrayList<Director> getSearchedDirectors(String dirName) {
        ArrayList <Director> directors = null;
        try {directors=directorDataAccess.searchedDirectors(dirName);}
        catch(Exception e) {directors=null;}
        return directors;
    }
    
}
