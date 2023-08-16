package com.OnlineBookStore.OnlineBookStore.repository;

import com.OnlineBookStore.OnlineBookStore.entity.booksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface booksRepo extends JpaRepository<booksEntity, Long> {
}
