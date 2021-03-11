package com.halodoc.campaign.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UserDAO, Integer> {
    Optional<UserDAO> findByName(String username);

    Optional<UserDAO> findById(String id);

}
