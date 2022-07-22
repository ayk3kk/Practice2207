package jp.co.worldss;

import java.io.Serializable;
import java.util.List;

public interface DrinkDataDao extends Serializable {

	public List<DrinkData> search(String product);
}
