package ru.anton.myolimpoks.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anton.myolimpoks.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
