package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.SpecializationVO;
import com.digi.uniprr.model.Expertise;
import com.digi.uniprr.model.JournalMetadata;
import com.digi.uniprr.model.Specialization;
import com.digi.uniprr.repository.ExpertiseRepo;
import com.digi.uniprr.repository.JournalMetadataRepo;
import com.digi.uniprr.repository.SpecilizationRepo;
import com.digi.uniprr.service.SpecializationService;

@Service
@Transactional
public class SpecializationServiceImpl implements SpecializationService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SpecilizationRepo specilizationRepo;

	@Autowired
	JournalMetadataRepo journalMetadataRepo;

	@Autowired
	ExpertiseRepo expertiseRepo;

	JSONObject obj = new JSONObject();

	/*
	 * @Override public List<SpecializationVO> getList() {
	 * log.info("Inside specilizationList getList Impl"); List<Specialization>
	 * specilizationList = specilizationRepo.findAll(); List<SpecializationVO> list
	 * = new ArrayList<SpecializationVO>(); for(Specialization s :specilizationList
	 * ) { SpecializationVO vo = new SpecializationVO(); vo.setId(s.getId());
	 * vo.setExpertiseId(s.getSubjectId());
	 * vo.setSpecialization(s.getSpecialization());
	 * vo.setCreatedby(s.getCreatedBy()); vo.setCreatedOn(s.getCreatedOn());
	 * vo.setUpdatedBy(s.getUpdatedBy()); vo.setUpdatedOn(s.getUpdatedOn());
	 * 
	 * list.add(vo); } return list; }
	 */

	@Override
	public List<Specialization> getspecializationListById(List<Integer> id) {
		return specilizationRepo.getSpecializationByIdList(id);
	}

	@Override
	public List<SpecializationVO> querysearchjournal(SpecializationVO specializationVO) {
		List<SpecializationVO> list = new ArrayList<SpecializationVO>();
		if (specializationVO.getSpecializationName().isEmpty()) {
			List<JournalMetadata> data = journalMetadataRepo
					.getSpecilaizationByJournalOne(specializationVO.getSubjectName());
			for (JournalMetadata s : data) {

				SpecializationVO vo = new SpecializationVO();
				vo.setJournalId(s.getJournalId());
				vo.setJournalSpeciality(s.getJournalSpeciality());
				vo.setJournalSubCategory(s.getJournalSubCategory());
				vo.setJournalSubject(s.getJournalSubject());
				vo.setJournalDOI(s.getJournalDOI());
				vo.setJournalBlindType(s.getJournalBlindType());
				vo.setJournalEissn(s.getJournalEissn());
				vo.setJournalReadership(s.getJournalReadership());
				vo.setJournalFrequency(s.getJournalFrequency());
				vo.setJournalDOI(s.getJournalDOI());
				vo.setOpenAccess(s.getOpenAccess());
				vo.setJournalCode(s.getJournal().getJournalCode());
				vo.setJournalTitle(s.getJournal().getJournalTitle());
				vo.setJournalIssn(s.getJournalIssn());
				vo.setBibliography(s.getBibliography());
				vo.setJournalChargeId(s.getJournal().getCharge().getJournalChargeId());
				vo.setChargeAmount(s.getJournal().getCharge().getChargeAmount());
				vo.setColorCharges(s.getJournal().getCharge().getColorCharges());
				vo.setFixedChargeAmount(s.getJournal().getCharge().getFixedChargeAmount());
				vo.setFixedCharges(s.getJournal().getCharge().getFixedCharges());
				vo.setExtendDueDate(s.getExtendDueDate());
				vo.setCreatedby(s.getCreatedBy());
				vo.setCreatedOn(s.getCreatedOn());
				vo.setUpdatedBy(s.getUpdatedBy());
				vo.setUpdatedOn(s.getUpdatedOn());

				list.add(vo);
			}
		} else {
			List<JournalMetadata> data = journalMetadataRepo.getSpecilaizationByJournal(
					specializationVO.getSpecializationName(), specializationVO.getSubjectName());
			for (JournalMetadata s : data) {

				SpecializationVO vo = new SpecializationVO();
				vo.setJournalId(s.getJournalId());
				vo.setJournalSpeciality(s.getJournalSpeciality());
				vo.setJournalSubCategory(s.getJournalSubCategory());
				vo.setJournalSubject(s.getJournalSubject());
				vo.setJournalDOI(s.getJournalDOI());
				vo.setJournalBlindType(s.getJournalBlindType());
				vo.setJournalEissn(s.getJournalEissn());
				vo.setJournalReadership(s.getJournalReadership());
				vo.setJournalFrequency(s.getJournalFrequency());
				vo.setJournalDOI(s.getJournalDOI());
				vo.setOpenAccess(s.getOpenAccess());
				vo.setJournalCode(s.getJournal().getJournalCode());
				vo.setJournalTitle(s.getJournal().getJournalTitle());
				vo.setJournalIssn(s.getJournalIssn());
				vo.setBibliography(s.getBibliography());
				if(s.getJournal().getCharge() !=null) {
				vo.setJournalChargeId(s.getJournal().getCharge().getJournalChargeId());
				vo.setChargeAmount(s.getJournal().getCharge().getChargeAmount());
				vo.setColorCharges(s.getJournal().getCharge().getColorCharges());
				vo.setFixedChargeAmount(s.getJournal().getCharge().getFixedChargeAmount());
				vo.setFixedCharges(s.getJournal().getCharge().getFixedCharges());
				}
				vo.setExtendDueDate(s.getExtendDueDate());
				vo.setCreatedby(s.getCreatedBy());
				vo.setCreatedOn(s.getCreatedOn());
				vo.setUpdatedBy(s.getUpdatedBy());
				vo.setUpdatedOn(s.getUpdatedOn());

				list.add(vo);
			}
		}

		return list;
	}

	/*
	 * @Override public List<Expertise> getExpertise() {
	 * log.info("Inside getExpertise Impl"); return expertiseRepo.findAll(); }
	 */

	@Override
	public void createSpecilization(List<Specialization> specialization) {
		for (Specialization s : specialization) {
			s.setIsActive(1);
			specilizationRepo.save(s);
		}

	}

	/*
	 * @Override public Specialization updateSpecilization(Specialization
	 * specialization) { Specialization specializationData =
	 * specilizationRepo.save(specialization); return specializationData; }
	 */

	@Override
	public void deleteSpecilization(IDVO id) {
		specilizationRepo.deleteSpecilization(id.getId());
	}

	/*
	 * @Override public List<Specialization> getSpecializationByID(SpecializationVO
	 * specializationVO) { List<Specialization> data =
	 * specilizationRepo.getSpecializationByIdList(specializationVO.getExpertiseid()
	 * ); return data; }
	 */

}
