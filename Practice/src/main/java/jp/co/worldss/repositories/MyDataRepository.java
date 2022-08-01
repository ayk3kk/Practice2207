package jp.co.worldss.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.worldss.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long>{

}

