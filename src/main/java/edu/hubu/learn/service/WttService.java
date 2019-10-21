package edu.hubu.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.hubu.learn.dao.WttDao;
import edu.hubu.learn.entity.User;
import edu.hubu.learn.entity.Wtt;

import java.util.List;


@Service
public class WttService {

    @Autowired
    private WttDao wttDao;
    public List<Wtt> getUsers() {
        return wttDao.findAll(new Sort(Direction.DESC, "id"));
    }

    public Wtt getWtt(Long id) {
        return wttDao.findById(id).get();
    }

    public List<Wtt> getWtts(){
        return wttDao.findAll();
    }

    public Wtt addWtt(Wtt wtt) {
        return wttDao.save(wtt);
    }
    public void deleteWtt(Long id) {
        wttDao.deleteById(id);
    }

    public void modifyWtt(Wtt wtt) {
        wttDao.save(wtt);
    }


        public List<Wtt> searchWtts(String keyword) {
            Wtt wtt= new Wtt();
            wtt.setName(keyword);
            ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", match->match.contains());
            Example<Wtt> example = Example.of(wtt, matcher);
            Sort sort = new Sort(Direction.DESC, "id");
            return wttDao.findAll(example, sort);
        }
}