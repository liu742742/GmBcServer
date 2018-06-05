package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Contract;
import com.service.ContractService;

/**
 * 合约操作 creation time 2018 05 29
 * 
 * @author User742742
 *
 */
@RestController
public class ContractController {

    @Autowired
    ContractService contractService;

    /**
     * 查询所有合约
     * @return
     */
    @RequestMapping(value = "/contracts", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Map<String, Object> select() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Contract> contractions = contractService.select();
        if (contractions.size() != 0) {
            System.err.println("查询成功");
            map.put("ret", 0);
            map.put("contractions", contractions);
            map.put("msg", "查询成功");
        } else {
            System.err.println("查询失败");
            map.put("ret", 1);
            map.put("msg", "查询失败");
        }
        return map;
    }

    /**
     * 查询所有代币
     * @return
     */
    @RequestMapping(value = "/tokens", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Map<String, Object> selectTokens() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Contract> listContract = contractService.select();
        if (listContract.size() != 0) {
            List<Object> tokens = new ArrayList<Object>();
            for (Contract contract : listContract) {
                if (contract.getType().equals("代币")) {
                    Map<String, Object> token = new HashMap<String, Object>();
                    token.put("id", contract.getId());
                    token.put("name", contract.getName());
                    token.put("address", contract.getAddress());
                    tokens.add(token);
                }
            }
            if (tokens.size() != 0) {
                System.err.println("查询成功");
                map.put("ret", 0);
                map.put("token", tokens);
                map.put("msg", "查询成功");
                return map;
            }
        }
        System.err.println("查询失败");
        map.put("ret", 1);
        map.put("msg", "查询失败");
        return map;
    }

    /**
     * 合约新增
     * @param data
     * @return
     */
    @RequestMapping(value = "/saveContract", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Map<String, Object> insert(@RequestBody Map<String, Object> data) {
        Map<String, Object> map = new HashMap<String, Object>();
        Contract contract = new Contract();
        contract.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        contract.setPublisher(((String) data.get("publisher")).trim());
        contract.setName(((String) data.get("name")).trim());
        contract.setDescriptioin(((String) data.get("descriptioin")).trim());
        contract.setAddress(((String) data.get("address")).trim());
        contract.setType(((String) data.get("type")).trim());
        contract.setArtifact(((String) data.get("artifact")).trim());
        int i = contractService.insertSelective(contract);
        if (i == 1) {
            System.err.println("新增成功");
            map.put("ret", 0);
            map.put("msg", "新增成功");
        } else {
            System.err.println("新增失败");
            map.put("ret", 1);
            map.put("msg", "新增失败");
        }
        return map;
    }

    /**
     * 合约修改
     * @param data
     * @return
     */
    @RequestMapping(value = "/contractUpdate", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Map<String, Object> update(@RequestBody Map<String, Object> data) {
        Map<String, Object> map = new HashMap<String, Object>();
        Contract contract = new Contract();
        contract.setId(Integer.parseInt(((String) data.get("id")).trim()));
        contract.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        contract.setPublisher(((String) data.get("publisher")).trim());
        contract.setName(((String) data.get("name")).trim());
        contract.setDescriptioin(((String) data.get("descriptioin")).trim());
        contract.setAddress(((String) data.get("address")).trim());
        contract.setType(((String) data.get("type")).trim());
        contract.setArtifact(((String) data.get("artifact")).trim());
        int i = contractService.updateByPrimaryKeySelective(contract);
        if (i == 1) {
            System.err.println("修改成功");
            map.put("ret", 0);
            map.put("contract", contract);
            map.put("msg", "修改成功");
        } else {
            System.err.println("修改失败");
            map.put("ret", 1);
            map.put("msg", "修改失败");
        }
        return map;
    }

    /**
     * 根据发布人查询合约
     * @param publisher
     * @return
     */
    @RequestMapping(value = "/contractSelectPublisher", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Map<String, Object> selectPublisher(
            @RequestParam(value = "publisher", required = true) String publisher) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Contract> listContract = contractService.selectByPrimaryPublisher(publisher);
        if (listContract.size() != 0) {
            System.err.println("根据发布人查询成功");
            map.put("ret", 0);
            map.put("listContract", listContract);
            map.put("msg", "根据发布人查询成功");
        } else {
            System.err.println("根据发布人查询失败");
            map.put("ret", 1);
            map.put("msg", "根据发布人查询失败");
        }
        return map;
    }

    /**
     * 根据合约名查询合约
     * @param name
     * @return
     */
    @RequestMapping(value = "/contractSelectName", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Map<String, Object> selectName(@RequestParam(value = "name", required = true) String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Contract> listContract = contractService.selectByPrimaryName(name);
        if (listContract.size() != 0) {
            System.err.println("根据合约查询成功");
            map.put("ret", 0);
            map.put("listContract", listContract);
            map.put("msg", "根据合约查询成功");
        } else {
            System.err.println("根据合约查询失败");
            map.put("ret", 1);
            map.put("msg", "根据合约查询失败");
        }
        return map;
    }

    /**
     * 根据合约地址查询合约
     * @param address
     * @return
     */
    @RequestMapping(value = "/contractSelectAddress", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Map<String, Object> selectAddress(
            @RequestParam(value = "address", required = true) String address) {
        Map<String, Object> map = new HashMap<String, Object>();
        Contract contract = contractService.selectByPrimaryAddress(address);
        if (contract != null) {
            System.err.println("根据合约地址查询成功");
            map.put("ret", 0);
            map.put("contract", contract);
            map.put("msg", "根据合约地址查询成功");
        } else {
            System.err.println("根据合约地址查询失败");
            map.put("ret", 1);
            map.put("msg", "根据合约地址查询失败");
        }
        return map;
    }
}
