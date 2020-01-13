package com.digi.uniprr.utils;

import java.util.ArrayList;
import java.util.List;

import com.digi.uniprr.VO.JournalVO;
import com.digi.uniprr.model.Journal;

public class JournalTransformationUtils {

	public static JournalVO mapJournalModelToJournalVo(Journal journal) {
		JournalVO vo = new JournalVO();
		
		vo.setChargeFlag(journal.getChargeFlag());
		vo.setExtendDueDate(journal.getExtendDueDate());
		vo.setJournalCode(journal.getJournalCode());
		vo.setJournalEditorGroup(journal.getJournalEditorGroup());
		vo.setJournalMeGroup(journal.getJournalMeGroup());
		vo.setJournalShortTitle(journal.getJournalShortTitle());
		vo.setJournalTitle(journal.getJournalTitle());
		vo.setJournalWorkflowId(journal.getJournalWorkflowId());
		vo.setJournalLogo(journal.getJournalLogo());
		vo.setJournalId(journal.getJournalId());
		vo.setPublisherId(journal.getPublisherId());
		vo.setReviewerSelection(journal.getReviewerSelection());
		vo.setCreatedOn(journal.getCreatedOn());
		vo.setUpdatedOn(journal.getUpdatedOn());
		
		if (journal.getJournalMetadata() != null) {
			vo.setAffilitaedTo(journal.getJournalMetadata().getAffilitaedTo());
			vo.setBibliography(journal.getJournalMetadata().getBibliography());
			vo.setColourFigures(journal.getJournalMetadata().getColourFigures());
			vo.setIsChargingRequired(journal.getJournalMetadata().getIsChargingRequired());
			vo.setJournalBlindType(journal.getJournalMetadata().getJournalBlindType());
			vo.setJournalDOI(journal.getJournalMetadata().getJournalDOI());
			vo.setJournalEissn(journal.getJournalMetadata().getJournalEissn());
			vo.setJournalIssn(journal.getJournalMetadata().getJournalIssn());
			vo.setJournalFrequency(journal.getJournalMetadata().getJournalFrequency());
			vo.setJournalIndexCopernicus(journal.getJournalMetadata().getJournalIndexCopernicus());
			vo.setJournalReadership(journal.getJournalMetadata().getJournalReadership());
			vo.setJournalSpeciality(journal.getJournalMetadata().getJournalSpeciality());
			vo.setJournalSubCategory(journal.getJournalMetadata().getJournalSubCategory());
			vo.setMetadataId(journal.getJournalMetadata().getMetadataId());
			vo.setOpenAccess(journal.getJournalMetadata().getOpenAccess());
			vo.setSuggestReviewer(journal.getJournalMetadata().getSuggestReviewer());
			vo.setTblcost(journal.getJournalMetadata().getTblcost());
			vo.setTypseStting(journal.getJournalMetadata().getTypseStting());
		}
		
		if (journal.getCharge() != null) {
			vo.setFixedCharges(journal.getCharge().getFixedCharges());
			vo.setBlackWhiteCharges(journal.getCharge().getBlackWhiteCharges());
			vo.setColorCharges(journal.getCharge().getColorCharges());
			vo.setProductionCharges(journal.getCharge().getProductionCharges());
			vo.setAdditionalCharges(journal.getCharge().getAdditionalCharges());
			vo.setTableCharges(journal.getCharge().getTableCharges());
			vo.setTypeSettingCharges(journal.getCharge().getTypeSettingCharges());
			vo.setFixedChargeAmount(journal.getCharge().getFixedChargeAmount());
		}
		
		return vo;
	}

	public static Journal mapJournalVOToJournalModel(JournalVO vo) {
		Journal journal = new Journal();
		journal.setChargeFlag(vo.getChargeFlag());
		journal.setExtendDueDate(vo.getExtendDueDate());
		journal.setJournalCode(vo.getJournalCode());
		journal.setJournalEditorGroup(vo.getJournalEditorGroup());
		journal.setJournalId(vo.getJournalId());
		journal.setJournalLogo(vo.getJournalLogo());
		journal.setJournalManagingEditor(vo.getJournalManagingEditor());
		journal.setJournalMeGroup(vo.getJournalMeGroup());
		journal.getJournalMetadata().setJournalBlindType(vo.getJournalBlindType());
		journal.getJournalMetadata().setAffilitaedTo(vo.getAffilitaedTo());
		journal.getJournalMetadata().setBibliography(vo.getBibliography());
		journal.getJournalMetadata().setCode(vo.getCode());
		journal.getJournalMetadata().setColourFigures(vo.getColourFigures());
		journal.getJournalMetadata().setIsChargingRequired(vo.getIsChargingRequired());
		journal.getJournalMetadata().setExtendDueDate(vo.getExtendDueDate());
		journal.getJournalMetadata().setJournalDOI(vo.getJournalDOI());
		journal.getJournalMetadata().setJournalEissn(vo.getJournalEissn());
		journal.getJournalMetadata().setJournalFrequency(vo.getJournalFrequency());
		journal.getJournalMetadata().setJournalId(vo.getJournalId());
		journal.getJournalMetadata().setJournalIssn(vo.getJournalIssn());
		journal.getJournalMetadata().setJournalIndexCopernicus(vo.getJournalIndexCopernicus());
		journal.getJournalMetadata().setJournalReadership(vo.getJournalReadership());
		journal.getJournalMetadata().setJournalSpeciality(vo.getJournalSpeciality());
		journal.getJournalMetadata().setJournalSubCategory(vo.getJournalSubCategory());
		journal.getJournalMetadata().setMetadataId(vo.getMetadataId());
		journal.getJournalMetadata().setOpenAccess(vo.getOpenAccess());
		journal.getJournalMetadata().setSuggestReviewer(vo.getSuggestReviewer());
		journal.getJournalMetadata().setTblcost(vo.getTblcost());
		journal.getJournalMetadata().setTypseStting(vo.getTypseStting());
		journal.getJournalMetadata().setUpdatedBy(vo.getUpdatedBy());

		return journal;
	}

	public static List<Journal> mapJournalVOToJOurnalModel(List<JournalVO> journalVOList) {

		List<Journal> list = new ArrayList<Journal>();
		for (JournalVO vo : journalVOList) {
			list.add(mapJournalVOToJournalModel(vo));
		}
		return list;
	}

	public static List<JournalVO> mapJournalModelToVO(List<Journal> journalList) {
		List<JournalVO> journalVoList = new ArrayList<JournalVO>();
		for (Journal journal : journalList) {
			journalVoList.add(mapJournalModelToJournalVo(journal));
		}
		return journalVoList;
	}

}
