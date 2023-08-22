package com.insu.iworkshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.insu.iworkshop.entities.User;

public interface UserRepo extends JpaRepository<User,Long> {
	@Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
    
    @Query("select u from User u where u.email = :email")
    public User getUserByUserName(@Param("email") String email);
}
