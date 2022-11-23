package spring.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.bms.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{

}
