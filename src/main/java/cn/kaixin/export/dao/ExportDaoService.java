package cn.kaixin.export.dao;

/**
 * @author Yao Shuai
 *
 */
public class ExportDaoService {

    private CharacterDao characterDao;

    public ExportDaoService(){
        this.initDao();
    }

    private void initDao() {
        SessionFactoryManager sessionFactoryManager = new SessionFactoryManager();
        characterDao = new CharacterDao(sessionFactoryManager);
    }

    public CharacterDao getCharacterDao() {
        return characterDao;
    }

    public void setCharacterDao(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }
}
