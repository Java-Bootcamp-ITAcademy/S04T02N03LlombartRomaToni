package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.repository;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitsRepository extends MongoRepository<Fruit, Integer> {

    /* Since finding and removing fruits through its id would be so annoying, we implement some methods to do so via name */
    Optional<Fruit> findFruitByName(String name);
    Optional<Fruit> deleteFruitByName(String name);
}
