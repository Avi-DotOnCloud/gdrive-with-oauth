package com.gdrive.oauth.service;

import org.springframework.web.multipart.MultipartFile;

public interface DriveService {

	void uploadFile(MultipartFile multipartFile) throws Exception;
}
