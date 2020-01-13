package com.digi.uniprr.serviceImpl;

import static com.digi.uniprr.utils.AppConstants.Avg_Syllables_Count;
import static com.digi.uniprr.utils.AppConstants.Avg_Word_Length;
import static com.digi.uniprr.utils.AppConstants.Difficult_Words_Ratio;
import static com.digi.uniprr.utils.AppConstants.Flesch_Kincaid_Grade;
import static com.digi.uniprr.utils.AppConstants.Flesch_Reading_Ease;
import static com.digi.uniprr.utils.AppConstants.Gunning_Fog_Index;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_ABSTRACT;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_ACKNOWLEDGMENT;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_BLACK_WHITE_FIGURES;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_COLOR_FIGURES;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_FIGURES;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_INTRODUCTION;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_PAGES;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_PARAGRAPH;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_REFERENCES;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_RUNNING_HEAD;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_SHORT_TITLE;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_TABLES;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_TITLE;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_TYPE;
import static com.digi.uniprr.utils.AppConstants.MANUSCRIPT_WORDS;
import static com.digi.uniprr.utils.AppConstants.POS_Ratio;
import static com.digi.uniprr.utils.AppConstants.Sentence_Length;
import static com.digi.uniprr.utils.AppConstants.Sentence_No;
import static com.digi.uniprr.utils.AppConstants.Type_To_Token_Ratio;
import static com.digi.uniprr.utils.AppConstants.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zeroturnaround.zip.ZipUtil;

import com.digi.uniprr.VO.FunderDetailsVO;
import com.digi.uniprr.VO.ManuscriptFileVO;
import com.digi.uniprr.VO.ResubmissionManuscriptFileVo;
import com.digi.uniprr.controller.ManuscriptFunder;
import com.digi.uniprr.model.FunderDetails;
import com.digi.uniprr.model.Keywords;
import com.digi.uniprr.model.ManscriptScore;
import com.digi.uniprr.model.ManuScript;
import com.digi.uniprr.model.ManuScriptFile;
import com.digi.uniprr.model.ManuscriptTypeDetails;
import com.digi.uniprr.repository.FunderDetailsRepo;
import com.digi.uniprr.repository.KeywordsRepo;
import com.digi.uniprr.repository.ManscriptScoreRepo;
import com.digi.uniprr.repository.ManuScriptFileRepo;
import com.digi.uniprr.repository.ManuScriptRepo;
import com.digi.uniprr.repository.ManuscriptFunderRepo;
import com.digi.uniprr.repository.ManuscriptTypeDetailsRepo;
import com.digi.uniprr.service.ManuScriptFileService;

import javassist.compiler.ast.Keyword;

@Service
@Transactional
public class ManuScriptFileServiceImpl implements ManuScriptFileService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ManuScriptRepo manuscriptRepo;

	@Autowired
	ManuScriptFileRepo manuScriptFileRepo;

	@Autowired
	ManuscriptTypeDetailsRepo manuscriptTypeDetailsRepo;

	@Autowired
	Environment environment;

	@Autowired
	ManscriptScoreRepo manscriptScoreRepo;

	@Autowired
	FunderDetailsRepo funderDetailsRepo;

	@Autowired
	ManuscriptFunderRepo manuscriptFunderRepo;
	
	@Autowired
	KeywordsRepo Keywordsrepo;

	@Override
	public String createManuScriptFile(ManuScriptFile manuScriptFile) {
		manuScriptFileRepo.save(manuScriptFile);
		return "Created successfully";
	}

	@Override
	public List<ManuScriptFile> getManuScriptFileDetails() {

		return manuScriptFileRepo.findAll();
	}

	@Override
	public String updateManuScriptFileDetails(ManuScriptFile manuScriptFile) {
		manuScriptFileRepo.save(manuScriptFile);
		return "Updated successfully";
	}

	@Override
	public String deleteManuScriptFileById(Integer id) {
		manuScriptFileRepo.deleteById(id);
		return "deleted successfully";
	}

	@Override
	public boolean isIdExist(Integer id) {

		return manuScriptFileRepo.existsById(id);
	}

	@Override
	public List<ManuScriptFile> getFileDetailsById(ManuScriptFile manuScriptFile) {
		return manuScriptFileRepo.getFileDetailsById(manuScriptFile.getManuscriptFileId());
	}

	@Override
	public ManuScriptFile saveFile(ManuScriptFile manuScriptFile) {
		log.info("saveFile Impl");
		return manuScriptFileRepo.save(manuScriptFile);

	}

	@Override
	public ManuScriptFile getListByManuscriptId(Integer id) {

		return manuScriptFileRepo.getById(id);
	}

	@Override
	public ManuScriptFile getManuScriptFile(ManuScriptFile manuscriptFile) {

		return manuScriptFileRepo.getManuscriptFileDetilsById(manuscriptFile.getManuscriptFileId(),
				manuscriptFile.getFileName());
	}

	@Override
	public List<ManuscriptFileVO> getManuscriptByactive(Integer manuscriptId, Integer manuscriptVersion) {
		log.info("Inside getManuscriptByactive Impl");
		List<ManuScriptFile> manu = manuScriptFileRepo.getManuscriptByactive(manuscriptId, manuscriptVersion, 1);
		List<ManuscriptFileVO> listVo = new ArrayList<ManuscriptFileVO>();
		if (manu != null && !manu.isEmpty()) {
			manu.stream().forEach(i -> {
				if (i.getFileType() != MERGED_FILE) {
					ManuscriptFileVO file = new ManuscriptFileVO();
					file.setManuscriptFileId(i.getManuscriptFileId());
					file.setManuScriptId(i.getManuScriptId());
					file.setFileType(i.getFileType());
					file.setFileName(i.getFileName());
					file.setFileOrder(i.getFileOrder());
					file.setFilePath(i.getFilePath());
					file.setContentType(i.getContentType());
					file.setFileSize(i.getFileSize());
					file.setFileVersion(i.getFileVersion());
					file.setLegend(i.getLegend());
					file.setManuscriptVersion(manuscriptVersion);
					file.setCreatedBy(i.getCreatedBy());
					file.setCreatedOn(i.getCreatedOn());
					file.setUpdatedBy(i.getUpdatedBy());
					file.setUpdatedOn(i.getUpdatedOn());
					listVo.add(file);
				}
			});
			return listVo;
		} else {
			return null;
		}

	}

	@Override
	public String deleteManuscriptFile(Integer manuscriptFileId) {
		log.info("deleteManuscriptFile Impl");
		ManuScriptFile fileDetails = manuScriptFileRepo.downloadFileByManuScriptFileID(manuscriptFileId);
		String fileName = fileDetails.getFileName();
		String filePath = fileDetails.getFilePath();
		String finalPath = filePath.replace(environment.getProperty("file.upload-dirServer") + "//",
				environment.getProperty("file.zipMaking-dir"));
		try {
			FileUtils.forceDelete(new File(finalPath));
			log.info("File Deleted");
		} catch (IOException e) {
			log.info("Error");
		}
		manuScriptFileRepo.deleteById(manuscriptFileId);
		return "File Deleted";
	}

	@Override
	public String downloadFileByManuScriptFileID(Integer manuscriptFileId) {
		log.info("Inside downloadFileByManuScriptFileID Impl");
		ManuScriptFile filePath = manuScriptFileRepo.downloadFileByManuScriptFileID(manuscriptFileId);
		return filePath.getFilePath();
	}

	@Override
	public String updateManuscriptFileUpload(ResubmissionManuscriptFileVo resubmissionManuscriptFileVo,
			HttpServletRequest request) {
		log.info("Inside updateManuscriptFileUpload Impl");
		try {
			// Update In Manuscript File
			resubmissionManuscriptFileVo.getManuscriptFileVO().stream().forEach(i -> {
				manuScriptFileRepo.submitManuscript(i.getManuscriptFileId(), i.getFileType(), i.getLegend(),
						resubmissionManuscriptFileVo.getManuscriptVersion());
			});
			// Get Manuscript Data
			ManuScript manu = manuscriptRepo.getOne(resubmissionManuscriptFileVo.getManuScriptId());

			// Server Setup
			String filezipMakingdir = System.getProperty("catalina.base") + File.separator + "webapps"
					+ File.separator;
			String fileuploaddirServer = "http://" + InetAddress.getLocalHost().getHostAddress() + ":"
					+ request.getServerPort();
			// Find CopyRightFile in Manuscript File Folder With the Provided Manuscript And
			// version
			ManuScriptFile copyRightFile = manuScriptFileRepo
					.getCopyRightFile(resubmissionManuscriptFileVo.getManuScriptId(), 1);
			if (copyRightFile != null) {
				String copyRightFilePath = copyRightFile.getFilePath();
				String drivePath = copyRightFilePath.replace(fileuploaddirServer, filezipMakingdir);
				String attachmentFolderPath = filezipMakingdir + "UniprrCopyRightFileFolder" + File.separator
						+ "MNT_LWW_JOURNAL_" + "R" + resubmissionManuscriptFileVo.getManuscriptVersion() + "_"
						+ manu.getJournalId() + "" + resubmissionManuscriptFileVo.getManuScriptId();
				File dir = new File(attachmentFolderPath);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				FileUtils.moveFileToDirectory(new File(drivePath), new File(attachmentFolderPath), true);
				String fileName = attachmentFolderPath.replace(filezipMakingdir, fileuploaddirServer + File.separator)
						+ copyRightFile.getFileName();
				copyRightFile.setFilePath(fileName);
				log.info("copyRightFile Save");
				manuScriptFileRepo.save(copyRightFile);
			}
			// Change the name of man document if the file name is different
			ManuScriptFile manusCriptDocument = manuScriptFileRepo
					.getManuScriptFile(resubmissionManuscriptFileVo.getManuScriptId(), 1);
			String serverfilePath = manusCriptDocument.getFilePath();
			String driveFilePath = serverfilePath.replace(fileuploaddirServer, filezipMakingdir);
			if (manusCriptDocument != null) {
				String[] array = driveFilePath.split("\\.");
				int len = array.length;
				String extension = array[len - 1];
				if (extension.equalsIgnoreCase("doc")) {
					File rename = new File(driveFilePath);
					File name = new File(rename.getParent() + File.separator + "Manuscript.doc");
					if (rename.renameTo(name)) {
						manusCriptDocument.setFileName("Manuscript.doc");
						String dataTemp[] = serverfilePath.split("\\\\");
						int length = dataTemp.length;
						String dummy = dataTemp[length - 1].toString();
						serverfilePath = serverfilePath.replace(dummy, "Manuscript.doc");
						manusCriptDocument.setFilePath(serverfilePath);
						log.info("Document Name Changed As a Manuscript.doc");
						manuScriptFileRepo.save(manusCriptDocument);
					}
				} else {
					File rename = new File(driveFilePath);
					File name = new File(rename.getParent() + File.separator + "Manuscript.docx");
					if (rename.renameTo(name)) {
						manusCriptDocument.setFileName("Manuscript.docx");
						String dataTemp[] = serverfilePath.split("\\\\");
						int length = dataTemp.length;
						String dummy = dataTemp[length - 1].toString();
						serverfilePath = serverfilePath.replace(dummy, "Manuscript.docx");
						manusCriptDocument.setFilePath(serverfilePath);
						log.info("Document Name Changed As a Manuscript.docx");
						manuScriptFileRepo.save(manusCriptDocument);
					}
				}
			}
			log.info("Create XML File in That provided manuscript and version file folder");
			// Create XML File in That provided manuscript and version file folder
			ManuScriptFile mainDocument = manuScriptFileRepo
					.getManuScriptDocumentFile(resubmissionManuscriptFileVo.getManuScriptId(), 1);
			if (mainDocument != null) {
				String xmlFileContent = createXMLFormatFile(mainDocument,request.getServerPort());
				File orderXmlFile = new File(filezipMakingdir + "UniprrFileFolder" + File.separator + "MNT_LWW_JOURNAL_"
						+ "R" + resubmissionManuscriptFileVo.getManuscriptVersion() + "_" + manu.getJournalId() + "_"
						+ resubmissionManuscriptFileVo.getManuScriptId() + File.separator
						+ mainDocument.getManuScript().getJournalId() + "_"
						+ mainDocument.getManuScript().getManuScriptId() + ".xml");
				FileUtils.writeStringToFile(orderXmlFile, xmlFileContent);
			}
			log.info("Given Manucript File Folder Has Been Ziped");
			// Create Zip For That provided manuscript and version file folder
			ZipUtil.pack(
					new File(filezipMakingdir + File.separator + "UniprrFileFolder" + File.separator
							+ "MNT_LWW_JOURNAL_" + "R" + resubmissionManuscriptFileVo.getManuscriptVersion() + "_"
							+ manu.getJournalId() + "_" + resubmissionManuscriptFileVo.getManuScriptId()),
					new File(filezipMakingdir + File.separator + "UniprrFileFolder" + File.separator
							+ "MNT_LWW_JOURNAL_" + "R" + resubmissionManuscriptFileVo.getManuscriptVersion() + "_"
							+ manu.getJournalId() + "_" + resubmissionManuscriptFileVo.getManuScriptId() + ".zip"));
			String myPath = "MNT_LWW_JOURNAL_" + "R" + resubmissionManuscriptFileVo.getManuscriptVersion() + "_"
					+ manu.getJournalId() + "_" + resubmissionManuscriptFileVo.getManuScriptId();
			log.info("Dot Net Api Call");
			// Dot Net Api Call
			String url = environment.getProperty("dotNet.Url") + myPath;
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			// JSONObject obj=restTemplate.getForObject(url, JSONObject.class);
			// Response From Dot net Api
			if (result != null && !result.isEmpty()) {
				// if(obj !=null && !obj.isEmpty()) {
				log.info("Got Response from .net API");
				JSONParser jsonParser = new JSONParser();
				JSONObject obj = (JSONObject) jsonParser.parse(result);
				String manuscriptType = (String) obj.get(MANUSCRIPT_TYPE);
				String manuscriptTitle = (String) obj.get(MANUSCRIPT_TITLE);
				String manuscriptRunningHead = (String) obj.get(MANUSCRIPT_RUNNING_HEAD);
				String manuscriptAbstract = (String) obj.get(MANUSCRIPT_ABSTRACT);
				String manuscriptFigures = (String) obj.get(MANUSCRIPT_FIGURES);
				String manuscriptBlackWhiteFigures = (String) obj.get(MANUSCRIPT_BLACK_WHITE_FIGURES);
				String manuscriptColorFigures = (String) obj.get(MANUSCRIPT_COLOR_FIGURES);
				String manuscriptTables = (String) obj.get(MANUSCRIPT_TABLES);
				String manuscriptWords = (String) obj.get(MANUSCRIPT_WORDS);
				String manuscriptPages = (String) obj.get(MANUSCRIPT_PAGES);
				String manuscriptParagraph = (String) obj.get(MANUSCRIPT_PARAGRAPH);
				String manuscriptIntroduction = (String) obj.get(MANUSCRIPT_INTRODUCTION);
				String manuscriptAcknowledgment = (String) obj.get(MANUSCRIPT_ACKNOWLEDGMENT);
				String manuscriptReferences = (String) obj.get(MANUSCRIPT_REFERENCES);
				String manuscriptShortTitle = (String) obj.get(MANUSCRIPT_SHORT_TITLE);
				String filePathh = (String) obj.get(FILE_PATH);
				String finalDocfileSize = (String) obj.get(FINAL_DOC_FILE_SIZE);
				Double avgSyllablesCount = (Double) obj.get(Avg_Syllables_Count);
				Double avgWordLength = (Double) obj.get(Avg_Word_Length);
				Double difficultWordsRatio = (Double) obj.get(Difficult_Words_Ratio);
				Double fleschKincaidGrade = (Double) obj.get(Flesch_Kincaid_Grade);
				Double fleschReadingEase = (Double) obj.get(Flesch_Reading_Ease);
				Double gunningFogIndex = (Double) obj.get(Gunning_Fog_Index);
				Double posRatio = (Double) obj.get(POS_Ratio);
				Double sentenceLength = (Double) obj.get(Sentence_Length);
				Double sentenceNo = (Double) obj.get(Sentence_No);
				Double typeToTokenRatio = (Double) obj.get(Type_To_Token_Ratio);
				// String manuscriptKeywords = (String) obj.get(MANUSCRIPT_KEYWORDS);
				// String[] keyword=manuscriptKeywords.split(",");

				/*
				 * List<JSONObject> funderItems = (List<JSONObject>)
				 * obj.get(MANUSCRIPT_KEYWORDS);
				 * 
				 * for (JSONObject jsonObject : funderItems) { Keywords
				 * keyWordData=Keywordsrepo.getUniqueKeywordForManuscript(); }
				 */
				
				
				ManscriptScore manuscriptScore = manscriptScoreRepo
						.getManscriptScoreData(resubmissionManuscriptFileVo.getManuScriptId());
				// Update in manuscriptScore Table
				if (manuscriptScore != null) {
					manuscriptScore.setManuscriptVersion(resubmissionManuscriptFileVo.getManuscriptVersion());
					manuscriptScore.setAvgSyllablesCount(avgSyllablesCount);
					manuscriptScore.setAvgWordLength(avgWordLength);
					manuscriptScore.setDifficultWordsRatio(difficultWordsRatio);
					manuscriptScore.setFleschKincaidGrade(fleschKincaidGrade);
					manuscriptScore.setFleschReadingEase(fleschReadingEase);
					manuscriptScore.setGunningFogIndex(gunningFogIndex);
					manuscriptScore.setPosRatio(posRatio);
					manuscriptScore.setSentenceLength(sentenceLength);
					manuscriptScore.setSentenceNo(sentenceNo);
					manuscriptScore.setTypeToTokenRatio(typeToTokenRatio);
					manscriptScoreRepo.save(manuscriptScore);
				} else {
					// Create new manuscriptScore
					ManscriptScore manuscriptScoreNew = new ManscriptScore();
					manuscriptScoreNew.setManuScriptId(resubmissionManuscriptFileVo.getManuScriptId());
					manuscriptScoreNew.setManuscriptVersion(resubmissionManuscriptFileVo.getManuscriptVersion());
					manuscriptScoreNew.setAvgSyllablesCount(avgSyllablesCount);
					manuscriptScoreNew.setAvgWordLength(avgWordLength);
					manuscriptScoreNew.setDifficultWordsRatio(difficultWordsRatio);
					manuscriptScoreNew.setFleschKincaidGrade(fleschKincaidGrade);
					manuscriptScoreNew.setFleschReadingEase(fleschReadingEase);
					manuscriptScoreNew.setGunningFogIndex(gunningFogIndex);
					manuscriptScoreNew.setPosRatio(posRatio);
					manuscriptScoreNew.setSentenceLength(sentenceLength);
					manuscriptScoreNew.setSentenceNo(sentenceNo);
					manuscriptScoreNew.setTypeToTokenRatio(typeToTokenRatio);
					manscriptScoreRepo.save(manuscriptScoreNew);
				}
				ManuScript manuscript = manuscriptRepo.getOne(resubmissionManuscriptFileVo.getManuScriptId());
				// Update in manuscript Table
				if (manuscript != null) {
					manuscript.setManuscriptTitle(manuscriptTitle);
					manuscript.setManuscriptShortTitle(manuscriptShortTitle);
					manuscript.setManuscriptRunningHead(manuscriptRunningHead);
					manuscript.setManuscriptAbstract(manuscriptAbstract);
					manuscript.setManuscriptVersion(resubmissionManuscriptFileVo.getManuscriptVersion());
					manuscriptRepo.save(manuscript);
				}
				ManuScriptFile manuScriptFile = manuScriptFileRepo
						.getManuScriptFileData(resubmissionManuscriptFileVo.getManuScriptId());
				// Update in manuScriptFile Table
				if (manuScriptFile != null) {
					manuScriptFile.setFileType(MERGED_FILE);
					manuScriptFile.setFileName(FINAL_DOC);
					manuScriptFile.setFilePath(filePathh);
					manuScriptFile.setIsActive(1);
					manuScriptFile.setFileSize(128);
					manuScriptFile.setFileVersion(resubmissionManuscriptFileVo.getManuscriptVersion());
					manuScriptFileRepo.save(manuScriptFile);
				} else {
					// Create in manuScriptFile Table
					ManuScriptFile manuScriptFileCreate = new ManuScriptFile();
					manuScriptFileCreate.setManuScriptId(resubmissionManuscriptFileVo.getManuScriptId());
					manuScriptFileCreate.setFileType(MERGED_FILE);
					manuScriptFileCreate.setFileName(FINAL_DOC);
					manuScriptFileCreate.setFilePath(filePathh);
					manuScriptFileCreate.setIsActive(1);
					manuScriptFileCreate.setFileSize(128);
					manuScriptFileCreate.setFileVersion(resubmissionManuscriptFileVo.getManuscriptVersion());
					manuScriptFileRepo.save(manuScriptFileCreate);
				}
				ManuscriptTypeDetails manuscriptTypeDetails = manuscriptTypeDetailsRepo
						.getDetailsFromManuscriptId(resubmissionManuscriptFileVo.getManuScriptId());
				// Update in manuscriptTypeDetails
				if (manuscriptTypeDetails != null) {
					manuscriptTypeDetails.setManuscriptType(manuscriptType);
					manuscriptTypeDetails.setManuscriptFigures(manuscriptFigures);
					manuscriptTypeDetails.setManuscriptBlackWhiteFigures(manuscriptBlackWhiteFigures);
					manuscriptTypeDetails.setManuscriptColorFigures(manuscriptColorFigures);
					manuscriptTypeDetails.setManuscriptTables(manuscriptTables);
					manuscriptTypeDetails.setManuscriptWords(manuscriptWords);
					manuscriptTypeDetails.setManuscriptPages(manuscriptPages);
					manuscriptTypeDetails.setManuscriptParagraph(manuscriptParagraph);
					manuscriptTypeDetails.setManuscriptIntroduction(manuscriptIntroduction);
					manuscriptTypeDetails.setManuscriptAcknowledgment(manuscriptAcknowledgment);
					manuscriptTypeDetails.setManuscriptReferences(manuscriptReferences);
					manuscriptTypeDetails.setManuscriptVersion(resubmissionManuscriptFileVo.getManuscriptVersion());
					manuscriptTypeDetailsRepo.save(manuscriptTypeDetails);
				} else {
					// Create in manuscriptTypeDetails
					ManuscriptTypeDetails manuscriptTypeDetailsCreate = new ManuscriptTypeDetails();
					manuscriptTypeDetailsCreate.setManuscriptId(resubmissionManuscriptFileVo.getManuScriptId());
					manuscriptTypeDetailsCreate.setManuscriptType(manuscriptType);
					manuscriptTypeDetailsCreate.setManuscriptFigures(manuscriptFigures);
					manuscriptTypeDetailsCreate.setManuscriptBlackWhiteFigures(manuscriptBlackWhiteFigures);
					manuscriptTypeDetailsCreate.setManuscriptColorFigures(manuscriptColorFigures);
					manuscriptTypeDetailsCreate.setManuscriptTables(manuscriptTables);
					manuscriptTypeDetailsCreate.setManuscriptWords(manuscriptWords);
					manuscriptTypeDetailsCreate.setManuscriptPages(manuscriptPages);
					manuscriptTypeDetailsCreate.setManuscriptParagraph(manuscriptParagraph);
					manuscriptTypeDetailsCreate.setManuscriptIntroduction(manuscriptIntroduction);
					manuscriptTypeDetailsCreate.setManuscriptAcknowledgment(manuscriptAcknowledgment);
					manuscriptTypeDetailsCreate.setManuscriptReferences(manuscriptReferences);
					manuscriptTypeDetailsCreate
							.setManuscriptVersion(resubmissionManuscriptFileVo.getManuscriptVersion());
					manuscriptTypeDetailsRepo.save(manuscriptTypeDetailsCreate);
				}
			} else {
				log.info(".net API not gives any Response");
				return "fail";
			}
		} catch (Exception e) {
			log.error("Error : " + e);
			e.printStackTrace();
		}
		return "Success";
	}

	public String createXMLFormatFile(ManuScriptFile mainDocument,Integer port) {
		StringBuilder createXmlContent = new StringBuilder();
		String manuscriptTileForXml = "";
		try {
			String mainDocumentFilePath = mainDocument.getFilePath();
			String path = mainDocumentFilePath.replace("http://", "");
			System.out.println(path);
			String replacePath = path.replaceAll("\\\\", "@");
			String finalPath = "@@" + replacePath;
			finalPath = finalPath.replace(":"+port, "");
			System.out.println(finalPath);
			// Python Api for extracting title from the maindocument file
			String url = environment.getProperty("python.api.Xml.Data") + "/" + finalPath;
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			System.out.println(result.toString());
			if (result != null) {
				JSONParser jsonParser = new JSONParser();
				JSONObject obj = (JSONObject) jsonParser.parse(result);
				manuscriptTileForXml = (String) obj.get(TITLE);
			}
			createXmlContent.append("<?xml version = '1.0' encoding = 'UTF-8'?>");
			createXmlContent.append(
					"<?xml-stylesheet type=\"text/xsl\" href=\"ptsiiiorder.xsl\" ?><!DOCTYPE orders SYSTEM \"ptsiiiorder151.dtd\">");
			createXmlContent.append("<orders>");
			createXmlContent.append("<order>");
			createXmlContent.append("<time day=\"30\" month=\"10\" yr=\"2019\" hr=\"17\" min=\"30\" sec=\"06\"/>");
			createXmlContent.append("<po-number>T07517192</po-number>");
			createXmlContent.append("<due-date>");
			createXmlContent.append("<time day=\"01\" month=\"11\" yr=\"2019\" hr=\"17\" min=\"00\" sec=\"00\"/>");
			createXmlContent.append("</due-date>");
			createXmlContent.append("<prod-site>ESCH - Elsevier India Pvt Ltd.</prod-site>");
			createXmlContent.append("<opco>OCNL - Operating Company Elsevier B.V.</opco>");
			createXmlContent.append("<stage step=\"S100\"/>");
			createXmlContent.append("<executor type=\"TYPESETTER\" addressee=\"yes\">");
			createXmlContent.append("<exec-code>THOM2</exec-code>");
			createXmlContent.append("<exec-name>Thomson Digital (Gangtok)</exec-name>");
			createXmlContent.append("<aff>");
			createXmlContent.append("<address>Tseyang Dzong Building, Amdo Golai</address>");
			createXmlContent.append("<address-contd>Indira Bye pass, NH-31A</address-contd>");
			createXmlContent.append("<zipcode zipcode-pos=\"AFTERCTY\">737102</zipcode>");
			createXmlContent.append("<cty>Tadong, Gangtok, Sikkim</cty>");
			createXmlContent.append("<cny>India</cny>");
			createXmlContent.append("<tel>+91-3592-281138</tel>");
			createXmlContent.append("</aff>");
			createXmlContent.append("</executor>");
			createXmlContent.append("<executor type=\"WAREHOUSE\" addressee=\"no\">");
			createXmlContent.append("<exec-code>AIRBU</exec-code>");
			createXmlContent.append("<exec-name>Air Business Limited</exec-name>");
			createXmlContent.append("<aff>");
			createXmlContent.append("<address>The Merlin Centre</address>");
			createXmlContent.append("<address-contd>Acrewood Way</address-contd>");
			createXmlContent.append("<zipcode zipcode-pos=\"AFTERCTY\">AL4 0JY</zipcode>");
			createXmlContent.append("<cty>St Albans, Hertfordshire</cty>");
			createXmlContent.append("<cny>United Kingdom</cny>");
			createXmlContent.append("<tel>+44(0)1727 890600</tel>");
			createXmlContent.append("</aff>");
			createXmlContent.append("</executor>");
			createXmlContent.append("<executor type=\"COMPOSITOR\" addressee=\"no\">");
			createXmlContent.append("<exec-code>MPS</exec-code>");
			createXmlContent.append("<exec-name>MPS (CPC)</exec-name>");
			createXmlContent.append("<aff>");
			createXmlContent.append("<address>HMG Ambassador</address>");
			createXmlContent.append("<address-contd>137, Residency Road</address-contd>");
			createXmlContent.append("<zipcode zipcode-pos=\"AFTERCTY\">560 025</zipcode>");
			createXmlContent.append("<cty>Bangalore</cty>");
			createXmlContent.append("<cny>India</cny>");
			createXmlContent.append("<tel>+91 80 4178 4242</tel>");
			createXmlContent.append("<fax>+91 80 2227 1015</fax>");
			createXmlContent.append("</aff>");
			createXmlContent.append("</executor>");
			createXmlContent.append("<item-info>");
			createXmlContent.append("<language>English</language>");
			createXmlContent.append("<crossmark>no</crossmark>");

			createXmlContent.append("<jid>");
			createXmlContent.append(mainDocument.getManuScript().getJournalId());
			createXmlContent.append("</jid>");
			createXmlContent.append("<issn>0921-8009</issn>");
			createXmlContent.append("<aid>");
			createXmlContent.append(mainDocument.getManuScriptId());
			createXmlContent.append("</aid>");

			createXmlContent.append("<pii>S0921-8009(19)30373-8</pii>");
			createXmlContent.append("<article-number>106479</article-number>");
			createXmlContent.append("<doi>10.1016/j.ecolecon.2019.106479</doi>");

			createXmlContent.append("<item-title>");
			createXmlContent.append(manuscriptTileForXml);
			createXmlContent.append("</item-title>");

			createXmlContent.append("<section>ANA</section>");
			createXmlContent.append("<eo-item-nr>ECOLEC_2019_356</eo-item-nr>");
			createXmlContent.append("<e-submission-item-nr>ECOLEC_2019_356</e-submission-item-nr>");
			createXmlContent.append("<received-date>");
			createXmlContent.append("<date day=\"10\" month=\"03\" yr=\"2019\"/>");
			createXmlContent.append("</received-date>");
			createXmlContent.append("<revised-date>");
			createXmlContent.append("<date day=\"27\" month=\"08\" yr=\"2019\"/>");
			createXmlContent.append("</revised-date>");
			createXmlContent.append("<accept-date>");
			createXmlContent.append("<date day=\"12\" month=\"09\" yr=\"2019\"/>");
			createXmlContent.append("</accept-date>");
			createXmlContent.append("<cpc>Supplier</cpc>");
			createXmlContent.append("<in-scope-cpc type=\"Y\"/>");
			createXmlContent.append("<prd-type-as-sent>FLP</prd-type-as-sent>");
			createXmlContent.append("<online-version type=\"print\"/>");
			createXmlContent.append("<pit>FLA</pit>");
			createXmlContent.append("<copy-edit-content required=\"no\"/>");
			createXmlContent.append("<no-mns-pages>33</no-mns-pages>");
			createXmlContent.append("<no-phys-figs>4</no-phys-figs>");
			createXmlContent.append("<no-bw-figs>2</no-bw-figs>");
			createXmlContent.append("<no-web-colour-figs>2</no-web-colour-figs>");
			createXmlContent.append("<no-colour-figs>0</no-colour-figs>");
			createXmlContent.append("<no-e-components>1</no-e-components>");
			createXmlContent.append("<physical-figures>");
			createXmlContent.append("<figure>");
			createXmlContent.append("<figure-nr>1</figure-nr>");
			createXmlContent.append("<figure-type>BW</figure-type>");
			createXmlContent.append("<graphical-abstract grabs=\"no\"/>");
			createXmlContent.append("</figure>");
			createXmlContent.append("</physical-figures>");
			createXmlContent.append("<e-components>");
			createXmlContent.append("<e-component>");
			createXmlContent.append("<e-component-nr>1</e-component-nr>");
			createXmlContent.append("<e-component-format>APPLICATION</e-component-format>");
			createXmlContent.append("</e-component>");
			createXmlContent.append("</e-components>");
			createXmlContent.append("<righthand-start>N</righthand-start>");
			createXmlContent.append("<copyright-status>001</copyright-status>");

			createXmlContent.append("<first-author>");
			createXmlContent.append("<degree>");
			createXmlContent.append(mainDocument.getManuScript().getUser().getSalutation());
			createXmlContent.append("</degree>");
			createXmlContent.append("<fnm>");
			createXmlContent.append(mainDocument.getManuScript().getUser().getFirstName());
			createXmlContent.append("</fnm>");
			createXmlContent.append("<snm>");
			createXmlContent.append(mainDocument.getManuScript().getUser().getLastName());
			createXmlContent.append("</snm>");
			createXmlContent.append("</first-author>");

			createXmlContent.append("<corr-author>");
			createXmlContent.append("<degree>Dr.</degree>");
			createXmlContent.append("<fnm>Katharina</fnm>");
			createXmlContent.append("<snm>Momsen</snm>");
			createXmlContent.append("<aff>");
			createXmlContent.append("<inst-contd>University of Innsbruck</inst-contd>");
			createXmlContent.append("<address>Universitaetsstrasse 15/4</address>");
			createXmlContent.append("<address-contd>Department of Public Economics</address-contd>");
			createXmlContent.append("<zipcode zipcode-pos=\"BEFORECTY\">6020</zipcode>");
			createXmlContent.append("<cty>Innsbruck, Tyrol</cty>");
			createXmlContent.append("<cny>Austria</cny>");
			createXmlContent.append("<ead>katharina.momsen@uibk.ac.at</ead>");
			createXmlContent.append("</aff>");
			createXmlContent.append("</corr-author>");
			createXmlContent.append("<revised-proof>N</revised-proof>");
			createXmlContent.append("<offprint-payment payment=\"no\"/>");
			createXmlContent.append("</item-info>");
			createXmlContent.append("</order>");
			createXmlContent.append("</orders>");

		} catch (Exception e) {
			System.out.println(e);
		}
		return createXmlContent.toString();
	}

	@Override
	public List<FunderDetailsVO> getResearchFunders(FunderDetailsVO funderDetailsVO) {
		try {
			if (funderDetailsVO.getFunderId() != null) {
				String url = "http://api.crossref.org/funders/" + funderDetailsVO.getFunderId();
				RestTemplate restTemplate = new RestTemplate();
				String result = restTemplate.getForObject(url, String.class);
				if (result != null && !result.isEmpty()) {
					JSONParser jsonParser = new JSONParser();
					JSONObject obj = (JSONObject) jsonParser.parse(result);
					JSONObject message = (JSONObject) obj.get("message");
					String funderName = (String) message.get("name");
					String funderUri = (String) message.get("uri");
					String funderLocation = (String) message.get("location");
					String funderId = (String) message.get("id");
					List<FunderDetailsVO> newfunder = new ArrayList<>();
					FunderDetailsVO newfunderDetail = new FunderDetailsVO();
					newfunderDetail.setFunderId(funderId);
					newfunderDetail.setFunderName(funderName);
					newfunderDetail.setFunderUri(funderUri);
					newfunderDetail.setFunderLocation(funderLocation);
					newfunder.add(newfunderDetail);
					return newfunder;
				}
			} else {
				String url = "http://api.crossref.org/funders?query=" + funderDetailsVO.getFunderName();
				RestTemplate restTemplate = new RestTemplate();
				String result = restTemplate.getForObject(url, String.class);
				if (result != null && !result.isEmpty()) {
					JSONParser jsonParser = new JSONParser();
					JSONObject obj = (JSONObject) jsonParser.parse(result);
					JSONObject message = (JSONObject) obj.get("message");
					List<JSONObject> funderItems = (List<JSONObject>) message.get("items");
					List<FunderDetailsVO> newCreatefunderByname = new ArrayList<>();
					for (JSONObject i : funderItems) {
						String funderId = (String) i.get("id");
						String funderLocation = (String) i.get("location");
						String funderName = (String) i.get("name");
						String funderUri = (String) i.get("uri");
						FunderDetailsVO createdFunder = new FunderDetailsVO();
						createdFunder.setFunderId(funderId);
						createdFunder.setFunderName(funderName);
						createdFunder.setFunderUri(funderUri);
						createdFunder.setFunderLocation(funderLocation);
						newCreatefunderByname.add(createdFunder);
					}
					return newCreatefunderByname;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveManuscriptFunders(List<FunderDetailsVO> funderDetailsVO) {
		funderDetailsVO.stream().forEach(i -> {
			FunderDetails funderDetails = funderDetailsRepo.getResearchFunderByFunderId(i.getFunderId());
			if (funderDetails != null) {
				funderDetails.setFunderId(i.getFunderId());
				funderDetails.setFunderName(i.getFunderName());
				funderDetails.setFunderUri(i.getFunderUri());
				funderDetails.setFunderLocation(i.getFunderLocation());
				funderDetailsRepo.save(funderDetails);
				ManuscriptFunder manu = manuscriptFunderRepo.getManuscriptFunder(i.getManuScriptId(),
						funderDetails.getId());
				if (manu == null) {
					ManuscriptFunder manuFunder = new ManuscriptFunder();
					manuFunder.setManuscriptId(i.getManuScriptId());
					manuFunder.setFunderId(funderDetails.getId());
					manuscriptFunderRepo.save(manuFunder);
				} else {
					manu.setManuscriptId(i.getManuScriptId());
					manu.setFunderId(manu.getId());
					manuscriptFunderRepo.save(manu);
				}
			} else {
				FunderDetails newFunderDetail = new FunderDetails();
				newFunderDetail.setFunderId(i.getFunderId());
				newFunderDetail.setFunderName(i.getFunderName());
				newFunderDetail.setFunderUri(i.getFunderUri());
				newFunderDetail.setFunderLocation(i.getFunderLocation());
				funderDetailsRepo.save(newFunderDetail);
				ManuscriptFunder manu = manuscriptFunderRepo.getManuscriptFunder(i.getManuScriptId(),
						funderDetails.getId());
				if (manu == null) {
					ManuscriptFunder manuFunder = new ManuscriptFunder();
					manuFunder.setManuscriptId(i.getManuScriptId());
					manuFunder.setFunderId(funderDetails.getId());
					manuscriptFunderRepo.save(manuFunder);
				} else {
					manu.setManuscriptId(i.getManuScriptId());
					manu.setFunderId(manu.getId());
					manuscriptFunderRepo.save(manu);
				}
			}
		});
	}

	@Override
	public List<FunderDetailsVO> getManuscriptFunders(FunderDetailsVO funderDetailsVO) {
		List<ManuscriptFunder> manu = manuscriptFunderRepo.getManuscriptFundersList(funderDetailsVO.getManuScriptId());
		List<FunderDetailsVO> manuList = new ArrayList<>();
		if (manu != null && !manu.isEmpty()) {
			manu.stream().forEach(i -> {
				FunderDetailsVO list = new FunderDetailsVO();
				list.setManuscriptFunderId(i.getId());
				list.setManuScriptId(i.getManuscriptId());
				list.setFunderDetailsId(i.getFunderDetails().getId());
				list.setFunderId(i.getFunderDetails().getFunderId());
				list.setFunderName(i.getFunderDetails().getFunderName());
				list.setFunderLocation(i.getFunderDetails().getFunderLocation());
				list.setFunderUri(i.getFunderDetails().getFunderUri());
				manuList.add(list);
			});
		}
		return manuList;
	}

	@Override
	public ManuScript getManusManuScript(Integer id) {
		return manuscriptRepo.getOne(id);
	}
}
