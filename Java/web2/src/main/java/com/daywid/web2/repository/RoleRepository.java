package com.daywid.web2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daywid.web2.entity.Role;
import java.util.List;
import com.daywid.web2.StatusRole;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
    List<Role> findByStatus(StatusRole status);

    Page<Role> findAll(Pageable pageable);

}
