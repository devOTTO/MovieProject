package main.java.domain;

public class Director implements java.io.Serializable  {
	int dirId;
	String dirName;
	int dirAge;
	
	public Director() {
		this(-1, null, -1);
	}
	
	public Director(int dirId, String dirName, int dirAge) {
		this.dirId = dirId;
		this.dirName = dirName;
		this.dirAge = dirAge;
	}
	
	public Director(String dirName, int dirAge) {
		this.dirName = dirName;
		this.dirAge = dirAge;
	}
	
	public int getDirId() {
		return dirId;
	}
	public void setDirId(int dirId) {
		this.dirId = dirId;
	}
	public String getDirName() {
		return dirName;
	}
	public void setDirName(String dirName) {
		this.dirName = dirName;
	}
	
	public int getDirAge() {
		return dirAge;
	}
	public void setDirAge(int dirAge) {
		this.dirAge = dirAge;
	}
}
