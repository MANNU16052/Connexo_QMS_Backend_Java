package QMS.QMS_Project.Repository;
import QMS.QMS_Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	//User findFirstByEmail(String email);
}
