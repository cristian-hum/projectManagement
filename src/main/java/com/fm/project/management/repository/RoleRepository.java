package com.fm.project.management.repository;

import com.fm.project.management.model.Role;
import com.fm.project.management.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
