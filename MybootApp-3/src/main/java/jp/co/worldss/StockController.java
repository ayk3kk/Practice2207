package jp.co.worldss;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drink")
public class StockController {

	@Autowired
	private DrinkService drinkService;

	@PersistenceContext
	EntityManager entityManager;

	//一覧表示処理
	@GetMapping
	public String index(Model model,@ModelAttribute("formModel") DrinkData drinkdata) {

		model.addAttribute("msg", "在庫管理");
		model.addAttribute("msg2","検索条件を入力してください");
		List<DrinkData> drinks = drinkService.findAll();
		model.addAttribute("drinks", drinks);

		return "search";
	}

	//検索結果の受け取り処理
	@PostMapping
	public String select(@ModelAttribute("formModel") DrinkData drinkdata, Model model) {

		model.addAttribute("msg", "検索結果");
		List<DrinkData> result = drinkService.search(drinkdata.getProduct());
		model.addAttribute("drinks", result);

		return "search";
	}

	//詳細画面処理
	@GetMapping("detail/{isbn}")
	public String detail(@PathVariable int isbn, Model model) {

		model.addAttribute("msg", "参照画面");
		Optional<DrinkData> data = drinkService.findById(isbn);
		model.addAttribute("form", data.get());

		return "detail";
	}

	//初期化処理 （商品仮入力）
	@PostConstruct
	public void init() {

		DrinkData d1 = new DrinkData();
		d1.setNumber(1);
		d1.setPrice(78);
		d1.setProduct("コカ・コーラ");
		d1.setStatus(false);
		drinkService.save(d1);

		DrinkData d2 = new DrinkData();
		d2.setNumber(4);
		d2.setPrice(108);
		d2.setProduct("アクエリアス");
		d2.setStatus(false);
		drinkService.save(d2);

		DrinkData d3 = new DrinkData();
		d3.setNumber(7);
		d3.setPrice(158);
		d3.setProduct("濃い綾鷹");
		d3.setStatus(false);
		drinkService.save(d3);
	}
}
