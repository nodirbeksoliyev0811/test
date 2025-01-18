package nodirbek.uz.test.repository;

import nodirbek.uz.test.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {
    @Transactional
    @Modifying
    @Query("update UserEntity u set u.name = :name, u.surname = :surname where u.id = :id")
    void updateById(@Param("name") String name, @Param("surname") String surname, @Param("id") Long id);
}