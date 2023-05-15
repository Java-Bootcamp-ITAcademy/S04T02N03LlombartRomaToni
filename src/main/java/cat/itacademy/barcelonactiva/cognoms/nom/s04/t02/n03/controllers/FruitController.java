package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.domain.Fruit;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class FruitController {
    @Autowired
    private FruitService fruitService;
    /* Handles adding fruits requests */
    @PostMapping(value={"/fruit/add","/fruit/add/"})
    public ResponseEntity<Fruit> add(@RequestBody Fruit fruit) {
        try {
            Optional<Fruit> optionalFruit = fruitService.add(fruit);
            if(optionalFruit.isPresent()) {
                return new ResponseEntity<>(optionalFruit.get(), HttpStatus.CREATED);
            }
            else {
                throw new FruitNotFoundException();
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    /* Handles updating fruits requests */
    @PutMapping(value={"/fruit/update/{name}","/fruit/update/{name}/"})
    public ResponseEntity<Fruit> update(@RequestBody Fruit newFruit, @PathVariable String name) {
        try {
            Optional<Fruit> optionalFruit = fruitService.update(newFruit, name);
            if(optionalFruit.isPresent()) {
                return new ResponseEntity<>(optionalFruit.get(), HttpStatus.CREATED);
            } else {
                throw new FruitNotFoundException();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    /* Handles deleting fruits requests */
    @DeleteMapping(value={"/fruit/delete/{name}","/fruit/delete/{name}/"})
    public ResponseEntity<Fruit> delete(@PathVariable String name) {
        try {
            Optional<Fruit> optionalFruit = fruitService.delete(name);
            if(optionalFruit.isPresent()) {
                return new ResponseEntity<>(optionalFruit.get(), HttpStatus.OK);
            }
            else {
                throw new FruitNotFoundException();
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    /* Handles retrieving one fruit requests */
    @GetMapping(value={"/fruit/getOne/{name}","/fruit/getOne/{name}/"})
    public ResponseEntity<Fruit> getOne(@PathVariable String name) {
        Optional<Fruit> optionalFruit = fruitService.getOne(name);
        try {
            if(optionalFruit.isPresent()) {
                return new ResponseEntity<>(optionalFruit.get(),HttpStatus.OK);
            }
            else {
                throw new FruitNotFoundException();
            }
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    /* Handles retrieving all fruits requests */
    @GetMapping(value={"/fruit/getAll","/fruit/getAll/"})
    public ResponseEntity<List<Fruit>> getAll() {
        Optional<List<Fruit>> optionalFruits = fruitService.getAll();
        try {
            if(optionalFruits.isPresent()) {
                return new ResponseEntity<>(optionalFruits.get(), HttpStatus.OK);
            }
            else {
                throw new FruitNotFoundException();
            }
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}

