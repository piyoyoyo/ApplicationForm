package com.techscore.springboot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MenuController {
    @Autowired
    MenuListRepository menuListRepository;
    @Autowired
    CartItemRepository cartItemRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Menu> menuList = menuListRepository.findAll();
        model.addAttribute("menuList", menuList);
        return "index";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String detail(@PathVariable Long id, Model model) {
        Optional<Menu> optMenu = menuListRepository.findById(id);
        Menu menu = optMenu.get();
        model.addAttribute("menu", menu);
        return "detail";
    }

    ////////////////////　カートに追加したい。///////////////////////////
    @RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
    public String cart(@PathVariable Long id, Model model) {
    	Optional<Menu> optCart = menuListRepository.findById(id);
    	Menu menu = optCart.get();

    	// カートにすでに追加されているかどうか調べる
    	// カートの中身のメニューIDと、これから追加するメニューのIDが一致するかどうか
    	List<CartItem>  cartItemList = cartItemRepository.findAll();

    	//　フラグを作る
        boolean isAlreadyInCart = false;

    	for(CartItem cartItem : cartItemList){
            Long alreadyInCartMenuId = cartItem.getMenuId();
            Long buyingMenuId = menu.getId();

            //　一致したら、そのカートの数量を１足す
            if (alreadyInCartMenuId == buyingMenuId) {
            	int currentQuantity = cartItem.getQuantity();
            	int orderedQuantity = currentQuantity + 1;
            	cartItem.setQuantity(orderedQuantity);
            	cartItemRepository.save(cartItem);
            	// s.setQuantity(s.getQuantity()+ 1);
            	isAlreadyInCart = true;
            	break;
            }
    	}
		//　一致しなかったら、ふつうにふやす
		if (isAlreadyInCart == false) {
			CartItem cart = new CartItem(id, 1, (short) 1, LocalDate.now());
			cartItemRepository.save(cart);
		}

		// テーブルを一個ずつもってきてあとでジョインする
		List<Menu> menuList = menuListRepository.findAll();
	  	List<CartItem>  inCartItemList = cartItemRepository.findAll();
	  	List<CartForm> cartForm = new ArrayList<CartForm>();

	  	for(CartItem s : inCartItemList) {
	  		// 注文した商品のメニューIDを取得する
	  		Long orderedMenuId = s.getMenuId();
	  		for(Menu currentMenu : menuList) {
	  			if(orderedMenuId == currentMenu.getId()) {
	  				// メニュー名 価格 数量 カートに入った日付
	  				CartForm order = new CartForm(currentMenu.getName(), currentMenu.getPrice(), s.getQuantity(), s.getInCartAt());
	  				cartForm.add(order);
	  			}
	  		}
	  	}
	  	model.addAttribute("cartForm", cartForm);
    	return "cart";
    }
    ////////////////////　カートに追加ここまで。///////////////////////////



}