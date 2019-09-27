package edu.hubu.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hubu.learn.entity.Wtt;

public interface WttDao extends JpaRepository<Wtt, Long> {

}