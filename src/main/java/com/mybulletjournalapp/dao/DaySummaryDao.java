package com.mybulletjournalapp.dao;

import com.mybulletjournalapp.model.DaySummary;
import org.springframework.data.repository.CrudRepository;

/**
 * @author teodora.bobirneci
 */
public interface DaySummaryDao extends CrudRepository<DaySummary, Long> {


//    public DaySummary saveOrUpdateDaySummary(DaySummary daySummary) {
//        if (daySummary.getId() == null) {
//            entityManager.persist(daySummary);
//        } else {
//            entityManager.merge(daySummary);
//        }
//        //entityManager.detach(daySummary);
//        return entityManager.find(DaySummary.class, daySummary.getId());
//    }
//
//    public DaySummary getSummaryForDay(Date date) {
//        TypedQuery<DaySummary> query = entityManager.createQuery("SELECT s FROM DaySummary s where s.day=:day", DaySummary.class);
//        query.setParameter("day", date, TemporalType.DATE);
//        List<DaySummary> results = query.getResultList();
//        if (isEmpty(results)) {
//            return new DaySummary();
//        }
//        return getOnlyElement(results);
//    }

}
