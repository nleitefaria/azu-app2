package com.nleitefaria.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nleitefaria.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{
	@Query(value = "from Order o where o.orderTime BETWEEN :from AND :to")
	List<Order> findAllFromTo(@Param("from") Date startDate, @Param("to") Date endDate);

}
