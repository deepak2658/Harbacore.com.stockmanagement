package mainapp.demo.controller;

import mainapp.demo.model.*;
import mainapp.demo.service.StockManagement;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/stock")
public class StockController {

    final StockManagement stockManagement;
    public StockController(StockManagement stockManagement) {
        this.stockManagement = stockManagement;
    }

    //Home Page
    @GetMapping("")
    public String getHomePage(){
        return "home";
    }

    //For stockIn
    @GetMapping("/stockin")
    public String  getStockInPage(Model model){
        List<String> list = stockManagement.listProductName();
        model.addAttribute("list",list);
        return "stockIn";
    }

    @PostMapping("/stockin")
    @Transactional
    protected String postIn(ItemInVO product, BindingResult bindingResult, Model model) throws InterruptedException {
        if (bindingResult.hasErrors()){
            return "error";
        }
        System.out.println(product);
        //For update/insertion MainStock table
        if(stockManagement.checkName(Arrays.asList(product.getProductName()))){
            stockManagement.updateMainStock(product.getProductName(),product.getQuantity(),product.getInsertionDate());
            System.out.println("match found");
        }
        else{
            stockManagement.save(product);
            System.out.println("match not found");
        }
        //for insertion into ItemIn Table
        stockManagement.addProductToItemIn(product);
        return "redirect:/stock/stockin";
    }

    //For Stock out
    @GetMapping("/stockout")
    public String  getStockOutPage(Model model){
        List<String> list = stockManagement.listProductName();
        model.addAttribute("list",list);
        return "stockout";
    }

    @PostMapping("/stockout")
    @Transactional
    public String postOutProduct(ItemsOutVo product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "error";
        }
        //Updating MainStock
        if (stockManagement.getProdByName(product.getProductName()).getQuantity()<product.getQuantity()){
            System.out.println("error updating since out quantity excedes exsisting amount");
        }
        else {
            stockManagement.updateMainStockOut(product.getProductName(), product.getQuantity(), product.getDate());
            System.out.println("product updated");
        }
        //Updating StockOut
        stockManagement.addProductToItemOut(product);
        return "redirect:/stock/stockout";
    }

    //For Replacement
    @GetMapping("/replacement")
    public String  getReplacementPage(Model model){
        List<String> list = stockManagement.listProductName();
        model.addAttribute("list",list);
        return "replacement";
    }

    @PostMapping("/replacement")
    public  String postReplacementProduct(ItemReplaceVo product, BindingResult bindingResult, Model model){
        stockManagement.updateMainStockReplace(product.getProductName(), product.getQuantity(), product.getDate());
        stockManagement.addProductToItemReplace(product);
        return "redirect:/stock/replacement";
    }

}
