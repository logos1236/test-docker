package testSpring.service.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import testSpring.service.dtos.EmployeeDto;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AllEmployeesResponse {
    @Builder.Default
    List<EmployeeDto> data = Collections.emptyList();
}
