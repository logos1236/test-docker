package testSpring.domain.repository.employee;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import testSpring.domain.entities.TEmployee;

import java.util.List;

public interface TEmployeeRepository extends JpaRepository<TEmployee, Long>, TEmployeeCustomRepository {
    /**
     * Ищем сотрудников по ФИО
     */
    List<TEmployee> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);

    @Query("SELECT employee from TEmployee employee " +
            "where concat(employee.surname, ' ', employee.name, ' ', employee.patronymic) =:fullName")
    List<TEmployee> findAllByFullName(@Param("fullName") String fullName);

    /**
     * Ищем сотрудников по фамилии
     */
    List<TEmployee> findBySurnameIgnoreCase(String surname);

    /**
     * Ищем сотрудников по email
     */
    List<TEmployee> findByEmailIgnoreCase(@NonNull String email);

    List<TEmployee> findByGlobalId(Integer globalId);
}
