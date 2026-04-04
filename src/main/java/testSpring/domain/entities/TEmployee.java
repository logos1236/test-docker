package testSpring.domain.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Справочник сотрудников
 */
@Entity
@Table(name = "T_EMPLOYEE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TEmployee extends AbstractEntity {

    /**
     * Имя
     */
    @Column(name = "name")
    private String name;

    /**
     * Фамилия
     */
    @Column(name = "surname", nullable = false)
    private String surname;

    /**
     * Отчество
     */
    @Column(name = "patronymic")
    private String patronymic;

    /**
     * Признак того, что является вакансией
     */
    @Column(name = "is_vacancy", nullable = false)
    private Boolean vacancy;


    /**
     * Дата приема на работу
     */
    @Column(name = "start_date")
    private LocalDate startDate;

    /**
     * Дата увольнения
     */
    @Column(name = "dismiss_date")
    private LocalDate dismissDate;

    /**
     * Email
     */
    @Column(name = "email")
    private String email;

    /**
     * Один из УФОСовских id
     */
    @Column(name = "global_id")
    private Integer globalId;


}
