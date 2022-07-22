package jp.co.worldss;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {

	@Autowired
	private DrinkDataRepository drinkDataRepository;

	@Autowired
	private DrinkDataDaoImpl drinkDataDaoImpl;

	//全件検索
	public List<DrinkData> findAll(){
		return drinkDataRepository.findAll();
	}

	//該当IDを見つける
	public Optional<DrinkData> findById(long isbn){
		return drinkDataRepository.findById(isbn);
	}

	//保存
	public DrinkData save(DrinkData drinkData) {
		return drinkDataRepository.saveAndFlush(drinkData);
	}

	//検索

	public List<DrinkData> search(String product){
		List<DrinkData> result = new ArrayList<DrinkData>();

		if("".equals(product)) {
			result = drinkDataRepository.findAll();
		}else {
			result = drinkDataDaoImpl.search(product);
		}

		return result;
	}
}
