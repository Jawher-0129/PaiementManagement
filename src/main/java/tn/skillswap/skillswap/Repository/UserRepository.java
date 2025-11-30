package tn.skillswap.skillswap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.skillswap.skillswap.Entity.Reservation;
import tn.skillswap.skillswap.Entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
}
