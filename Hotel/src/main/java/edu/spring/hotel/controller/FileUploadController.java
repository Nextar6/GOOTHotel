package edu.spring.hotel.controller;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.spring.hotel.util.FileUploadUtil;
import edu.spring.hotel.util.MediaUtil;


@Controller
@RequestMapping(value="/hotel")
public class FileUploadController {
	private static final Logger logger = 
			LoggerFactory.getLogger(FileUploadController.class);
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@GetMapping("/fileUpload")
	public void uploadGET() {
		logger.info("uploadGET() 호출");
	}
	
	@ResponseBody
	@PostMapping("/fileUpload")
	public ResponseEntity<String[]> fileUploadPOST(MultipartFile[] filelist) throws Exception{
		logger.info("fileUploadPOST() 호출");
		
		String result = "";
		String[] images = new String[filelist.length];
		for(int i = 0; i < filelist.length; i++) {
			result = FileUploadUtil.saveUploadedFile(uploadPath, 
					filelist[i].getOriginalFilename(), 
					filelist[i].getBytes());
			images[i] = result;
			logger.info("images = " + images[i]);
		}
		return new ResponseEntity<String[]>(images, HttpStatus.OK);
	}
	
	@GetMapping("/display")
	public ResponseEntity<byte[]> display(String fileName) throws Exception{
		logger.info("display() 호출");
		
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		
		logger.info("fileName = " + fileName);
		
		String[] str = fileName.split(",");
		for(int i = 0; i < str.length; i++) {
			logger.info("str = " + str[i]);
		}
		
		String filePath = uploadPath + fileName;
		logger.info("filePath = " + filePath);
		in = new FileInputStream(filePath);

		String extension = 
				filePath.substring(filePath.lastIndexOf(".") + 1);
		logger.info(extension);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaUtil.getMediaType(extension));
		
		entity = new ResponseEntity<byte[]>(
					IOUtils.toByteArray(in),
					httpHeaders,
					HttpStatus.OK
				);
		logger.info("entity = " + entity);
		return entity;
				
	}
	
}
