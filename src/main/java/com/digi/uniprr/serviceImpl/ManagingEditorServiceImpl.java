package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ReviewerVO;
import com.digi.uniprr.model.MeAvailability;
import com.digi.uniprr.model.ReviewerAvailability;
import com.digi.uniprr.model.Role;
import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.MeAvailabilityRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.ManagingEditorService;

@Service
@Transactional
public class ManagingEditorServiceImpl implements ManagingEditorService {

	@Autowired
	MeAvailabilityRepo meAvailabilityRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public void saveManagingEditorAvailability(MeAvailability meAvailability) {
		if(meAvailability.getIsActive() == null) {
			meAvailability.setIsActive(1);
		}
		meAvailabilityRepo.save(meAvailability);
		
	}

	@Override
	public List<ReviewerVO> getManagingEditorWithAvailability() {


		List<ReviewerVO> managingEditorData = new ArrayList<>();

		List<User> user = userRepo.getAllActiveUser();
		if (user != null && !user.isEmpty()) {

			for (User uerDetail : user) {
				ReviewerVO data = new ReviewerVO();
				for (Role roleDetail : uerDetail.getRole()) {
					if (roleDetail.getRoleId().equals(2)) {
						List<MeAvailability> managingEditorUnavaailableList = meAvailabilityRepo
								.getManagingEditorAvailabilityById(uerDetail.getId());
						List<ReviewerAvailability> mEUnavaailable = new ArrayList<>();
						if (managingEditorUnavaailableList != null && !managingEditorUnavaailableList.isEmpty()) {
							for (MeAvailability mEData : managingEditorUnavaailableList) {
								ReviewerAvailability mEUnavailableData = new ReviewerAvailability();
								mEUnavailableData.setUnavilableFrom(mEData.getUnavilableFrom());
								mEUnavailableData.setUnavailableTo(mEData.getUnavailableTo());
								mEUnavaailable.add(mEUnavailableData);
							}
						}
						data.setFirstname(uerDetail.getFirstName());
						data.setLastname(uerDetail.getLastName());
						data.setEmail(uerDetail.getEmail());
						if (mEUnavaailable != null) {
							data.setReviewerAvailability(mEUnavaailable);
						}
						managingEditorData.add(data);
					}
				}
			}
		}
		return managingEditorData;
	
	
	}

	@Override
	public List<MeAvailability> getManagingEditorAvailabilityById(Integer id) {
		return meAvailabilityRepo.getManagingEditorAvailabilityById(id);
	}

	@Override
	public void deleteManagingEditorAvailabilityById(Integer id) {
		meAvailabilityRepo.deleteManagingEditorAvailabilityById(id);
		
	}

}
