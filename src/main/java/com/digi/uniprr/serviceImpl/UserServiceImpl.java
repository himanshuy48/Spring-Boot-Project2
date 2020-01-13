package com.digi.uniprr.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ExpertiseVO;
import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.VO.ReviewerFilterVO;
import com.digi.uniprr.VO.ReviewerVO;
import com.digi.uniprr.VO.UserVO;
import com.digi.uniprr.controller.dao.UserDao;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.ManuScriptReviewer;
import com.digi.uniprr.model.ManuscriptEditor;
import com.digi.uniprr.model.ReviewerAvailability;
import com.digi.uniprr.model.User;
import com.digi.uniprr.model.UserGroup;
import com.digi.uniprr.model.UserJournal;
import com.digi.uniprr.model.UserRole;
import com.digi.uniprr.model.UserSpecilization;
import com.digi.uniprr.repository.ManuScriptRepo;
import com.digi.uniprr.repository.ManuScriptReviewerRepo;
import com.digi.uniprr.repository.ManuscriptEditorRepo;
import com.digi.uniprr.repository.ReviewerAvailabilityRepo;
import com.digi.uniprr.repository.RoleRepo;
import com.digi.uniprr.repository.UserGroupRepo;
import com.digi.uniprr.repository.UserJournalRepo;
import com.digi.uniprr.repository.UserLoginRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.repository.UserRoleRepo;
import com.digi.uniprr.repository.UserSpecilizationRepo;
import com.digi.uniprr.service.ManuScriptReviewerService;
import com.digi.uniprr.service.ManuScriptService;
import com.digi.uniprr.service.ManuscriptEditorService;
import com.digi.uniprr.service.UserService;
import com.digi.uniprr.utils.GroupTransformationalUtils;
import com.digi.uniprr.utils.JournalListTransformationUtils;
import com.digi.uniprr.utils.RoleTransformationalUtils;
import com.digi.uniprr.utils.SendMailUtils;
import com.digi.uniprr.utils.UserTransformationalUtils;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Autowired
	Environment env;

	@Autowired
	SendMailUtils mailUtils;

	@Autowired
	UserRoleRepo userRoleRepo;

	@Autowired
	UserGroupRepo userGroupRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	ManuScriptRepo manuscriptRepo;

	@Autowired
	ManuScriptReviewerService manuscriptReviewerService;

	@Autowired
	ManuscriptEditorService manuscriptEditorService;

	@Autowired
	ManuScriptService manuscriptService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	ManuscriptEditorRepo manuscriptEditorRepo;

	@Autowired
	ManuScriptReviewerRepo manuScriptReviewerRepo;

	@Autowired
	UserJournalRepo userJournalRepo;
	
	@Autowired
	UserSpecilizationRepo userSpecilizationRepo;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ReviewerAvailabilityRepo reviewerAvailabilityRepo;

	@Override
	public void addUser(User user) {
		userLoginRepo.save(user);
	}

	@Override
	public Iterable<User> getUserDetail(User user) {
		Iterable<User> userList = userLoginRepo.findAll();
		return userList;
	}

	@Override
	public void updateUser(UserVO userVO) {
		User userData = userLoginRepo.getOne(userVO.getId());
		
		userData.setSalutation(userVO.getSalutation());
		userData.setFirstName(userVO.getFirstName());
		userData.setMiddleName(userVO.getMiddleName());
		userData.setLastName(userVO.getLastName());
		userData.setUsername(userVO.getUsername());
		userData.setInstitute(userVO.getInstitute());
		userData.setMobileNumber(userVO.getMobileNumber());
		userData.setOrcidId(userVO.getOrcidId());
		userData.setAddress(userVO.getAddress());
		userData.setCity(userVO.getCity());
		userData.setCountryId(userVO.getCountryId());
		userData.setState(userVO.getState());
		userData.setPostalCode(userVO.getPostalCode());
		        
		if (userVO.getPassword() != null && !userVO.getPassword().isEmpty() &&
				userVO.getPassword().length() > 0 ) 
			userData.setPassword(passwordEncoder.encode(userVO.getPassword()));
		
		userLoginRepo.save(userData);
		
		userRoleRepo.deleteUserRole(userVO.getId());
		
		for (Integer roleId : userVO.getRoleId()) {
			UserRole userRole = new UserRole();
			userRole.setUser(userVO.getId());
			userRole.setRole(roleId);
			userRoleRepo.save(userRole);
		}
		
		userJournalRepo.deleteUserJournal(userVO.getId());
		
		for (Integer journalId : userVO.getJournalId()) {
			UserJournal userJournal = new UserJournal();
			userJournal.setUserId(userVO.getId());
			userJournal.setJournalId(journalId);
			userJournalRepo.save(userJournal);
		}
		
	}

	@Override
	public User getByUsername(String username) {
		return userLoginRepo.findByusername(username);
	}

	@Override
	public List<User> getGroupByUserId(Integer id) {
		List<User> list = userLoginRepo.getGroupByUserId(id);
		return list;
	}

	@Override
	public boolean isUserExist(User user) {
		return getByUsername(user.getUsername()) != null;
	}

	@Override
	public User createUser(UserVO userVo) {
		boolean isEmail = false;
		User user = UserTransformationalUtils.mapVOToModel(userVo);
		if(user.getPassword() == null) {
			String token = UUID.randomUUID().toString();
			user.setPassword(null);
			user.setToken(token);
			isEmail = true;
		}else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		
		user.setIsActive(1);
		user.setUsername(userVo.getEmail());
		User savedUser = userLoginRepo.save(user);
		if (savedUser != null) {
			if (userVo.getRoleId() != null) {
				for (Integer roleId : userVo.getRoleId()) {
					UserRole userRole = new UserRole();
					userRole.setUser(savedUser.getId());
					userRole.setRole(roleId);
					userRoleRepo.save(userRole);
				}
			}

			if (userVo.getGroupId() != null) {
				for (Integer groupId : userVo.getGroupId()) {
					UserGroup userGroup = new UserGroup();
					userGroup.setUserId(savedUser.getId());
					userGroup.setGroupId(groupId);
					userGroupRepo.save(userGroup);
				}
			}
			if (userVo.getJournalId() != null) {
				for (Integer journalId : userVo.getJournalId()) {
					UserJournal userJournals = new UserJournal();
					userJournals.setJournalId(journalId);
					userJournals.setUserId(savedUser.getId());
					userJournalRepo.save(userJournals);
				}
			}
			if(userVo.getExpertiseData()!=null && !userVo.getExpertiseData().isEmpty()) {
				for(ExpertiseVO userSpecilizationData : userVo.getExpertiseData()) {
					for(Integer specialization : userSpecilizationData.getSpecialization()) {
						UserSpecilization userSpecilization = new UserSpecilization();
						userSpecilization.setUserId(savedUser.getId());
						userSpecilization.setExpertiseId(userSpecilizationData.getId());
						userSpecilization.setSpecializationId(specialization);
						userSpecilization.setCreatedBy(savedUser.getId());
						userSpecilizationRepo.save(userSpecilization);
					}
				}
				
			}
		}
		if(isEmail) {
			sendMailForActivation(user.getEmail(), user.getToken());
		}
		return savedUser;
	}

	@Override
	public List<UserVO> getUserDetails() {
		List<User> userList = userLoginRepo.findAllIsActiveUser();
		List<UserVO> userVoList = UserTransformationalUtils.mapUserListToUserVOList(userList);
		return userVoList;
	}

	@Override
	public List<User> getUserListById(Integer id) {

		return userLoginRepo.getListById(id);
	}

	@Override
	public String deleteUserById(Integer id) {
		userLoginRepo.deleteUser(id);
		return "deleted successfully";
	}

	@Override
	public User getByEmail(String email) {
		return userLoginRepo.findByEmail(email);
	}

	@Override
	public User getById(Integer id) {
		return userLoginRepo.getOne(id);
	}
	
	@Override
	public UserVO getUserById(Integer id) {
		User user = userLoginRepo.getOne(id);
		UserVO vo = UserTransformationalUtils.mapUserModelToUserVO(user);
		return vo;
	}

	@Override
	public UserVO getUserByEmailAndPassword(String email) {
		User rowData = userLoginRepo.findByEmail(email);
		UserVO userVO = new UserVO();
		if (rowData != null) {
			userVO.setId(rowData.getId());
			userVO.setOrcidId(rowData.getOrcidId());
			userVO.setUsername(rowData.getUsername());
			userVO.setPassword(rowData.getPassword());
			userVO.setEmail(rowData.getEmail());
			userVO.setEmailCC(rowData.getEmailCC());
			userVO.setSecondaryEmail(rowData.getSecondaryEmail());
			userVO.setSecondaryEmailCC(rowData.getSecondaryEmailCC());
			userVO.setSalutation(rowData.getSalutation());
			userVO.setFirstName(rowData.getFirstName());
			userVO.setMiddleName(rowData.getMiddleName());
			userVO.setLastName(rowData.getLastName());
			userVO.setUserType(rowData.getUserType());
			userVO.setInstitute(rowData.getInstitute());
			userVO.setState(rowData.getState());
			userVO.setAddress(rowData.getAddress());
			userVO.setAddressTwo(rowData.getAddressTwo());
			userVO.setAddressThree(rowData.getAddressThree());
			userVO.setDepartment(rowData.getDepartment());
			userVO.setMobileNumber(rowData.getMiddleName());
			userVO.setPhoneNumber(rowData.getPhoneNumber());
			userVO.setFaxNumber(rowData.getFaxNumber());
			userVO.setIsActive(rowData.getIsActive());
			userVO.setCountryId(rowData.getCountryId());
			userVO.setCity(rowData.getCity());
			userVO.setPostalCode(rowData.getPostalCode());
			userVO.setAreaOfInterest(rowData.getAreaOfInterest());
			userVO.setNotificationFlag(rowData.getNotificationFlag());
			userVO.setPublicationName(rowData.getPublicationName());
			userVO.setAccountExpired(rowData.getAccountExpired());
			userVO.setAccountLocked(rowData.getAccountLocked());
			userVO.setDesignation(rowData.getDesignation());
			userVO.setSpecialization(rowData.getSpecialization());
			userVO.setExperience(rowData.getExperience());
			userVO.setExpertise(rowData.getExpertise());
			userVO.setEmailNotification(rowData.getEmailNotification());
			userVO.setSmsNotification(rowData.getSmsNotification());
			userVO.setRole(RoleTransformationalUtils.mapRoleListToVOList(rowData.getRole()));
			userVO.setGroup(GroupTransformationalUtils.mapGroupListToGroupVOList(rowData.getGroup()));
			userVO.setJournalVO(JournalListTransformationUtils.mapModelListToVoList(rowData.getJournal()));
		}

		return userVO;
	}

	@Override
	public List<UserVO> getUserListByRoleId(List<Integer> roleId) {
		List<User> users = userRepo.getUserListByRoleId(roleId);
		List<UserVO> voList = UserTransformationalUtils.mapUserListToUserVOList(users);
		return voList;
	}

	@Override
	public void assignUser(ManuscriptListVO manuscriptListVO) {
		if (manuscriptListVO.getRoleId() == 5) {
			for(Integer assignToId : manuscriptListVO.getAssignToID()) {
				ManuScriptReviewer manuscriptReviewer = manuScriptReviewerRepo.findManuscriptReviewerDetails(
						manuscriptListVO.getManuScriptId(), manuscriptListVO.getManuscriptVersion(),
						manuscriptListVO.getJournalId(), assignToId);

				if (manuscriptReviewer != null) {
					UserJournal userJournal = userJournalRepo.getUserJournalByJournal(assignToId , manuscriptListVO.getJournalId());
					if(userJournal == null) {
						UserJournal userJournalData = new UserJournal();
						userJournalData.setJournalId(manuscriptListVO.getJournalId());
						userJournalData.setUserId(assignToId);
						userJournalData.setUpdatedBy(manuscriptListVO.getUserId().toString());
						userJournalRepo.save(userJournalData);
					}
					manuScriptReviewerRepo.updateReviewerDetails(manuscriptListVO.getManuStatusId(),
							manuscriptReviewer.getId());
				} else {
					ManuScriptReviewer manuscriptReviewerData = new ManuScriptReviewer();
					manuscriptReviewerData.setManuscriptId(manuscriptListVO.getManuScriptId());
					manuscriptReviewerData.setManuscriptVersion(manuscriptListVO.getManuscriptVersion());
					manuscriptReviewerData.setReviewerId(assignToId);
					manuscriptReviewerData.setJournalId(manuscriptListVO.getJournalId());
					manuscriptReviewerData.setCommentsForReviewer(manuscriptListVO.getMessage());
					manuscriptReviewerData.setManuscriptStatus(manuscriptListVO.getManuStatusId());
					manuscriptReviewerData.setDueDate(manuscriptListVO.getDueDate());
					UserJournal userJournal = userJournalRepo.getUserJournalByJournal(assignToId , manuscriptListVO.getJournalId());
					if(userJournal == null) {
						UserJournal userJournalData = new UserJournal();
						userJournalData.setJournalId(manuscriptListVO.getJournalId());
						userJournalData.setUserId(assignToId);
						userJournalData.setUpdatedBy(manuscriptListVO.getUserId().toString());
						userJournalRepo.save(userJournalData);
					}
					manuscriptReviewerService.saveManuScriptReviewerDetails(manuscriptReviewerData);
				}
				if (manuscriptListVO.getManuStatusId() == 8) {
					manuscriptRepo.updateStage(manuscriptListVO.getManuStatusId(), manuscriptListVO.getManuScriptId());
				}
			}
			

		} else if (manuscriptListVO.getRoleId() == 3) {
			ManuscriptEditor manuscriptEditor = manuscriptEditorRepo.findManuscriptEditorDetails(
					manuscriptListVO.getManuScriptId(), manuscriptListVO.getManuscriptVersion(),
					manuscriptListVO.getJournalId(), manuscriptListVO.getAssignToId());

			if (manuscriptEditor != null) {
				manuscriptEditorRepo.updateEditorDetails(manuscriptListVO.getManuStatusId(), manuscriptEditor.getId());
			} else {
				ManuscriptEditor manuscriptEditorData = new ManuscriptEditor();
				manuscriptEditorData.setManuscriptId(manuscriptListVO.getManuScriptId());
				manuscriptEditorData.setManuscriptVersion(manuscriptListVO.getManuscriptVersion());
				manuscriptEditorData.setEditorId(manuscriptListVO.getUserId());
				manuscriptEditorData.setJournalId(manuscriptListVO.getJournalId());
				manuscriptEditorData.setCommentsForEditor(manuscriptListVO.getMessage());
				manuscriptEditorData.setManuscriptStatus(manuscriptListVO.getManuStatusId());
				manuscriptEditorRepo.save(manuscriptEditorData);
			}
			if (manuscriptListVO.getManuStatusId() == 3) {
				manuscriptRepo.updateStage(manuscriptListVO.getManuStatusId(), manuscriptListVO.getManuScriptId());
			}
		} else {
			ManuScript manuscriptData = new ManuScript();
			manuscriptData.setManuScriptId(manuscriptListVO.getManuScriptId());
			manuscriptData.setJournalId(manuscriptListVO.getJournalId());
			manuscriptService.saveManuscriptDetails(manuscriptData);
		}

	}
	
	public String sendMailForActivation(String userEmail, String token) {

		userRepo.updateTokenByUser(userEmail, token);

		String fromMailID = env.getProperty("spring.mail.username");
		String toMailID = userEmail;
		String mailSubject = "Activate your account";
		String mailBody = activateUserMailTemplate(userEmail, token);

		mailUtils.sendEmail(fromMailID, toMailID, mailSubject, mailBody);

		String message = "Password reset URL send on mail successfully.";

		return message;
	}

	private String activateUserMailTemplate(String email, String token) {

		StringBuilder builder = new StringBuilder();
		String resetUrl = "http://172.16.1.209:4200/signup/userverfication";
		String resetPasswordURL = resetUrl + "?token=" + token + "&email=" + email;
		builder.append("Dear User,");
		builder.append("Please activate your account " + resetPasswordURL);
		builder.append(" ");
		builder.append("THANK YOU !!");
		return builder.toString();
	}

	@Override
	public void activateLockedUser(UserVO userVO) {
		userRepo.updateUserPassword(userVO.getPassword(), userVO.getToken());
	}
	
	@Override
	public List<ReviewerVO> reviewerFilter(ReviewerFilterVO vo) {
		StringBuilder query = new StringBuilder("SELECT u FROM User u WHERE id IN (SELECT user FROM UserRole WHERE role =5) AND ");
		int countConditions = 0;
		
		Boolean journalBoolean = vo.getJournalId() != null && !vo.getJournalId().isEmpty();
		Boolean expertiseBoolean = vo.getExpertiseId() != null && !vo.getExpertiseId().isEmpty();
		Boolean specializationBoolean = vo.getSpecializationId() != null && !vo.getSpecializationId().isEmpty();
		Boolean institutionBoolean = vo.getInstitutionId() != null && !vo.getInstitutionId().isEmpty();
		Boolean nameBoolean = vo.getName() != null && !vo.getName().isEmpty();
		
		if (vo.getJournalId() != null && !vo.getJournalId().isEmpty()) {
			query.append("(id IN (SELECT userId FROM UserJournal WHERE journalId IN :journalList) ");
			countConditions++;
		}
			
		if (vo.getExpertiseId() != null && !vo.getExpertiseId().isEmpty()) {
			if (countConditions > 0) 
				query.append("OR ");
			else 
				query.append("( ");
			query.append("id IN (SELECT userId FROM UserSpecilization WHERE expertiseId IN :expertiseList) ");
			countConditions++;
		}
		
		if (vo.getSpecializationId() != null && !vo.getSpecializationId().isEmpty()) {
			if (countConditions > 0) 
				query.append("OR ");
			else
				query.append("( ");
			query.append("id IN (SELECT userId FROM UserSpecilization WHERE specializationId IN :specializationList) ");
			countConditions++;
		}
		
		if (vo.getInstitutionId() != null && !vo.getInstitutionId().isEmpty()) {
			if (countConditions > 0) 
				query.append("OR ");
			query.append("institute IN :instituteList ");
			countConditions++;
		}
		
		if (vo.getName() != null && !vo.getName().isEmpty()) {
			if (countConditions > 0) 
				query.append("OR ");
			query.append("CONCAT(COALESCE(first_name,''), COALESCE(middle_name,''), COALESCE(last_name,'')) LIKE :name");
			countConditions++;
		}
		
		if (!(!(journalBoolean || expertiseBoolean || specializationBoolean) && (institutionBoolean || nameBoolean))) 
			query.append(")");
		
		List<User> list = userDao.reviewerFilterImplementation(query.toString(), vo);
		
		List<ReviewerVO> reviewerVoList = new ArrayList<ReviewerVO>();
		
		for (User user : list) {
			ReviewerVO reviewerVO = new ReviewerVO();
			reviewerVO.setId(user.getId());
			reviewerVO.setFirstname(user.getFirstName());
			reviewerVO.setMiddlename(user.getFirstName());
			reviewerVO.setLastname(user.getLastName());
			reviewerVO.setEmail(user.getEmail());
			reviewerVO.setCity(user.getCity());
			reviewerVO.setState(user.getState());
			List<ReviewerAvailability> availibilityList = reviewerAvailabilityRepo.getReviewerAvailabilityById(user.getId());
			reviewerVO.setReviewerAvailability(availibilityList);
			reviewerVoList.add(reviewerVO);
		}
		
		return reviewerVoList;
	}

	

}
