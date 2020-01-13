package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.model.StatusMaster;

public interface StatusMasterService {

	List<StatusMaster> getStatusMasterDetails();

	List<StatusMaster> getListByStatusValue(String statusValue);

	List<StatusMaster> getStatusMasterDetailsById(Integer manuscriptStatus);

}