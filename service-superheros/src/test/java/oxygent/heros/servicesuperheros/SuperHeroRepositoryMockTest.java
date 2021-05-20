package oxygent.heros.servicesuperheros;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import oxygent.heros.servicesuperheros.entity.SuperHero;
import oxygent.heros.servicesuperheros.repository.SuperHeroRepository;

import java.util.List;

@DataJpaTest
public class SuperHeroRepositoryMockTest {

    @Autowired
    private SuperHeroRepository superHeroRepository;


    //Probar que cuando filtramos la busqueda por el nombre, nos retorna un resultado.
    @Test
    public void whenfindByName_thenReturnList(){

        List<SuperHero> result = superHeroRepository.findByName("Spiderman");

        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void whenAddThenFindByName_thenReturnList(){
        //Anadimos un superhereo mas
        SuperHero superHero = SuperHero.builder()
                .name("Spiderman")
                .country("United States")
                .status("active").build();

        //Guardamos el super heroe en la base de datos
        superHeroRepository.save(superHero);

        List<SuperHero> result = superHeroRepository.findByName("Spiderman");

        //validamos que ahora tenemos dos super heroes spidermans en la base de datos
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
