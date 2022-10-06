package goody.domain;

import goody.domain.FileUploaded;
import goody.DriveApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="File_table")
@Data

public class File  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String name;
    
    
    
    
    
    private String type;
    
    
    
    
    
    private Long size;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        FileUploaded fileUploaded = new FileUploaded(this);
        fileUploaded.publishAfterCommit();

    }

    public static FileRepository repository(){
        FileRepository fileRepository = DriveApplication.applicationContext.getBean(FileRepository.class);
        return fileRepository;
    }



    public void deleteFile(){
        FileDeleted fileDeleted = new FileDeleted(this);
        fileDeleted.publishAfterCommit();

    }



}
