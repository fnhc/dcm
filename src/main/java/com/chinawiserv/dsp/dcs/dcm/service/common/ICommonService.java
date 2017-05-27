package com.chinawiserv.dsp.dcs.dcm.service.common;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * Created by jacky on 2017/5/11.
 */

/**
 *
 * @param <P> po对象
 * @param <V>
 */
public interface ICommonService<P , V> extends IService<P> {
    /**
     * 添加一个VO对象
     * @param v
     * @return
     */
    boolean insertVO(V v) throws Exception;

    /**
     * 更新一个VO对象（以ID为主键进行更新）
     * @param v
     * @return
     */
    boolean updateVO(V v) throws Exception;

    /**
     * 根据查询参数删除对象
     * @param paramMap
     * @return
     * @throws Exception
     */
    boolean deleteByQuery(Map<String , Object> paramMap) throws Exception;
    /**
     * 根据id查询Vo对象
     * @param id
     * @return
     * @throws Exception
     */
    V selectVoById(String id) throws Exception;

    /**
     * 根据paramMap 对Vo进行分页查询
     * @param paramMap
     * @return 返回分页查询结果
     * @throws Exception
     */
    Page<V> selectVoPage(Map<String, Object> paramMap) throws Exception ;

    /**
     * 根据paramMap 统计Vo 数量
     * @param paramMap
     * @return
     * @throws Exception
     */
    int selectVoCount(Map<String , Object> paramMap) throws Exception;

    /**
     * 根据paramMap 的 pageNumber ， pageSize ， sortName ， sortOrder 四个key ，构造Page对象。
     *  pageNumber 默认值为 1 ；pageSize默认值为 SystemConst.DEFAULT_PAGE_SIZE
     * @param paramMap
     * @param <V>
     * @return
     */
    <V> Page<V> getPage(Map<String , Object> paramMap) ;

}
