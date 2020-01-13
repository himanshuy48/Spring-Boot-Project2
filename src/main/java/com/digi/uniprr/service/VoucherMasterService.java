package com.digi.uniprr.service;

import java.util.List;

import com.digi.uniprr.model.VoucherMaster;

public interface VoucherMasterService {

	public void createVoucher(VoucherMaster voucherMaster);

	public List<VoucherMaster> getVoucherList();

	public List<VoucherMaster> getVoucherListById(VoucherMaster voucherMaster);

	public void updateVoucher(VoucherMaster voucherMaster);

	public boolean isExist(Integer voucherCode);

	public boolean isExistById(Integer id);

}
