package service;

import dao.ConfigDAO;
import entity.Config;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfigService {
    
    @Autowired
    ConfigDAO configDAO;
    
    public Config getConfig(){
        return configDAO.getConfig();
    }
    
    public void updateConfig(Config config){
        configDAO.updateConfig(config);
    }
}
