package com.exammanagament.dto;



import java.util.Set;

public class ExamTypeDTO {
    private Long id;
    private String type;
    private String description;
    private Set<Long> examIds;


    public ExamTypeDTO() {
    }


    public ExamTypeDTO(Long id, String type, String description, Set<Long> examIds) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.examIds = examIds;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Long> getExamIds() {
        return examIds;
    }

    public void setExamIds(Set<Long> examIds) {
        this.examIds = examIds;
    }

    @Override
    public String toString() {
        return "ExamTypeDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", examIds=" + examIds +
                '}';
    }
}
