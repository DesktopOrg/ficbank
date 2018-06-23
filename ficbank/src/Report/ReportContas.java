/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author kamimuraf
 */
public class ReportContas {
    private static final String url      = "jdbc:mysql://localhost/ficbank";
    private static final String driver   = "com.mysql.jdbc.Driver";
    private static final String user     = "root";
    private static final String password = "";
 
    public ReportContas(){
       
    }
    
 
    public void generate(String layout) throws JRException , SQLException, ClassNotFoundException{
        //gerando o jasper design
        JasperDesign drawing = JRXmlLoader.load(layout);

        //compila o relatório
        JasperReport report = JasperCompileManager.compileReport(drawing);

        //estabelece conexão
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stm  = con.createStatement();
        String query   = "SELECT * from conta";
        ResultSet rs   = stm.executeQuery(query);

        //implementação da interface JRDataSource para DataSource ResultSet
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

        //executa o relatório
        Map params = new HashMap();
        params.put("HEADER", "FicBank  - Relatório de Contas");
        Date hoje = new Date();
        SimpleDateFormat df;
        df = new SimpleDateFormat("dd/MM/yyyy");;
        params.put("FOOTER", "Final do Relatório -  " + df.format(hoje));
        JasperPrint print = JasperFillManager.fillReport(report, params, jrRS);

        //exibe o resultado
        JasperViewer viewer = new JasperViewer(print, true);
        viewer.show();

    }
}
