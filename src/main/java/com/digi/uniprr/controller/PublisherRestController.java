package com.digi.uniprr.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digi.uniprr.model.Publishers;
import com.digi.uniprr.service.PublisherService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/publisher")
public class PublisherRestController {
	@Autowired
	PublisherService publisherService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createPublisher(@RequestBody Publishers publishers,
			@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		if (publisherService.isIdExist(publishers.getPublisherId())) {
			return new ResponseEntity<Object>("Already exist", HttpStatus.CONFLICT);
		}
		
		 if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            return new ResponseEntity<Object>("redirect:uploadStatus", HttpStatus.FORBIDDEN);
	        }

	        try {
	        	String UPLOADED_FOLDER="";
	        	
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            publishers.setPublisherLogo(path.toString());
	            Files.write(path, bytes);
	            return new ResponseEntity<Object>("redirect:uploadStatus", HttpStatus.CREATED);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		publishers.getPublisherLogo();

		publisherService.createPublisher(publishers);
		return new ResponseEntity<Object>("Publisher created", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Publishers> getPublishersList() {
		List<Publishers> publisherList = publisherService.getPublishersList();
		return publisherList;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Object> updatePublisherDetails(@RequestBody Publishers publishers) {
		if (publisherService.isIdExist(publishers.getPublisherId())) {
			publisherService.updatePublisherDetails(publishers);
			return new ResponseEntity<Object>("updated successfully", HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<Object>("Does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<Object> deletePublisher(@RequestBody Publishers publishers) {
		if (publisherService.isIdExist(publishers.getPublisherId())) {
			publisherService.deleteById(publishers.getPublisherId());
			return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Id does not exist", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
        	String UPLOADED_FOLDER="";

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

}
