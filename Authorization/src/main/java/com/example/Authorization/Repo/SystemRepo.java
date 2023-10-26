package com.example.Authorization.Repo;

import com.example.Authorization.Entity.SystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SystemRepo  extends JpaRepository<SystemEntity, Long> {
}
