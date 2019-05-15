package com.techscore.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuListRepository extends JpaRepository<Menu, Long> {
}