package testSpring.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import testSpring.domain.entities.TEmployee;
import testSpring.domain.repository.employee.TEmployeeRepository;
import testSpring.service.EmployeeService;
import testSpring.service.dtos.EmployeeDto;
import testSpring.service.response.AllEmployeesResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeServiceImpl implements EmployeeService {
    TEmployeeRepository tEmployeeRepository;

    @Override
    public AllEmployeesResponse getAllEmployees() {
        List<TEmployee> allEmployees = tEmployeeRepository.findAll();

        return AllEmployeesResponse.builder()
                .data(getData(allEmployees))
                .build();
    }

    private List<EmployeeDto> getData(List<TEmployee> allEmployees) {
        return allEmployees.stream()
                .map(employee -> {
                    return EmployeeDto.builder()
                            .id(employee.getId())
                            .name(getFullName(employee))
                            .build();
                })
                .collect(Collectors.toList());
    }

    private String getFullName(TEmployee employee) {
        return employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic();
    }
}
