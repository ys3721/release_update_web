package cn.kaixin.export.dao;

import cn.kaixin.export.model.TCharacterEntity;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Yao Shuai
 *
 */
public class CharacterDao {

    private SessionFactoryManager sessionFactoryManager;

    public CharacterDao(SessionFactoryManager sessionFactoryManager) {
        this.sessionFactoryManager = sessionFactoryManager;
    }

    public TCharacterEntity queryCharacterById(long charId) {
        SqlSession sqlSession = sessionFactoryManager.getSqlSessionFactory().openSession();
        return sqlSession.selectOne("cn.kaixin.export.model.TCharacterEntity.selectCharacter", charId);
    }

}
