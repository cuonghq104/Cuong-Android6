package hq.cuong.lab4_remake.models;

/**
 * Created by Cuong on 12/4/2016.
 */
public class BigThing {
    Content content;

    public BigThing(Content content) {
        this.content = content;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BigThing{" +
                "content=" + content +
                '}';
    }
}
