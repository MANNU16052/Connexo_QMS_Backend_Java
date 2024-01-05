package QMS.QMS_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QMS.QMS_Project.model.DataField;



@Repository
public interface DataFieldRepo extends JpaRepository<DataField, Integer>{

}
