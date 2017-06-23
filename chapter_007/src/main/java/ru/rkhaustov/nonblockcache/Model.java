package ru.rkhaustov.nonblockcache;

/**
 * Created by rvkha_000 on 21.06.2017.
 */
public class Model {
    private String text;
    private Integer version;

    public Model(String text, int version) {
        this.text = text;
        this.version = version;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (version != model.version) return false;
        return text.equals(model.text);
    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + version;
        return result;
    }
}
