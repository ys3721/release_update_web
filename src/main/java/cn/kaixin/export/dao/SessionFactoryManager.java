package cn.kaixin.export.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Yao Shuai
 *
 */
public class SessionFactoryManager {

    private SqlSessionFactory sqlSessionFactory;

    public SessionFactoryManager() {
        try {
            this.sqlSessionFactory = this.buildSessionFactory();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    private SqlSessionFactory buildSessionFactory() throws IOException {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

}
