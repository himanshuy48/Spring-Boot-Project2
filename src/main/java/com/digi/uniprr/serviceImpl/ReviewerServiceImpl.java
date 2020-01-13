package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.ReviewerAvailabilityVO;
import com.digi.uniprr.VO.ReviewerStatusData;
import com.digi.uniprr.VO.ReviewerVO;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.Reviewer;
import com.digi.uniprr.model.ReviewerAvailability;
import com.digi.uniprr.model.Role;
import com.digi.uniprr.model.StatusMaster;
import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.ManuScriptReviewerRepo;
import com.digi.uniprr.repository.ReviewerAvailabilityRepo;
import com.digi.uniprr.repository.ReviewerRepo;
import com.digi.uniprr.repository.StatusMasterRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.ReviewerService;

@Service
@Transactional
public class ReviewerServiceImpl implements ReviewerService {

	@Autowired
	ReviewerRepo reviewerRepo;

	@Autowired
	ReviewerAvailabilityRepo reviewerAvailabilityRepo;

	@Autowired
	ManuScriptReviewerRepo manuScriptReviewerRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	StatusMasterRepo statusMasterRepo;

	@Override
	public List<User> getReviewerListDeatils() {
		List<User> userData = new ArrayList<>();
		List<User> user = userRepo.getAllActiveUser();
		for (User uerDetail : user) {
			for (Role roleDetail : uerDetail.getRole()) {
				if (roleDetail.getRoleId().equals(5)) {
					uerDetail.setPassword("");
					userData.add(uerDetail);
				}
			}
		}
		return userData;
	}
	
	@Override
	public String createReviewer(Reviewer reviewer) {
		reviewerRepo.save(reviewer);
		return "Created successfully";
	}

	@Override
	public void saveReviewerAvailability(ReviewerAvailability reviewerAvailability) {
		if (reviewerAvailability.getIsActive() == null) {
			reviewerAvailability.setIsActive(1);
		}
		reviewerAvailabilityRepo.save(reviewerAvailability);
	}

	@Override
	public List<ReviewerAvailabilityVO> getReviewerAvailabilityById(Integer id) {
		List<ReviewerAvailability> data =  reviewerAvailabilityRepo.getReviewerAvailabilityById(id);
		List<ReviewerAvailabilityVO> reviewerAvailabilityData = new ArrayList<>(); 
		for(ReviewerAvailability reviewerAvailability : data) {
			User user = userRepo.getOne(reviewerAvailability.getReviewerId());
			ReviewerAvailabilityVO tempData = new ReviewerAvailabilityVO();
			tempData.setId(reviewerAvailability.getRa_id());
			tempData.setReviewerId(reviewerAvailability.getReviewerId());
			tempData.setUnavilableFrom(reviewerAvailability.getUnavilableFrom());
			tempData.setUnavailableTo(reviewerAvailability.getUnavailableTo());
			tempData.setApplyDate(reviewerAvailability.getApplyDate());
			tempData.setReason(reviewerAvailability.getReason());
			if(user!=null) {
				tempData.setName(user.getFirstName() +" " +user.getLastName());
			}
			
			reviewerAvailabilityData.add(tempData);
		}
		return reviewerAvailabilityData;
	}

	@Override
	public void deleteReviewerAvailabilityById(Integer id) {
		reviewerAvailabilityRepo.deleteReviewerAvailabilityById(id);

	}

	@Override
	public boolean isExistById(Integer id) {
		boolean result = false;
		try {
			if (reviewerRepo.getReviewerById(id).isEmpty())
				result = true;
		} catch (Exception e) {
			return result;
		}
		return result;
	}

	@Override
	public List<ReviewerVO> getReviewerList() {
		List<Reviewer> reviewerList = reviewerRepo.findAll();
		List<ReviewerVO> reviewervoList = new ArrayList<ReviewerVO>();
		for (Reviewer r : reviewerList) {
			ReviewerVO vo = new ReviewerVO();
			vo.setFirstname(r.getFirstName());
			vo.setLastname(r.getLastName());
			vo.setState(r.getState());
			vo.setCity(r.getCity());
			vo.setState(r.getState());
			vo.setMiddlename(r.getMiddleName());
			reviewervoList.add(vo);
		}

		return reviewervoList;
	}

	@Override
	public List<ReviewerStatusData> getReviewerByJournalId(IDVO id) {

		List<ReviewerStatusData> rsd = new ArrayList<>();
		List<ManuScriptReviewer> reviewerData = manuScriptReviewerRepo.getManuscriptReviewerListByJournalId(id.getId());
		if (reviewerData != null && !reviewerData.isEmpty()) {
			for (ManuScriptReviewer list : reviewerData) {
				ReviewerStatusData tempData = new ReviewerStatusData();
				tempData.setReviewerId(list.getReviewerId());
				tempData.setStatusId(list.getManuscriptStatus());
				StatusMaster st = statusMasterRepo.getOne(list.getManuscriptStatus());
				tempData.setStatusCode(st.getStatusValue());
				if (list.getReviewerId() != null) {
					User user = userRepo.getOne(list.getReviewerId());
					if (user != null && user.getFirstName() != null) {
						tempData.setName(user.getFirstName()+" "+user.getLastName());
						tempData.setEmail(user.getEmail());
					}

					List<ReviewerAvailability> reviewerAbailData = reviewerAvailabilityRepo
							.getReviewerAvailabilityById(list.getReviewerId());

					List<Date> UAvailFrom = new ArrayList<>();
					List<Date> UAvailTo = new ArrayList<>();
					if (reviewerAbailData != null && !reviewerAbailData.isEmpty()) {
						for (ReviewerAvailability rAvailList : reviewerAbailData) {
							Date tempAvailFrom = new Date();
							Date tempAvailTo = new Date();

							tempAvailFrom = rAvailList.getUnavilableFrom();
							tempAvailTo = rAvailList.getUnavailableTo();
							UAvailFrom.add(tempAvailFrom);
							UAvailTo.add(tempAvailTo);
						}
						tempData.setUnavailableFrom(UAvailFrom);
						tempData.setUnavailableTo(UAvailTo);
					}
				}
				rsd.add(tempData);
			}

		}

		return rsd;
	}

	@Override
	public List<ReviewerVO> getReviewerWithAvailability() {
		List<ReviewerVO> reviewerData = new ArrayList<>();

		List<User> user = userRepo.getAllActiveUser();
		if (user != null && !user.isEmpty()) {

			for (User uerDetail : user) {
				ReviewerVO data = new ReviewerVO();
				for (Role roleDetail : uerDetail.getRole()) {
					if (roleDetail.getRoleId().equals(5)) {
						List<ReviewerAvailability> reviewerUnavaailableList = reviewerAvailabilityRepo
								.getReviewerAvailabilityById(uerDetail.getId());
						List<ReviewerAvailability> rUnavaailable = new ArrayList<>();
						if (reviewerUnavaailableList != null && !reviewerUnavaailableList.isEmpty()) {
							for (ReviewerAvailability rData : reviewerUnavaailableList) {
								ReviewerAvailability rUnavailableData = new ReviewerAvailability();
								rUnavailableData.setUnavilableFrom(rData.getUnavilableFrom());
								rUnavailableData.setUnavailableTo(rData.getUnavailableTo());
								rUnavaailable.add(rUnavailableData);
							}
						}

						data.setFirstname(uerDetail.getFirstName());
						// data.setMiddlename(uerDetail.getMiddleName());
						data.setLastname(uerDetail.getLastName());
						data.setEmail(uerDetail.getEmail());
						if (rUnavaailable != null) {
							data.setReviewerAvailability(rUnavaailable);
						}
						reviewerData.add(data);
					}

				}

			}

		}

		return reviewerData;
	}

}
