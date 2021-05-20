package oxygent.heros.servicesuperheros.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_superhero")
@Data  @NoArgsConstructor @Builder
public class SuperHero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String country;
    private String status;

    public SuperHero(Long id, String name, String country, String status) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.status = status;
    }

    public String getStatus() {return status; }

    public void setStatus(String status) { this.status = status; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



}
