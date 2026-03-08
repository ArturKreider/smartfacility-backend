package de.artur.smartfacility.user.repository;

import de.artur.smartfacility.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public boolean existsByEmail(String email);
}
