package com.service;

import java.util.List;

import com.entity.Contract;

/**
 * 合约
 * @author User742742
 *
 */
public interface ContractService {
    
    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增数据，新增字段无法选择
     * @param record
     * @return
     */
    int insert(Contract record);

    /**
     * 新增数据，新增字段可以选择
     * @param record
     * @return
     */
    int insertSelective(Contract record);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Contract selectByPrimaryKey(Integer id);

    /**
     * 查询所有数据
     * @return
     */
    List<Contract> select();
    
    /**
     * 根据id修改除id以外的字段值，修改字段可以选择
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Contract record);

    /**
     * 根据id修改除id以外的字段值，修改字段无法选择
     * @param record
     * @return
     */
    int updateByPrimaryKey(Contract record);
}
