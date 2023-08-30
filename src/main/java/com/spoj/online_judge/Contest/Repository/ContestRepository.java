package com.spoj.online_judge.Contest.Repository;

import com.spoj.online_judge.Contest.Entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Integer> {
}
