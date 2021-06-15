package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String lastName;
    private String firstName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Author(String lastName, String firstName, Set<Book> books) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.books = books;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "Id=" + Id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(Id, author.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
