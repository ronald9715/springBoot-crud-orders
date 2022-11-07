package com.ronald.controller;

import com.ronald.model.Order;
import com.ronald.service.IOrderService;
import com.ronald.service.impl.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private IOrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> readAll() throws Exception{
        List<Order> list = service.readAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> readById(@PathVariable("id") Integer id) throws Exception{
        Order order = service.readById(id);
        if (order == null){
            throw new ClassNotFoundException("NOT FOUND");
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Order>create(@RequestBody Order order) throws Exception{
        Order order1 = service.create(order);
        return new ResponseEntity<>(order1, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Order> update(@RequestBody Order order) throws Exception{
        Order obj = service.readById(order.getIdOrder());
        if (obj == null){
            throw new ClassNotFoundException("NOT FOUND");
        }
        Order order1 = service.update(order);
        return new ResponseEntity<>(order1, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) throws Exception{
        Order obj = service.readById(id);
        if (obj == null){
            throw new ClassNotFoundException("NOT FOUND");
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
