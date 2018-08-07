package ru.rvkhaustov.analysisdata.pojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

/**
 * Created by rvkha_000 on 12.05.2018.
 */
public class Vacancy {
    /**
     * The title of the vacancy.
     */
    private final String title;

    /**
     * Body of a vacancy.
     */
    private final String body;

    /**
     * Date of vacancy creation.
     */
    private final Calendar createDate;

    /**
     * Ref of vacancy.
     */
    private final String ref;


    /**
     * Constructor.
     *
     * @param title      - The title of the vacancy.
     * @param body       - Body of a vacancy.
     * @param ref        - Ref of vacancy.
     * @param createDate - Date of vacancy creation.
     */
    public Vacancy(final String title, final String body, final String ref, final Calendar createDate) {
        this.title = title;
        this.body = body;
        this.ref = ref;
        this.createDate = createDate;
    }

    /**
     * Get.
     *
     * @return title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Get.
     *
     * @return body.
     */
    public String getBody() {
        return this.body;
    }

    /**
     * @return ref.
     */
    public String getRef() {
        return this.ref;
    }

    /**
     * Get.
     *
     * @return create date.
     */
    public Calendar getCreateDate() {
        return this.createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vacancy)) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(getTitle(), vacancy.getTitle())
                && Objects.equals(getBody(), vacancy.getBody())
                && Objects.equals(getCreateDate(), vacancy.getCreateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getBody(), getCreateDate());
    }

    @Override
    public String toString() {
        return String.format("Vacancy {title = %s, body = %s, create date = %s, ref = %s",
                title, body, new SimpleDateFormat("dd MMM yy HH:mm").format(this.createDate.getTime()),
                ref);
    }
}