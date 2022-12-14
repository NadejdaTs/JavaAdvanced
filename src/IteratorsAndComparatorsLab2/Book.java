package IteratorsAndComparatorsLab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors){
        setTitle(title);
        setYear(year);
        setAuthors(authors);
    }

    @Override
    public int compareTo(Book other){
        int result = this.title.compareTo(other.title);
        if(result == 0){
            result = Integer.compare(this.year, other.year);
        }
        return result;
    }

    private void setTitle(String title){
        this.title = title;
    }

    private void setYear(int year){
        this.year = year;
    }

    private void setAuthors(String... authors){
        this.authors = new ArrayList<>();
        /*for (String author : authors) {
            this.authors.add(author);
        }*/
        this.authors.addAll(Arrays.asList(authors));
    }

    public String getTitle(){
        return this.title;
    }

    public int getYear(){
        return this.year;
    }
}

