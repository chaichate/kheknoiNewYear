package com.chaiidev.kheknoi.ui.gallery;

public class Gallery {

    private boolean isFavorite = false;
    private final String imageUrl;

    public Gallery(String imageUrl) {
        this.imageUrl = imageUrl;
    }

//    public int getName() {
//        return name;
//    }
//
//    public int getAuthor() {
//        return author;
//    }
//
//    public int getImageResource() {
//        return imageResource;
//    }

    public boolean getIsFavorite() {
        return isFavorite;
    }
    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public void toggleFavorite() {
        isFavorite = !isFavorite;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
