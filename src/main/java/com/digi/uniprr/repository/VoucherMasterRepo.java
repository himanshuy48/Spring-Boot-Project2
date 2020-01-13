package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.VoucherMaster;

public interface VoucherMasterRepo extends JpaRepository<VoucherMaster, Integer> {

	@Query("SELECT v FROM VoucherMaster v WHERE v.voucherCode=:voucherCode")
	List<VoucherMaster> getVoucherListById(Integer voucherCode);

	@Query("SELECT v FROM VoucherMaster v WHERE v.voucherCode=:voucherCode")
	Object getVoucherCode(Integer voucherCode);

}
