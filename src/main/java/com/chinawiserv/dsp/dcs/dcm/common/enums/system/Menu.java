package com.chinawiserv.dsp.dcs.dcm.common.enums.system;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    public enum MenuType{

        /** 目录（默认） */
        Catalog("1", "目录"),

        /** 菜单 */
        Menu("2", "菜单"),

        /** 功能 */
        Function("3", "功能");

        /** 主键 */
        private final String key;

        /** 描述 */
        private final String desc;


        MenuType(final String key, final String desc) {
            this.key = key;
            this.desc = desc;
        }

        public String getKey() {
            return this.key;
        }

        public String getDesc() {
            return this.desc;
        }

        /**
         * 获取枚举类型列表（转为List<Map>形式）
         * @return
         */
        public static List<Map<String,Object>> getEnumList(){
            List<Map<String,Object>> resultList = new ArrayList<>();
            for(MenuType item : MenuType.values()){
                Map<String,Object> map = new HashMap<>();
                map.put("id",item.getKey());
                map.put("text",item.getDesc());
                resultList.add(map);
            }
            return resultList;
        }
    }


}
