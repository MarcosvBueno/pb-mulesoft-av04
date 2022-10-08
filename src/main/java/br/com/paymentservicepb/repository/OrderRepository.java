package br.com.paymentservicepb.repository;

import br.com.paymentservicepb.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
