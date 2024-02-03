package QMS.QMS_Project.Repository;
import QMS.QMS_Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	//User findFirstByEmail(String email);

    Optional<User> findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);


}
