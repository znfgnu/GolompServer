package pl.golomp.restserver.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by konrad on 25.01.15.
 */
@Entity
@Table
public class Encja {
    @Id @GeneratedValue
    private Long id;
    private String content;

    public Encja() {
    }

    @Override
    public String toString() {
        return "Encja{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

    public Encja(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
