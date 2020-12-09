package com.example.stockapi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockapi.models.Stock;
import com.example.stockapi.repositories.StockRepository;

/** This class provides the handlers for the HTTP methods, when a request hits
 * some URI of the REST API. Here we define how the objects should be created,
 * deleted, updated or searched. Each method of this class has an annotation
 * that define, among other things, the HTTP method to handle and the endpoints
 * of the API.
 * @author @italocampos
 */
@RestController // Allows the handle of the endpoints
@RequestMapping(path = "/stock") // Defines the main endpoint
public class StockController {
    /** Creates a StockRepository object to handle the Stock objects in the
     * database.
     */
    private StockRepository repository;

    public StockController(StockRepository repository) {
        this.repository = repository;
    }

    /** Deals with POST HTTP method and inserts a provided object in DB.
     * @param stock : the stock to be saved. The content of the object is get
     * from the body of the requisition (this is the meaning of the annotation
     * @RequestBody).
     * @return ResponseEntity : the HttpEntity with the result of the POST
     * method, that is, the object that was stored in DB.
     */
    @PostMapping
    public ResponseEntity<Stock> create(@RequestBody Stock stock) {
        // Setting the stock name to upper case
        stock.setName(stock.getName().toUpperCase());
        /*if(stock.getQuotes() == null) {

        }*/
        // The line below gets the provided task object and saves it on DB.
        this.repository.save(stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    /** Deals with PUT HTTP method and updates the object whose the id is
     * provided at the end of the URI.
     * @param name : the name of the stock to be updataed.
     * @param updates : the Stock object with the infos to be set in the DB.
     * @return ResponseEntity : a HTTP response with the updated object
     * corresponding to the provided name.
     */
    //@PatchMapping(value = "/{name}")
    @PatchMapping(path = "/{name}")
    public ResponseEntity<Stock> update(@PathVariable String name, @RequestBody Stock updates) {
        return this.repository.findById(name.toUpperCase())
        .map(stock -> {
            stock.addQuotes(updates.getQuotes());
            return new ResponseEntity<>(this.repository.save(stock), HttpStatus.OK);
        })
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /** Deals with GET HTTP method and returns all the stock objects from the
     * database.
     * @return ResponseEntity : the HTTP response with all the objects in the
     * Stock table.
     */
    @GetMapping
    public ResponseEntity<List<Stock>> getAll() {
        return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
    }

    /** Deals with GET HTTP method and returns the object whose the name is
     * provided at the end of the URI.
     * @param name : the name of the task to be returned.
     * @return ResponseEntity : the HTTP response with the object corresponding
     * to the name got from the URI.
     */
    @GetMapping(params = "name")
    public ResponseEntity<Stock> getById(@RequestParam String name) {
        return this.repository.findById(name.toUpperCase())
            .map(stock -> {
                return new ResponseEntity<>(stock, HttpStatus.OK);
            })
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /** Deals with DELETE HTTP method and removes the object whose the name is
     * provided at the end of the URI.
     * @param name : the name of the stock to be deleted.
     * @return ResponseEntity : the HTTP response with the status of the delete
     * operation.
     */
    @DeleteMapping(params = "name")
    public ResponseEntity<Stock> deleteById(@RequestParam String name) {
        return this.repository.findById(name.toUpperCase())
            .map(stock -> {
                this.repository.deleteById(name.toUpperCase());
                return new ResponseEntity<Stock>(HttpStatus.OK);
            })
            .orElse(new ResponseEntity<Stock>(HttpStatus.NOT_FOUND));
    }

}
