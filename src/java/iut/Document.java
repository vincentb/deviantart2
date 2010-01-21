package iut;
// Generated 14 janv. 2010 16:48:02 by Hibernate Tools 3.2.1.GA



/**
 * Document generated by hbm2java
 */
public class Document  implements java.io.Serializable {


     private Integer id;
     private Users users;
     private Category category;
     private String name;
     private String description;
     private int nbclick;
     private int nbdownload;

    public Document() {
    }

	
    public Document(Users users, Category category, String name, int nbclick, int nbdownload) {
        this.users = users;
        this.category = category;
        this.name = name;
        this.nbclick = nbclick;
        this.nbdownload = nbdownload;
    }
    public Document(Users users, Category category, String name, String description, int nbclick, int nbdownload) {
       this.users = users;
       this.category = category;
       this.name = name;
       this.description = description;
       this.nbclick = nbclick;
       this.nbdownload = nbdownload;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public int getNbclick() {
        return this.nbclick;
    }
    
    public void setNbclick(int nbclick) {
        this.nbclick = nbclick;
    }
    public int getNbdownload() {
        return this.nbdownload;
    }
    
    public void setNbdownload(int nbdownload) {
        this.nbdownload = nbdownload;
    }




}

