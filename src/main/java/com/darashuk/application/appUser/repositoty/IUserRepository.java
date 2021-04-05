package com.darashuk.application.appUser.repositoty;

import com.darashuk.application.appUser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<AppUser,Long> {
 Optional<AppUser>findByEmail(String email);
}
