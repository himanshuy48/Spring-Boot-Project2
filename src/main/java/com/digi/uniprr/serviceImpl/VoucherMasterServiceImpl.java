package com.digi.uniprr.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.model.VoucherMaster;
import com.digi.uniprr.repository.VoucherMasterRepo;
import com.digi.uniprr.service.VoucherMasterService;

@Service
@Transactional
public class VoucherMasterServiceImpl implements VoucherMasterService {

	@Autowired
	VoucherMasterRepo voucherMasterRepo;

	@Override
	public void createVoucher(VoucherMaster voucherMaster) {
		voucherMasterRepo.save(voucherMaster);
	}

	@Override
	public List<VoucherMaster> getVoucherList() {
		return voucherMasterRepo.findAll();
	}

	@Override
	public List<VoucherMaster> getVoucherListById(VoucherMaster voucherMaster) {
		return voucherMasterRepo.getVoucherListById(voucherMaster.getVoucherCode());
	}

	@Override
	public void updateVoucher(VoucherMaster voucherMaster) {
		voucherMasterRepo.save(voucherMaster);
	}

	@Override
	public boolean isExist(Integer voucherCode) {
		boolean result = false;
		try {
		if(voucherMasterRepo.getVoucherCode(voucherCode)!=null) 
			return true;
		}catch(Exception e) {
			return result;
		}
		return result;
	}

	@Override
	public boolean isExistById(Integer id) {
		return voucherMasterRepo.existsById(id);
	}

}
