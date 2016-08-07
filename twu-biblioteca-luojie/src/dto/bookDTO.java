package dto;

public class BookDTO {
    private Integer id;

    private String name;

    private String author;

    private Boolean isCheckedOut;

    private String description;

    public BookDTO(Integer id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.isCheckedOut = false;
    }

    public Integer getId() {
        return id;
    };

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setIsCheckedOut(Boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
