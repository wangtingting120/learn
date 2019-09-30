package edu.hubu.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hubu.learn.dao.WttDao;
import edu.hubu.learn.entity.Wtt;

import java.util.List;


@Service
public class WttService {

    @Autowired
    private WttDao wttDao;

    public Wtt getWtt(Long id) {
        return wttDao.findById(id).get();
    }

    public List<Wtt> getWtts(){
        return wttDao.findAll();
    }
}