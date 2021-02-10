package io.project.hotelpricesmapping.mappedprices.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("PRICE")
public class Price {

    Double price;

    public Price(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
