package com.fiap.burger.controller.controller;

import com.fiap.burger.controller.adapter.api.OrderController;
import com.fiap.burger.entity.order.Order;
import com.fiap.burger.entity.order.OrderStatus;
import com.fiap.burger.usecase.adapter.gateway.ClientGateway;
import com.fiap.burger.usecase.adapter.gateway.OrderGateway;
import com.fiap.burger.usecase.adapter.gateway.ProductGateway;
import com.fiap.burger.usecase.adapter.usecase.OrderUseCase;
import com.fiap.burger.usecase.misc.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultOrderController implements OrderController {
    @Autowired
    private OrderUseCase useCase;
    @Autowired
    OrderGateway orderGateway;
    @Autowired
    ClientGateway clientGateway;
    @Autowired
    ProductGateway productGateway;

    @Override
    public Order insert(Order order) {
        return useCase.insert(order);
    }

    @Override
    public Order findById(Long orderId) {
        var persistedOrder = useCase.findById(orderId);
        if (persistedOrder == null) throw new OrderNotFoundException();
        return persistedOrder;
    }

    @Override
    public Order updateStatus(Long orderId, OrderStatus newStatus) {
        return useCase.updateStatus(orderId, newStatus);
    }

    @Override
    public List<Order> findAllBy(OrderStatus status) {
        return useCase.findAllBy(status);
    }

    @Override
    public List<Order> findAllInProgress() {
        return useCase.findAllInProgress();
    }
}

