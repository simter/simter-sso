package org.simter.sso.client;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by dragon on 2015/1/30.
 */
public class MainTest {
    private static Logger logger = LoggerFactory.getLogger(MainTest.class);

    @Test
    public void test01() throws Exception {
        Assert.assertThat(SSOUtils.getServerURL(), equalTo("test"));
        logger.info("test");
    }
}