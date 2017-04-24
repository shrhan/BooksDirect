package org.books.direct.domain.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.books.direct.enums.BookTypeEnum;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "books",
uniqueConstraints = { @UniqueConstraint(columnNames = { "isbn" }) })
public class Book implements Serializable {

   private static final long serialVersionUID = 7299376433180070144L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @NotBlank
   private String name;

   @NotBlank
   private String isbn;

   @NotBlank
   private String author;

   @NotNull
   @Enumerated(EnumType.STRING)
   private BookTypeEnum bookType;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getIsbn() {
      return isbn;
   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public BookTypeEnum getBookType() {
      return bookType;
   }

   public void setBookType(BookTypeEnum bookType) {
      this.bookType = bookType;
   }

}
