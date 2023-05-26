package capjjangdol.mallangkongth.Controller.File;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FileController {
    @PostMapping(value="uploadFile")
    public ResponseEntity<String> uploadFile(MultipartFile file) throws IllegalStateException, IOException{
        if(!file.isEmpty()){
            System.out.println("file org name = {"+ file.getOriginalFilename()+"}");
            System.out.println("file content type = {"+ file.getOriginalFilename()+"}");
            file.transferTo(new File(file.getOriginalFilename()));
        }
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
