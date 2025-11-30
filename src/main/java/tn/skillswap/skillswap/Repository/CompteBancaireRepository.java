package tn.skillswap.skillswap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.skillswap.skillswap.Entity.CompteBancaire;

import java.util.Optional;

@Repository
public interface CompteBancaireRepository extends JpaRepository<CompteBancaire,Long> {

    @Query("SELECT c FROM CompteBancaire c WHERE c.user.id_User = :userId")
    Optional<CompteBancaire> findByUserId(@Param("userId") Long userId);


}
