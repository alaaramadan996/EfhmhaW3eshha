package com.alaa.efhmhaw3eshha;

public class Model {
String titleBook;
int ImageBook;
String nameImageBook;

    public Model(String titleBook, int imageBook, String nameImageBook) {
        this.titleBook = titleBook;
        ImageBook = imageBook;
        this.nameImageBook = nameImageBook;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public int getImageBook() {
        return ImageBook;
    }

    public void setImageBook(int imageBook) {
        ImageBook = imageBook;
    }

    public String getNameImageBook() {
        return nameImageBook;
    }

    public void setNameImageBook(String nameImageBook) {
        this.nameImageBook = nameImageBook;
    }
}
