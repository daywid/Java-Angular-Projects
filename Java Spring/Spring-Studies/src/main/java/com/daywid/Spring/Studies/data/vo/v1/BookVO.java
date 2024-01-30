package com.daywid.Spring.Studies.data.vo.v1;

import java.io.Serializable;
import java.util.Date;

import org.dozer.Mapping;
import org.springframework.hateoas.RepresentationModel;

import com.daywid.Spring.Studies.models.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "author", "launchDate", "price", "title"})
public class BookVO extends RepresentationModel<BookVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
	@Mapping("id")
    private Long key;
    private String author;
    private Date launchDate;
    private Double price;
    private String title;

    public BookVO() {}


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((launchDate == null) ? 0 : launchDate.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (key == null) {
            if (other.getId() != null)
                return false;
        } else if (!key.equals(other.getId()))
            return false;
        if (author == null) {
            if (other.getAuthor() != null)
                return false;
        } else if (!author.equals(other.getAuthor()))
            return false;
        if (launchDate == null) {
            if (other.getLaunchDate() != null)
                return false;
        } else if (!launchDate.equals(other.getLaunchDate()))
            return false;
        if (price == null) {
            if (other.getPrice() != null)
                return false;
        } else if (!price.equals(other.getPrice()))
            return false;
        if (title == null) {
            if (other.getTitle() != null)
                return false;
        } else if (!title.equals(other.getTitle()))
            return false;
        return true;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    public Long getKey() {
        return key;
    }


    public void setKey(Long key) {
        this.key = key;
    }

}