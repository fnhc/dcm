package com.chinawiserv.dsp.dcs.dcm.common;

/**
 * 系统常量
 * Created by Administrator on 2017/5/6.
 */
public final class SystemConst {
    private SystemConst(){}

    /***********************************************************/
    /**
     * 用户权限 session Key
     */
    public static final String PERMISSIONS = "permissions";
    /**
     * 菜单树 session Key
     */
    public static final String TREE_MENUS = "treeMenus";
    /**
     * 当前登录用户信息 session Key
     */
    public static final String ME = "me";
    public static final String RES = "res";
    public static final String CUR = "cur";

    /**
     * 数据对象的状态
     */
    public static final int SYS_STATUS_NORMAL = 1;
    public static final int SYS_STATUS_DELETE = -1;

    /**
     * 菜单的类型 menu_type(1:目录 2:菜单 3:功能)
     */
    public static final int SYS_MENU_TYPE_CATALOG = 1;
    public static final int SYS_MENU_TYPE_MENU = 2;
    public static final int SYS_MENU_TYPE_FUNCTION = 3;

    /***********************************************************/
    /**
     * 默认分页大小
     */
    public static final int DEFAULT_PAGE_SIZE = 15;

}
