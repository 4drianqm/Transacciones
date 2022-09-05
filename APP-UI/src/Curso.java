
public class Curso {
    private String name;
    private String assignature;
    private String credits;
    private Integer id;

public  Curso(String name,String assignature,String credits,Integer id){
   this.id = id;
   this.name = name;
   this.assignature = assignature;
   this.credits = credits;
}
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the assignature
     */
    public String getAssignature() {
        return assignature;
    }

    /**
     * @param assignature the assignature to set
     */
    public void setAssignature(String assignature) {
        this.assignature = assignature;
    }

    /**
     * @return the credits
     */
    public String getCredits() {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(String credits) {
        this.credits = credits;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

  
    
}
