package com.example.android.intangantira_1202154351_modul6;

/**
 * Created by Intan Gantira on 4/1/2018.
 */

public class databasesatu {
    String commenters, comments, commentedImage;

    //method kosong untuk membaca data
    public databasesatu(){
    }

    //konstruktor
    public databasesatu(String commenters, String comments, String commentedImage) {
        this.commenters = commenters;
        this.comments = comments;
        this.commentedImage = commentedImage;
    }

    //method getter
    public String getCommenters() {
        return commenters;
    }

    public String getComments() {
        return comments;
    }

    public String getCommentedImage() {
        return commentedImage;
    }
}

