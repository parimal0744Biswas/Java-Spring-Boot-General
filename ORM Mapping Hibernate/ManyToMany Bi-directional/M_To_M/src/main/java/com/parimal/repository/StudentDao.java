package com.parimal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parimal.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>
{

	// @Query("alter table b1 add foreign key(bid) references a1(id) on delete set
	// null")
}
