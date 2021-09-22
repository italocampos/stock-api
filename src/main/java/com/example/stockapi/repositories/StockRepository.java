package com.example.stockapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.stockapi.models.Stock;

/** This interface will provide the most common methods to be used in REST
 * operations (like save, update or delete an object). Note that this interface
 * manages the Stock objects in databases, not the HTTP requests. JPARepository
 * needs two parameters: The database model (Stock) and the type of its PK
 * (String);
 * @author @italocampos
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, String> { }
