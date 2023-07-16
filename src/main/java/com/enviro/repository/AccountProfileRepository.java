package com.enviro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enviro.model.AccountProfile;

public interface AccountProfileRepository extends JpaRepository<AccountProfile,Long>{
    
}
