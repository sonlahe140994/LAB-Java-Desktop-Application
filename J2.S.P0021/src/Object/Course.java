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
public class Course {

    private String Code;
    private String Name;
    private int Credit;

    public Course() {
    }

    public Course(String Code, String Name, int Credit) {
        this.Code = Code;
        this.Name = Name;
        this.Credit = Credit;
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

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int Credit) {
        this.Credit = Credit;
    }

    @Override
    public String toString() {
        return Code + " | " + Name + " | " + Credit;
    }

}
