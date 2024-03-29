package com.fiap.burger.controller.controller;

import com.fiap.burger.entity.order.Order;
import com.fiap.burger.entity.order.OrderStatus;
import com.fiap.burger.usecase.misc.exception.OrderNotFoundException;
import com.fiap.burger.usecase.usecase.DefaultOrderUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DefaultOrderControllerTest {

    @Mock
    DefaultOrderUseCase useCase;

    @InjectMocks
    DefaultOrderController controller;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldFindById() {
        var id = 1L;
        var expected = new Order(null, Collections.emptyList(), OrderStatus.FINALIZADO);

        when(useCase.findById(id)).thenReturn(expected);

        Order actual = controller.findById(id);

        assertEquals(expected, actual);

        verify(useCase, times(1)).findById(id);
    }

    @Test
    void shouldThrownOrderNotFoundExceptionWhenOrderNotFoundById() {
        var id = 1L;

        when(useCase.findById(id)).thenReturn(null);

        assertThrows(OrderNotFoundException.class, () -> controller.findById(id));

        verify(useCase, times(1)).findById(id);
    }

    @Test
    void shouldFindAllBy() {
        var expected = List.of(new Order(null, Collections.emptyList(), OrderStatus.FINALIZADO));

        when(useCase.findAllBy(OrderStatus.FINALIZADO)).thenReturn(expected);

        List<Order> actual = controller.findAllBy(OrderStatus.FINALIZADO);

        assertEquals(expected, actual);

        verify(useCase, times(1)).findAllBy(OrderStatus.FINALIZADO);
    }

    @Test
    void shouldFindAllInProgress() {
        var expected = List.of(new Order(null, Collections.emptyList(), OrderStatus.RECEBIDO));

        when(useCase.findAllInProgress()).thenReturn(expected);

        List<Order> actual = controller.findAllInProgress();

        assertEquals(expected, actual);

        verify(useCase, times(1)).findAllInProgress();
    }

    @Test
    void shouldInsertOrder() {
        var order = new Order(null, Collections.emptyList(), OrderStatus.RECEBIDO);

        when(useCase.insert(order)).thenReturn(order);

        Order actual = controller.insert(order);

        assertEquals(order, actual);

        verify(useCase, times(1)).insert(order);
    }

    @Test
    void shouldUpdateStatusOrder() {
        var order = new Order(null, Collections.emptyList(), OrderStatus.EM_PREPARACAO);

        when(useCase.updateStatus(1L, OrderStatus.EM_PREPARACAO)).thenReturn(order);

        Order actual = controller.updateStatus(1L, OrderStatus.EM_PREPARACAO);

        assertEquals(order, actual);

        verify(useCase, times(1)).updateStatus(1L, OrderStatus.EM_PREPARACAO);
    }
}
