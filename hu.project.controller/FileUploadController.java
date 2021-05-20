package hu.konyvtar.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hu.konyvtar.domain.Allomany;


import hu.konyvtar.service.KarbantartasService;
import hu.konyvtar.service.OlvasoszolgalatService;

@Controller
public class FileUploadController{

	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String kepfeltoltes(Model model, @RequestParam("file")MultipartFile file, ModelMap modelMap) {

		byte[] bytes;
		try {
			bytes = file.getBytes(); 
			
			//A fájl mentés helye
			Path path = Paths.get("C:\\Spring project\\file.jpg");
			
			Files.write(path, bytes);

			return "/";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "error";
		}	
	}
	