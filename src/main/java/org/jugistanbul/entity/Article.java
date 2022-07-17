package org.jugistanbul.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author hakdogan (huseyin.akdogan@patikaglobal.com)
 * Created on 17.07.2022
 ***/
@Entity
public class Article
{
    public Article() {}

    public Article(final String title, final String author,
                   final LocalDateTime createdOn){
        this.title = title;
        this.author = author;
        this.createdOn = createdOn;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private LocalDateTime createdOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id.equals(article.id) && title.equals(article.title) && author.equals(article.author) && createdOn.equals(article.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, createdOn);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
