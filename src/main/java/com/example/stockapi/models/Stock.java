package com.example.stockapi.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

/** This class creates a model of a Stock. The objects of this classes will be
 * added in the database by means of the annotations from JPA library. This lib
 * maps each object in a table.
 * @author @italocampos   
 */
@Entity
public class Stock {
    @Id // Defines this attribute as PK of the model
    private String name;
    private ArrayList<Float> quotes;

    public Stock(String name, ArrayList<Float> quotes) {
        this.name = name;
        this.quotes = quotes;
    }

    public Stock() {
    }

    /** Returns the name of the Stock's objects.
     * @return String : the name of the Stock's object.
     */
    public String getName() {
        return name;
    }

    /** Sets the name for the Stock's objects.
     * @param name : the name of the Stock's object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Returns a list with the quotes of the Stock's objects.
     * @return ArrayList<Float> : the list with the quotes of this Stock's
     * object.
     */
    public ArrayList<Float> getQuotes() {
        return this.quotes;
    }

    /** Sets the quotes for the Stock's objects.
     * @param quotes : a ArrayList with the quotes of the Stock's object.
     */
    public void setQuotes(ArrayList<Float> quotes) {
        this.quotes = quotes;
    }

    @Override
    public String toString() {
        return "Stock [name=" + name + ", quotes=" + quotes + "]";
    }
    
}
