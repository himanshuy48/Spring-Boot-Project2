package com.digi.uniprr.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.model.VoucherMaster;
import com.digi.uniprr.service.VoucherMasterService;

@RestController
@RequestMapping("/voucherMaster")
public class VoucherMasterRestController {

	@Autowired
	VoucherMasterService voucherMasterService;

	JSONObject obj = new JSONObject();

	@PostMapping("create")
	public ResponseEntity<?> createVoucher(@RequestBody VoucherMaster voucherMaster) {
		if (voucherMasterService.isExistById(voucherMaster.getId())) {
			obj.put("data", "Already Exist");
			return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
		}
		voucherMasterService.createVoucher(voucherMaster);
		obj.put("data", "Created successfully");
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@GetMapping("list")
	public ResponseEntity<?> listVoucher() {
		List<VoucherMaster> voucherList = voucherMasterService.getVoucherList();
		obj.put("data", voucherList);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("listById")
	public ResponseEntity<?> listVoucherById(@RequestBody VoucherMaster voucherMaster) {
		List<VoucherMaster> voucherList = voucherMasterService.getVoucherListById(voucherMaster);
		obj.put("data", voucherList);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("update")
	public ResponseEntity<?> updateVoucher(@RequestBody VoucherMaster voucherMaster) {
		if (voucherMasterService.isExist(voucherMaster.getVoucherCode())) {
			voucherMasterService.updateVoucher(voucherMaster);
			obj.put("data", "Updated Successfully");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
		obj.put("data", "Does not exist");
		return new ResponseEntity<>(obj, HttpStatus.CONFLICT);
	}

}
