package music;

// what's the issue...
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Table(name= "BANDS_INFO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BandsInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

   // @NotNull(message="must have unique name")
    private String name;

  //  @Size(max=100)
    private String backstory;

    private int numberStudioAlbums;
    private String bandPhoto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackstory() {
        return backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    public int getNumberStudioAlbums() {
        return numberStudioAlbums;
    }

    public void setNumberStudioAlbums(int numberStudioAlbums) {
        this.numberStudioAlbums = numberStudioAlbums;
    }

    public String getBandPhoto() {
        return bandPhoto;
    }

    public void setBandPhoto(String bandPhoto) {
        this.bandPhoto = bandPhoto;
    }


}
