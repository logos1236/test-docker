package testSpring.domain.repository.employee;

import jakarta.persistence.TypedQuery;
import lombok.NonNull;
import org.springframework.stereotype.Repository;
import testSpring.domain.entities.TEmployee;
import testSpring.domain.repository.AbstractRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Repository
public class TEmployeeCustomRepositoryImpl extends AbstractRepository<TEmployee> implements TEmployeeCustomRepository {
    @Override
    public Set<TEmployee> findActiveEmployeesForMonth(@NonNull LocalDate month) {
        TypedQuery<TEmployee> query =
                em.createQuery("select " +
                                "distinct employee " +
                                "from TEmployee employee " +
                                "where 1 = 1 " +
                                "and employee.vacancy = false " +
                                "and (employee.dismissDate IS NULL " +
                                " or employee.dismissDate >= :month) "
                        , TEmployee.class);

        query.setParameter("month", month);

        return new HashSet<>(query.getResultList());
    }

    @Override
    public Set<TEmployee> findAllEmployeesForIntegration() {
        TypedQuery<TEmployee> query =
                em.createQuery("select " +
                                "distinct employee " +
                                "from TEmployee employee " +
                                "left join TEmployeeCfo employeeCfo " +
                                "on employee = employeeCfo.employee " +
                                "where 1 = 1 " +
                                "and employee.vacancy = false " +
//                                "and employee.dismissDate IS NULL " + // Если в декрет, то проставляется дата?
                                "and employee.name != null " +
                                "and employeeCfo.id is not null " // Есть дубли, у которых нет в итоге t_employee_cfo
                        , TEmployee.class);

        return new HashSet<>(query.getResultList());
    }
}
