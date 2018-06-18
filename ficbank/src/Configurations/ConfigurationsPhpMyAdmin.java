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
            super.PASS = "";
            super.PORT = "8012";
            super.BASE = "ficbank";
            super.DRIV = "com.mysql.jdbc.Driver";
        }
}
