package QMS.QMS_Project.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QMS.QMS_Project.Repository.DataFieldRepo;
import QMS.QMS_Project.model.DataField;




@Service
public class DataFieldService {
	
	@Autowired
	private DataFieldRepo repo;
	
	/* @Autowired */
	public DataFieldService(DataFieldRepo repo) {
		super();
		this.repo = repo;
	}

	public DataField AddDataField(DataField datafield) {
		return repo.save(datafield);
	}

	public List<DataField> getAllDataField(){
		return repo.findAll() ;
	}
	
	public DataField getDataFieldBy(int id) {
		Optional<DataField> e=repo.findById(id); 
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}
	public void deleteDataField(int id) {
		repo.deleteById(id);
	}

	public DataField get(int id) {
		return repo.findById(id).get();
	}


}
