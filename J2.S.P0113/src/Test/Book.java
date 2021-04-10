/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author admin
 */
public class Book {

    private String Name;
    private String Author;
    private int YEAR;

    public Book() {
    }

    public Book(String Name, String Author, int YEAR) {
        this.Name = Name;
        this.Author = Author;
        this.YEAR = YEAR;
    }

    public int getYEAR() {
        return YEAR;
    }

    public void setYEAR(int YEAR) {
        this.YEAR = YEAR;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    @Override
    public String toString() {
        return Name + " " + Author + " " + YEAR;
    }

}
