package pocket;

public class Book {
    String name;
    int pageCount;
    Long id;
    public Book(String name,int pageCount,Long id){
        this.name=name;
        this.pageCount=pageCount;
        this.id=id;
    }
    public Book(String name,int pageCount){
        this.name=name;
        this.pageCount=pageCount;
    }
    public Book(){}
    public void setName(String name){
        this.name=name;
    }

    public void setPageCount(int pageCount){
        this.pageCount=pageCount;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Long getId() {
        return id;
    }

    @Override
    public java.lang.String toString() {
        return this.getName() + " " + this.getPageCount()+" "+this.getId();
    }



}
