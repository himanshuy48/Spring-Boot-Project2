package com.digi.uniprr.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.CommonVO;
import com.digi.uniprr.VO.IDVO;
import com.digi.uniprr.VO.SpecializationVO;
import com.digi.uniprr.model.Specialization;
import com.digi.uniprr.service.SpecializationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/specialization")
public class SpecializationController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SpecializationService specializationService;

	/*
	 * @RequestMapping(value = "/list", method = RequestMethod.GET) public
	 * ResponseEntity<?> specilizationList() { log.info("Inside specilizationList");
	 * JSONObject obj = new JSONObject(); List<SpecializationVO> specilizationList
	 * =specializationService.getList(); obj.put("data", specilizationList); return
	 * new ResponseEntity<>(obj, HttpStatus.OK); }
	 */

	@PostMapping("createSpecilization")
	public ResponseEntity<?> createSpecilization(@RequestBody List<Specialization> specialization) {
		log.info("Inside specilizationList");
		JSONObject obj = new JSONObject();
		try {
			specializationService.createSpecilization(specialization);
			obj.put("data", "Created...");
		} catch (Exception e) {
			obj.put("data", "Something Went Wrong");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	/*
	 * @PostMapping("updateSpecilization") public ResponseEntity<?>
	 * updateSpecilization(@RequestBody Specialization specialization) {
	 * log.info("Inside specilizationList"); JSONObject obj = new JSONObject(); try
	 * { Specialization specializationData =
	 * specializationService.updateSpecilization(specialization);
	 * obj.put("data","Updated..."); }catch(Exception e) { obj.put("data",
	 * "Something Went Wrong"); } return new ResponseEntity<>(obj, HttpStatus.OK); }
	 */

	@PostMapping("deleteSpecilization")
	public ResponseEntity<?> deleteSpecilization(@RequestBody IDVO id) {
		log.info("Inside specilizationList");
		JSONObject obj = new JSONObject();
		try {
			specializationService.deleteSpecilization(id);
			obj.put("data", "Deleted...");
		} catch (Exception e) {
			System.out.println(e);
			obj.put("data", "Something Went Wrong");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("listById")
	public List<Specialization> getManuScriptListById(@RequestBody CommonVO id) {
		List<Specialization> specializationList = specializationService.getspecializationListById(id.getRoleId());
		return specializationList;
	}

	/*
	 * @PostMapping("getSpecializationByID") public ResponseEntity<?>
	 * getSpecializationByID(@RequestBody SpecializationVO specializationVO) {
	 * JSONObject obj = new JSONObject(); List<Specialization> data =
	 * specializationService.getSpecializationByID(specializationVO); if (data !=
	 * null && !data.isEmpty()) { obj.put("data", data); return new
	 * ResponseEntity<>(obj, HttpStatus.OK); } return new
	 * ResponseEntity<>("data not found", HttpStatus.OK); }
	 */

	@RequestMapping(value = "/searchjournal", method = RequestMethod.POST)
	public ResponseEntity<?> searchReviewer(@RequestBody SpecializationVO specializationVO) {
		List<SpecializationVO> reviewerList = specializationService.querysearchjournal(specializationVO);
		return new ResponseEntity<>(reviewerList, HttpStatus.OK);
	}

	/*
	 * @GetMapping("getExpertiseList") public ResponseEntity<?> getExpertise() {
	 * log.info("Inside getExpertise"); List<Expertise>
	 * expertise=specializationService.getExpertise(); return new
	 * ResponseEntity<>(expertise,HttpStatus.OK); }
	 */

}
