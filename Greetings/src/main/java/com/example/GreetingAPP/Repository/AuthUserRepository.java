package com.example.GreetingAPP.Repository;
import com.example.GreetingAPP.Modal.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {


}