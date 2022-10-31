/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wsa.praktikum1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Controller
public class myController {

    /**
     *
     */
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static";
    
    
    @RequestMapping("/nexthalaman")
    public String hai (
            @RequestParam(value="name")String isipertama,
            @RequestParam(value="lok")String isikedua,
            @RequestParam(value="img")MultipartFile file,
            Model kurir
    ){
        StringBuilder filenames = new StringBuilder();
        Path filenameandpath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        filenames.append(file.getOriginalFilename());
        try {
            Files.write(filenameandpath,file.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(myController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        kurir.addAttribute("img", file.getOriginalFilename());
        kurir.addAttribute("name", isipertama);
        kurir.addAttribute("lok", isikedua);
        return "homepage";
    }
    
}
