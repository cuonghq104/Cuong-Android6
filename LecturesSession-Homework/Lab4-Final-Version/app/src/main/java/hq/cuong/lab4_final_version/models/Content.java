package hq.cuong.lab4_final_version.models;

/**
 * Created by Cuong on 12/5/2016.
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
}
