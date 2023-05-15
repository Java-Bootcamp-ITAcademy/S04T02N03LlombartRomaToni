package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.domain.Fruit;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.repository.FruitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FruitService {
    @Autowired
    private FruitsRepository fruitsRepository;
    /* Implements how API add a new Fruit */
    public Optional<Fruit> add(Fruit fruit) {
        return Optional.ofNullable(fruitsRepository.save(fruit));
    }
    /* Implements how API updates a Fruit */
    public Optional<Fruit> update(Fruit fruit, String name) {
        Optional<Fruit> optionalFruit = fruitsRepository.findFruitByName(name);
        if(optionalFruit.isPresent()) {
            Fruit updatedFruit = optionalFruit.get();
            updatedFruit.setName(fruit.getName());
            updatedFruit.setQuantity(fruit.getQuantity());
            return Optional.ofNullable(fruitsRepository.save(updatedFruit));
        }
        else {
            return Optional.empty();
        }
    }
    /* Implements how API removes a Fruit by its name*/
    public Optional<Fruit> delete(String name) {
        Optional<Fruit> optionalFruit = fruitsRepository.findFruitByName(name);
        fruitsRepository.deleteFruitByName(name);
        return optionalFruit;
    }
    /* Implements how API retrieves a single Fruit by its name*/
    public Optional<Fruit> getOne(String name) {
        return fruitsRepository.findFruitByName(name);
    }
    /* Implements how API retrieves all Fruits */
    public Optional<List<Fruit>> getAll() {
        return Optional.ofNullable(fruitsRepository.findAll());
    }

}
