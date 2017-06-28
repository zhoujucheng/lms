package com.dt.lms.controller;

import com.dt.lms.domain.Good;
import com.dt.lms.domain.Order;
import com.dt.lms.domain.SupOrRe;
import com.dt.lms.mapper.GoodMapper;
import com.dt.lms.mapper.OrderMapper;
import com.dt.lms.util.InfoException;
import com.dt.lms.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by dtjc on 2017/6/22.
 */

@RestController
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodMapper goodMapper;

    @RequestMapping("/query")
    public List<Good> goods(String name){
        Util.checkLogin();
        if (name == null)   throw new InfoException("搜索框内不能为空");
        return goodMapper.searchByName(name);
    }

    @RequestMapping("/delete")
    public String delete(int id){
        Util.checkLogin();
        Good good = goodMapper.selectByPrimaryKey(id);
        String msg;
        if (good != null){
            if (good.getAmount()==0){
                if (goodMapper.deleteByPrimaryKey(id) == 1){
                    msg = "删除成功";
                }else {
                    msg = "删除失败";
                }
            }else {
                msg = "商品数量必须为0时才能删除";
            }
        }else {
            msg = "商品不存在";
        }
        return msg;
    }

    @RequestMapping("/idOut")
    public String out(int id,int amount,String retail,double price){
        Util.checkLogin();
        synchronized (goodMapper){
            Good good = goodMapper.selectByPrimaryKey(id);
            return outCheckAndUpdate(amount,good,retail,price);
        }
    }

    @RequestMapping("/nameOut")
    public String out(String name,int amount,String retail,double price){
        Util.checkLogin();
        if (name == null)   throw new InfoException("请输入商品名称");
        synchronized (goodMapper){
            Good good = goodMapper.findGoodByName(name);
            return outCheckAndUpdate(amount,good,retail,price);
        }
    }

    @RequestMapping("/addGood")
    public String addGood(int id, String name, double inprice, double outprice, String type){
        Util.checkLogin();
        goodCheck(id,name,inprice,outprice,type);
        Good good = new Good(id,name,0,inprice,outprice,type);
        int status = goodMapper.insert(good);
        if (status == 1){
            return "添加成功";
        }else {
            return "添加失败，原因未知";
        }
    }

    @RequestMapping("/goodIn")
    public String goodIn(int id, String name, double inprice, int account,String supplier){
        Util.checkLogin();
        Good good;
        if (id <= 0){
            if (name == null || name.equals("")){
                throw new InfoException("商品编号或商品名称出错");
            }
            good = goodMapper.findGoodByName(name);
        }else {
            good = goodMapper.selectByPrimaryKey(id);
        }
        if (good == null){
            throw new InfoException("商品不存在");
        }
        if (inprice <= 0){
            throw new InfoException("价格为非正");
        }
        if (account <= 0){
            throw new InfoException("数量为非正");
        }
        good.setAmount(good.getAmount()+account);
        int status = goodMapper.updateByPrimaryKey(good);
        if (status == 1){
            Order order = new Order(good.getId(),good.getName(),inprice*account,supplier,new Date(System.currentTimeMillis()),OrderController.IN_ORDER);
            goodMapper.addOrder(order);
            return "入库成功";
        }else {
            return "入库失败";
        }
    }

    @RequestMapping("/goodChange")
    public String goodChang(int id, String name, double inprice, double outprice, String type){
        Util.checkLogin();
        goodCheck(id,name,inprice,outprice,type);
        Good origin = goodMapper.selectByPrimaryKey(id);
        Good good = new Good(id,name,origin.getAmount(),inprice,outprice,type);
        int status = goodMapper.updateByPrimaryKey(good);
        if (status == 1){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    private void goodCheck(int id, String name, double inprice, double outprice, String type){
        if (id < 0){
            throw new InfoException("id不能为负");
        }
        if (name == null || name.equals("")){
            throw new InfoException("商品名不能为空");
        }
        if (type == null || type.equals("")){
            throw new InfoException("类型不能为空");
        }
        if (inprice < 0 || outprice <0){
            throw new InfoException("价格不能为负");
        }
        Good good = goodMapper.selectByPrimaryKey(id);
        if (good != null){
            throw new InfoException("商品id已存在");
        }
        good = goodMapper.findGoodByName(name);
        if (good != null){
            throw new InfoException("商品名已存在");
        }
    }

    private String outCheckAndUpdate(int amount,Good good,String retail,double price){
        if (good == null) throw new InfoException("出库失败,商品不存在");
        if (amount <= 0)    throw new InfoException("出库失败,数量必须为大于0的整数");
        if (good.getAmount() - amount < 0){
            throw new InfoException("出库失败，出库数量大于库存数量,当前商品库存量为:"+good.getAmount());
        }
        if (retail == null || retail.equals("")){
            throw new InfoException("商家不能为空");
        }
        if (price < 0){
            throw new InfoException("价格少于0");
        }
        good.setAmount(good.getAmount() - amount);
        int status = goodMapper.updateByPrimaryKey(good);
        if (status == 1){
            Order order = new Order(good.getId(),good.getName(),amount*price,retail,new Date(System.currentTimeMillis()),OrderController.OUT_ORDER);
            goodMapper.addOrder(order);
            return "出库成功,当前商品剩余库存量为:"+good.getAmount();
        }else {
            return "出库失败";
        }
    }

}
