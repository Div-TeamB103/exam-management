package com.exammanagament.map;

import com.exammanagament.dto.ParentDto;
import com.exammanagament.entity.Parent;
import com.exammanagament.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper()
public interface ParentMap {
    @Mapping(target = "studentsId", expression = "java(toSet(parent.getStudents()))")
    ParentDto toDto (Parent parent);
    @Mapping(target ="lastLoginDate", ignore = true)
    @Mapping(target = "lastLoginIp", ignore = true)
    @Mapping(target = "status", ignore = true)
    Parent toParent (ParentDto parentDto);
    default List<Long> toSet(List<Student> students){
        return  students.stream()
                .map(Student::getId)
                .collect(Collectors.toList());
    }
}
