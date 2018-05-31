package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.TradingRecord;
import com.service.TradingRecordService;

/**
 * 交易记录操作 creation time 2018 05 29
 * 
 * @author User742742
 *
 */
@RestController
public class TradingRecordController {

    @Autowired
    TradingRecordService tradingRecordService;

    
    /**
     * 交易记录新增
     * 
     * @param sender
     * @param recepient
     * @param ammount
     * @param name
     * @param type
     * @return
     */
    @RequestMapping(value = "/saveTransaction", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Map<String, Object> insert(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            TradingRecord tradingRecord = new TradingRecord();
            tradingRecord.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).trim());
            tradingRecord.setSender(request.getParameter("sender").trim());
            tradingRecord.setRecepient(request.getParameter("recepient").trim());
            tradingRecord.setAmmount(request.getParameter("ammount").trim());
            tradingRecord.setName(request.getParameter("name").trim());
            tradingRecord.setType(request.getParameter("type").trim());
            int i = tradingRecordService.insertSelective(tradingRecord);
            if (i == 1) {
                System.err.println("新增成功");
                map.put("ret", 0);
                return map;
            }
            System.err.println("新增失败");
            map.put("ret", 1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println("系统错误");
            map.put("ret", 2);
        }
        return map;
    }

    /**
     * 查询所有交易记录
     * 
     * @param username
     * @return
     */
    @RequestMapping(value = "/transactions", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Map<String, Object> select() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<TradingRecord> transactions = tradingRecordService.select();
            if (transactions.size() != 0) {
                System.err.println("查询成功");
                map.put("ret", 0);
                map.put("transactions", transactions);
                return map;
            }
            System.err.println("查询失败");
            map.put("ret", 1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println("系统错误");
            map.put("ret", 2);
        }
        return map;
    }
    
//    /**
//     * 根据sender查询交易记录
//     * 
//     * @param username
//     * @return
//     */
//    @RequestMapping(value = "/tradingRecordSelectSender", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
//    public Map<String, Object> selectSender(
//            @RequestParam(value = "sender", required = true) String sender) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        try {
//            List<TradingRecord> listTradingRecord = tradingRecordService.selectByPrimarySender(sender.trim());
//            if (listTradingRecord.size() != 0) {
//                System.err.println("根据发送人查询成功");
//                map.put("ret", 0);
//                map.put("listTradingRecord", listTradingRecord);
//                return map;
//            }
//            System.err.println("根据发送人查询失败");
//            map.put("ret", 1);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.err.println("系统错误");
//            map.put("ret", 2);
//        }
//        return map;
//    }
//
//    /**
//     * 根据recepient查询交易记录
//     * 
//     * @param username
//     * @return
//     */
//    @RequestMapping(value = "/tradingRecordSelectRecepient", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
//    public Map<String, Object> selectRecepient(
//            @RequestParam(value = "recepient", required = true) String recepient) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        try {
//            List<TradingRecord> listTradingRecord = tradingRecordService.selectByPrimaryRecepient(recepient.trim());
//            if (listTradingRecord.size() != 0) {
//                System.err.println("根据接收人查询成功");
//                map.put("ret", 0);
//                map.put("listTradingRecord", listTradingRecord);
//                return map;
//            }
//            System.err.println("根据接收人查询失败");
//            map.put("ret", 1);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.err.println("系统错误");
//            map.put("ret", 2);
//        }
//        return map;
//    }
//
//    /**
//     * 根据name查询交易记录
//     * 
//     * @param username
//     * @return
//     */
//    @RequestMapping(value = "/tradingRecordSelectName", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
//    public Map<String, Object> selectName(@RequestParam(value = "name", required = true) String name) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        try {
//            List<TradingRecord> listTradingRecord = tradingRecordService.selectByPrimaryName(name.trim());
//            if (listTradingRecord.size() != 0) {
//                System.err.println("根据合约查询成功");
//                map.put("ret", 0);
//                map.put("listTradingRecord", listTradingRecord);
//                return map;
//            }
//            System.err.println("根据合约查询失败");
//            map.put("ret", 1);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.err.println("系统错误");
//            map.put("ret", 2);
//        }
//        return map;
//    }
}
