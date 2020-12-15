package com.company;

import com.fasterxml.jackson.annotation.*;

import java.util.List;


public class Category {

    @JsonView(CategoryViews.IdView.class)
    private long id;

    @JsonView(CategoryViews.NameView.class)
    private String name;

    @JsonView(CategoryViews.FullView.class)
    private int countBooks;

    private List<Book> books;

    @JsonIgnore
    public String getPassword() {
        return "password";
    }

    public long getId() {
        return id;
    }

    @JsonProperty("CATEGORY_ID")
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("CATEGORY_NAME")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countBooks=" + countBooks +
                ", books=" + books +
                '}';
    }

    public int getCountBooks() {
        return countBooks;
    }

    public void setCountBooks(int countBooks) {
        this.countBooks = countBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
