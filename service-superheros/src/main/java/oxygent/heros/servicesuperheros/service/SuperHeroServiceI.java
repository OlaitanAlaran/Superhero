package oxygent.heros.servicesuperheros.service;

import oxygent.heros.servicesuperheros.entity.SuperHero;

import java.util.List;

public interface SuperHeroServiceI {

    public List<SuperHero> listAllSuperHero();

    public List<SuperHero> listSuperHeroContainingName(String name);

    public SuperHero getSuperHeroByID(Long id);

    public List<SuperHero> listSuperHerosByName(String name);

    public SuperHero modifySuperHero(Long id);

    public SuperHero deleteSuperHero(Long id);


}
