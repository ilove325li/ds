package com.ds.project.front.indexPage.domain;

import java.util.Objects;

public class Paper {
    private String title;
    private String authors;
    private String source;
    private String publishTime;

    public Paper() {
    }

    public Paper(String title, String authors, String source, String publishTime) {
        this.title = title;
        this.authors = authors;
        this.source = source;
        this.publishTime = publishTime;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Paper paper = (Paper) o;
        return Objects.equals(title, paper.title) &&
                Objects.equals(authors, paper.authors) &&
                Objects.equals(source, paper.source) &&
                Objects.equals(publishTime, paper.publishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authors, source, publishTime);
    }

    @Override
    public String toString() {
        return "Paper{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", source='" + source + '\'' +
                ", publishTime='" + publishTime + '\'' +
                '}';
    }
}