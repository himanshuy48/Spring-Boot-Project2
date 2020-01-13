
package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digi.uniprr.VO.ManuscriptFilterVO;
import com.digi.uniprr.VO.SearchReviewerVO;
import com.digi.uniprr.VO.TrackManuScriptVO;
import com.digi.uniprr.model.Author;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.Role;
import com.digi.uniprr.model.User;
import com.digi.uniprr.model.UserJournal;
import com.digi.uniprr.repository.ManuScriptRepo;
import com.digi.uniprr.repository.UserJournalRepo;
import com.digi.uniprr.repository.UserLoginRepo;
import com.digi.uniprr.service.CommonService;

@Transactional

@Service
public class CommonServiceImpl implements CommonService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UserLoginRepo userLoginRepo;

	@Autowired
	ManuScriptRepo manuscriptRepo;

	@Autowired
	UserJournalRepo userJournalRepo;

	@Override

	@SuppressWarnings("unchecked")
	public List<TrackManuScriptVO> queryManuscript(ManuscriptFilterVO manuscriptFilterVO) {
		User user = userLoginRepo.getOne(manuscriptFilterVO.getUserId());
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ManuScript.class);

		if (manuscriptFilterVO.getManuscriptCode() != null
				&& manuscriptFilterVO.getManuscriptCode().trim().length() > 0)
			criteria.add(Restrictions.eq("manuscriptCode", manuscriptFilterVO.getManuscriptCode()));

		if (manuscriptFilterVO.getManuscriptTitle() != null
				&& manuscriptFilterVO.getManuscriptTitle().trim().length() > 0)
			criteria.add(
					Restrictions.like("manuscriptTitle", manuscriptFilterVO.getManuscriptTitle(), MatchMode.ANYWHERE));

		if (manuscriptFilterVO.getSubmissionDateFrom() != null)
			criteria.add(Restrictions.ge("submissionDate", manuscriptFilterVO.getSubmissionDateFrom()));

		if (manuscriptFilterVO.getSubmissionDateTo() != null)
			criteria.add(Restrictions.le("submissionDate", manuscriptFilterVO.getSubmissionDateTo()));

		List<ManuScript> list = (List<ManuScript>) criteria.list();

		List<TrackManuScriptVO> voList = new ArrayList<TrackManuScriptVO>();

		for (ManuScript m : list) {
			for (Role role : user.getRole()) {
				if (manuscriptFilterVO.getUserId().equals(m.getAuthorId())) {
					if (role.getRoleId().equals(4)) {
						TrackManuScriptVO vo = new TrackManuScriptVO();
					    vo.setManuscriptId(m.getManuScriptId());
						vo.setManuscriptCode(m.getManuscriptCode());
						vo.setAuthorId(m.getAuthorId());
						vo.setUserName(m.getUser().getFirstName() + " " + m.getUser().getLastName());
						vo.setManuscriptTitle(m.getManuscriptTitle());
						vo.setSubmissionDate(m.getSubmissionDate());
						vo.setManuscriptStatusId(m.getManuscriptStatusId());
						vo.setManuscriptValue(m.getStatusMaster().getStatusValue());
						vo.setJournalId(m.getJournalId());
						vo.setManuscriptVersion(m.getManuscriptVersion());
						vo.setSubmittedBy(m.getSubmittedBy());
						vo.setUpdatedBy(m.getUpdatedBy());
						vo.setCreatedBy(m.getCreatedBy());
						vo.setCreatedOn(m.getCreatedOn());
						vo.setUpdatedOn(m.getUpdatedOn());
						voList.add(vo);
					} else {
						TrackManuScriptVO vo = new TrackManuScriptVO();
						vo.setManuscriptId(m.getManuScriptId());
						vo.setManuscriptCode(m.getManuscriptCode());
						vo.setAuthorId(m.getAuthorId());
						vo.setUserName(m.getUser().getFirstName() + " " + m.getUser().getLastName());
						vo.setManuscriptTitle(m.getManuscriptTitle());
						vo.setSubmissionDate(m.getSubmissionDate());
						vo.setManuscriptStatusId(m.getManuscriptStatusId());
						vo.setManuscriptValue(m.getStatusMaster().getStatusValue());
						vo.setJournalId(m.getJournalId());
						vo.setManuscriptVersion(m.getManuscriptVersion());
						vo.setSubmittedBy(m.getSubmittedBy());
						vo.setUpdatedBy(m.getUpdatedBy());
						vo.setCreatedBy(m.getCreatedBy());
						vo.setCreatedOn(m.getCreatedOn());
						vo.setUpdatedOn(m.getUpdatedOn());
						voList.add(vo);
					}
				}
			}
		}
		return voList;

	}

	@Override
	public List<SearchReviewerVO> queryReviewer(SearchReviewerVO searchReviewerVO) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Author.class);

		if (searchReviewerVO.getReviewerName() != null && searchReviewerVO.getReviewerName().trim().length() > 0)
			criteria.add(Restrictions.like("firstName", searchReviewerVO.getReviewerName(), MatchMode.ANYWHERE));

		if (searchReviewerVO.getReviewerSpeciality() != null
				&& searchReviewerVO.getReviewerSpeciality().trim().length() > 0)
			criteria.add(Restrictions.eq("speciality", searchReviewerVO.getReviewerSpeciality()));

		if (searchReviewerVO.getOrcid() != null && searchReviewerVO.getOrcid().trim().length() > 0)
			criteria.add(Restrictions.eq("orcidid", searchReviewerVO.getOrcid()));

		if (searchReviewerVO.getEmailId() != null && searchReviewerVO.getEmailId().trim().length() > 0)
			criteria.add(Restrictions.like("authorEmail", searchReviewerVO.getEmailId(), MatchMode.ANYWHERE));

		List<Author> list = (List<Author>) criteria.list();

		if (searchReviewerVO.getInstitutionName() != null) {
			List<Author> manuscriptList = list.stream()
					.filter(s -> s.getInstitution().getInstName().toUpperCase()
							.contains(searchReviewerVO.getInstitutionName().toUpperCase()))
					.collect(Collectors.toList());
			list = manuscriptList;
		}

		List<SearchReviewerVO> voList = new ArrayList<SearchReviewerVO>();
		for (Author a : list) {
			SearchReviewerVO vo = new SearchReviewerVO();
			vo.setReviewerName(a.getFirstName() + " " + a.getLastName());
			vo.setReviewerSpeciality(a.getSpeciality());
			vo.setInstitutionName(a.getInstitution().getInstName());
			vo.setOrcid(a.getOrcidid());
			vo.setEmailId(a.getAuthorEmail());

			voList.add(vo);
		}
		return voList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TrackManuScriptVO> getManuscript(ManuscriptFilterVO manuscriptFilterVO) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ManuScript.class);

		if (manuscriptFilterVO.getManuscriptCode() != null
				&& manuscriptFilterVO.getManuscriptCode().trim().length() > 0)
			criteria.add(Restrictions.eq("manuscriptCode", manuscriptFilterVO.getManuscriptCode()));

		if (manuscriptFilterVO.getManuscriptTitle() != null
				&& manuscriptFilterVO.getManuscriptTitle().trim().length() > 0)
			criteria.add(
					Restrictions.like("manuscriptTitle", manuscriptFilterVO.getManuscriptTitle(), MatchMode.ANYWHERE));

		if (manuscriptFilterVO.getSubmissionDateFrom() != null)
			criteria.add(Restrictions.ge("submissionDate", manuscriptFilterVO.getSubmissionDateFrom()));

		if (manuscriptFilterVO.getSubmissionDateTo() != null)
			criteria.add(Restrictions.le("submissionDate", manuscriptFilterVO.getSubmissionDateTo()));

		List<ManuScript> list = (List<ManuScript>) criteria.list();

		List<TrackManuScriptVO> voList = new ArrayList<TrackManuScriptVO>();

		for (ManuScript m : list) {
			TrackManuScriptVO vo = new TrackManuScriptVO();
			vo.setManuscriptId(m.getManuScriptId());
			vo.setManuscriptCode(m.getManuscriptCode());
			vo.setAuthorId(m.getAuthorId());
			vo.setUserName(m.getUser().getFirstName() + " " + m.getUser().getLastName());
			vo.setManuscriptTitle(m.getManuscriptTitle());
			vo.setSubmissionDate(m.getSubmissionDate());
			vo.setManuscriptStatusId(m.getManuscriptStatusId());
			vo.setManuscriptValue(m.getStatusMaster().getStatusValue());
			vo.setJournalId(m.getJournalId());
			vo.setManuscriptVersion(m.getManuscriptVersion());
			vo.setSubmittedBy(m.getSubmittedBy());
			vo.setUpdatedBy(m.getUpdatedBy());
			vo.setCreatedBy(m.getCreatedBy());
			vo.setCreatedOn(m.getCreatedOn());
			vo.setUpdatedOn(m.getUpdatedOn());
			voList.add(vo);
		}
		return voList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TrackManuScriptVO> getJournalIdManuscript(ManuscriptFilterVO manuscriptFilterVO) {
		List<Integer> journalId = new ArrayList();
		User user = userLoginRepo.getOne(manuscriptFilterVO.getUserId());
		List<UserJournal> userJournalList = userJournalRepo.getUserJournalByUserId(user.getId());
		for (UserJournal userJournal : userJournalList) {
			journalId.add(userJournal.getJournalId());
		}
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ManuScript.class);

		if (manuscriptFilterVO.getManuscriptCode() != null
				&& manuscriptFilterVO.getManuscriptCode().trim().length() > 0)
			criteria.add(Restrictions.eq("manuscriptCode", manuscriptFilterVO.getManuscriptCode()));

		if (manuscriptFilterVO.getManuscriptTitle() != null
				&& manuscriptFilterVO.getManuscriptTitle().trim().length() > 0)
			criteria.add(
					Restrictions.like("manuscriptTitle", manuscriptFilterVO.getManuscriptTitle(), MatchMode.ANYWHERE));

		if (manuscriptFilterVO.getSubmissionDateFrom() != null)
			criteria.add(Restrictions.ge("submissionDate", manuscriptFilterVO.getSubmissionDateFrom()));

		if (manuscriptFilterVO.getSubmissionDateTo() != null)
			criteria.add(Restrictions.le("submissionDate", manuscriptFilterVO.getSubmissionDateTo()));

		criteria.add(Restrictions.in("journalId", journalId));
	    
		
		
		List<ManuScript> list = (List<ManuScript>) criteria.list();
		//List<ManuScript> list1 = manuscriptRepo.getManuscriptByJournalList(journalId);

		List<TrackManuScriptVO> voList = new ArrayList<TrackManuScriptVO>();

		for (ManuScript m : list) {
			for (Role role : user.getRole()) {

				TrackManuScriptVO vo = new TrackManuScriptVO();
				vo.setManuscriptId(m.getManuScriptId());
				vo.setManuscriptCode(m.getManuscriptCode());
				vo.setAuthorId(m.getAuthorId());
				vo.setUserName(m.getUser().getFirstName() + " " + m.getUser().getLastName());
				vo.setManuscriptTitle(m.getManuscriptTitle());
				vo.setSubmissionDate(m.getSubmissionDate());
				vo.setManuscriptStatusId(m.getManuscriptStatusId());
				vo.setManuscriptValue(m.getStatusMaster().getStatusValue());
				vo.setJournalId(m.getJournalId());
				vo.setManuscriptVersion(m.getManuscriptVersion());
				vo.setSubmittedBy(m.getSubmittedBy());
				vo.setUpdatedBy(m.getUpdatedBy());
				vo.setCreatedBy(m.getCreatedBy());
				vo.setCreatedOn(m.getCreatedOn());
				vo.setUpdatedOn(m.getUpdatedOn());
				voList.add(vo);

			}
		}
		return voList;

	}
}
