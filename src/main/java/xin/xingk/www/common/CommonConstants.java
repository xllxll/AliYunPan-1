package xin.xingk.www.common;


import cn.hutool.core.io.watch.WatchMonitor;

import java.io.File;
import java.math.BigDecimal;

/**
 * Description: 公共变量
 * Author: 陈靖杰
 * Date: 2021/05/10
 */
public class CommonConstants {

    public static String TITLE = "备份助手v1.2";

    //当前路径
    public static String SYSTEM_PATH = System.getProperty("user.dir") + File.separator;

    //获取token
    public final static String TOKEN_URL="https://websv.aliyundrive.com/token/refresh";
    //文件列表
    public final static String FILE_LIST_URL="https://api.aliyundrive.com/adrive/v3/file/list";
    //文件上传
    public final static String CREATE_FILE_URL="https://api.aliyundrive.com/v2/file/create";
    //完成上传
    public final static String COMPLETE_FILE_URL="https://api.aliyundrive.com/v2/file/complete";
    //删除文件
    public final static String DELETE_FILE_URL="https://api.aliyundrive.com/v2/recyclebin/trash";
    //Token
    public static String TOKEN="";
    //driveId
    public static String DriveId="";
    //根目录
    public final static String ROOT="root";

    //refresh_token
    public static String REFRESH_TOKEN = "tokenText";
    //上传目录
    public static String PATH = "pathText";
    //云盘备份目录
    public static String BACKUP_NAME = "folderText";
    //备份模式
    public static String BACKUP_TYPE = "backType";//0是普通备份 1是分类备份
    //定时任务时间
    public static String BACKUP_TIME = "backupTime";
    //是否监听目录
    public static String MONITOR_FOLDER= "monitorFolder";//0是关闭 1是开启

    //输出日志模式 0是覆盖 1追加
    public static int CLEAN_CONSOLE=1;
    //备份状态
    public static boolean BACK_STATE = false;
    //是否打印日志
    public static boolean IS_CONSOLE = false;
    //文件监听
    public static WatchMonitor monitor;
    //默认大小
    public static final Integer DEFAULT_SIZE = 10480000;
    //软件版本
    public static final BigDecimal VERSION = new BigDecimal(1.2);

}
