package org.bulletjournal.dao;

import com.google.common.collect.Iterables;
import org.bulletjournal.model.ApplicationUser;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

/**
 * @author Teodora Bobirneci
 */
@Component
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ApplicationUser findByUsername(String username) {
        List<ApplicationUser> resultList = entityManager.createQuery("from ApplicationUser where username=:username", ApplicationUser.class)
                .setParameter("username", username)
                .getResultList();
        if (isEmpty(resultList)) {
            return null;
        }
        return Iterables.getOnlyElement(resultList);
    }

    @Override
    public ApplicationUser saveUser(ApplicationUser applicationUser) {
        return entityManager.merge(applicationUser);
    }

}
