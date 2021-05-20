package oxygent.heros.servicesuperheros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import oxygent.heros.servicesuperheros.entity.SuperHero;

import java.util.List;

public interface SuperHeroRepository extends JpaRepository<SuperHero,Long> {

    public List<SuperHero> findByName(String name);

    public List<SuperHero> findByNameContainingIgnoreCase(String name);

}
