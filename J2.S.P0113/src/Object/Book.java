/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author admin
 */
public class Book {

    private String Code;
    private String Name;
    private String Author;
    private String Publisher;
    private int PublishYEAR;
    private Boolean ForRent;

    public Book() {
    }

    public Book(String Code, String Name, String Author, String Publisher, int PublishYEAR, Boolean ForRent) {
        this.Code = Code;
        this.Name = Name;
        this.Author = Author;
        this.Publisher = Publisher;
        this.PublishYEAR = PublishYEAR;
        this.ForRent = ForRent;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
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

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public int getPublishYEAR() {
        return PublishYEAR;
    }

    public void setPublishYEAR(int PublishYEAR) {
        this.PublishYEAR = PublishYEAR;
    }

    public Boolean getForRent() {
        return ForRent;
    }

    public void setForRent(Boolean ForRent) {
        this.ForRent = ForRent;
    }

    @Override
    public String toString() {
        return Name;
    }

}
