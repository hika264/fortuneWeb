
package com.example.demo;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FortuneWebController {
	
	private final String luckyColor;
	
	public FortuneWebController() {
		this.luckyColor = getRandomColor(); //ランダムで色を取ってくる
	}
	
    @GetMapping("/fortuneweb")
    public String getFortune(Model model) {
    	double fn = Math.random(); //0.0～1.0の乱数
    	String fortune;
    	
        if (fn >= 0.7) {
            fortune =  "おめでとう、大吉です!";
        } else if (fn >= 0.4) {
            fortune = "中吉です";
        } else if (fn >= 0.1) {
            fortune = "小吉です";
        } else {
            fortune = "残念、凶";
        }
        
        //ラッキーカラーを更新する
        String luckyColor = getRandomColor();
        
        model.addAttribute("fortune", fortune);
        model.addAttribute("luckyColor",luckyColor);
        return "fortune";
    }
    
    //ランダムにカラーコードを生成するメソッド
    private String getRandomColor() {
    	Random random = new Random();
    	int red = random.nextInt(256);
    	int green = random.nextInt(256);
    	int blue = random.nextInt(256);
    	return String.format("#%02X%02X%02X", red,green,blue);
    	
    }
}