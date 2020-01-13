package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.VO.ReviewerVO;
import com.digi.uniprr.model.EditorAvailability;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.ReviewerAvailability;
import com.digi.uniprr.model.Role;
import com.digi.uniprr.model.User;
import com.digi.uniprr.repository.EditorAvailabilityRepo;
import com.digi.uniprr.repository.ManuScriptRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.EditorService;

@Service
@Transactional
public class EditorServiceImpl implements EditorService {

	@Autowired
	ManuScriptRepo manuScriptRepo;
	
	@Autowired
	EditorAvailabilityRepo editorAvailabilityRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<ManuscriptListVO> getManuScriptDataByStatus(ManuscriptListVO manuscriptListVO) {
		for (int i = 0; i <= manuscriptListVO.getManuscriptStatusId().size() - 1; i++) {
			List<ManuScript> manuList = manuScriptRepo.getManuScriptDataByStatus(manuscriptListVO.getJournalId(),
					manuscriptListVO.getManuscriptStatusId().get(i));
			List<ManuscriptListVO> manuVo = new ArrayList<ManuscriptListVO>();
			manuList.stream().forEach(manu -> {
				ManuscriptListVO manuListVo = new ManuscriptListVO();
				manuListVo.setManuScriptId(manu.getManuScriptId());
				manuListVo.setJournalId(manu.getJournalId());
				manuListVo.setManuscripCode(manu.getManuscriptCode());
				manuListVo.setManuscripTitle(manu.getManuscriptTitle());
				manuListVo.setManuscriptAuthorId(manu.getAuthorId());
				manuListVo.setManuScriptId(manu.getManuscriptStatusId());
				manuListVo.setManuscriptVersion(manu.getManuscriptVersion());
				manuListVo.setSubmissionDate(manu.getSubmissionDate());
				manuVo.add(manuListVo);
			});
			return manuVo;
		}
		return null;
	}

	@Override
	public void updateManuScriptByAuthor(ManuscriptListVO manuscriptListVO) {
		
			manuScriptRepo.updateManuScriptByAuthor(manuscriptListVO.getManuScriptId(),
					manuscriptListVO.getManuscriptAuthorId(), manuscriptListVO.getManuStatusId());
		
	}

	@Override
	public void saveEditorAvailability(EditorAvailability editorAvailability) {
		if(editorAvailability.getIsActive() == null) {
			editorAvailability.setIsActive(1);
		}
		editorAvailabilityRepo.save(editorAvailability);
		
	}

	@Override
	public List<EditorAvailability> getEditorAvailabilityById(Integer id) {
		return editorAvailabilityRepo.getEditorAvailabilityById(id);
		 
	}

	@Override
	public void deleteEditorAvailabilityById(Integer id) {
		editorAvailabilityRepo.deleteReviewerAvailabilityById(id);
		
	}

	@Override
	public List<ReviewerVO> getEditorWithAvailability() {

		List<ReviewerVO> editorData = new ArrayList<>();

		List<User> user = userRepo.getAllActiveUser();
		if (user != null && !user.isEmpty()) {

			for (User uerDetail : user) {
				ReviewerVO data = new ReviewerVO();
				for (Role roleDetail : uerDetail.getRole()) {
					if (roleDetail.getRoleId().equals(3)) {
						List<EditorAvailability> editorUnavaailableList = editorAvailabilityRepo
								.getEditorAvailabilityById(uerDetail.getId());
						List<ReviewerAvailability> eUnavaailable = new ArrayList<>();
						if (editorUnavaailableList != null && !editorUnavaailableList.isEmpty()) {
							for (EditorAvailability eData : editorUnavaailableList) {
								ReviewerAvailability eUnavailableData = new ReviewerAvailability();
								eUnavailableData.setUnavilableFrom(eData.getUnavilableFrom());
								eUnavailableData.setUnavailableTo(eData.getUnavailableTo());
								eUnavaailable.add(eUnavailableData);
							}
						}
						data.setFirstname(uerDetail.getFirstName());
						data.setLastname(uerDetail.getLastName());
						data.setEmail(uerDetail.getEmail());
						if (eUnavaailable != null) {
							data.setReviewerAvailability(eUnavaailable);
						}
						editorData.add(data);
					}

				}

			}

		}

		return editorData;
	
	}

}
