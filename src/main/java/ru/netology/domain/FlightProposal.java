package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FlightProposal implements Comparable<FlightProposal>{
    private int id;
    private int price;
    private String from;
    private String to;
    private int flightTimeMin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightProposal that = (FlightProposal) o;
        return id == that.id &&
                price == that.price &&
                flightTimeMin == that.flightTimeMin &&
                Objects.equals(from, that.from) &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, from, to, flightTimeMin);
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "id=" + id +
                ", price=" + price +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", flightTimeMin=" + flightTimeMin +
                '}';
    }

    public boolean matches(String from, String to) {
        return getFrom().equalsIgnoreCase(from) && getTo().equalsIgnoreCase(to);
    }

    @Override
    public int compareTo(FlightProposal o) {
        return price - o.price;
    }
}
