package stkmgt.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import stkmgt.StockServices.StockServices;
import stkmgt.model.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockServices stockServices;

    //get home page
    @GetMapping("")
    public String getHomePage(){
        return "home";
    }

    //displaying all products
    @GetMapping("/allproducts")
    public String getAllProductsDisplay(Model model){
        List<MainStock> allProducts = stockServices.getAllProductsList();
        model.addAttribute("list",allProducts);
        return "allproducts";
    }

    //get stock in page
    @GetMapping("/stockin")
    public String getStockInPage(Model model){
        List<String> allProducts = stockServices.getAllProducts();
        model.addAttribute("list",allProducts);
        return "stockIn";
    }

    //Adding product to produts mainstock and productsin table
    @PostMapping("/stockin")
    public String addStockToDatabase(ProductsInVo product, BindingResult bindingResult, Model model) throws InterruptedException{
        if (bindingResult.hasErrors()){
            return "error";
        }
        System.out.println(product);
        if (stockServices.checkName(Arrays.asList(product.getProductName()))){
            stockServices.updateMainStockAndProductIn(product);
            System.out.println("match found");
        }
        else {
            stockServices.addToMainStockAndProductIn(product);
        }
        return "redirect:/stock/stockin";
    }

    //stock out page
    @GetMapping("stockout")
    public String getStockOutPage(Model model){
        List<String> allProducts = stockServices.getAllProducts();
        model.addAttribute(("list"),allProducts);
        return "stockout";
    }

    //updating mainstock tabel and productout
    @PostMapping("stockout")
    public String addProductOut(ProductsOutVo product, BindingResult bindingResult, Model model) throws InterruptedException{
        if (bindingResult.hasErrors()){
            return "error";
        }
        //Updating MainStock
        if (stockServices.getProdByName(product.getProductName()).getQuantity()<product.getQuantity()){
            System.out.println("error updating since out quantity excedes exsisting amount");
        }
        else {
            stockServices.updateMainStockOutAndProductsOut(product);
            System.out.println("product updated");
        }
        return "redirect:/stock/stockout";
    }

    //get Product replacement page
    @GetMapping("replacement")
    public String getReplacementPage(Model model){
        List<String> allProducts = stockServices.getAllProducts();
        model.addAttribute("list",allProducts);
        return "replacement";
    }

    //updating mainstock table and replacememnt table
    @PostMapping("replacement")
    public String updateReplacementAndMainStock(ProductReplaceVo product, BindingResult bindingResult, Model model) throws InterruptedException{
        stockServices.updateMainStockAndReplacement(product);
        return "redirect:/stock/replacement";
    }

}
