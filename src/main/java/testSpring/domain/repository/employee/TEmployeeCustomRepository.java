package testSpring.domain.repository.employee;

import lombok.NonNull;
import testSpring.domain.entities.TEmployee;

import java.time.LocalDate;
import java.util.Set;

public interface TEmployeeCustomRepository {
    /**
     * Ищем сотрудников, которые не были уволены на определенную дату
     */
    Set<TEmployee> findActiveEmployeesForMonth(@NonNull LocalDate month);

    Set<TEmployee> findAllEmployeesForIntegration();
}
