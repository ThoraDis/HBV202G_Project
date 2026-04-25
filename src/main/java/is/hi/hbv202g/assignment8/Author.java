package is.hi.hbv202g.assignment8;

public class Author {
    private String name;

    /**
     * Constructor for author
     * 
     * @param name the name of the author
     */
    public Author(String name){ this.name=name; }

    /**
     * Get name of an author
     * 
     * @return the name of the author
     */
    public String getName(){
        return this.name;
    }

    /**
     * Set new name for author
     * 
     * @param name the new name for author
     */
    public void setName(String name){
        this.name=name;
    }

    

}
