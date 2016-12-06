package hq.cuong.lab4_final_version.models;

/**
 * Created by Cuong on 12/5/2016.
 */
public class Container {

    private Content content;

    public Container(Content content) {
        this.content = content;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
