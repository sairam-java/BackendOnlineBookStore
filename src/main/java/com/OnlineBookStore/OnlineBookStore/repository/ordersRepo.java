package com.OnlineBookStore.OnlineBookStore.repository;

import com.OnlineBookStore.OnlineBookStore.entity.ordersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ordersRepo extends JpaRepository<ordersEntity, Long> {
}
