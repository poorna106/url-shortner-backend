package com.project.avance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String inputUrl;
    private String outputUrl;

    public Url(int id, String inputUrl, String outputUrl) {
        this.id = id;
        this.inputUrl = inputUrl;
        this.outputUrl = outputUrl;
    }
    public Url(String inputUrl, String outputUrl) {
        this.id = id;
        this.inputUrl = inputUrl;
        this.outputUrl = outputUrl;
    }

    public Url() {
        super();
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", inputUrl='" + inputUrl + '\'' +
                ", outputUrl='" + outputUrl + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInputUrl() {
        return inputUrl;
    }

    public void setInputUrl(String inputUrl) {
        this.inputUrl = inputUrl;
    }

    public String getOutputUrl() {
        return outputUrl;
    }

    public void setOutputUrl(String outputUrl) {
        this.outputUrl = outputUrl;
    }
}
