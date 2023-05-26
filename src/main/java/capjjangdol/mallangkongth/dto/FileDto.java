package capjjangdol.mallangkongth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
public class FileDto {
    @Id
    @Column(name = "FILE_ID")
    private String fileId;

    @Column(name = "ORGN_FILE_NAME")
    private String orgnFileName;

    @Column(name = "PYSC_FILE_NAME")
    private String pyscFileName;

    @Column(name = "FILE_SIZE")
    private Long fileSize;

    /**
     * @param fileId
     * @param orgnFileName
     * @param pyscFileName
     * @param fileSize
     */
    public FileDto(String fileId, String orgnFileName, String pyscFileName, long fileSize) {
        this.fileId       = fileId;
        this.orgnFileName = orgnFileName;
        this.pyscFileName = pyscFileName;
        this.fileSize     = fileSize;
    }

}
