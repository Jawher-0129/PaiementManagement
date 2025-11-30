package tn.skillswap.skillswap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.skillswap.skillswap.Entity.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("SELECT r FROM Reservation r WHERE r.user.id_User = :userId")
    List<Reservation> findReservationsByUserId(@Param("userId") Long userId);

}
