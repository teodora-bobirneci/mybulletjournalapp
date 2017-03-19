package com.mybulletjournalapp.dao;

import com.mybulletjournalapp.model.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * @author teodora.bobirneci
 */
public interface TaskDAO extends CrudRepository<Task, Long> {

}
