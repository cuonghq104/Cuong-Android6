package hq.cuong.lab4_remake.models;

import java.util.Arrays;

/**
 * Created by Cuong on 12/4/2016.
 */
public class Content {
    private Author author;

    private Item[] items;

    public Content(Author author, Item[] items) {
        this.author = author;
        this.items = items;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Content{" +
                "author=" + author +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
