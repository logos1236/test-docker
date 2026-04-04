package testSpring.domain.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;


public abstract class AbstractRepository<T> {
    @PersistenceContext
    protected EntityManager em;

    protected Session getHibernateSession(){
        return (Session) em.getDelegate();
    }
}
