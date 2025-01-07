package com.vector.authorbook.specification;

import com.vector.authorbook.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {

    private String name;
    private String surname;
    private String phone;
    private Gender gender;

}