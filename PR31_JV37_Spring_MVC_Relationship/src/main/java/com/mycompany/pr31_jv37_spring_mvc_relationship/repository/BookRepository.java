/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_relationship.repository;

import com.mycompany.pr31_jv37_spring_mvc_relationship.entities.BookEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface BookRepository
        extends CrudRepository<BookEntity, Integer> {

    List<BookEntity> findByAuthorContaining(String author);

    @Query("Select b From BookEntity b where b.category.name like %?1%"
            + " or b.bookDetail.isbn like %?2%")
    List<BookEntity> findBookByCategoryNameOrIsbn(String categoryName,
            String isbn);

    List<BookEntity> findByCategory_NameContainingOrBookDetail_IsbnContaining(String categoryName,
            String isbn);
}
