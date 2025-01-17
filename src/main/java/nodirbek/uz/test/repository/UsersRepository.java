package nodirbek.uz.test.repository;

import nodirbek.uz.test.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {

}