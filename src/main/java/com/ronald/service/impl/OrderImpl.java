package com.ronald.service.impl;

import com.ronald.model.Order;
import com.ronald.repo.IGenericRepo;
import com.ronald.repo.IOrderRepo;
import com.ronald.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderImpl extends CRUDImpl<Order, Integer> implements IOrderService {
    @Autowired
    private IOrderRepo repo;
    @Override
    IGenericRepo<Order, Integer> getRepo() {
        return repo;
    }
}
