package com.example.writeout;

public class ArticleHelperClass {
    String author, category, title, article;//image

    public ArticleHelperClass(){
    }

    public ArticleHelperClass(String author, String category, String title, String article) {
        this.author = author;
        this.category = category;
        this.title = title;
        this.article = article;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}