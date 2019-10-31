package com.isea.virgin.group;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author isea_you
 * @date 2019/10/30
 * @time 17:09
 * @target: 多个测试用例组合成多个测试集，多个测试集组合成一个测试集
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {TestSuiteA.class,TestSuiteB.class})
public class MasterTestSuite {
}
