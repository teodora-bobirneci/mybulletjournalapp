package com.mybulletjournalapp.dao;

import com.mybulletjournalapp.model.Appointment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author teodora.bobirneci
 */
//@RepositoryRestResource
public interface AppointmentDao extends CrudRepository<Appointment, Long> {


}
