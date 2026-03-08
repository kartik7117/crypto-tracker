package com.CryptoTracker.CryptoTracker.CryptoService;

import com.CryptoTracker.CryptoTracker.model.CryptoCoin;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoService {
    private final String API_Url="https://api.coingecko.com/api/v3/simple/price?ids=%s&vs_currencies=usd&include_24hr_change=true";

    public List<CryptoCoin> getcryptoprices(List<String> coins){
        List<CryptoCoin> coinList=new ArrayList<>();
        String ids=String.join(",",coins);
        String url=String.format(API_Url,ids);

        RestTemplate restTemplate=new RestTemplate();
        String response=restTemplate.getForObject(url,String.class);
        JSONObject json=new JSONObject(response);

        for(String coin:coins){
            if(json.has(coin)){
                JSONObject coinjson=json.getJSONObject(coin);
                double price=coinjson.getDouble("usd");
                double change24h=coinjson.getDouble("usd_24h_change");
                coinList.add(new CryptoCoin(coin,coin,change24h,price));
            }
        }

        return coinList;
    }
}
