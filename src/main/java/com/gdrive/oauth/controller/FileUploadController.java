package com.gdrive.oauth.controller;

import com.gdrive.oauth.model.UploadFile;
import com.gdrive.oauth.service.AuthorizationService;
import com.gdrive.oauth.service.DriveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileUploadController {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    AuthorizationService authorizationService;

    @Autowired
    DriveService driveService;


    @RequestMapping(value="/uploadFiles", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public /*@ResponseBody String*/ ResponseEntity <Object> handleFileUpload(
            @RequestParam(value = "textMessage",required=false) String message,
            @RequestParam(value = "pdfFile", required = false) MultipartFile pdfFile,
            @RequestParam(value = "jsonFile", required = false) MultipartFile jsonFile,
            @RequestParam(value = "zipFile", required = false) MultipartFile zipFile,
            @RequestParam(value = "imgFile", required = false) MultipartFile imageFile,
            MultipartHttpServletRequest request, @ModelAttribute UploadFile uploadedFile) throws Exception{

        //Extracting the multipartFiles from request parameters
        List<String> requestKeys = new ArrayList<String>();
        List<String> originalFileName = new ArrayList<String>();
        request.getFileNames().forEachRemaining(requestKeys::add);
        logger.info("requestKeys " + requestKeys.size());
        for(String multiPartFile : requestKeys) {
            //originalFileName.add(request.getFile(multiPartFile).getOriginalFilename());
            driveService.uploadFile(request.getFile(multiPartFile));
            ;
        }
        //return "uploaded files :" + originalFileName.toString();
        return new ResponseEntity<Object>("The file was uploaded successfully", HttpStatus.OK);
    }

}
