package oxygent.heros.servicesuperheros.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oxygent.heros.servicesuperheros.entity.SuperHero;
import oxygent.heros.servicesuperheros.repository.SuperHeroRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuperHeroServiceImpl implements SuperHeroServiceI{

    @Autowired
    private SuperHeroRepository superHeroRepository;

    @Override
    public List<SuperHero> listAllSuperHero() {
        return superHeroRepository.findAll();
    }

    @Override
    public List<SuperHero> listSuperHeroContainingName(String name){
        return superHeroRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public SuperHero getSuperHeroByID(Long id) {
        return superHeroRepository.findById(id).orElse(null);
    }

    @Override
    public List<SuperHero> listSuperHerosByName(String name) {
        return superHeroRepository.findByName(name);
    }

    @Override
    public SuperHero modifySuperHero(Long id) {
        SuperHero superHeroDB = getSuperHeroByID(id);
        if (null == superHeroDB){
            return null;
        }
        superHeroDB.setName("DeadPool");
        superHeroDB.setCountry("England");

        return superHeroRepository.save(superHeroDB);
    }

    @Override
    public SuperHero deleteSuperHero(Long id) {
        SuperHero superHeroDB = getSuperHeroByID(id);
        if (null == superHeroDB){
            return null;
        }
        superHeroDB.setStatus("inactive");
        return superHeroRepository.save(superHeroDB);
    }
}
