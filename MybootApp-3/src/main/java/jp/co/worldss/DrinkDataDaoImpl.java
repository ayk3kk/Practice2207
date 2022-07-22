package jp.co.worldss;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DrinkDataDaoImpl implements DrinkDataDao {

	@Autowired
	private EntityManager entityManager;

	public DrinkDataDaoImpl() {
		super();
	}

	public DrinkDataDaoImpl(EntityManager manager) {
		this();
		this.entityManager = manager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DrinkData> search(String product){

	StringBuilder sql = new StringBuilder();
	sql.append("SELECT b From DrinkData b WHERE");

	boolean productFlg = false;
	boolean andFlg     = false;

	if(!"".equals(product)) {
		sql.append("b.product LIKE :product");
		productFlg = true;
		andFlg     = true;
	}

	Query query = entityManager.createQuery(sql.toString());

	if(productFlg) query.setParameter("product", "%" + product + "%");

	return query.getResultList();

	}
}
