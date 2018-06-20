package Configurations;

/**
 *
 * @author kassia
 */
public class ConfigurationsPhpMyAdmin extends Configurations {
    public ConfigurationsPhpMyAdmin(){
            super.TYPE = "mysql";
            super.HOST = "localhost";
            super.USER = "root";
            super.PASS = "senhaSQL";
            super.PORT = "3306";
            super.BASE = "ficbank";
            super.DRIV = "com.mysql.jdbc.Driver";
        }
}
