package com.alaythiaproductions.springmvcproject.repositories;

import com.alaythiaproductions.springmvcproject.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
