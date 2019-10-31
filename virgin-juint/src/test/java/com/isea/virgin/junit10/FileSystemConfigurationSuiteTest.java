package com.isea.virgin.junit10;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author isea_you
 * @date 2019/10/30
 * @time 16:50
 * @target: 将多个测试用例组合成一个测试集
 */
@RunWith(value = org.junit.runners.Suite.class) // 使用什么运行器
@Suite.SuiteClasses(value = {FolderConfigurationTest.class,
        FileConfigurationTest.class})

public class FileSystemConfigurationSuiteTest {

}
