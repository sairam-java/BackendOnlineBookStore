package com.OnlineBookStore.OnlineBookStore.repository;


import com.OnlineBookStore.OnlineBookStore.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<userEntity, Long> {

}
