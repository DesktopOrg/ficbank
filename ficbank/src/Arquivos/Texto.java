/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos;

import Model.Cliente;
import java.io.*;
/**
 *
 * @author kamimuraf
 */
public class Texto {
    public void TextFileWriter(Cliente c) throws IOException{
        FileWriter w = new FileWriter("arquivoTexto.txt"); 
        PrintWriter out = new PrintWriter(w);
        out.println(c.getName());
        out.println(c.getTelefone());
        out.println(c.getEmail());
        out.println(c.getEstado());
        out.println(c.getCidade());
        out.println(c.getLogradouro());
        out.println(c.getNumero());
        out.println(c.getBairro());
        out.println(c.getCpf());
        out.println(c.isAtivo());
        out.close();
        w.close();
    }
    public Cliente TextFileReader() throws IOException{
       FileReader r = new FileReader("arquivoTexto.txt");
        BufferedReader in = new BufferedReader(r);
        Cliente novo = new Cliente();
        
        String line = in.readLine();
        novo.setName(line);
        line = in.readLine();
        novo.setTelefone(line);
        line = in.readLine();
        novo.setEmail(line);
        novo.setCpf(line);
        line = in.readLine();
        novo.setEstado(line);
        line = in.readLine();
        novo.setCidade(line);
        line = in.readLine();
        novo.setLogradouro(line);
        line = in.readLine();
        novo.setNumero(line);
        line = in.readLine();
        novo.setBairro(line);
        line = in.readLine();
        novo.setCpf(line);
        line = in.readLine();
        novo.setAtivo(Boolean.valueOf(line));
 
        in.close();
        r.close(); 
        return novo;
    }
}
