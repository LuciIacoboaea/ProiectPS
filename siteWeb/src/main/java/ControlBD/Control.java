package ControlBD;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Control<T> {

    private Map<Integer, T> data = new HashMap<>();
    private int idCounter = 1;

    @GetMapping("/{id}")
    public T getById(@PathVariable int id) {
        return data.get(id);
    }

    @GetMapping("/all")
    public List<T> getAll() {
        return new ArrayList<>(data.values());
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        data.put(idCounter, entity);
        idCounter++;
        return entity;
    }

    @PutMapping("/{id}")
    public T update(@PathVariable int id, @RequestBody T entity) {
        if (data.containsKey(id)) {
            data.put(id, entity);
            return entity;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        data.remove(id);
    }
}
