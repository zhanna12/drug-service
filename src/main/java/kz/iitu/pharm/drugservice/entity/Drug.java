package kz.iitu.pharm.drugservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="drugs")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;

    @JsonIgnore
    @ManyToMany(mappedBy = "drugs", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Basket> basket;

    public Drug(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Drug(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public Set<Basket> getBasket() {
        return basket;
    }

    public void setBasket(Set<Basket> basket) {
        this.basket = basket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drug drug = (Drug) o;

        return id.equals(drug.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

