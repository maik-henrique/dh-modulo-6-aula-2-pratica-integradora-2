package br.com.meli.qatestingproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestcaseRequest {
    private String description;
    private boolean tested;
    private boolean passed;
    private int number_of_tries;
    private Date last_update;
}
