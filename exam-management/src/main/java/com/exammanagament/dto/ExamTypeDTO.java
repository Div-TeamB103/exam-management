package com.exammanagament.dto;



import lombok.*;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ExamTypeDTO {
    private String type;
    private String description;
    private Set<Long> examIds;


    @Override
    public String toString() {
        return "ExamTypeDTO{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", examIds=" + examIds +
                '}';
    }
}
