package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.SubjectVO;
import com.digi.uniprr.model.Subject;

public interface SubjectService {

	void createSubject(SubjectVO subjectVO);

	List<Subject> getSubjectList();

	void deleteSubject(IDVO id);

	void updateSubject(Subject subject);

}
