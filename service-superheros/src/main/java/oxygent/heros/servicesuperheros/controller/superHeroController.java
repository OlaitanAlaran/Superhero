package oxygent.heros.servicesuperheros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import oxygent.heros.servicesuperheros.entity.SuperHero;
import oxygent.heros.servicesuperheros.service.SuperHeroServiceI;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/heros")
public class superHeroController {

    @Autowired
    private SuperHeroServiceI superHeroServiceI;

    @GetMapping
    public ResponseEntity<List<SuperHero>> listSuperHero(@RequestParam(name = "name" , required = false) String name){
        List<SuperHero> heros = new ArrayList<>();
        if (null == name){
            heros = superHeroServiceI.listAllSuperHero();
            if (heros.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else{
            heros = superHeroServiceI.listSuperHeroContainingName(name);
        }
        return ResponseEntity.ok(heros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuperHero> listSuperHerobyId(@PathVariable("id") long id) {
       SuperHero hero = superHeroServiceI.getSuperHeroByID(id);
        if (null == hero){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hero);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SuperHero> updateSuperHero(@PathVariable("id") long id){
        SuperHero  superHero =  superHeroServiceI.modifySuperHero(id);
        if (null == superHero){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(superHero);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SuperHero> deleteSuperhero(@PathVariable("id") Long id){
       SuperHero superHero  = superHeroServiceI.deleteSuperHero(id);
        if (superHero == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(superHero);
    }

}
