package safron.rest.backend.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SportFoodController {

    private Map<String, List<String>> sportFoodBrand = new HashMap<>();

    {
        sportFoodBrand.put("Optimum Nutrition", new ArrayList<>() {
            {
                add("Chocolate");
                add("Banana");
                add("Vanilla");
            }
        });

        sportFoodBrand.put("Universal Nutrition", new ArrayList<>() {
            {
                add("Vanilla");
                add("Banana");
            }
        });

        sportFoodBrand.put("NOW", new ArrayList<>() {
            {
                add("Strawberry");
                add("Vanilla");
            }
        });

        sportFoodBrand.put("Xtend", new ArrayList<>() {
            {
                add("Mango");
                add("Strawberry");
                add("Vanilla");
            }
        });
    }

    @GetMapping("brand/getAllBrands")
    @ApiOperation("Получить все бренды")
    public List<String> getBrands() {

        return sportFoodBrand.entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @GetMapping("brand/getAllTastesOfOneBrand")
    @ApiOperation("Получить все вкусы одного бренда")
    public List<String> getTastesBrand() {
        return sportFoodBrand.get("Optimum Nutrition");
    }

    @GetMapping("brand/getAllTastes")
    @ApiOperation("Получить все вкусы")
    public List<List<String>> getTastes() {
        return sportFoodBrand.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

}
